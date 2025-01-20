// api.js
import axios from "axios";

const BASE_URL = "https://a387bb02-2aa0-41a6-b8f7-9cc5247b9d5f.mock.pstmn.io";

export const fetchWords = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/words`);
    return response.data.words;
  } catch (error) {
    console.error("Error fetching words:", error);
    throw error;
  }
};
