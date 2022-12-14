import React, { Component, useState } from 'react'
import { Dropdown } from "react-bootstrap";

import {  Button, Modal, Form } from 'react-bootstrap';
import {Link, Navigate} from "react-router-dom";
import backend_url from '../services/api'
import axios from 'axios';
import Problem from "./Problem";


class ProblemList extends Component {


    state = {
        problems: [],
        redirect: null,
    };
    componentDidMount() {
        axios.get(`${backend_url}/problem/list`).then
        (response =>{
            console.log(response)
            this.setState({problems:response.data})
            console.log(this.state.problems)
        })
            .catch(err =>{
                console.log(err)
            })

    }

    changeBookmark = () => {
        if (this.state.bookmarkIcon === "mdi mdi-bookmark")
            this.setState({ bookmarkIcon: "mdi mdi-bookmark-outline" });
        else this.setState({ bookmarkIcon: "mdi mdi-bookmark" });
    };

    addProblem = () =>{
        this.setState({ridirect:"/ProblemToSolved"});
        this.setState({ redirect: "/addproblem" });
        this.setState(({ridirect: "/instructor"}))

    }

    render() {
        const {problems} = this.state
        return (
            <div className="row">
                <div >
                    {
                        problems.length ?
                            problems.map(problem =>
                                <Problem key ={problem.id} singleProblem={problem}/>
                            ):null
                    }
                </div>
                <Link to= "/Solution"><button>solve</button> </Link>
                <Link to= "/StudentLearning"><button>Back</button> </Link>
            </div>
        )
    }
}

const ListItems = (props) => {
    return (
        <>
            <h4 className="card-title">{props.heading}</h4>

                {props.list.map((item, index) => {
                    return (

                            <div >
                                <label >
                                    <input
                                        type="checkbox"
                                        checked={item.isChecked}
                                        onChange={() => {}}

                                    />

                                    {item.title}
                                </label>

                            </div>

                    );
                })}

        </>

    );
};
export default ProblemList;