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
            user: " ",
            score: " ",
            noOfProblemSolved: " ",
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
                <Link to="/StudentLearning">
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
        //api/studentDashboard/{userId}  /api/user/{userId}
        axios.get(backend_url+`/user/${this.state.userId}`).then(
            (response) => {
                this.setState({user :response.data});
            }, (error) => {
                console.log(error)
            }
        );

        // /api/user/{userId}/get-problem-solved
        axios.get(backend_url+`/user/${this.state.userId}/get-problem-solved`).then(
            (response) => {
                this.setState({noOfProblemSolved :response.data});
            }, (error) => {
                console.log(error)
            }
        );

        // user/{userId}/get-score
        axios.get(backend_url+`/user/${this.state.userId}/get-score`).then(
            (response) => {
                this.setState({score :response.data});
            }, (error) => {
                console.log(error)
            }
        );

    }
}

export default StudentDashboard;
