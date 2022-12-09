import logo from './logo.svg';
import './App.css';
import Dashboard from "./app/components/Dashboard";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import InstructorProfile from "./app/components/InstructorProfile";


function App() {
  return (
      <div className="App">
        <BrowserRouter>
          <div>
            <Routes>
              <Route path="/" element={<InstructorProfile/>}></Route>
            </Routes>
          </div>
        </BrowserRouter>
      </div>
  );
}

export default App;