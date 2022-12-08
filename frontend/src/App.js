import logo from './logo.svg';
import './App.css';
import Dashboard from "./app/components/Dashboard";
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {
  return (
      <div className="App">
        <BrowserRouter>
          <div>
            <Routes>
              <Route path="/" element={<Dashboard/>}></Route>
            </Routes>
          </div>
        </BrowserRouter>
      </div>
  );
}

export default App;