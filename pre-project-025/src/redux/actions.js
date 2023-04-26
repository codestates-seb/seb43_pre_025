// eslint-disable-next-line import/no-unresolved
import { createAsyncThunk } from "@reduxjs/toolkit";
// eslint-disable-next-line import/no-unresolved
import axios from "axios";

export const loginAction = createAsyncThunk(
  "loginSlice/loginAction",
  async (payload) => {
<<<<<<< HEAD
    const response = await axios('https://3c1e-110-14-12-165.ngrok-free.app/api/login', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
      },
      data: payload,
    }).then((res) => {console.log(res)})

    
    const getProfile = await axios('', {
=======
    const response = await axios(
      "http://ec2-13-124-185-51.ap-northeast-2.compute.amazonaws.com:8080/api/login",
      {
        method: "post",
        headers: {
          "Content-Type": "application/json",
        },
        data: payload,
      }
    );

    const getProfile = await axios("", {
>>>>>>> ab0b642ee8252d61e0cdf27a53dedce636b72c22
      headers: {
        authorization: response.headers.authorization,
      },
    });

    return { ...getProfile.data, token: response.headers.authorization };
  }
);
