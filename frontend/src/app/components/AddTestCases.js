import {Component} from "react";
import { Form } from 'react-bootstrap';
import backend_url from '../services/api'
import axios from 'axios'

class AddTestCases extends Component {
    constructor() {
        super();
        this.state = {

            redirect: null,
            input: '',
            output: '',
            problemId: localStorage.getItem("problemId")
        };
    }

    testCases = []
    input = ''
    output = ''

    handleChange = (e) => {
        this.input = e.target.value
    }

    addIO = (e) => {

        this.output = e.target.value
        console.log(this.input)
        console.log(this.output)
        //console.log(this.count)

        if (this.input != '' && this.output != '') {
            console.log("inside addIO")
            let values = {};
            values["input"] = this.input;
            values["output"] = this.output;
            values['problemId'] = this.state.problemId;
            this.testCases.push(values);
            console.log(this.testCases)
            //this.count =0;
            this.input = ''
            this.output = ''
        }

    }

    addTestCases = (e) => {
        e.preventDefault();
        //console.log("onsubmit")
        let problemId = localStorage.getItem("problemId")
        let userId = localStorage.getItem("user_id")
        axios.post(`${backend_url}/user/problem/test-case/add`,this.testCases).then(
            response => {
                console.log(response)
                alert("Problem added successfully")
            },
            error =>{
                alert(error)
            }
        )
    }

    render() {
        const rows = localStorage.getItem("test_case_count");
        const forms = []
        for (let i = 0; i < rows; i++) {
            forms.push(
                <div>
                    <h4 className="card-title">{`Test Case ${i + 1}`}</h4>
                    <Form.Group>
                        <label>Input</label>
                        <textarea placeholder="Input" className="form-control" rows="5"
                                  onChange={this.handleChange}
                            //name="input"
                            //value={input}
                        ></textarea>
                    </Form.Group>
                    <Form.Group>
                        <label>Output</label>
                        <textarea placeholder="Output" className="form-control" rows="5"
                                  // onChange={this.addIO}
                                  onBlur={this.addIO}
                            //name="output"
                            //value={output}
                        ></textarea>
                    </Form.Group>
                </div>)

        }
        return (
            <div className="main-panel" style={{ marginTop: 20, marginLeft: 100 }}>
                <div className="page-header">
                    <h3 className="page-title">
            <span className="page-title-icon bg-gradient-primary text-white mr-2">
              <i className="mdi mdi-account-box"></i>
            </span>Add Test cases</h3>
                </div>

                <div className="col-12 grid-margin stretch-card">
                    <div className="card">
                        <div className="card-body">
                            <form className="forms-sample" onSubmit={this.addTestCases}>
                                {forms}
                                <button type="submit" className="btn btn-gradient-primary mr-2" >Submit</button>
                                <button className="btn btn-light">Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default AddTestCases;