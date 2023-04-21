import styled from 'styled-components';
import mainLogo from '../assets/images/logo.png';
import Search from './Search';
import { Link, useNavigate } from 'react-router-dom';
import LoginHeader from '../pages/LoginHeader';
import { useEffect, useState } from 'react';
import axios from 'axios';

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

    .header-container {
    width: 1264px;
    max-width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;

      .menu {
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

axios.defaults.withCredentials = true;

const Header = () => {
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate('./login');
    };

    const hadleSignup = () => {
        navigate('./signup');
    };

    const [isLogin, setIsLogin] = useState(false);
  
    const authHandler = () => {
      axios
        .get('https://165d-110-14-12-165.ngrok-free.app/api/questions')
        .then((res) => {
          setIsLogin(true);
        })
        .catch((err) => {
          if (err.response.status === 404) {
            console.log(err.response.data);
          }
        });
    };

    useEffect(() => {
        authHandler();
      }, []);

    return (
        <StyledHeader>
            <div className='header-container'>
            <Link to = "/">
            <LogoImg src={mainLogo} alt="logo" />
            </Link>
                <ul className="menu">
                    <li>About</li>
                    <li>Products</li>
                    <li>For Teams</li>
                </ul>
                <Search/> 
                {!isLogin ? (
                <div className="button-container">
                    <LoginButton onClick={handleLogin} setIsLogin={setIsLogin}>Log in</LoginButton>
                    <SignButton onClick={hadleSignup} isLogin={isLogin}
                  setIsLogin={setIsLogin}>Sign up</SignButton>
                </div>
                ) : (
                <LoginHeader />
                )}
            </div>
        </StyledHeader>
    )
}

export default Header;