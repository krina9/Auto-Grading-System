import logo from './logo.svg';
import './App.css';
import Dashboard from "./app/components/Dashboard";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import InstructorProfile from "./app/components/InstructorProfile";
import InstructorPwdChange from "./app/components/InstructorPwdChange";
import StudentProfile from "./app/components/StudentProfile"
import Solution from './app/components/Solution';
import StudentPassword from "./app/components/StudentPassword"
import StudentLearning from "./app/components/StudentLearning"
import StudentDashboard from "./app/components/StudentDashboard";
import AddProblem from "./app/components/AddProblem";
import AddTestCases from "./app/components/AddTestCases";
import ProblemList from "./app/components/ProblemList";


function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <Routes>
                        <Route path="/instructorProfileSettings" element={<InstructorProfile/>}></Route>
                        <Route path="/instructorPwdSettings" element={<InstructorPwdChange/>}></Route>
                        <Route path="/student/profile" element={<StudentProfile/>}></Route>
                        <Route path="/student/profile/password" element={<StudentPassword/>}></Route>
                        <Route path="/student/learning" element={<StudentLearning/>}></Route>
                        <Route path="/Solution" element={<Solution/>}></Route>
                        <Route path="/addProblem" element={<AddProblem/>}></Route>
                        <Route path="/addTestCases" element={<AddTestCases/>}></Route>
                        <Route path="/problems/list" element={<ProblemList/>}></Route>
                        <Route path="/StudentDashboard" element={<StudentDashboard />}></Route>
                        <Route path="/InstructorDashboard" element={<Dashboard />}></Route>
                    </Routes>
                </div>
            </BrowserRouter>
        </div>
    );
}

export default App;