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