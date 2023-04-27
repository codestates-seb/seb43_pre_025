import { useRef, useState } from "react";
import styled, { css } from "styled-components";
import { Editor } from "@toast-ui/react-editor";
import { CommonButton } from "./Buttons";
import "@toast-ui/editor/dist/toastui-editor.css";

const EditorWrapper = styled.div`
  border-radius: 4px;
  border: 1px solid var(--black-200);
  box-shadow: none;
  position: relative;

  ${(props) =>
    props.focus &&
    css`
      box-shadow: 0px 0px 0px 4px var(--powder-100);
      border-color: var(--blue-600);
    `}
`;

const AnswerForm = ({ initialValue, onClickHandler }) => {
  const editorRef = useRef();
  const [isFocused, setIsFocused] = useState(false);
  const [body, setBody] = useState("");

  const onSubmit = () => {
    onClickHandler(body);
    editorRef.current.getInstance().setMarkdown("");
  };

  const onChange = () => {
    const data = editorRef.current.getInstance().getMarkdown();
    setBody(data);
  };

  return (
    <div>
      <EditorWrapper focus={isFocused}>
        <Editor
          ref={editorRef}
          initialValue={initialValue || " "}
          onChange={onChange}
          onFocus={() => setIsFocused(true)}
          onBlur={() => setIsFocused(false)}
        />
      </EditorWrapper>
      <CommonButton
        bgColor="var(--blue-500)"
        color="#fff"
        border="transparent"
        className="submit-answer-btn"
        onClick={onSubmit}
      >
        Post Your Answer
      </CommonButton>
    </div>
  );
};

export default AnswerForm;
