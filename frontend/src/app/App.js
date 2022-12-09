import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import Register from "./user-pages/register";
import AddProblem from "./components/AddProblem";
import AddTessCases from "./components/AddTessCases";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <div>
              <Routes>
                  <Route path="/" element={<AddProblem/>}></Route>
                  <Route path = "/login" element={<LoginComponent/>}></Route>
              </Routes>
          </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
