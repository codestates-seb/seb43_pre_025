import styled from "styled-components";

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: hsl(210, 8%, 95%);
`;

const RegistrationWindow = styled.div`
  width: 300px;
  height: 430px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 30px;
`;

const InputContainer = styled.div`
  display: flex;
  flex-direction: column;
`;

const InputLabel = styled.label`
  margin-bottom: 5px;
  font-size: 16px;
  font-weight: bold;
`;

const PasswordRule = styled.p`
  width: 240px;
  font-size: 12px;
  color: hsl(210, 8%, 45%);
  margin-bottom: 3px;
`;

const InputField = styled.input`
  width: 240px;
  height: 20px;
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  font-size: 16px;

  &:nth-last-child(2) {
    margin-bottom: 1px;
  }
  &:focus {
    outline: none;
    border-color: #00a2ff;
    box-shadow: 0 0 5px #00a2ff;
  }
`;

const SignupButton = styled.button`
  width: 270px;
  height: 40px;
  margin-top: 20px;
  background-color: hsl(206, 100%, 52%);
  color: #fff;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;

  &:hover {
    background-color: #007acc;
  }
`;

const PolicyLinks = styled.div`
  margin-top: 10px;
  font-size: 12px;
  width: 270px;
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
          By clicking “Sign up”, you agree to our&nbsp;
          <PolicyLink
            href="https://stackoverflow.com/legal/terms-of-service/public"
            target="_blank"
          >
            terms of service
          </PolicyLink>
          ,&nbsp;
          <PolicyLink
            href="https://stackoverflow.com/legal/privacy-policy"
            target="_blank"
          >
            privacy policy
          </PolicyLink>
          and&nbsp;
          <PolicyLink
            href="https://stackoverflow.com/legal/cookie-policy"
            target="_blank"
          >
            cookie policy
          </PolicyLink>
          .
        </PolicyLinks>
      </RegistrationWindow>
    </Container>
  );
}
export default SignUp;
