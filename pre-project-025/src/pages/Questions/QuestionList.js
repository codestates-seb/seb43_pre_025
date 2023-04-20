import styled from 'styled-components';
import { AskBtn } from '../../components/Buttons';

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
    return (
        <QuestionListPage>
          <QuestionHeader>
             <h1>All Questions</h1>
             <AskBtn>
          Ask Question
        </AskBtn>
      </QuestionHeader>
        </QuestionListPage>
    )
}


export default QuestionList;