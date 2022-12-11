import React from "react";

const Problem =({singleProblem}) => {
    return(
        <div className="row">
            <div className="col-sm-12 grid-margin stretch-card">
                <div class="card text-white bg-dark mb-3">
                    <div class="card">
                        {singleProblem.id}
                    </div>
                    <div class="card-header" >
                        {singleProblem.title}
                    </div>
                    <div class="card-body">
                        <div className="row">
                        <span class="col card-text">
                            <ul className="list-inline">
                                <li>
                                    <i className="mdi mdi-bullseye"></i>{singleProblem.difficulty}
                                </li>
                                <li></li>
                                <li>{singleProblem.category}</li>
                            </ul>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Problem;