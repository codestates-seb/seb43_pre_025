import { configureStore } from '@reduxjs/toolkit';
import loginSlice from './loginSlice';
import renderSlice from './renderSlice';

const store = configureStore({
  reducer: {
    loginReducer: loginSlice.reducer,
    renderReducer: renderSlice.reducer,
  },
});

export default store;
