import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import {Layout} from './Layout'
import {Home} from './Home.jsx'
import {NoPage} from './NoPage'
import {Practice} from './Practice'
import {About} from './About'


function App() {


  return (
<BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="practice" element={<Practice />} />
          <Route path="about" element={<About />} />
          <Route path="*" element={<NoPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
