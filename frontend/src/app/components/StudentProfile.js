import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import {Link} from 'react-router-dom';

class StudentProfile extends React.Component {
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
        axios.post(backend_url+"/user/update-profile",this.state).then(
            (response) => {
                console.log(response);
            }
        )
    }

    render() {
        return (
        <React.Fragment>
            <form onSubmit={this.handleSubmit}>
                <h1>Student Profile Settings</h1>
                <div>
                <label>
                    New First Name:
                    <input name="firstName" type="text" value={this.state.firstName} onChange={this.handleChange} />
                </label>
                </div>
                <br/>
                <div>
                <label>
                    New Last Name:
                    <input name="lastName" value={this.state.lastName} type="text" onChange={this.handleChange} />
                </label>
                </div>
                <br/>
                <div>
                </div>
                <br/>
                <button type="submit" value="Submit" >Update</button>
            </form>
            <br/>
            <Link to="/StudentPwd">
                 <button type="button">
                      Update Password
                 </button>
            </Link>
            <Link to="/studentDashboard">
                <button type="button">
                    Back
                </button>
            </Link>
        </React.Fragment>
        );
    }
}
export default StudentProfile;
