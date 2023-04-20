import styled from "styled-components";
import SocialSignup from "./SocialSignup";
import { Link } from 'react-router-dom';

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

function SignUp() {
  return (
    <Container>
      <SocialSignup />
      <RegistrationWindow>
        <InputContainer>
          <InputLabel>Display name</InputLabel>
          <InputField type="text" />
        </InputContainer>
        <InputContainer>
          <InputLabel>Email</InputLabel>
          <InputField type="email" />
        </InputContainer>
        <InputContainer>
          <InputLabel>Password</InputLabel>
          <InputField type="password" />
          <PasswordRule>
            Passwords must contain at least eight characters, including at least
            1 letter and 1 number.
          </PasswordRule>
        </InputContainer>
        <SignupButton>Sign&nbsp;up</SignupButton>
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
    </Container>
  );
}
export default SignUp;
