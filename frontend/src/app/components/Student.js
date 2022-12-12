import React from 'react';
import {Link} from "react-router-dom";
import {render} from "@testing-library/react";
class Student extends React.Component {


    render() {
        return (
            <div className="App">
                Hello World !SS
                <Link to = "/login"><button>SignOut</button></Link>
            </div>
        );
    }
}
export default Student;