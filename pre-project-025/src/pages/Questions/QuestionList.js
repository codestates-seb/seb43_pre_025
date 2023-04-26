// import axios from "axios";
import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { AskBtn } from "../../components/Buttons";
import Questions from "./Questions";
import { useSelector } from "react-redux";

const QuestionListPage = styled.div`
  width: calc(100% - 164px - 324px);
  height: 100%;
  display: flex;
  padding: 10px 24px 20px 50px;
  border-left: 1px solid var(--black-075);
  flex-direction: column;
`;

const QuestionHeader = styled.header`
  margin-left: 24px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 15px;
  color: var(--black-700);

  > h1 {
    font-weight: 500;
    font-size: 27px;
  }
`;

const QuestionList = () => {
  const [questions, setQuestion] = useState([]);

  const { render } = useSelector((state) => state.renderReducer);

  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get(
        `https://7168-110-14-12-165.ngrok-free.app/api/questions?page=1&size=10 `
      );
      setQuestion(response.data.data);
    };
    fetchData();
  }, [render]);

  const navigate = useNavigate();
  const { user } = useSelector((state) => state.loginReducer);
  // Ask Question 버튼 클릭시 로그인 상태가 아니라면 로그인 창으로 이동
  const askHandle = () => {
    user ? navigate("/ask") : navigate("/login");
  };

  return (
    <QuestionListPage>
      <QuestionHeader>
        <h1>All Questions</h1>
        <AskBtn
          onClick={() => {
            askHandle();
          }}
        >
          Ask Question
        </AskBtn>
      </QuestionHeader>
      <div>
        {questions.map((question, index) => {
          return (
            <Questions
              key={question.questionId}
              questions={question}
              userName={question.author}
              index={index}
            />
          );
        })}
      </div>
      <Questions />
    </QuestionListPage>
  );
};

export default QuestionList;
