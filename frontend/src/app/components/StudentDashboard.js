import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import * as PropTypes from "prop-types";
import {Link} from 'react-router-dom';

function Button(props) {
    return null;
}

Button.propTypes = {children: PropTypes.node};
// const navigate = useNavigate();
// const navigateToLogin = () => {
//     navigate('/login')
// }

class StudentDashboard extends React.Component {
    constructor(props)
    {
        super(props);
        this.state ={
            user: null,
            score: null,
            noOfProblemSolved: null,
            userId: localStorage.getItem("user_id")
        };
        this.getUserInfo();
    }
    render() {
        return (
            <div>
                <h1>Student Dashboard</h1>
                <h3>First Name: {this.state.user.firstName}</h3>
                <h3>Last Name: {this.state.user.lastName}</h3>
                <h3>Email: {this.state.user.email}</h3>
                <h3>Score: {this.state.score}</h3>
                <h3>No of Problems Solved: {this.state.noOfProblemSolved}</h3>
                <br/>
                <Link to="/StudentProfile">
                     <button type="button">
                          Edit Profile Settings
                     </button>
                </Link>
                <div className="space">
                </div>
                <br/>
                <Link to="/student/learning">
                     <button type="button">
                          Start Learning
                     </button>
                </Link>
                <div className="space">
                </div>
                <br/>
                <Link to="#">
                     <button type="button">
                          Sign out
                     </button>
                </Link>
            </div>
        )
    }
        getUserInfo = function() {
        //api/studentDashboard/{userId}
        axios.get(backend_url+`/user/${this.state.userId}`).then(
            (response) => {
                this.setState({user : response.data});
            }, (error) => {
                console.log(error)
            }
        );

        axios.get(backend_url + `/user/${this.state.userId}/get-problem-solved`).then (
            (response) => {
                this.setState({noOfProblemSolved: response.data});
            } , (err) => {
                console.error(err);
            }
        );

        axios.get(backend_url + `/user/${this.state.userId}/get-score`).then (
            (response) => {
                this.setState({score :response.data});
            }, (err) => {
                console.error(err);
            }
        )
    }
}

export default StudentDashboard;
