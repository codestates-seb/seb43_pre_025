import styled from "styled-components";
import SocialSignup from "./SocialSignup";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState } from "react";

const Container = styled.div`
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  background-color: white;

  .login-link {
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
`;

const RegistrationWindow = styled.div`
  width: 300px;
  padding: 24px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  align-items: center;
  padding-top: 30px;
`;

const InputContainer = styled.div`
  display: flex;
  flex-direction: column;
`;

const InputLabel = styled.label`
  font-size: 15px;
  font-weight: bold;
  padding: 2px;
`;

const PasswordRule = styled.p`
  font-size: 11px;
  font-weight: 400;
  color: black;
  margin: 0px 0px 20px 3px;
`;

const InputField = styled.input`
  width: 100%;
  margin-top: 5px;
  padding: 8px 9px;
  background-color: #ffffff;
  color: hsl(210, 8%, 5%);
  font-size: 13px;
  border: 1px solid hsl(210, 8%, 75%);
  border-radius: 3px;
  outline: none;
  &:focus {
    box-shadow: 0px 0px 0px 1px hsl(210, 8%, 5%);
    border-color: hsl(210, 100%, 67%);
  }
`;

const SignupButton = styled.button`
  background-color: hsl(206, 100%, 52%);
  width: 100%;
  padding: 10px;
  border: transparent;
  box-shadow: inset 0 1px 0 0 hsl(0, 0%, 100%);
  border-radius: 3px;
  color: white;
  font-size: 13px;
  border: 1px solid hsl(206, 100%, 52%);
`;

const PolicyLinks = styled.div`
  font-size: 10px;
  color: black;
  margin: 10px 0px 20px 3px;
`;

const PolicyLink = styled.a`
  color: #00a2ff;
  text-decoration: none;

  &:hover {
    text-decoration: underline;
  }
`;

const SignUp = () => {
  // 이름,이메일,비밀번호 전송
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

<<<<<<< HEAD
    // 이름,이메일,비밀번호 전송
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
  
    // 유효성 검사
    const [isValidName, setIsValidName] = useState(false);
    const [isValidEmail, setIsValidEmail] = useState(false);
    const [isValidPassword, setisValidPassword] = useState(false);
  
    // 회원가입 완료 후 로그인 페이지로 이동
    const navigate = useNavigate();
  
    // 회원가입 데이터 전송
    const signUpSubmit = async () => {
      try {
        const response = await axios
          .post(`https://3c1e-110-14-12-165.ngrok-free.app/api/signup`, {
            username,
            email,
            password,
          })
          .then(() => navigate('/login'));
      } catch (error) {
        window.alert('오류가 발생했습니다. 입력 사항을 확인해 주세요.');
      }
    };
  
    // DisplayName 유효성 검사 체크
    const validationNameCheck = (nameVal) => {
      if (nameVal.length >= 1) {
        return true;
      } else {
        return false;
      }
    };
  
    // email 유효성 검사 체크
    const validationEmailCheck = (emailVal) => {
      const emailRegex = // 이메일 형식 정규표현식
        /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
  
      return emailRegex.test(emailVal);
    };
  
    // Password 유효성 검사 체크
    const validationPasswordCheck = (passwordVal) => {
      // 전체 8자 이상이어야 합니다.
      const isValidPassword = passwordVal.length >= 8;
      if (isValidPassword) {
        return true;
      } else {
        return false;
      }
    };
  
    // 이름
    const onNameHandler = (e) => {
      let targetValue = e.currentTarget.value;
      setUsername(targetValue);
  
      if (validationNameCheck(targetValue)) {
        setIsValidName(false);
      } else {
        setIsValidName(true);
      }
    };
  
    // 이메일
    const onEmailHandler = (e) => {
      let targetValue = e.currentTarget.value;
      setEmail(targetValue);
      if (validationEmailCheck(targetValue)) {
        setIsValidEmail(false);
      } else {
        setIsValidEmail(true);
      }
    };
  
    // 패스워드
    const onPasswordHandler = (e) => {
      let targetValue = e.currentTarget.value;
      setPassword(targetValue);
      if (validationPasswordCheck(targetValue)) {
        setisValidPassword(false);
      } else {
        setisValidPassword(true);
      }
    };
  
    // 회원가입 기능 구현
    const onSignupHandler = (e) => {
      e.preventDefault();
      let validationName = validationNameCheck(username);
      let validationEmail = validationEmailCheck(email);
      let validationPassword = validationPasswordCheck(password);
      if (validationName && validationEmail && validationPassword) {
        signUpSubmit();
      } else {
        setIsValidName(!validationName);
        setIsValidEmail(!validationEmail);
        setisValidPassword(!validationPassword);
        return;
      }
    };
=======
  // 유효성 검사
  const [isValidName, setIsValidName] = useState(false);
  const [isValidEmail, setIsValidEmail] = useState(false);
  const [isValidPassword, setisValidPassword] = useState(false);
>>>>>>> ab0b642ee8252d61e0cdf27a53dedce636b72c22

  // 회원가입 완료 후 로그인 페이지로 이동
  const navigate = useNavigate();

  // 회원가입 데이터 전송
  const signUpSubmit = async () => {
    try {
      // eslint-disable-next-line no-unused-vars
      const response = await axios
        .post(`http://ec2-13-124-185-51.ap-northeast-2.compute.amazonaws.com:8080/api/signup`, {
          username,
          email,
          password,
        })
        .then(() => navigate("/login"));
    } catch (error) {
      window.alert("오류가 발생했습니다. 입력 사항을 확인해 주세요.");
    }
  };

  // DisplayName 유효성 검사 체크
  const validationNameCheck = (nameVal) => {
    if (nameVal.length >= 1) {
      return true;
    } else {
      return false;
    }
  };

  // email 유효성 검사 체크
  function validationEmailCheck(emailVal) {
    const emailRegex = // 이메일 형식 정규표현식
      /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;

    return emailRegex.test(emailVal);
  }

  // Password 유효성 검사 체크
  const validationPasswordCheck = (passwordVal) => {
    // 전체 8자 이상이어야 합니다.
    const isValidPassword = passwordVal.length >= 8;
    if (isValidPassword) {
      return true;
    } else {
      return false;
    }
  };

  // 이름
  const onNameHandler = (e) => {
    let targetValue = e.currentTarget.value;
    setUsername(targetValue);

    if (validationNameCheck(targetValue)) {
      setIsValidName(false);
    } else {
      setIsValidName(true);
    }
  };

  // 이메일
  const onEmailHandler = (e) => {
    let targetValue = e.currentTarget.value;
    setEmail(targetValue);
    if (validationEmailCheck(targetValue)) {
      setIsValidEmail(false);
    } else {
      setIsValidEmail(true);
    }
  };

  // 패스워드
  const onPasswordHandler = (e) => {
    let targetValue = e.currentTarget.value;
    setPassword(targetValue);
    if (validationPasswordCheck(targetValue)) {
      setisValidPassword(false);
    } else {
      setisValidPassword(true);
    }
  };

  // 회원가입 기능 구현
  const onSignupHandler = (e) => {
    e.preventDefault();
    let validationName = validationNameCheck(username);
    let validationEmail = validationEmailCheck(email);
    let validationPassword = validationPasswordCheck(password);
    if (validationName && validationEmail && validationPassword) {
      signUpSubmit();
    } else {
      setIsValidName(!validationName);
      setIsValidEmail(!validationEmail);
      setisValidPassword(!validationPassword);
      return;
    }
  };

  return (
    <Container>
      <form onSubmit={(e) => e.preventDefault()}>
        <SocialSignup />
        <RegistrationWindow>
          <InputContainer>
            <InputLabel>Display name</InputLabel>
            <InputField type="text" value={username} onChange={onNameHandler} />
            {isValidName && (
              <div className="isvalid">Please enter a valid Display name.</div>
            )}
          </InputContainer>

          <InputContainer>
            <InputLabel>Email</InputLabel>
            <InputField type="email" value={email} onChange={onEmailHandler} />
            {isValidEmail && (
              <div className="isvalid">Please enter a valid email address.</div>
            )}
          </InputContainer>

          <InputContainer>
            <InputLabel>Password</InputLabel>
            <InputField
              type="password"
              value={password}
              onChange={onPasswordHandler}
            />
            <PasswordRule>
              {isValidPassword && (
                <div className="isvalid">Please enter a valid Password.</div>
              )}
              Passwords must contain at least eight characters, including at
              least 1 letter and 1 number.
            </PasswordRule>
          </InputContainer>

          <SignupButton onClick={onSignupHandler}>Sign&nbsp;up</SignupButton>

          <PolicyLinks>
            By clicking “Sign up”, you agree to our &nbsp;
            <PolicyLink
              href="https://stackoverflow.com/legal/terms-of-service/public"
              target="_blank"
            >
              terms of service &nbsp;
            </PolicyLink>
            <PolicyLink
              href="https://stackoverflow.com/legal/privacy-policy"
              target="_blank"
            >
              privacy policy
            </PolicyLink>
            &nbsp; and
            <PolicyLink
              href="https://stackoverflow.com/legal/cookie-policy"
              target="_blank"
            >
              &nbsp; cookie policy
            </PolicyLink>
            .
          </PolicyLinks>
        </RegistrationWindow>
        <div className="login-link">
          {`Already have an account?`}
          <Link to="/login">Login</Link>
        </div>
      </form>
    </Container>
  );
};
export default SignUp;
