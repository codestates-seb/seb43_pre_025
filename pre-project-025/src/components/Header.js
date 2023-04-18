import styled from 'styled-components';
import mainLogo from '../assets/logo.png';
import Search from './Search';

const StyledHeader = styled.header`
    width: 100%;
    position: fixed;
    z-index: 10;
    height: 50px;
    border-top: 3px solid orange;
    background-color: white;
    display: flex;
    justify-content: center;
    align-items: center;
    box-shadow: 0 1px 1px hsl(0, 0%, 0%);

    .header-container {
    width: 1264px;
    max-width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;

      .gnb {
      display: flex;
      align-items: center;
      padding: 2px;
      margin: 3px;
      color: black;
      font-size: 13px;

      li {
        padding: 6px 12px;
        margin: 2px;
        list-style:none;
      }
    }

    .button-container {
      display: flex;
    }
    .button-container button {
      padding: 8px 10px;
    }
}
`;

const LoginButton = styled.button`
    background-color: hsl(205, 46%, 92%);
    padding: 10px;
    margin: 4px;
    width: 70px;
    border: 1px solid black;
    color: hsl(205, 47%, 42%);
    text-align: center;
    font-size: 13px;
    border-radius: 3px;
    border-color: hsl(205, 41%, 63%);
    &:hover {
        background-color: #99c4e4;
    }
`;

const SignButton = styled.button`
    background-color: hsl(206, 100%, 52%);
    padding: 10px;
    margin: 4px;
    width: 70px;
    border: 1px solid hsl(206, 100%, 52%);
    color: hsl(0, 0%, 100%);
    text-align: center;
    font-size: 13px;
    border-radius: 3px;
    &:hover {
        background-color: #3388c8;
    }
`;

const LogoImg = styled.img`
        display: block;
        width: 150px;
        height: 30px;
        margin-top: -4px;
`

function Header() {
    return (
        <StyledHeader>
            <div className='header-container'>
            <LogoImg src={mainLogo} alt="logo" />
                <ul className="gnb">
                    <li>About</li>
                    <li>Products</li>
                    <li>For Teams</li>
                </ul>
                <Search/>
                <div className="button-container">
                    <LoginButton>Log in</LoginButton>
                    <SignButton>Sign up</SignButton>
                </div>
            </div>
        </StyledHeader>
    )
}

export default Header;