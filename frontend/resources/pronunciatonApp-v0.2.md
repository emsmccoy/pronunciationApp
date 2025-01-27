# PronunciationApp Frontend v0.2

## Reference Lab

- [# React JS App: router]([React JS App: router – albertprofe wiki](https://albertprofe.dev/reactjs/reactjs-app-router.html)): with the installation of `npm i -D react-router-dom`
- [react-router-dom ](https://www.npmjs.com/package/react-router-dom): npm official repo
- [React Router v6.0](https://reactrouter.com/): official recommendation

## React Router Setup

> For setting up the router in our React application, we'll follow the guide from Albert Profe's documentation on React App Router[1]. 

This will allow us to create a multi-page application with different routes for our `Home`, `Practice`, and `About` pages.

## Mockup Low Fidelity

Here's a low fidelity mockup for our three main domains:

**Home**

- **Home View**: Main landing page with app introduction and navigation
- **HomeForm View**: Login/Signup form for user authentication
- **UserLogged View**: Personalized dashboard for logged-in users

**Practice**

Three <mark>variants</mark> for displaying pronunciation cards:

- Grid layout
- Carousel
- Swipe pair cards

**About**

- Information about the app and its features

## Home Page Components

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

## Practice Page Variants

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

[1] https://albertprofe.dev/reactjs/reactjs-app-router.html
