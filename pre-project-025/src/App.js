import Header from "./components/Header";
import Questions from "./components/Questions";
import { createGlobalStyle } from "styled-components";

const GlobalStyles = createGlobalStyle`
  body{
    width: 100%;
    background-color: white;
  }`;
function App() {
  return (
    <div>
      <GlobalStyles />
      <Header />
      <Questions />
    </div>
  );
}

export default App;
