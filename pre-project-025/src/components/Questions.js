import styled from "styled-components";
import QuestionRow from "./QuestionRow";

const Container = styled.div`
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`;

const HeaderRow = styled.div`
  width: 40%;
  display: flex;
  padding: 15px 30px;
  padding-top: 60px;
  justify-content: space-evenly;
  align-items: center;
`;

const StyledHeader = styled.h1`
  font-size: 1.8rem;
`;

const BlueButton = styled.button`
  background-color: #378ad3;
  color: #fff;
  border: 0;
  border-radius: 5px;
  padding: 12px 10px;
  height: 40px;
`;

// const QuestionRow = styled.div`
//   width: 40%;
//   background-color: gray;
//   padding: 10px 10px;
//   display: flex;
//   flex-wrap: wrap;
//   justify-content: center;
//   align-items: center;
//   border-top: 1px solid #aaa;
// `;

// const QuestionStat = styled.div`
//   text-align: center;
//   display: flex;
//   flex-direction: column;
//   font-size: 1.2rem;
//   font-weight: bold;
//   padding: 10px;
//   span {
//     font-size: 0.8rem;
//     font-weight: 400;
//     margin-top: 4px;
//   }
// `;

// const QuestionTitleArea = styled.div`
//   padding: 0 30px;
// `;

// const QuestionLink = styled.a`
//   text-decoration: none;
//   color: hsl(206, 100%, 40%);
//   font-size: 1.2rem;
//   display: block;
//   margin-bottom: 3px;
// `;

// const Tag = styled.span`
//   display: inline-block;
//   margin-right: 3px;
//   background-color: hsl(205, 46%, 92%);
//   color: hsl(205, 47%, 42%);
//   padding: 3px;
//   border-radius: 4px;
//   font-size: 0.9rem;
// `;

function Questions() {
  return (
    <main>
      <Container>
        <HeaderRow>
          <StyledHeader>Top Questions</StyledHeader>
          <BlueButton>Ask&nbsp;Questions</BlueButton>
        </HeaderRow>
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
        <QuestionRow />
      </Container>
    </main>
  );
}

export default Questions;
