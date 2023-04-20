import styled from "styled-components";
import {CgProfile} from 'react-icons/cg';
import {AiOutlinePoweroff} from 'react-icons/ai';

const AfterContainer = styled.div`
    display: flex;
    align-items: center;
`

const Profile = styled.div`
    display: flex;
    align-items: center;

    .user-icon {
        padding: 10px;
        width: 50px;
        height: 50px;
        color: hsl(32, 100%, 60%);
    }
`

const LogoutButton = styled.button`
    display: flex;
    align-items: center;
    background-color: hsl(32, 100%, 60%);
    border-radius: 3px;
    border: 1px solid hsl(32, 100%, 56%);

    li {
    font-size: 15px;
    color: hsl(0, 0%, 100%);
    list-style:none;
    padding: 5px;
    }
    
    .logout-icon {
        padding: 5px;
        width: 30px;
        height: 30px;
        color: hsl(0, 0%, 100%);
    }
`

function LoginHeader() {
    return (
        <AfterContainer>
            <Profile>
            <CgProfile className="user-icon" />
            </Profile>
            <LogoutButton>
                <AiOutlinePoweroff className="logout-icon"/>
                <li>Logout</li>
            </LogoutButton>
        </AfterContainer>
    )
}

export default LoginHeader;