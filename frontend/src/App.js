import logo from './logo.svg';
import './App.css';
import Dashboard from "./app/components/Dashboard";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import InstructorProfile from "./app/components/InstructorProfile";
import InstructorPwdChange from "./app/components/InstructorPwdChange";
import Solution from "./app/components/Solution";
function App() {
  return (
      <div className="App">
        <BrowserRouter>
          <div>
            <Routes>
              <Route path="/" element={<Solution/>}></Route>
                <Route path="/instructorProfileSettings" element={<InstructorProfile/>}></Route>
                <Route path="/instructorPwdSettings" element={<InstructorPwdChange/>}></Route>
            </Routes>
          </div>
        </BrowserRouter>
      </div>
  );
}
export default App;