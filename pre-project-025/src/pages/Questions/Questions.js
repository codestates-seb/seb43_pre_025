import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { getTimeElapsed, getDaysElapsed } from '../../utils/timeElapsed';

const QuestionContainer = styled.div`
  .container {
    width: 100%;
    display: flex;
    border-top: 1px solid var(--black-075);
    padding: 16px;
  }

  .questions {
    width: calc(100% - 140px);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
  }

  .question-title {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    hyphens: auto;
    overflow-wrap: break-word;
  }

  .question-title {
    width: 100%;
    font-size: 17px;
    font-weight: 400;
    color: var(--blue-600);
    font-family: "Noto Sans KR", sans-serif;
    padding-top: 13px;
    cursor: pointer;
  }
`;

const UserInfo = styled.div`
  width: 100%;
  .user-container {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    width: auto;
    color: var(--black-800);
  }
  .user-name {
    color: var(--blue-600);
    padding: 4px;
    font-size: 13px;
  }
  .written-name {
    color: var(--black-800);
  }
`;

const Qusetions = ({ questions }) => {
  const navigate = useNavigate();
  // 질문 제목 클릭 시 페이지 이동 구현
  const detailQuestionView = (questionId) => {
    navigate(`questions/${questionId}`);
  };

  return (
    <div>
      <QuestionContainer>
        <>
          <div className="container">
            {/* <PostSummary
              // 질문 투표 수
              voteNum={questions?.voteCount}
              // 질문 답변 수
              answerNum={questions?.answerNum}
            /> */}
            <div className="questions">
              <div
                className="question-title"
                onClick={() => {
                  detailQuestionView(questions?.questionId);
                }}
                role="button"
                tabIndex="0"
              >
                {questions?.title}Token so hard
              </div>
              <UserInfo>
                <div className="user-container">
                  <div className="user-name">
                    <span className="written-name">written&nbsp;by&nbsp;</span>
                    {/* 작성자 username 들어올 곳 */}
                    {questions?.author.username}Me
                  </div>
                </div>
              </UserInfo>
            </div>
          </div>
        </>
      </QuestionContainer>
    </div>
  );
};

export default Qusetions;
