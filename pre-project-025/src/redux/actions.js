import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

export const loginAction = createAsyncThunk(
  'loginSlice/loginAction',
  async (payload) => {
    const response = await axios('https://e88c-110-14-12-165.ngrok-free.app/api/login', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
      },
      data: payload,
    });
  }
);