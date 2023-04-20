import { Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Main from "./components/Main";
import GlobalStyle from "./assets/style/GlobalStyle";
import Login from "./pages/Login";
import Signup from "./pages/SignUp";
import QuestionList from "./pages/Questions/QuestionList";
import AskQuestion from './pages/Questions/AskQuestion';

function App() {
  return (
    <div>
      <GlobalStyle />
      <Header />
<<<<<<< HEAD
      <Routes>
        <Route path="/" element={<Main />}>
          <Route index element={<QuestionList />}></Route>
        </Route>
      </Routes>
      <Routes>
=======
      {/* outlet router용 */}
        <Routes>
          <Route path="/" element={<Main />}>
          <Route index element={<QuestionList />}></Route>
          </Route>
        </Routes>
        {/* common router용 */}
        <Routes>
        <Route path="/ask" element={<AskQuestion />} />
>>>>>>> 84bcdda15ec79dc30c21a47b781b781f79394a86
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
}

export default App;
