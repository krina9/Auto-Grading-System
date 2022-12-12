import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import Register from "./user-pages/register";
import AddProblem from "./components/AddProblem";
import AddTessCases from "./components/Instructor";
import ListProblem from "./components/Student";
import SignupComponent from "./components/SignupComponent";
import Student from "./components/Student";
import Instructor from "./components/Instructor";
import ProblemList from "./components/ProblemList";
import AddTestCases from "./components/AddTestCases";
import Solution from "./components/Solution";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <Routes>
                        <Route path="/addTestCases" element={<AddTestCases/>}></Route>
                        <Route path="/login" element={<LoginComponent/>}></Route>
                        <Route path="/Student" element={<Student/>}></Route>
                        <Route path="/Instructor" element={<Instructor/>}></Route>
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
