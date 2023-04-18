import styled from 'styled-components';
import {AiOutlineSearch} from 'react-icons/ai';

const SearchContainer = styled.form`
  position: relative;
  flex-grow: 1;
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
  &:focus {
    box-shadow: 0px 0px 0px 4px;
    border-color: blue;
  }
`;

function Search() {
return (
    <SearchContainer>
      <SearchBar placeholder="Search..." />
    </SearchContainer>
  );
};

export default Search;