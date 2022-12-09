
import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import * as PropTypes from "prop-types";
class InstructorProfile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: '',
            lastName: '',
            email: localStorage.getItem("user_email")
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
        axios.post(backend_url+"/api/user/update",this.state).then(
            (response) => {
                console.log(response);
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
                <button type="submit" value="Submit" >Button</button>
            </form>
        );
    }
}
export default InstructorProfile;