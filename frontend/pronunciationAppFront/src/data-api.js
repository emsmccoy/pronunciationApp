// api.js
import axios from "axios";

const BASE_URL = "https://1e84671c-879b-423f-b798-dfa33a0482f6.mock.pstmn.io";

export const fetchWords = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/words`);
    return response.data.words;
  } catch (error) {
    console.error("Error fetching words:", error);
    throw error;
  }
};
