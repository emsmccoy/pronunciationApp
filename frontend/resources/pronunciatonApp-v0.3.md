# PronunciationApp Frontend v0.3

## Reference Lab

- [GitHub - AlbertProfe/howRenderCycleWorks](https://github.com/AlbertProfe/howRenderCycleWorks)

- [GitHub - AlbertProfe/basicRegisterForm](https://github.com/AlbertProfe/basicRegisterForm)

## Basic React Register Form

> Register form using HTML tags for a user with username, email, and password.

### Reference

- [Setting state triggers renders](https://react.dev/learn/state-as-a-snapshot#setting-state-triggers-renders)

- [Copying objects with the spread syntax](https://react.dev/learn/updating-objects-in-state#copying-objects-with-the-spread-syntax)

- [Using a single event handler for multiple fields](https://react.dev/learn/updating-objects-in-state#using-a-single-event-handler-for-multiple-fields)

### Summary

This form includes:

1. Three input fields for username, email, and password, each with a corresponding label.
2. State management using `useState` for form data and registration status.
3. A `handleChange` function to update the form data as the user types.
4. A `handleSubmit` function that prevents the default form submission, logs the form data, and sets the registration status to true.
5. Conditional rendering to show a success message after registration.

### Conditional Render

The **conditional rendering** is a fundamental React pattern.

```jsx
if (isRegistered) {
  return <h1>Registration successful! Welcome aboard!</h1>
}
```

This code snippet<mark> is an example of early return conditional rendering</mark>. Here's how it works:

1. **Condition Check**: 
   The `if` statement checks the value of `isRegistered`. This is likely a boolean state variable managed by `useState`.

2. **Early Return**:
   If `isRegistered` is `true`, the function immediately returns the JSX element `<h1>Registration successful! Welcome aboard!</h1>`.

3. **Short-Circuiting the Render**:
   By returning early, this prevents the rest of the component's JSX from being rendered.
   
   1. It's like saying, *"If the user is registered, don't bother with the form, just show the success message."*

4. **Component Behavior**:
   
   - When `isRegistered` is `false`, this condition is skipped, and the component continues to render the registration form.
   - When `isRegistered` becomes `true` (likely after a successful form submission), the component re-renders, hits this condition, and only displays the success message.

This pattern is powerful because it allows you to completely change what a component renders based on its state. It's particularly useful for scenarios like:

- Showing success messages after form submissions
- Displaying loading states while data is being fetched
- Rendering different UIs based on user authentication status

### handleChange and spread operator

> The `handleChange` function is a common pattern used in React for managing form input changes.

1. The function takes an event object `e` as its parameter. This event is automatically passed when the function is called on an input change.

2. It uses object <mark>destructuring</mark> to extract `name` and `value` from `e.target`. In a form input, `name` corresponds to the input's name attribute, and `value` is the current value of the input.

3. The `setFormData` function is called to update the state. It uses a callback function that receives the previous state (`prevData`) as an argument.

4. Inside the callback, a new object is created and returned. This object:
   
   - <mark>Spreads all properties from the previous state</mark> (`...prevData`)
   - Adds or updates a property using computed property name syntax `[name]: value`

```jsx
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };
```

This approach allows a single function to handle changes for multiple form inputs, updating the corresponding state property based on the input's name.

> The use of spread operator (`...`) ensures that all other form data remains intact while only updating the changed field. This is particularly useful for forms with multiple inputs, as it allows you to manage all form data in a single state object.

By using the input's name as the key, this function can dynamically update the correct property in the state object, making it versatile for handling various form inputs without needing separate handlers for each field.

### Code

```jsx
import { useState } from "react";

export default function RegisterForm() {
  const [isRegistered, setIsRegistered] = useState(false);
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
  });

  if (isRegistered) {
    return <h4>Registration successful! Welcome aboard!</h4>;
  }

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Here you would typically send the data to your backend
    console.log("Form submitted with:", formData);
    setIsRegistered(true);
  };

  return (
    <div className="card">
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Username</label>
          <br />
          <input
            type="text"
            id="username"
            name="username"
            placeholder="username"
            value={formData.username}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="email">Email</label>
          <br />
          <input
            type="email"
            id="email"
            name="email"
            placeholder="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <br />
          <input
            type="password"
            id="password"
            name="password"
            placeholder="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>{" "}
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}
```









**Home View**: Main landing page with app introduction and navigation

- **HomeForm View**: Login/Signup form for user authentication
- **UserLogged View**: Personalized dashboard for logged-in users

**Practice**

Three <mark>variants</mark> for displaying pronunciation cards:

- Grid layout
- Carousel
- Swipe pair cards

**About**

- Information about the app and its features

### Home Page Components

The Home page will consist of three main views:

**Home View**

- App logo and tagline
- Brief description of the app's purpose
- "Get Started" button leading to HomeForm

**HomeForm View**

- Toggle between Login and Signup forms
- Input fields for username and password
- Submit button

**UserLogged View**

- Welcome message with user's name
- Quick stats on practice sessions
- Link to start a new practice session

### Practice Page Variants

**Grid Layout**

- Display words in a responsive grid
- Each card shows the word and its pronunciation
- Click to hear pronunciation

**Carousel**

- Horizontal scrolling carousel of word cards
- Navigation arrows for moving between cards
- Current card centered with pronunciation audio control

**Swipe Pair Cards**

- Two cards shown side by side
- Word on one card, pronunciation on the other
- Swipe right if correct, left if incorrect

## Router Implementation

To implement the router, we'll use React Router. Here's a basic setup:

```jsx
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/Home';
import Practice from './components/Practice';
import About from './components/About';

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/practice" component={Practice} />
        <Route path="/about" component={About} />
      </Switch>
    </Router>
  );
}
```

This setup creates routes for our main pages. The Home component will need to handle its own sub-views (Home, HomeForm, UserLogged) using state or nested routes.

#### Named and Default exportations

> Curly braces `{}` in React imports are used to distinguish between default exports and named exports

1. **Named exports**: When a module uses <mark>named exports</mark>, you need to use curly braces {} to import specific items. This is the case for `BrowserRouter`, `Route`, and `Switch` from 'react-router-dom'.
   
   ```jsx
   import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
   ```

2. **Default exports**: When a module has a <mark>default</mark> export, you import it without curly braces. This is likely the case for your component files like `About`.
   
   ```jsx
    import About from './components/About';
   ```

The reason for this distinction is how modules export their contents[1](https://blog.stackademic.com/why-do-some-imports-use-d194c00cb391?gi=4707c297c748):

- Default export: `export default myVariable;`
- Named export: `export const myVariable = 'value';`

<mark>It's important to note that a single file can have both default and named exports</mark>. This is why you might see imports like: 

```jsx
import React, { useState } from 'react'
```

Citations:

[1] [What is the Difference Between Default and Named Exports in JavaScript?](https://www.freecodecamp.org/news/difference-between-default-and-named-exports-in-javascript/)

## Axios

- [Getting Started | Axios Docs](https://axios-http.com/docs/intro) : Promise based HTTP client for the browser and node.js

### What is Axios?

> Axios is a [promise-based](https://javascript.info/promise-basics) HTTP Client for [`node.js`](https://nodejs.org) and the browser. It is [isomorphic](https://www.lullabot.com/articles/what-is-an-isomorphic-application) (= it can run in the browser and nodejs with the same codebase). 
> 
> On the server-side it uses the native node.js `http` module, while on the client (browser) it uses XMLHttpRequests.

### CRUD implementation

Now, we could complete the implementation of all <mark>CRUD (Create, Read, Update, Delete) operations</mark> for our `api.js` file using Axios with our `BASE_URL`.

```javascript
// api.js
import axios from "axios";

const BASE_URL = "https://1e84671c-879b-423f-b798-dfa33a0482f6.mock.pstmn.io";

// READ: Fetch all words
export const fetchWords = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/words`);
    return response.data.words;
  } catch (error) {
    console.error("Error fetching words:", error);
    throw error;
  }
};

// CREATE: Add a new word
export const createWord = async (newWord) => {
  try {
    const response = await axios.post(`${BASE_URL}/words`, { word: newWord });
    return response.data;
  } catch (error) {
    console.error("Error creating a new word:", error);
    throw error;
  }
};

// UPDATE: Update an existing word by ID
export const updateWord = async (id, updatedWord) => {
  try {
    const response = await axios.put(`${BASE_URL}/words/${id}`, { word: updatedWord });
    return response.data;
  } catch (error) {
    console.error(`Error updating the word with ID ${id}:`, error);
    throw error;
  }
};

// DELETE: Delete a word by ID
export const deleteWord = async (id) => {
  try {
    const response = await axios.delete(`${BASE_URL}/words/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error deleting the word with ID ${id}:`, error);
    throw error;
  }
};
```

### Explanation of Each Function:

1. **`fetchWords`**:
   
   - Sends a `GET` request to fetch all words from the server.
   - Returns the list of words.
   - `${BASE_URL}/words` is a <mark>string interpolation in JavaScript</mark>, specifically using a template literal: the `${}` syntax within a template literal is used for string interpolation [1] [2].

2. **`createWord`**:
   
   - Sends a `POST` request to add a new word.
   - Takes `newWord` as an argument, which is the word to be added.
   - Returns the server's response.

3. **`updateWord`**:
   
   - Sends a `PUT` request to update an existing word by its ID.
   - Takes `id` (the unique identifier of the word) and `updatedWord` (the updated value of the word) as arguments.
   - Returns the updated data from the server.

4. **`deleteWord`**:
   
   - Sends a `DELETE` request to remove a word by its ID.
   - Takes `id` as an argument.
   - Returns the server's response.

Citations:

[1]  [JavaScript Template Strings](https://www.w3schools.com/js/js_string_templates.asp)

[2] [Template literals (Template strings) - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals)

**Usage Example:**

Here’s how you might use these functions in your application:

```javascript
import { fetchWords, createWord, updateWord, deleteWord } from "./api";

const main = async () => {
  try {
    // Fetch all words
    const words = await fetchWords();
    console.log("Fetched words:", words);

    // Create a new word
    const newWord = "example";
    const createdWord = await createWord(newWord);
    console.log("Created word:", createdWord);

    // Update an existing word
    const updatedWord = "updated-example";
    const updatedResponse = await updateWord(createdWord.id, updatedWord);
    console.log("Updated word:", updatedResponse);

    // Delete a word
    const deletedResponse = await deleteWord(createdWord.id);
    console.log("Deleted word:", deletedResponse);
  } catch (error) {
    console.error("An error occurred:", error);
  }
};

main();
```

## File Navigation

> To navigate files for import and export in React, we can use **relative paths or implement absolute imports**. 

Here's how to handle file navigation in your project structure:

## Relative Paths

When using relative paths, you navigate based on the current file's location:

- `./` refers to the current directory
- `../` moves up one directory
- `../../` moves up two directories, and so on

For our structure, here's how you might import files:

```javascript
// In App.jsx
import Header from './Header';
import Home from './Home';
import { getData } from './data-api';

// In Home.jsx
import heroImage from './assets/hero-image.png';
```

## Absolute Imports

To simplify imports and avoid long relative paths, you can set up absolute imports:

1. Create a `jsconfig.json` file in your project root:

```json
{
  "compilerOptions": {
    "baseUrl": "src"
  }
}
```

2. Now you can import using absolute paths:

```javascript
// From anywhere in your project
import Header from 'components/Header';
import { getData } from 'utils/data-api';
import heroImage from 'assets/hero-image.png';
```

## Reorganizing Project Structure

To improve organization, move files into appropriate folders:

```
src/
├── components/
│   ├── Cards.jsx
│   └── Header.jsx
├── pages/
│   ├── About.jsx
│   ├── Home.jsx
│   ├── NoPage.jsx
│   └── Practice.jsx
├── layout/
│   └── Layout.jsx
├── assets/
│   └── hero-image.png
├── utils/
│   └── data-api.js
├── styles/
│   ├── App.css
│   └── index.css
├── App.jsx
└── main.jsx
```

After reorganizing, update imports:

```javascript
// In App.jsx
import Header from './components/Header';
import Home from './pages/Home';
import { getData } from './utils/data-api';

// In pages/Home.jsx
import heroImage from '../assets/hero-image.png';
```

Using absolute imports with this structure would be even cleaner:

```javascript
// In any file
import Header from 'components/Header';
import Home from 'pages/Home';
import { getData } from 'utils/data-api';
import heroImage from 'assets/hero-image.png';
```

Citations:
[1] https://albertprofe.dev/reactjs/reactjs-app-router.html
