import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginComponent from "./components/LoginComponent";
import Register from "./user-pages/register";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <div>
              <Routes>
                  <Route path="/" element={<Register/>}></Route>
                  <Route path = "/login" element={<LoginComponent/>}></Route>
              </Routes>
          </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
