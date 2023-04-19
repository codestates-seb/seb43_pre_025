import styled from "styled-components";

const QuestionStat = styled.div`
  text-align: center;
  display: flex;
  flex-direction: column;
  font-size: 1.2rem;
  font-weight: bold;
  padding: 10px;
  margin-top: 6px;
  span {
    font-size: 0.8rem;
    font-weight: 400;
    margin-top: 4px;
  }
`;

const QuestionTitleArea = styled.div`
  padding: 0 30px;
`;

const QuestionLink = styled.a`
  text-decoration: none;
  color: hsl(206, 100%, 40%);
  font-size: 1.2rem;
  display: block;
  margin-bottom: 3px;
`;

const Tag = styled.span`
  display: inline-block;
  margin-right: 3px;
  background-color: hsl(205, 46%, 92%);
  color: hsl(205, 47%, 42%);
  padding: 3px;
  border-radius: 4px;
  font-size: 0.9rem;
`;
const StyledQuestionRow = styled.div`
  width: 40%;
  background-color: hsl(47, 87%, 94%);
  padding: 15px 15px 12px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  border-top: 1px solid #aaa;
`;

const Who = styled.div`
  display: flex;
  font-size: 0.8rem;
  float: right;
  padding: 10px 0px;
  color: hsl(206, 100%, 40%);
`;

function QuestionRow() {
  return (
    <StyledQuestionRow>
      <QuestionStat>
        0&nbsp;<span>votes</span>
      </QuestionStat>
      <QuestionStat>
        1&nbsp;<span>answers</span>
      </QuestionStat>
      <QuestionTitleArea>
        <QuestionLink>Getting string in quotes in javascripts</QuestionLink>
        <Tag>javascript</Tag>
        <Tag>parsing</Tag>
        <Tag>literals</Tag>
        <Who>Dawid</Who>
      </QuestionTitleArea>
    </StyledQuestionRow>
  );
}

export default QuestionRow;
