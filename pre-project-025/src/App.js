import { Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Main from "./components/Main";
import GlobalStyle from "./assets/style/GlobalStyle";
import Login from "./pages/Login";
import Signup from "./pages/SignUp";
import QuestionList from "./pages/Questions/QuestionList";
import AskQuestion from "./pages/Questions/AskQuestion";
import QuestionDetail from "./pages/Questions/QuestionDetail";

function App() {
  return (
    <div>
      <GlobalStyle />
      <Header />
      {/* outlet router용 */}
      <Routes>
        <Route path="/" element={<Main />}>
          <Route index element={<QuestionList />}></Route>
          <Route path="/questions/answers" element={<QuestionDetail />} />
        </Route>
      </Routes>
      {/* common router용 */}
      <Routes>
        <Route path="/ask" element={<AskQuestion />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
}

export default App;
