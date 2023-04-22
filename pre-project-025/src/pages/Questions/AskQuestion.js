import styled from "styled-components";
import questionCreateBg from "../../assets/images/questionCreateBg.svg";
import AskQuestionForm from "../../components/AskQuestionForm";
import axios from 'axios';
import { useState } from 'react';

const QuestionCreatePage = styled.section`
  width: 100%;
  padding-top: 50px;
  display: flex;
  justify-content: center;
  background-color: var(--black-025);

  .question-create-container {
    width: 100%;
    max-width: 1264px;
    padding: 0 24px 24px;

    .question-create-description {
      display: flex;
      flex-direction: column;
      width: 100%;

      .question-create-title {
        display: flex;
        align-items: center;
        width: 100%;
        height: 130px;
        background: url(${questionCreateBg}) right bottom no-repeat;
        > h2 {
          font-size: 27px;
        }
      }

      .question-create-description-box {
        width: 100%;
        margin-top: 16px;
        display: flex;

        > div {
          width: 70%;
          margin-bottom: 24px;
          padding: 24px;
          border-radius: 3px;
          background: #ebf4fb;
          border: 1px solid var(--powder-400);
          > h3,
          h4,
          p {
            margin: 0;
          }
          > h3 {
            font-weight: 400;
            font-size: 21px;
            margin: 0 0 8px;
            line-height: 1.3;
          }
          > p {
            font-style: 15px;
            margin-bottom: 15px;
          }
          > h4 {
            font-size: 13px;
            margin-bottom: 8px;
          }

          > p:last-child {
            margin: 0;
            > ul {
              margin-left: 15px;
              > li {
                font-size: 13px;
                line-height: 1.3;
                list-style-type: disc;
                list-style-position: inside;
              }
            }
          }
        }
      }
    }
  }
`;

const fetchCreate = (url, data) => {
  axios(url, {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
      Authorization: "JWT 토큰 키",
    },
    data,
  }).catch((err) => console.log('Error', err.message));
};

const AskQuestion = () => {
  const [askTitle, askTitleSet] = useState('');
  const [askBody, askBodySet] = useState('');
  const handleSubmit = (title, content) => {
    const data = { title, content };
    // fetchCreate('http://15.165.244.155:8080/questions', data);
    // dispatch(rendering());
    // navigate('/');
    // location.href = '/';
  };
  return (
    <>
      <QuestionCreatePage>
        <div className="question-create-container">
          <div className="question-create-description">
            <div className="question-create-title">
              <h2>Ask a public question</h2>
            </div>
            <div className="question-create-description-box">
              <div>
                <h3>Writing a good question</h3>
                <p>
                  You’re ready to ask a programming-related question and this
                  form will help guide you through the process. <br />
                  Looking to ask a non-programming question? See the topics here
                  to find a relevant site.
                </p>
                <h4>Steps</h4>
                <p>
                  <ul>
                    <li>Summarize your problem in a one-line title.</li>
                    <li>Describe your problem in more detail.</li>
                    <li>
                      Describe what you tried and what you expected to happen.
                    </li>
                    <li>
                      Add “tags” which help surface your question to members of
                      the community.
                    </li>
                    <li>Review your question and post it to the site.</li>
                  </ul>
                </p>
              </div>
            </div>
          </div>
          <AskQuestionForm
          askTitle={askTitle}
          askTitleSet={askTitleSet}
          askBody={askBody}
          askBodySet={askBodySet}
          handleSubmit={handleSubmit}
          />
        </div>
      </QuestionCreatePage>
    </>
  );
};

export default AskQuestion;
