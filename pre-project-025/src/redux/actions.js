import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

export const loginAction = createAsyncThunk(
  'loginSlice/loginAction',
  async (payload) => {
    const response = await axios('https://3c1e-110-14-12-165.ngrok-free.app/api/login', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
      },
      data: payload,
    }).then((res) => {console.log(res)})

    
    const getProfile = await axios('', {
      headers: {
        authorization: response.headers.authorization,
      },
    });

    return { ...getProfile.data, token: response.headers.authorization };
  }
);
