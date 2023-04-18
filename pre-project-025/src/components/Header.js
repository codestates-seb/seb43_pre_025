import styled from 'styled-components';
import mainLogo from '../assets/logo.png';

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

    .logo {
      height: 100%;
      margin: 0;
      padding: 0 8px;
      display: flex;
      align-items: center;
    }
    .logo-img {
        display: block;
        width: 150px;
        height: 30px;
        margin-top: -4px;
        background: url(${mainLogo}) 0 -500px no-repeat;
      }
    }
`;


const HeaderMenu = styled.div`
    text-align: center;
    font-size: 8px;
    padding: 10px;
`

const SearchInput = styled.input`
    display: inline-block;
    box-sizing: border-box;
    width: 100%;
    border-radius: 3px;
    border: 1px solid black;
    background: rgba(0, 0, 0, .1);
    padding: 8px 10px;
    margin-top: 9px;
`

const LoginButton = styled.button`
    background-color: hsl(205, 46%, 92%);
    padding: 8px 10px;
    margin-top: 9px;
    border: 1px solid black;
    color: hsl(205, 47%, 42%);
    text-align: center;
    font-size: 4px;
    border-radius: 3px;
    border-color: hsl(205, 41%, 63%);
    &:hover {
        background-color: #99c4e4;
    }
`

const SignButton = styled.button`
    background-color: hsl(206, 100%, 52%);
    padding: 8px 10px;
    margin-top: 9px;
    border: 1px solid hsl(206, 100%, 52%);
    color: hsl(0, 0%, 100%);
    text-align: center;
    font-size: 4px;
    border-radius: 3px;
    &:hover {
        background-color: #3388c8;
    }
`

function Header() {
    return (
        <StyledHeader>
        <div className='header-container'>
            <img src={mainLogo} alt="logo" />
            <HeaderMenu>About Products For Teams</HeaderMenu>
            <form action='' className='search'>
                <SearchInput type="text" placeholder='Search...'/>
            </form>
            <LoginButton>Log in</LoginButton>
            <SignButton>Sign up</SignButton>
        </div>
        </StyledHeader>
    )
}

export default Header;