// import { useParams, useNavigate } from 'react-router-dom';
// eslint-disable-next-line import/no-unresolved
import styled from "styled-components";
// eslint-disable-next-line import/no-unresolved
// import { UserInfo } from './UserInfo';
// import { getTimeElapsed } from '../utils/timeElapsed';
// import { ContentViewer } from './ContentViewer';
// import { useSelector } from 'react-redux';
// import axios from 'axios';

const ContentWrapper = styled.section`
  display: flex;
  align-items: flex-start;
  padding-top: 15px;

  .main-content {
    width: 100%;

    .text {
      margin: 0;
      font-size: 15px;
      line-height: 22.5px;
      padding-top: 4px;
    }
  }
`;

// 질문 내용 아래 수정, 삭제 옵션 ~ 작성자 정보 스타일링
const Utils = styled.div`
  display: flex;
  color: red;
  justify-content: space-between;
  flex-wrap: wrap;
  margin: 16px 0;
  padding-top: 4px;
`;

// 수정, 삭제 옵션들 스타일링
const Options = styled.div`
  display: flex;
  color: var(--black-500);
  font-size: 13px;
  margin: -4px;

  button {
    height: 17px;
    margin-top: 2px;
    padding-top: 7px;
    color: var(--black-500);
    font-size: 13px;
    background-color: transparent;
    border: none;
    cursor: pointer;
  }
`;

export const Content = ({
  type,
  // author,
  // content,
  // id,
  // questionData,
}) => {
  // const { user } = useSelector((state) => state.loginReducer);
  // const params = useParams();

  // const navigate = useNavigate();
  const handleEdit = () => {
    // type === 'question'
    //   ? navigate(`/edit/${params.id}`)
    //   : navigate(`/edit/answers/${id}`, {
    //       state: {
    //         questionId: questionData.questionId,
    //         questionTitle: questionData.title,
    //         questionContent: questionData.content,
    //         answer: content,
    //       },
    //     });
  };

  const handleDelete = () => {
    // if (window.confirm('Are you sure you want to delete?')) {
    //   axios(`http://15.165.244.155:8080/${type}s/${id}`, {
    //     method: 'delete',
    //     headers: {
    //       Authorization: user.token,
    //     },
    //   })
    //     .then(() => {
    //       if (type === 'question') {
    //         location.href = '/';
    //       } else if (type === 'answer') {
    //         updateData({
    //           ...questionData,
    //           answers: questionData.answers.filter((el) => el.answerId !== id),
    //         });
    //       }
    //     })
    //     .catch((err) => console.error(err));
    // }
  };

  return (
    <ContentWrapper className={type + "-container"}>
      <div className="main-content">
        {/* <ContentViewer content={content} /> */}
        <Utils>
          <Options>
            {/* {user?.userId === author.userId && (
              <> */}
            <button onClick={() => handleEdit()}>Edit</button>
            <button onClick={() => handleDelete()}>Delete</button>
            {/* </>
            )} */}
          </Options>
          {/* <UserInfo type={type} author={author} /> */}
        </Utils>
      </div>
    </ContentWrapper>
  );
};
