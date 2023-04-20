import styled from 'styled-components';
import google from '../assets/images/google-logo.png';
import github from '../assets/images/github-logo.png';
import facebook from '../assets/images/facebook-logo.png';
import { SocialButton } from '../components/Buttons';

const SocialContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 288px;
  margin: 24px 0 16px;
`;

function SocialLogin() {
    return (
      <SocialContainer className="social-container">
        <SocialButton>
        <img src={google} alt="google-logo" />
          Log in with Google
        </SocialButton>
        <SocialButton style={{backgroundColor: 'hsl(210, 8%, 20%)', color:"#ffffff"}}>
        <img src={github} alt="github-logo" />
          Log in with GitHub
        </SocialButton>
        <SocialButton style={{backgroundColor: '#385499', color:"#ffffff"}}>
        <img src={facebook} alt="facebook-logo" />
          Log in with Facebook
        </SocialButton>
      </SocialContainer>
    );
  };
  
  export default SocialLogin;