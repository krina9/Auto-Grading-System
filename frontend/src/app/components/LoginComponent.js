import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import {Link, Navigate, Route, Routes} from "react-router-dom";
import {useNavigate} from "react-router-dom";
import {RedirectFunction} from "react-router-dom";

class LoginComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
            redirect: ""
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
                    if(response.data.role === "STUDENT") {
                        this.setState({ redirect: "/studentDashboard" });
                    }else{
                        this.setState({ redirect: "/instructorDashboard" });

                    }

                }
            }
        )
    }

    render() {
        if (this.state.redirect) {
            return <Navigate to={this.state.redirect} />
        }
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
                    <Link to= "/"><button type="submit">Signup?</button></Link>
                </form>
            </div>
        );
    }
}
 export default LoginComponent;