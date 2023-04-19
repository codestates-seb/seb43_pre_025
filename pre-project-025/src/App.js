import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Login from './components/Login';

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
      </Routes>
    </>
  );
}

export default App;
