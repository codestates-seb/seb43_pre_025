import Header from "./components/Header";
import Nav from "./components/Nav";
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
      <Nav />
      <Questions />
    </div>
  );
}

export default App;
