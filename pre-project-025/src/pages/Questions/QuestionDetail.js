import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import axios from "axios";
import styled from "styled-components";
import { CommonButton } from "../../components/Buttons";
import { Content } from "../../components/Content";
import AnswerForm from "../../components/AnswerForm";

// 전체 감싸는 컨테이너 - 스타일링 및 배치용
const Container = styled.article`
  width: calc(100% - 164px - 324px);
  padding: 24px;
  border-left: 1px solid var(--black-100);
  height: 100%;

  .question-detail-container {
    width: 100%;
  }

  .answer-container {
    padding: 16px 0;
    border-bottom: 1px solid var(--black-075);
  }

  .submit-answer-btn {
    margin: 10px 0 15px;
  }
`;

// QuestionHeader와 그 내부 요소들 스타일링
const QuestionHeader = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid var(--black-100);

  > h1 {
    width: calc(100% - 100px);
    margin: 0;
    font-size: 27px;
    font-weight: 400;
    padding: 10px 10px 10px 0;

    > a {
      color: var(--black-700);
      overflow-wrap: break-word;
      hyphens: auto;
    }
  }

  .ask-btn-container {
    width: 100%;
    text-align: right;
    flex: 1;

    .ask-question-btn {
      margin: 0;
      margin-top: 6px;
      margin-right: -8px;
    }
  }
`;

// QuestionHeader 아래 날짜 및 조회수 정보 스타일링 및 컴포넌트

// 답변 목록 헤더 스타일링 및 컴포넌트
const AnswersHeaderWrapper = styled.div`
  display: flex;
  flex-direction: column;
  .answer-count {
    font-weight: 400;
    font-size: 1.46153846rem;
  }

  .new-answer {
    h2 {
      font-weight: 400;
      font-size: 1.46153846rem;
    }
  }
`;

const AnswersHeader = ({ count }) => {
  return (
    <AnswersHeaderWrapper>
      <h2 className="answer-count">
        {count > 0 && count + (count === 1 ? " answer" : " answers")}
      </h2>
    </AnswersHeaderWrapper>
  );
};

// 답변 작성란 헤더 스타일링
const YourAnswerHeader = styled.h2`
  padding-top: 20px;
  margin: 0 0 1em;
  font-size: 1.46153846rem;
  font-weight: 400;
  line-height: 1.3;
`;

const QuestionDetail = () => {
  const params = useParams();
  const url =
    "http://ec2-13-124-185-51.ap-northeast-2.compute.amazonaws.com:8080/api/questions/" + [params.id];
  const [questionData, setQuestionData] = useState(null);
  const [isPending, setIsPending] = useState(false);

  const navigate = useNavigate();
  const { user } = useSelector((state) => state.loginReducer);

  const handleAskQuestion = () => {
    if (user) navigate("/ask");
    else navigate("/login");
  };

  const handleAnswerSubmit = (body) => {
    const data = { content: body };
    axios(
      `http://ec2-13-124-185-51.ap-northeast-2.compute.amazonaws.com:8080/api/questions/${params.id}/answers`,
      {
        method: "post",
        headers: {
          Authorization: user.token,
        },
        data,
      }
    )
      .then((res) => {
        const newAnswer = { ...res.data, voteCount: 0 };
        setQuestionData({
          ...questionData,
          answers: [...questionData.answers, newAnswer],
        });
      })
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    const fetchData = async () => {
      setIsPending(true);
      try {
        const res = await axios(url, {
          headers: {
            Authorization: user?.token,
          },
        });
        setQuestionData({ ...res.data });
      } catch (err) {
        navigate("/notfound");
        console.error(err);
      }
      setIsPending(false);
    };
    fetchData();
  }, [url]);

  if (isPending && questionData === null) return <div>질문 불러오는 중...</div>;
  if (questionData) {
    return (
      <Container>
        <div className="question-detail-container">
          <QuestionHeader>
            <h1>
              <a href="?">{questionData.title}</a>
            </h1>
            <div className="ask-btn-container">
              <CommonButton
                bgColor="var(--blue-500)"
                color="#fff"
                border="transparent"
                onClick={() => {
                  handleAskQuestion();
                }}
                className="ask-question-btn"
              >
                Ask Question
              </CommonButton>
            </div>
          </QuestionHeader>
          <Content
            type="question"
            author={questionData.author}
            content={questionData.content}
            id={questionData.questionId}
            questionData={questionData}
            updateData={setQuestionData}
          />
        </div>
        {questionData.answers.length > 0 && (
          <>
            <AnswersHeader count={questionData.answers.length} />
            {questionData.answers.map((answer) => {
              return (
                <Content
                  key={"answer" + answer.answerId}
                  type="answer"
                  author={answer.author}
                  content={answer.content}
                  id={answer.answerId}
                  questionData={questionData}
                  updateData={setQuestionData}
                />
              );
            })}
          </>
        )}
        <YourAnswerHeader>Your Answer</YourAnswerHeader>
        <AnswerForm onClickHandler={handleAnswerSubmit} />
      </Container>
    );
  }
};

export default QuestionDetail;
