# PRA#01-React Components Frontend Development

## Overview

This document serves as both a guide and a log for the PRA#01 React frontend development task. 

---

## PR Submission Checklist

### **Tasks Completed**:

    **Common**

- [x] Postman mock server is set up with correct endpoint.

- [x] Axios function is implemented in a decoupled manner.

- [x] User JSON structure includes varied data types.

- [x] User component renders correctly with avatar.

- [x] Difficulty levels and filtering are functional.

- [x] Synonyms rendering is implemented and error-free.
  
  **Optional** 

- [x] CSS Enhancements: transient effect on hover

- [ ] Animation Libraries

- [ ] Enhanced Card Features

---

## Estimated Time for Tasks

### Common Part

| Task                                          | Estimated Time | Actual Time                    | Impediments and errors                                                                   |
| --------------------------------------------- | -------------- | ------------------------------ | ---------------------------------------------------------------------------------------- |
| Set up Postman mock server                    | 1 hour         | 2:30h                          | mock server JSON and the data data-api fetched had different structures                  |
| Implement axios function for data fetching    | 1 hour         | 1:15 (and back to mock server) | Needed to install font roboto, emotion and material ui.                                  |
| Create user JSON structure                    | 1 hour         | 10 min                         |                                                                                          |
| Develop user component with avatar            | 2 hours        | 4 hours                        | Potsman example didn't have the URL. <br/> Error rendering due to useEffect() and find() |
| Add difficulty levels and implement filtering | 2 hours        | 1:30 hours                     |                                                                                          |
| **Total**                                     | **7 hours**    | **9:25 hours**                 |                                                                                          |

### Optional Part

| Task                                        | Estimated Time | Actual Time | Impediments and errors |
| ------------------------------------------- | -------------- | ----------- | ---------------------- |
| CSS Enhancements: transient effect on hover | 1:30 hours     | 30 min      |                        |
| Animation Libraries                         | 1 hour         |             |                        |
| Enhanced Card Features                      | 1 hour         |             |                        |
| **Total**                                   | **3:30 hours** | 30 min      |                        |

---

## Error Documentation and Solution

### Error: `TypeError: Cannot read properties of undefined (reading 'map')`

**Corresponding task:** 

**Description:** This error occurs when trying to use the `.map()` function on a variable that is either `undefined` or `null`. In JavaScript, `map()` is a method available only on arrays, and attempting to call it on something that is not an array (or is undefined) will result in this error.

**Error Trace:**

- **Component:** `WordList`
- **File:** `Cards.jsx`
- **Line:** 40 (in `WordList`)
- **Stack Trace:**
  - `WordList (Cards.jsx:40:18)`
  - `App`

**Possible Causes:**

- The variable passed to `.map()` is `undefined` or `null`.
- The variable might not have been initialized or fetched correctly before calling `.map()`.

**Solution:**
The error was resolved by modifying the `data-api.js` file. The issue was in how the data was being returned from the API call.Original code in `data-api.js`:

```javascript
export const fetchWords = async () => {   try {    const response = await axios.get(`${BASE_URL}/words`);
return response.data.words; // This was causing the issue
} catch (error) {
  console.error("Error fetching words:", error);
  throw error;
  } };
```

Updated code in `api.js`:

```javascript
export const fetchWords = async () => {   try {    const response = await axios.get(`${BASE_URL}/words`);
return response.data; // This fixed the issue
} catch (error) {    console.error("Error fetching words:", error);
throw error;  } };
```

**Explanation:**  
The API was returning the array of words directly in the `response.data`, not nested under a `words` property. By changing `return response.data.words;` to `return response.data;`, we correctly access the array of words, allowing the `.map()` function to work as expected in the `WordList` component.

---

## **Undefined Errors During Initial Render: useEffect() and find()**

### **Initial Rendering:**

- The component is mounted with an initial empty state (`users = []`).
- The code tries to access `user.name` when `user` is `undefined`, causing an error.

### **Execution of `useEffect`:**

- `useEffect` runs **after** the initial render. React ensures the DOM is updated before running the effect.
- The `fetchUsers()` function is called inside `useEffect` to fetch the data.

### **State Update:**

- When the data is received, `setUsers(data)` updates the state, triggering a re-render of the component.

### **Rendering with Data:**

- The component is re-rendered with the correct data. `users.find()` now finds the correct user and renders their name.

---

## **Main Issue**

- The error occurs because `useEffect` does **not execute immediately** after the component renders; it runs after the initial render. This can lead to unexpected behavior and errors if not properly handled.

---

## **Solution**

To solve this error, implement a conditional check before rendering the content that depends on the data:

jsx

CopiarEditar

`return (   <>     {user ? <h1>{user.name}</h1> : <p>Loading...</p>}   </> );`

This solution prevents the error on the first render by showing a loading message while the data is still being fetched.

---

## **Best Practices**

1. **React Hooks Usage:** Ensure that React Hooks are always called at the top level of the component function. Do not place them inside conditions, loops, or nested functions, as React relies on the order of hook execution to manage state properly.
2. **Dependencies in `useEffect`:** Identify all dependencies used inside the `useEffect` hook and ensure they are included in the dependency array. This guarantees that the effect is re-executed when relevant values change.

### **Alternative Approach Using Loading State:**

jsx

CopiarEditar

`const [isLoading, setIsLoading] = useState(true);  useEffect(() => {   const fetchData = async () => {     try {       const data = await fetchUsers();       setUsers(data);     } finally {       setIsLoading(false);     }   };   fetchData(); }, []);  return (   <>     {isLoading ? <p>Loading...</p> : user && <h1>{user.name}</h1>}   </> );`

This approach provides better control over the loading state and avoids errors related to unavailable data during the initial render.

---

## Future Improvements

- Add unit and integration tests for key components.
- Enhance UI/UX with additional CSS animations or interactive features.
- Refactor components for improved reusability and maintainability.

---
