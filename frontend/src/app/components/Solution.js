import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import { Form } from 'react-bootstrap'
import {Link} from "react-router-dom";
class Solution extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            solution: null,
            userId: localStorage.getItem("user_id"),
            problemId: localStorage.getItem("problemId")
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }
    onFileChange = event => {

        // Update the state
        this.setState({ solution: event.target.files[0] });

    };

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
        const formData = new FormData();
        formData.append("solution", this.state.solution);
        axios.post(backend_url + `/user/${this.state.userId}/problem/${this.state.problemId}/solve`, formData).then(
            (response) => {
                console.log(response);
                if (response.status === 200) {
                    console.log(response.data);
                }
            }, (err) =>
            {
                alert("Successful");
            }
        )
    }
    handleFileChange = e => {
        e.preventDefault();
        //console.log(e.target.files[0])
        //console.log(typeof(e.target.files))
        this.setState({ solution : e.target.files[0] })
        //console.log(this.state.solution)
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <h1>Solution Upload page</h1>
                <p>Please upload your .java file using the button!</p>
                <div className="space">
                </div>
                <input
                    type="file"
                    style={{ display: 'none' }}
                    id="contained-button-file"
                />
                <Form.Group >
                    <div className="custom-file"  >
                        <Form.Control type="file" className="form-control visibility-hidden" id="customFileLang1" lang="es"
                                      onChange={this.handleFileChange}/>
                    </div>
                    <button type="submit" value="Submit" >Submit</button>
                    <div className="space">
                    </div>
                   <Link to="/listproblems"> <button type="submit" value="Submit" >Back</button></Link>
                </Form.Group>
            </form>
        );
    }
}

export default Solution;