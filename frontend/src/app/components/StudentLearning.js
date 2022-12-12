import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import * as PropTypes from "prop-types";
import {Link} from 'react-router-dom';

class StudentLearning extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userId: localStorage.getItem("user_id"),
            firstName: '',
            lastName: '',
            email: '',
            password: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange(event)
    {
        event.preventDefault();
        const target = event.target;
        this.setState({
            [target.name]: target.value,
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state);
    }

    render() {
        return (
        <React.Fragment>
            <h1>Student Learning Portal</h1>
            <div className="container">
                <select id="concept" value="" onChange={this.handleChange}>
                    <option value="">Filter By Concept</option>
                    <option value="DataType">DataType</option>
                    <option value="Strings">Strings</option>
                    <option value="Arrays">Arrays</option>
                </select>
                <table border="1">
                    <thead>
                        <tr>
                            <th>SN</th>
                            <th>Problem</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Introduction to Java</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Introduction to Java</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Introduction to Java</td>
                        </tr>
                    </tbody>
                </table>
                <Link to="#">
                    <button type="button">
                        Start Solving
                    </button>
                </Link>
            </div>
        </React.Fragment>
        );
    }
}
export default StudentLearning;