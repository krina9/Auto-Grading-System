import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import InstructorProfile from "./InstructorProfile";
class InstructorPwdChange extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userId: localStorage.getItem("user_id"),
            oldPassword: '',
            newPassword: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        event.preventDefault();
        const target = event.target;
        this.setState({
            [target.name]: target.value,
        });
    }
    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state);
        axios.post(backend_url+"/api/user/change-password",this.state).then(
            (response) => {
                console.log(response);
                if(response.status===200)
                {
                    alert("Password changed successfully")
                }
            }
        )
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <h1>Instructor Password Change</h1>
                <label>
                    Current Password:
                    <input name="oldPassword" type="password" value={this.state.oldPassword} onChange={this.handleChange} />
                </label>
                <div className="space">
                </div>
                <label>
                    New Password:
                    <input name="newPassword" value={this.state.newPassword} type="password" onChange={this.handleChange} />
                </label>
                <div className="space">
                </div>
                <button type="submit" value="Submit" >Submit</button>
            </form>
        );
    }
}
export default InstructorPwdChange;