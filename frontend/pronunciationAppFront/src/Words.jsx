import React, { useState, useEffect } from 'react';
import axios from 'axios';

const WordList = () => {
  const [words, setWords] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchWords = async () => {
      
        const response = await axios.get(
          'http://localhost:8080/words'
        );
        setWords(response.data);
        setIsLoading(false);
    
    };
    fetchWords();
  }, []);

  return (
    <>
    <h1>Words</h1>
      {isLoading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {words.map((word) => (
            <li key={word.id}>
              <strong>Name:</strong> {word.wordName} <br />
              <strong>Definition:</strong> {word.definition} <br />
              <strong>Phonetic spelling:</strong> {word.phoneticSpelling} <br />
              <strong>Sentence:</strong> {word.sentence} <br />
              <strong>Active:</strong> {word.isActive} <br />
              <strong>Level:</strong> {word.level}

              </li>
          ))}
        </ul>
      )}
    </>
  );
};

export default WordList;