import styled from 'styled-components';
import { Link } from 'react-router-dom';
import SocialLogin from './SocialLogin';
import React, { useState } from 'react';
import axios from 'axios';

const LoginPage = styled.section`
  width: 100%;
  height: 100vh;
  padding-top: 50px;
  display: flex;
  justify-content: center;
  background-color: white;

  .login-container {
    width: 100%;
    max-width: 1264px;
    padding: 24px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    
    .signup-link {
      width: 100%;
      max-width: 288px;
      padding: 24px 0;
      margin-bottom: 24px;
      font-size: 13px;
      text-align: center;
      > a {
        margin-left: 5px;
        color: blue;
      }
    }
  }
`;

const LoginBox = styled.div`
    width: 100%;
    max-width: 300px;
    overflow:hidden;
    padding: 24px;
    margin-bottom: 24px;
    background: #ffffff;
    border-radius: 7px;
    box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
    0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);

    div {
    display: flex;
    flex-direction: column;
    width: 100%;
    max-width: 288px;

    label {
      font-size: 15px;
      font-weight: bold;
    }

    button {
      margin: 0;
    }

    p {
      margin: 2px;
      padding: 2px;
      color: #d0390e;
      font-size: 12px;
    }

  }

  .login-email {
    margin-bottom: 10px;
  }
  .login-password {
    margin-bottom: 20px;
  }
`;

const UserInput = styled.input`
    width: 100%;
    margin-top: 5px;
    padding: 8px 9px;
    background-color: #FFFFFF;
    color: hsl(210, 8%, 5%);
    font-size: 13px;
    border: 1px solid hsl(210, 8%, 75%);
    border-radius: 3px;
    outline: none;
    &:focus {
        box-shadow: 0px 0px 0px 1px hsl(210, 8%, 5%);
        border-color: hsl(210, 100%, 67%)
    }
`;

const LoginButton = styled.button`
  background-color: hsl(206, 100%, 52%);
  margin: 4px;
  padding: 10px;
  border: transparent;
  box-shadow: inset 0 1px 0 0 hsl(0, 0%, 100%);
  border-radius: 3px;
  color: white;
  font-size: 13px;
  border: 1px solid hsl(206, 100%, 52%);
`;

const Login = ({ setUserInfo, setIsLogin }) => {
  
  const [loginInfo, setLoginInfo] = useState({
    email: '',
    password: '',
  });

  const [errorMessage, setErrorMessage] = useState('');
  const handleInputValue = (key) => (e) => {
    setLoginInfo({ ...loginInfo, [key]: e.target.value });
  };
  const loginRequestHandler = () => {
    const { email, password } = loginInfo;
    if (!email || !password) {
      setErrorMessage('아이디와 비밀번호를 입력하세요');
      return;
    } else {
      setErrorMessage('');
    }
    return axios
      .post('https://165d-110-14-12-165.ngrok-free.app/api/login', { loginInfo })
      .then((res) => {
        setIsLogin(true);
        setUserInfo(res.data);
      })
      .catch((err) => {
        if (err.response.status === 404) {
          setErrorMessage('로그인에 실패했습니다.');
        }
      });
  };


    return(
      <LoginPage>
        <div className="login-container">
          <SocialLogin />
          <LoginBox className="LoginBox">
          <form onSubmit={(e) => e.preventDefault()}>
              <div className="login-email">
                <label htmlFor="email">Email</label>
                <UserInput id="email" type="email" onChange={handleInputValue('email')}/>
              </div>
              <div className="login-password">
                <label htmlFor="email">Password</label>
                <UserInput id="password" type="password" onChange={handleInputValue('password')}/>
              </div>
              <div>
                <LoginButton onClick={loginRequestHandler} >Log in</LoginButton>
                </div>
                {errorMessage ? (
                <div id='alert-message' data-testid='alert-message'>{errorMessage}
              </div>
              ) : (
                ''
                )}
                </form>
          </LoginBox>

          <div className="signup-link">
          {`Don't have an account?`}
          <Link to="/signup">Sign up</Link>
          </div>
        </div>
    </LoginPage>
  );
};

export default Login;