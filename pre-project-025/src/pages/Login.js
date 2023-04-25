import styled from 'styled-components';
import { Link } from 'react-router-dom';
import SocialLogin from './SocialLogin';
import { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { loginAction } from '../redux/actions';
import { useNavigate } from 'react-router-dom';

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

const Login = () => {

  const initialInfo = { email: '', password: '' };
  const [loginInfo, loginInfoSet] = useState(initialInfo);
  const [emptyEmail, emptyEmailSet] = useState(false);
  const [emptyPassword, emptyPasswordSet] = useState(false);
  const [invalidEmail, invalidEmailSet] = useState(false);
  const [invalidPassword, invalidPasswordSet] = useState(false);
  const [loginFailed, loginFailedSet] = useState(false);

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const { user } = useSelector((state) => state.loginReducer);

  useEffect(() => {
    if (user) {
      loginFailedSet(false);
    }
  }, [user]);

  const handeLogin = (email, password) => {
    // eslint-disable-next-line
    const emailRegex = /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
    const passwordRegex = /^[A-Za-z\d!@#$%^&*()_+~\-=]{8,40}$/;

    // 비어있으면 empty메세지 출력
    if (email === '') emptyEmailSet(true);
    // 유효하지않으면(이메일 형식) invalid 메세지 출력
    else if (!emailRegex.test(email)) {
      emptyEmailSet(false);
      invalidEmailSet(true);
    }

    // 비어있으면 empty메세지 출력
    if (password === '') emptyPasswordSet(true);
    // 유효하지않으면(8자 이상) invalid 메세지 출력
    else if (!passwordRegex.test(password)) {
      emptyPasswordSet(false);
      invalidPasswordSet(true);
    }
    // 유효한 이메일과 패스워드이면 로그인 요청
    if (emailRegex.test(email) && passwordRegex.test(password)) {
      emptyEmailSet(false);
      emptyPasswordSet(false);
      invalidEmailSet(false);

      dispatch(loginAction({ email, password }));
      navigate('/');
    }
  };
  
    return(
      <LoginPage>
        <div className="login-container">
          <SocialLogin />
          <LoginBox className="LoginBox">
              <div className="login-email">
                <label htmlFor="email">Email</label>
                <UserInput id="email" type="email"           
                value={loginInfo.email}
          onChange={(event) =>
            loginInfoSet({ ...loginInfo, email: event.target.value })
          }
          border={emptyEmail || loginFailed ? '#d0390e' : null}
          focusBorder={emptyEmail || loginFailed ? '#d0390e' : null}
          shadow={emptyEmail || loginFailed ? 'rgb(246,224,224)' : null}/>
          {emptyEmail ? <p>Email cannot be empty.</p> : null}
        {invalidEmail ? <p>The email is not a valid email address.</p> : null}
        {loginFailed ? <p>The email or password is incorrect.</p> : null}
              </div>

              <div className="login-password">
                <label htmlFor="email">Password</label>
                <UserInput id="password" type="password"           
                value={loginInfo.password}
          onChange={(event) =>
            loginInfoSet({ ...loginInfo, password: event.target.value })
          }
          border={emptyEmail || loginFailed ? '#d0390e' : null}
          focusBorder={emptyEmail || loginFailed ? '#d0390e' : null}
          shadow={emptyEmail || loginFailed ? 'rgb(246,224,224)' : null}/>
        {emptyPassword ? <p>Password cannot be empty.</p> : null}
        {invalidPassword ? (
          <p>The password must be at least 8 characters long.</p>
        ) : null}
        {loginFailed ? <p>The email or password is incorrect.</p> : null}
              </div>
              <div>
                <LoginButton onClick={() => handeLogin(loginInfo.email, loginInfo.password)}>Log in</LoginButton>
                </div>
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
