import styled from 'styled-components';

export const CommonButton = styled.button`
  background-color: ${(props) => props.bgColor || 'var(--powder-100)'};
  margin: 4px;
  padding: 10px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border-radius: 3px;
  color: ${(props) => props.color || 'var(--powder-700)'};
  font-size: 13px;
  border: 1px solid ${(props) => props.border || 'var(--blue-600)'};
  opacity: ${(props) => (props.disabled ? 0.5 : 1)};
`;

export const AskBtn = styled.button`
  display: blcok;
  box-sizing: boreder-box;
  align-items: center;
  background-color: var(--blue-500);
  margin: 4px;
  padding: 0.5rem;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border: 1px solid ${(props) => props.border || 'var(--blue-600)'};
  width: auto;
  height: 36px;
  border-width: 0;
  border-radius: 3px;
  color: white;
  &:hover {
    background-color: var(--blue-400);
  }
`;

export const SocialButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #ffffff;
  padding: 10px;
  margin: 4px 0;
  border: 1px solid hsl(0, 0%, 79%);
  border-radius: 5px;
  font-size: 13px;
  color: black;
  outline: none;

  img {
    width: 18px; 
    height: 18px;
    margin-right: 5px;
  }
`

export const SortBtn = styled.button`
  display: blcok;
  box-sizing: boreder-box;
  align-items: center;
  background-color: transparent;
  margin-left: -1px;
  padding: 0.5rem;
  width: auto;
  height: 35px;
  border: 1px solid rgb(159, 166, 173);
  border-radius: 3px;
  font-size: 13px;
  font-weight: 500;
  color: var(--black-800);
  &:hover {
    background-color: var(--black-025);
  }
  &:focus {
    background-color: var(--black-050);
  }
  &:active {
    background-color: var(--black-100);
    color: black;
    border-style: initial;
    outline: 6px solid var(--blue-100);
  }
`;

export const BottomBtn = styled.button`
  /* background-color: transparent; */
  padding-left: 15px;
  padding-right: 15px;
  margin: 2px;
  width: auto;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 40%);
  border: 1px solid var(--black-400);
  border-radius: 3px;
  color: ${(props) => (props.bgColor ? 'white' : 'var(--black-900)')};
  font-size: 13px;
  height: 35px;
  background-color: ${(props) =>
    props.bgColor ? 'var(--orange-500)' : 'transparent'};

  &:hover {
    background-color: var(--black-100);
    color: var(--black-700);
  }

  &:active {
    background-color: var(--orange-500);
    color: white;
    outline: 6px solid var(--blue-100);
  }
`;