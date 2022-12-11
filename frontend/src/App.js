import React, { Component } from 'react';
import StudentDashboard from "./app/components/StudentDashboard"
import StudentProfile from "./app/components/StudentProfile"
import StudentPassword from "./app/components/StudentPassword"
import StudentLearning from "./app/components/StudentLearning"
import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {
    return (
      <div className="App">
         <BrowserRouter>
                   <div>
                     <Routes>
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
