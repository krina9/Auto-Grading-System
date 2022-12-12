import logo from './logo.svg';
import './App.css';
import Dashboard from "./app/components/Dashboard";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import InstructorProfile from "./app/components/InstructorProfile";
import InstructorPwdChange from "./app/components/InstructorPwdChange";
import StudentProfile from "./app/components/StudentProfile"
import StudentPassword from "./app/components/StudentPassword"
import StudentLearning from "./app/components/StudentLearning"

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
                <Route path="/student/dashboard" element={<StudentDashboard/>}></Route>
                <Route path="/student/profile" element={<StudentProfile/>}></Route>
                <Route path="/student/profile/password" element={<StudentPassword/>}></Route>
                <Route path="/student/learning" element={<StudentLearning/>}></Route>
            </Routes>
          </div>
        </BrowserRouter>
      </div>
  );
}
export default App;