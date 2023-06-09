/* eslint-disable no-unused-vars */
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { AskBtn } from '../../components/Buttons';
import Questions from './Questions';

const QuestionListPage = styled.div`
  width: calc(100% - 164px - 324px);
  height: 100%;
  display: flex;
  padding: 10px 24px 20px 0;
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

const SortContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-left: 24px;
  font-size: 17px;
  color: var(--black-600);

  > h4 {
    font-weight: 500;
  }
`;

const FooterBtnContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  text-align: center;
  padding-top: 50px;
  padding-bottom: 80px;
  border-top: 1px solid var(--black-075);
`;

const QuestionList = () => {
  const [questions, setQuestion] = useState([]);
 
  const { render } = useSelector((state) => state.renderReducer);

  useEffect(() => {
    const fetchData = async () => {
      try {
      const response = await axios.get(
        `http://ec2-13-124-185-51.ap-northeast-2.compute.amazonaws.com:8080/api/questions?page=1&size=10?`
      );
      setQuestion(response.data.data);
    } catch (e) {
      window.alert('오류가 발생했습니다.');
    }
  };
    fetchData();
  }, [render]);

  const navigate = useNavigate();
  const { user } = useSelector((state) => state.loginReducer);

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
        {questions?.map((question, index) => {
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
      <Questions />
      <Questions />
      <Questions />
      <Questions />
    </QuestionListPage>
  );
};

export default QuestionList;
