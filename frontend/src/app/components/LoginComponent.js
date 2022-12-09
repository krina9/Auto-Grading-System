import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import {Link} from "react-router-dom";

class LoginComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: ""
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleInputChange(event) {
        event.preventDefault();
        const target = event.target;
        this.setState({
            [target.name]: target.value,
        });
    }
    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state);
        axios.post(backend_url + "/login", this.state).then(
            (response) => {
                if(response.status === 200){
                    alert("login success");
                    console.log(response.data);
                    localStorage.setItem('user_id', response.data.userId);
                    if(response.data.role === "STUDENT"){

                    }
                }
            }
        )
    }
    render() {
        return (
            <div>
                <label>
                    {this.firstName}
                </label>
                <form onSubmit={this.handleSubmit}>
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
                        password
                        <input
                            name="password"
                            type="password"
                            value={this.state.password}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <button type="submit">log In</button>
                </form>
            </div>
        );
    }
}
 export default LoginComponent;