import React from "react";
import axios from "axios";
import backend_url from "../services/api";
import { Form } from 'react-bootstrap'
class Solution extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedFile: null,
            userId: localStorage.getItem("user_id")
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }
    onFileChange = event => {

        // Update the state
        this.setState({ selectedFile: event.target.files[0] });

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
        axios.post(backend_url + "/api/user/upload-solution", this.state).then(
            (response) => {
                console.log(response);
                if (response.status === 200) {
                    alert("Solution file uploaded successfully")
                }
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
                    <button type="submit" value="Submit" >Cancel</button>
                </Form.Group>
            </form>
        );
    }
}

export default Solution;