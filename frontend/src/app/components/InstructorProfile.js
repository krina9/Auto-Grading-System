
import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import * as PropTypes from "prop-types";
import {Link} from "react-router-dom";
class InstructorProfile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userId: localStorage.getItem("user_id"),
            firstName: '',
            lastName: '',
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
                if(response.status===200)
                {
                    alert("Details changed successfully")
                }
            }
        )
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <h1>Instructor Profile Settings</h1>
                <label>
                    New First Name:
                    <input name="firstName" type="text" value={this.state.firstName} onChange={this.handleChange} />
                </label>
                <div className="space">
                </div>
                <label>
                    New Last Name:
                    <input name="lastName" value={this.state.lastName} type="text" onChange={this.handleChange} />
                </label>
                <div className="space">
                </div>
                <button type="submit" value="Submit" >Submit</button>
                <div className="space">
                </div>
                <Link to = "/InstructorPwd"><button type ="submit">Change Password</button></Link>
                <Link to = "/InstructorDashboard"><button type ="submit">Back</button></Link>
            </form>
        );
    }
}
export default InstructorProfile;