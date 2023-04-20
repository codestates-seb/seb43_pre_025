import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Main from "./components/Main";
import GlobalStyle from "./assets/style/GlobalStyle";
import QuestionList from "./components/QuestionList";

// import Questions from "./components/Questions";
// import QuestionList from "./components/QuestionList";
// import { createGlobalStyle } from """;

// const GlobalStyles = createGlobalStyle`
//   body{
//     width: 100%;
//     background-color: white;
//   }`;
function App() {
  return (
    <div>
      <GlobalStyle />
      <Header />
      <Router>
        <Routes>
          <Route path="/" element={<Main />}></Route>
          {/* <Route index element={<QuestionList />}></Route> */}
        </Routes>
      </Router>
    </div>

  );
}

export default App;
