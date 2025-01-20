import { useState, useEffect } from "react";
import axios from "axios";
import {
  Box,
  Card,
  CardContent,
  Typography,
  Container,
  Grid,
} from "@mui/material";

const BASE_URL = "https://a387bb02-2aa0-41a6-b8f7-9cc5247b9d5f.mock.pstmn.io";

const fetchWords = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/words`);
    return response.data.words;
  } catch (error) {
    console.error("Error fetching words:", error);
    throw error;
  }
};

export default function WordList() {
  const [words, setWords] = useState([]);

  useEffect(() => {
    const getWords = async () => {
      try {
        const data = await fetchWords();
        setWords(data);
      } catch (error) {
        console.error("Failed to fetch words:", error);
      }
    };

    getWords();
  }, []);

  return (
    <Container maxWidth="md">
      <Box sx={{ my: 4 }}>
        <Typography variant="h4" component="h1" gutterBottom>
          Word List
        </Typography>
        <Grid container spacing={2}>
          {words.map((word) => (
            <Grid item xs={12} sm={6} md={4} key={word.id}>
              <Card>
                <CardContent>
                  <Typography variant="h6" component="div">
                    {word.word}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Pronunciation: {word.pronunciation}
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          ))}
        </Grid>
      </Box>
    </Container>
  );
}
