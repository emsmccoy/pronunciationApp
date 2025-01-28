# PRA#01-React Components Frontend Development

## Overview

This document serves as both a guide and a log for the PRA#01 React frontend development task. 

---

## Estimated Time for Tasks

### Common Part

| Task                                          | Estimated Time | Actual Time                    | Impediments (if any)                                                    | Error logs                                                     |
| --------------------------------------------- | -------------- | ------------------------------ | ----------------------------------------------------------------------- | -------------------------------------------------------------- |
| Set up Postman mock server                    | 1 hour         | 2:30h                          | mock server JSON and the data data-api fetched had different structures | TypeError: Cannot read properties of undefined (reading 'map') |
| Implement axios function for data fetching    | 1 hour         | 1:15 (and back to mock server) | Needed to install font roboto, emotion and material ui.                 |                                                                |
| Create user JSON structure                    | 1 hour         | 10 min                         |                                                                         |                                                                |
| Develop user component with avatar            | 2 hours        | 1 hour so far                  | potsman example didn't have the URL                                     |                                                                |
| Add difficulty levels and implement filtering | 2 hours        |                                |                                                                         |                                                                |

### Optional Part

| Task                   | Estimated Time | Actual Time | Impediments (if any) |
| ---------------------- | -------------- | ----------- | -------------------- |
| CSS Enhancements       | 1:30 hours     |             |                      |
| Animation Libraries    | 1 hour         |             |                      |
| Enhanced Card Features | 1 hour         |             |                      |
| **Total**              | **3:30 hours** |             |                      |



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

## PR Submission Checklist

### **Tasks Completed**:

- [x] Postman mock server is set up with correct endpoint.

- [x] Axios function is implemented in a decoupled manner.

- [x] User JSON structure includes varied data types.

- [ ] User component renders correctly with avatar.

- [ ] Difficulty levels and filtering are functional.

- [ ] Synonyms rendering is implemented and error-free.

### **Testing**:

- [ ] All components are tested locally.

- [ ] Error handling in data fetching.

- [ ] UI is responsive and behaves as expected.

---

## Future Improvements

- Add unit and integration tests for key components.
- Enhance UI/UX with additional CSS animations or interactive features.
- Refactor components for improved reusability and maintainability.

---
