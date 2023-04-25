import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

export const loginAction = createAsyncThunk(
  'loginSlice/loginAction',
  async (payload) => {
<<<<<<< HEAD
    const response = await axios('http://15.165.244.155:8080/auth/login', {
=======
    const response = await axios('https://e88c-110-14-12-165.ngrok-free.app/api/login', {
>>>>>>> 99126425ee1616c82a963923ebd79e57f0d9d5d4
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
      },
      data: payload,
    });
<<<<<<< HEAD

    const getProfile = await axios('http://15.165.244.155:8080/users/profile', {
      headers: {
        authorization: response.headers.authorization,
      },
    });

    return { ...getProfile.data, token: response.headers.authorization };
  }
);
=======
  }
);
>>>>>>> 99126425ee1616c82a963923ebd79e57f0d9d5d4
