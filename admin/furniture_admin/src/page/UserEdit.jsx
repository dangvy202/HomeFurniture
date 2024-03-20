import React, { Component } from "react";
import userService from "../service/UserService";


class UserEdit extends Component {
    constructor(props) {
        super(props);
        const pathName = window.location.pathname;
        var arrPath = pathName.split("/");
        var userParameter = arrPath[arrPath.length - 1];
        this.state = {
            firstName: "",
            lastName: "",
            userName: "",
            email: "",
            password: "",
            address: "",
            birthday: "",
            role: "",
            nation: "",
            phone: "",
            picture: "",
            updateDate: "",
            param: userParameter
        };
    }

    componentDidMount() {
        userService.getUserDetailByEmail(this.state.param).then((res) => {
            this.setState({ firstName : res.data.resultData.firstName});
            this.setState({ lastName : res.data.resultData.lastName});
            this.setState({ userName : res.data.resultData.userName});
            this.setState({ email : res.data.resultData.email});
            this.setState({ password : res.data.resultData.password});
            this.setState({ address : res.data.resultData.address});
            this.setState({ birthday : res.data.resultData.birthday.split("T")[0]});
            this.setState({ role : res.data.resultData.role});
            this.setState({ nation : res.data.resultData.nation});
            this.setState({ phone : res.data.resultData.phone});
            this.setState({ picture : res.data.resultData.picture});
            this.setState({ updateDate : res.data.resultData.updateDate.split("T")[0]});
        })
    }
    render() {
        return (
            <div className="hold-transition sidebar-mini">
                <div className="wrapper">
                    <div className="content-wrapper">
                        {/* <!-- Content Header (Page header) --> */}
                        <section className="content-header">
                            <div className="container-fluid">
                                <div className="row mb-2">
                                    <div className="col-sm-6">
                                        <h1>DataTables</h1>
                                    </div>
                                    <div className="col-sm-6">
                                        <ol className="breadcrumb float-sm-right">
                                            <li className="breadcrumb-item">
                                                <a href="/">Home</a>
                                            </li>
                                            <li className="breadcrumb-item">
                                                <a href="/user">User</a>
                                            </li>
                                            <li className="breadcrumb-item active">User Edit</li>
                                        </ol>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <div class="card">
                            <div class="card-body register-card-body">

                                <form action="../../index.html" method="post">
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.firstName} class="form-control" placeholder="First name" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.lastName} class="form-control" placeholder="Last name" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.userName} class="form-control" placeholder="Full name" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="email" value={this.state.email} class="form-control" placeholder="Email" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-envelope"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="password" value={this.state.password} class="form-control" placeholder="Password" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.address} class="form-control" placeholder="Address" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.birthday} class="form-control" placeholder="Birthday" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.role} class="form-control" placeholder="Role" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.nation} class="form-control" placeholder="Nation" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.phone} class="form-control" placeholder="Phone" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-lock"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        {/* <!-- /.col --> */}
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-block btn-primary">Save Edit</button>
                                        </div>
                                        {/* <!-- /.col --> */}
                                    </div>
                                    
                                </form>
                            </div>
                            {/* <!-- /.form-box --> */}
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default UserEdit;