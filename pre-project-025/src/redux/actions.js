// eslint-disable-next-line import/no-unresolved
import { createAsyncThunk } from "@reduxjs/toolkit";
// eslint-disable-next-line import/no-unresolved
import axios from "axios";

export const loginAction = createAsyncThunk(
  "loginSlice/loginAction",
  async (payload) => {
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
      headers: {
        authorization: response.headers.authorization,
      },
    });

    return { ...getProfile.data, token: response.headers.authorization };
  }
);
