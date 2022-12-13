import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import AddProblem from "./components/AddProblem";
import SignupComponent from "./components/SignupComponent";
import ProblemList from "./components/ProblemList";
import AddTestCases from "./components/AddTestCases";
import Solution from "./components/Solution";
import Dashboard from "./components/Dashboard";
import InstructorProfile from "./components/InstructorProfile";
import InstructorPwdChange from "./components/InstructorPwdChange";
import StudentDashboard from "./components/StudentDashboard";
import StudentProfile from "./components/StudentProfile";
import StudentPassword from "./components/StudentPassword";
import StudentLearning from "./components/StudentLearning";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <Routes>
                        <Route path="/login" element={<LoginComponent/>}></Route>
                        <Route path="/signup" element={<SignupComponent/>}></Route>
                        <Route path="/InstructorDashboard" element={<Dashboard/>}></Route>
                        <Route path="/InstructorProfile" element={<InstructorProfile/>}></Route>
                        <Route path="/InstructorPwd" element={<InstructorPwdChange/>}></Route>
                        <Route path="/StudentDashboard" element={<StudentDashboard/>}></Route>
                        <Route path="/StudentProfile" element={<StudentProfile/>}></Route>
                        <Route path="/StudentPwd" element={<StudentPassword/>}></Route>
                        <Route path="/StudentLearning" element={<StudentLearning/>}></Route>
                        <Route path="/AddProblem" element={<AddProblem/>}></Route>
                        <Route path="/addTestCases" element={<AddTestCases/>}></Route>
                        <Route path="/listproblems" element={<ProblemList/>}></Route>
                        <Route path="/Solution" element={<Solution/>}></Route>
                    </Routes>
                </div>
            </BrowserRouter>
        </div>
    );
}

export default App;
