import axios from 'axios'
import React, { Component } from 'react'
import { Form } from 'react-bootstrap'
import { Link, Routes } from "react-router-dom"
import backend_url from '../services/api'


class AddProblem extends Component {

    constructor(props){
        super(props)
        this.state = {

            redirect: null,
            title:'',
            statement:'',
            score:'',
            numOfTestCases:'',
            category:'',
            difficulty:''
        };
    }

    handleChange = e => {
        //console.log(e.target.name)
        this.setState({ [e.target.name]: e.target.value })
    }

    addTestCases = (e) =>{
        e.preventDefault();
        const formdata = new FormData();
        formdata.append("title",this.state.title)
        formdata.append("statement",this.state.statement)
        formdata.append("score",this.state.score)
        formdata.append("numOfTestCases",this.state.numOfTestCases)
        formdata.append("difficulty",this.state.difficulty)
        formdata.append("category",this.state.category)
        formdata.append("userId", localStorage.getItem("user_id"));

        axios.post(`${backend_url}/user/problem/add`,formdata).then(
            (response) => {
                localStorage.setItem("problemId",response.data)
                localStorage.setItem("test_case_count",this.state.numOfTestCases)
                this.setState({redirect:"/addTestCases"})
            },
            (err) => {
                alert(err);
            }
        )

    }
    render() {
        if (this.state.redirect) {
            return <Routes to={this.state.redirect} />
        }

        const {title,statement,numOfTestCases,difficulty,category,score}=this.state

        return (
            <div className="main-panel" style={{ marginTop: 20, marginLeft: 100 }}>

                <div className="page-header">
                    <h3 className="page-title">
            <span className="page-title-icon bg-gradient-primary text-white mr-2">
              <i className="mdi mdi-account-box"></i>
            </span>Add a problem</h3>
                </div>

                <div className="col-12 grid-margin stretch-card">
                    <div className="card">
                        <div className="card-body">
                            <h4 className="card-title">Fill up the form</h4>
                            <form className="forms-sample" onSubmit={this.addTestCases}>
                                <Form.Group>
                                    <br/><label>Problem Title:</label>
                                    <Form.Control type="text" className="form-control" placeholder="Problem Title"
                                                  name="title"
                                                  value={title}
                                                  onChange={this.handleChange}
                                    />
                                </Form.Group>
                                <Form.Group>
                                    <br/><br/> <label >Problem Statement:</label>
                                    <textarea placeholder="Problem Statement" className="form-control" rows="4"
                                              name="statement"
                                              value={statement}
                                              onChange={this.handleChange}
                                    ></textarea>
                                </Form.Group>
                                {/*<Form.Group >*/}
                                {/*    <br/>  <label>Solution File</label>*/}
                                {/*    <div className="custom-file"  >*/}
                                {/*        <Form.Control type="file" id="customFileLang1" lang="es"*/}
                                {/*                      onChange={this.handleFileChange}/>*/}
                                {/*        <label className="custom-file-label" htmlFor="customFileLang1">Upload solution file</label>*/}
                                {/*    </div>*/}
                                {/*</Form.Group>*/}
                                <Form.Group>
                                    <br/><label>Maximum Score:</label>
                                    <Form.Control type="number"  placeholder="Maximum Score"
                                                  name="score"
                                                  value={score}
                                                  onChange={this.handleChange} />
                                </Form.Group>
                                <Form.Group>
                                    <br/><label>Number of test cases:</label>
                                    <Form.Control type="number"  placeholder="Number of test cases"
                                                  name="numOfTestCases"
                                                  value={numOfTestCases}
                                                  onChange={this.handleChange}/>
                                </Form.Group>
                                <Form.Group>
                                    <br/> <label>Category:</label>
                                    <Form.Control type="text" placeholder="Problem Title"
                                                  name="category"
                                                  value={category}
                                                  onChange={this.handleChange} />
                                </Form.Group>
                                <Form.Group>
                                    <br/><label>Difficulty:</label>
                                    <Form.Control type="text"  placeholder="Problem Title"
                                                  name="difficulty"
                                                  value={difficulty}
                                                  onChange={this.handleChange} />
                                </Form.Group>
                                <br/><button type="submit" >Next</button>
                                <button >Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

    export default AddProblem;