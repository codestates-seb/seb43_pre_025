import { createGlobalStyle } from "styled-components";
import Questions from "./components/Quetions";

const GlobalStyle = createGlobalStyle`
  body {
    background: aliceblue;
  }
`;

function App() {
  return (
    <div>
      <GlobalStyle />
      <Questions />
    </div>
  );
}

export default App;
