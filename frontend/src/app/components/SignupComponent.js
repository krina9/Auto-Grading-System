import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import {Link} from "react-router-dom";
class SignupComponent extends React.Component{
    constructor(props) {
        super(props);
        this.state ={
            firstName: "",
            lastName: "",
            email:"",
            password:"",
            role:"STUDENT",

        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    handleInputChange(event){
        event.preventDefault();
        const target = event.target;
        this.setState({
            [target.name]: target.value,
        });

    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state);
        axios.post(backend_url + "/signup", this.state).then(
            (response) => {
                console.log(response);
            }
        )
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Firstname
                        <input
                            name="firstName"
                            type="text"
                            value={this.state.firstName}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <label>
                        Lastname
                        <input
                            name="lastName"
                            type="text"
                            value={this.state.lastName}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <label>
                        email
                        <input
                            name="email"
                            type="email"
                            value={this.state.email}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <label>
                        Password
                        <input
                            name="password"
                            type="password"
                            value={this.state.password}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <label>
                        role
                        <select name ="role" type="text" value={this.state.role} onChange={this.handleInputChange}>
                            <option value="STUDENT">student</option>
                            <option value ="FACULTY">faculty</option>
                        </select>
                    </label>

                    <button type="submit">Sign up</button>
                    <Link to = "/login"><button>Login</button></Link>
                </form>
            </div>
        );
    }



}

export default SignupComponent;