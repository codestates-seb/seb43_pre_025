// eslint-disable-next-line import/no-unresolved
import styled from "styled-components";

export const PostSum = styled.div`
  display: flex;
  align-items: flex-end;
  justify-content: flex-start;
  flex-direction: column;
  width: 140px;
  padding: 2px 16px 4px 0;
  text-align: left;
  font-size: 13px;

  span {
    padding: 2px;
    font-weight: 500;
  }

  .post-votes {
    color: var(--fc-dark);
  }
  .post-answers {
    color: var(--fc-light);
  }
  .post-views {
    color: var(--yellow-900);
  }
`;

const PostSummary = () => {
  return (
    <PostSum>
      <span className="post-votes">1 votes</span>
      <span className="post-answers">1 answers</span>
    </PostSum>
  );
};

export default PostSummary;
