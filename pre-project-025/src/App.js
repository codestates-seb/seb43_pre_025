import { Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Main from "./components/Main";
import GlobalStyle from "./assets/style/GlobalStyle";
import QuestionList from "./components/QuestionList";
import Login from './components/Login';
import Signup from './components/SignUp';


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
        <Routes>
          <Route path="/" element={<Main />}></Route>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          {/* <Route index element={<QuestionList />}></Route> */}
        </Routes>
    </div>

  );
}

export default App;
