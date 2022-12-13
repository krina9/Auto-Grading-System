import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import AddProblem from "./components/AddProblem";
import SignupComponent from "./components/SignupComponent";
import ProblemList from "./components/ProblemList";
import AddTestCases from "./components/AddTestCases";
import Solution from "./components/Solution";
import StudentDashboard from "./components/StudentDashboard";
import Dashboard from "./components/Dashboard";
import InstructorProfile from "./components/InstructorProfile";
import InstructorPwdChange from "./components/InstructorPwdChange";
import StudentProfile from "./components/StudentProfile";
import StudentLearning from "./components/StudentLearning";
import StudentPassword from "./components/StudentPassword";
import Problem from "./components/Problem";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <Routes>
                        <Route path="/login" element={<LoginComponent/>}></Route>
                        <Route path="/signup" element={<SignupComponent/>}></Route>
                        <Route path = "/instructorDashboard" element={<Dashboard/>}></Route>
                        <Route path = "/instructorProfile" element={<InstructorProfile/>}></Route>
                        <Route path = "/instructorPwdChange" element={<InstructorPwdChange/>}></Route>
                        <Route path="/studentDashboard" element={<StudentDashboard/>}></Route>
                        <Route path="/studentProfile" element={<StudentProfile/>}></Route>
                        <Route path="/studentLearning" element ={<StudentLearning/>}></Route>
                        <Route path="/studentPwdChange" element ={<StudentPassword/>}></Route>
                        <Route path="/addTestCases" element={<AddTestCases/>}></Route>
                        <Route path="/AddProblem" element={<AddProblem/>}></Route>
                        <Route path="/listproblems" element={<ProblemList/>}></Route>
                        <Route path="/Solution" element={<Solution/>}></Route>
                    </Routes>
                </div>
            </BrowserRouter>
        </div>
    )
        ;
}

export default App;
