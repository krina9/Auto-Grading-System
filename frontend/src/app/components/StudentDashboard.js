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
            firstName: '',
            lastName: '',
            email: '',
            score:'',
            noOfProblemSolved: '',
            userId: localStorage.getItem("user_id")
        };
        this.getUserInfo();
    }
    render() {
        return (
            <div>
                <h1>Student Dashboard</h1>
                <h3>First Name: {this.state.firstName}</h3>
                <h3>Last Name: {this.state.lastName}</h3>
                <h3>Email: {this.state.email}</h3>
                <h3>Score: {this.state.score}</h3>
                <h3>No of Problems Solved: {this.state.noOfProblemSolved}</h3>
                <br/>
                <Link to="/studentProfile">
                     <button type="button">
                          Edit Profile Settings
                     </button>
                </Link>
                <div className="space">
                </div>
                <br/>
                <Link to="/studentLearning">
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
        axios.get(backend_url+`/studentDashboard/${this.state.userId}`).then(
            (response) => {
                this.setState({firstName:response.data.firstName});
                this.setState({lastName:response.data.lastName});
                this.setState({email:response.data.email});
                this.setState({score:response.data.score});
                this.setState({noOfProblemSolved:response.data.numberOfProblemSolved});
            }, (error) => {
                console.log(error)
            }
        )
    }
}

export default StudentDashboard;
