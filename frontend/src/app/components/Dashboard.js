import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import * as PropTypes from "prop-types";
import {Link} from "react-router-dom";
import InstructorProfile from "./InstructorProfile";
function Button(props) {
    return null;
}

Button.propTypes = {children: PropTypes.node};
// const navigate = useNavigate();
// const navigateToLogin = () => {
//     navigate('/login')
// }

class Dashboard extends React.Component {
    constructor(props)
    {
        super(props);
        this.state ={
            firstName: '',
            lastName: '',
            email: '',
            user_id: localStorage.getItem("user_id")
        };
        this.getUserInfo();
    }
    render() {
        return (
            <div>
                <h1>Instructor Dashboard</h1>
                <h2>First Name: {this.state.firstName}</h2>
                <h2>Last Name: {this.state.lastName}</h2>
                <h3>Email: {this.state.email}</h3>
                <Link to = "/InstructorProfile"><button type="submit">Profile Settings</button></Link>
                <div className="space">
                </div>
                <button type="submit">Add Questions</button>
                <div className="space">
                </div>
                <label>Number of problems added : 0</label>
                <div className="space">
                </div>
                <Link to= "/login"><button type="submit">Sign out</button></Link>
            </div>
        )
    }
        getUserInfo = function() {
        axios.get(backend_url+`/user/${this.state.user_id}`).then(
            (response) => {
                this.setState({firstName:response.data.firstName});
                this.setState({lastName:response.data.lastName});
                this.setState({email:response.data.email});
            }, (error) => {
                console.log(error)
            }
        )
    }
}
export default Dashboard

