// eslint-disable-next-line import/no-unresolved
import { createAsyncThunk } from "@reduxjs/toolkit";
// eslint-disable-next-line import/no-unresolved
import axios from "axios";

export const loginAction = createAsyncThunk(
  "loginSlice/loginAction",
  async (payload) => {
    const response = await axios(
      "https://ec62-110-14-12-165.ngrok-free.app/login",
      {
        method: "post",
        headers: {
          "Content-Type": "application/json",
        },
        data: payload,
      }
    );

    const getProfile = await axios("", {
      headers: {
        authorization: response.headers.authorization,
      },
    });

    return { ...getProfile.data, token: response.headers.authorization };
  }
);
