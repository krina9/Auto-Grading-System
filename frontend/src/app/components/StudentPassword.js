import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import * as PropTypes from "prop-types";

class StudentPassword extends React.Component {
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
        axios.post(backend_url+"/user/change-password",this.state).then(
            (response) => {
                console.log(response);
            }
        )
    }

    render() {
        return (
        <React.Fragment>
            <form onSubmit={this.handleSubmit}>
                <h1>Update Student Password</h1>
                <div>
                    <label>
                        Old Password:
                        <input name="oldpassword" value={this.state.password} type="text" onChange={this.handleChange} />
                    </label>
                </div>
                <br/>
                <div>
                    <label>
                        New Password:
                        <input name="password" value={this.state.password} type="text" onChange={this.handleChange} />
                    </label>
                </div>
                <br/>
                <button type="submit" value="Update Password" >Update</button>
            </form>
        </React.Fragment>
        );
    }
}
export default StudentPassword;
