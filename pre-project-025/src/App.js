import { Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Main from "./components/Main";
import GlobalStyle from "./assets/style/GlobalStyle";
import Login from "./components/Login";
import Signup from "./components/SignUp";
// import Questions from "./components/Questions";
import QuestionList from "./components/QuestionList";
// import { createGlobalStyle } from """;

function App() {
  return (
    <div>
      <GlobalStyle />
      <Header />
      <Routes>
        <Route path="/" element={<Main />}>
          <Route index element={<QuestionList />}></Route>
        </Route>
      </Routes>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
}

export default App;
