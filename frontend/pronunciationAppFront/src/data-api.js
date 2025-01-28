// api.js
import axios from "axios";

const BASE_URL = "https://8eeb858c-019e-4bd3-8287-f53ccc9400a7.mock.pstmn.io";


export const fetchWords = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/words`);
    return response.data;
  } catch (error) {
    console.error("Error fetching words:", error);
    throw error;
  }
};

export const fetchUsers = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/users`);
    return response.data;
  } catch (error) {
    console.error("Error fetching users:", error);
    throw error;
  }
};
