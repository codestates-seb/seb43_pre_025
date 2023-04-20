import styled from 'styled-components';
import SearchIcon from '../assets/images/search.png';

const SearchContainer = styled.form`
  position: relative;
  flex-grow: 1;

  img {
    position: absolute;
    left: 0.5em;
    top: 50%;
    margin-top: -9px;
    width: 18px;
    height: 18px;
  }
`;

const SearchBar = styled.input`
  display: block;
  width: 92%;
  background-color: #ffffff;
  border: 1px solid black;
  font-size: 13px;
  color: black;
  border-radius: 3px;
  padding: 0.6em 0.7em;
  padding-left: 32px;
  outline: none;
  border-color: hsl(210, 8%, 75%);
  &:focus {
    box-shadow: 0px 0px 0px 2px hsl(206, 90%, 70%);
    border-color: hsl(205, 100%, 66%);
  }
`;

function Search() {
return (
    <SearchContainer>
        <img src={SearchIcon} alt="icon" />
      <SearchBar placeholder="Search..." />
    </SearchContainer>
  );
};

export default Search;