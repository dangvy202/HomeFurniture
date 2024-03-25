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
            status: false,
            error: "",
            message: "",
            param: userParameter
        };
        this.editUser = this.editUser.bind(this);
        this.onChangePhone = this.onChangePhone.bind(this);
        this.onChangeNation = this.onChangeNation.bind(this);
        this.onChangeBirthday = this.onChangeBirthday.bind(this);
        this.onChangeAddress = this.onChangeAddress.bind(this);
        this.onChangePassword = this.onChangePassword.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.onChangeUserName = this.onChangeUserName.bind(this);
        this.onChangeLastName = this.onChangeLastName.bind(this);
        this.onChangeFirstName = this.onChangeFirstName.bind(this);
        this.onChangeRole = this.onChangeRole.bind(this);
        this.loadPageWhenEditSuccess = this.loadPageWhenEditSuccess.bind(this);
    }

    componentDidMount() {
        userService.getUserDetailByEmail(this.state.param).then((res) => {
            this.setState({ firstName: res.data.resultData.firstName });
            this.setState({ lastName: res.data.resultData.lastName });
            this.setState({ userName: res.data.resultData.userName });
            this.setState({ email: res.data.resultData.email });
            this.setState({ password: res.data.resultData.password });
            this.setState({ address: res.data.resultData.address });
            this.setState({ birthday: res.data.resultData.birthday.split("T")[0] });
            this.setState({ role: res.data.resultData.role });
            this.setState({ nation: res.data.resultData.nation });
            this.setState({ phone: res.data.resultData.phone });
            this.setState({ picture: res.data.resultData.picture });
            this.setState({ updateDate: res.data.resultData.updateDate.split("T")[0] });
        })
    }

    loadPageWhenEditSuccess() {
        window.location.href="/user-edit/" + this.state.param
    }

    onChangeRole(e) {
        this.setState({ role: e.target.value })
    }

    onChangeFirstName(e) {
        this.setState({ firstName: e.target.value })
    }

    onChangeLastName(e) {
        this.setState({ lastName: e.target.value })
    }

    onChangeUserName(e) {
        this.setState({ userName: e.target.value })
    }

    onChangeEmail(e) {
        this.setState({ email: e.target.value })
    }

    onChangePhone(e) {
        this.setState({ phone: e.target.value });
    }

    onChangeNation(e) {
        this.setState({ nation: e.target.value })
    }

    onChangeBirthday(e) {
        this.setState({ birthday: e.target.value });
    }

    onChangeAddress(e) {
        this.setState({ address: e.target.value })
    }

    onChangePassword(e) {
        this.setState({ password: e.target.value })
    }

    editUser(e) {

        e.preventDefault();
        userService.saveEditUser(
            this.state.firstName,
            this.state.lastName,
            this.state.userName,
            this.state.email,
            this.state.password,
            this.state.address,
            this.state.birthday,
            this.state.role,
            this.state.nation,
            this.state.phone
        ).then((res) => {
            this.setState({ status: true });
            this.setState({ message: res.data.message })
        }).catch((error) => {
            this.setState({ message: error.response.data.message })
        })
    }
    render() {
        return (
            <div className="hold-transition sidebar-mini">
                <div
                    className="modal fade"
                    id="exampleModal"
                    tabIndex="-1"
                    role="dialog"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true"
                >
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">
                                    {this.state.message === "SUCCESS" ? "Message" : "Error!"}
                                </h5>
                                <button
                                    type="button"
                                    className="close"
                                    data-dismiss="modal"
                                    aria-label="Close"
                                >
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                {(() => {
                                    if (
                                        this.state.message === "SUCCESS"
                                    ) {
                                        return <>Edit information user success.</>;
                                    } else {
                                        return <>Edit information fail, please check again !!!</>;
                                    }
                                })()}
                            </div>
                            <div className="modal-footer">
                                <a href="/user" className="btn btn-primary">
                                    Back User
                                </a>
                                <a
                                    onClick={this.loadPageWhenEditSuccess}
                                    type="button"
                                    className="btn btn-secondary"
                                    data-dismiss="modal"
                                >
                                    Close
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
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
                                <form onSubmit={(e) => this.editUser(e)}>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.firstName} onChange={this.onChangeFirstName} class="form-control" placeholder="First name" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.lastName} onChange={this.onChangeLastName} class="form-control" placeholder="Last name" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.userName} onChange={this.onChangeUserName} class="form-control" placeholder="Full name" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="email" value={this.state.email} onChange={this.onChangeEmail} class="form-control" placeholder="Email" disabled />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-envelope"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="password" value={this.state.password} onChange={this.onChangePassword} class="form-control" placeholder="Password" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.address} onChange={this.onChangeAddress} class="form-control" placeholder="Address" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="date" value={this.state.birthday} onChange={this.onChangeBirthday} class="form-control" placeholder="Birthday" />
                                    </div>
                                    <div class="input-group mb-3">
                                        <select class="form-control" onChange={this.onChangeRole}>
                                            {(() => {
                                                if (this.state.role === "ADMIN") {
                                                    return (
                                                        <>
                                                            <option value="USER">USER</option>
                                                            <option value="ADMIN" selected>ADMIN</option>
                                                            ;
                                                        </>
                                                    );
                                                } else {
                                                    return (
                                                        <>
                                                            <option value="USER" selected>USER</option>
                                                            <option value="ADMIN">ADMIN</option>
                                                            ;
                                                        </>
                                                    );
                                                }
                                            })()}
                                        </select>
                                        {/* <input type="text" value={this.state.role} class="form-control" placeholder="Role" /> */}
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="text" value={this.state.nation} onChange={this.onChangeNation} class="form-control" placeholder="Nation" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-user"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-3">
                                        <input type="number" value={this.state.phone} onChange={this.onChangePhone} class="form-control" placeholder="Phone" />
                                        <div class="input-group-append">
                                            <div class="input-group-text">
                                                <span class="fas fa-lock"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        {/* <!-- /.col --> */}
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-block btn-primary"
                                                data-toggle="modal"
                                                data-target="#exampleModal">Save Edit</button>
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