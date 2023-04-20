import ReactDOM from 'react-dom/client';
// import { BrowserRouter } from 'react-router-dom';
import React from 'react';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // eslint-disable-next-line react/jsx-no-undef
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
