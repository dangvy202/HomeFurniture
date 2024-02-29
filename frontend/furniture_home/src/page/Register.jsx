import React, { Component } from "react";
import InfomationService from "../service/InfomationService";

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      first_name: "",
      last_name: "",
      user_name: "",
      email: "",
      password: "",
      address: "",
      birthday: "",
      nation: "",
      phone: "",
      status: false,
      error: "",
      message: "PROCESS",
    };
    this.onChageFirstName = this.onChageFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeUserName = this.onChangeUserName.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.onChangeAddress = this.onChangeAddress.bind(this);
    this.onChangeBirthday = this.onChangeBirthday.bind(this);
    this.onChangeNation = this.onChangeNation.bind(this);
    this.onChangePhone = this.onChangePhone.bind(this);
    this.regiterAccount = this.regiterAccount.bind(this);
    this.openPopup = this.openPopup.bind(this);
  }

  onChageFirstName(e) {
    this.setState({ first_name: e.target.value });
  }

  onChangeLastName(e) {
    this.setState({ last_name: e.target.value });
  }

  onChangeUserName(e) {
    this.setState({ user_name: e.target.value });
  }

  onChangeEmail(e) {
    this.setState({ email: e.target.value });
  }

  onChangePassword(e) {
    this.setState({ password: e.target.value });
  }

  onChangeAddress(e) {
    this.setState({ address: e.target.value });
  }

  onChangeBirthday(e) {
    this.setState({ birthday: e.target.value });
  }

  onChangeNation(e) {
    this.setState({ nation: e.target.value });
  }

  onChangePhone(e) {
    this.setState({ phone: e.target.value });
  }

  regiterAccount(e) {
    e.preventDefault();
    InfomationService.register(
      this.state.first_name,
      this.state.last_name,
      this.state.user_name,
      this.state.email,
      this.state.password,
      this.state.address,
      this.state.birthday,
      this.state.nation,
      this.state.phone
    )
      .then((res) => {
        this.setState({ status: res.data.status });
        this.setState({ error: res.data.error });
        this.setState({ message: res.data.message });
      })
      .catch((error) => {
        this.setState({ status: false });
        this.setState({ error: "FAIL" });
        this.setState({ message: "REJECT" });
      });
  }
  render() {
    return (
      <div className="user-register blog">
        {/* <!-- main content --> */}
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
                    this.state.message === "ACCOUNT NOT EXIST" &&
                    this.state.error === "ACCOUNT NOT EXIST" &&
                    this.state.status === true
                  ) {
                    return <>CAN'T REGISTER ACCOUNT</>;
                  } else if (
                    this.state.message === "SUCCESS" &&
                    this.state.error === null &&
                    this.state.status === true
                  ) {
                    return <>REGISTER SUCCESS</>;
                  } else if (
                    this.state.message === "EMAIL EXIST" &&
                    this.state.error === "FAIL" &&
                    this.state.status === false
                  ) {
                    return <>ACCOUNT EXITS</>;
                  } else {
                    return <>REGISTER FAIL</>;
                  }
                })()}
              </div>
              <div className="modal-footer">
                <button
                  type="button"
                  className="btn btn-secondary"
                  data-dismiss="modal"
                >
                  Close
                </button>
                <a href="/" className="btn btn-primary">
                  Back Home
                </a>
              </div>
            </div>
          </div>
        </div>

        <div className="main-content">
          <div className="wrap-banner">
            {/* <!-- breadcrumb --> */}
            <nav className="breadcrumb-bg">
              <div className="container no-index">
                <div className="breadcrumb">
                  <ol>
                    <li>
                      <a href="/">
                        <span>Home</span>
                      </a>
                    </li>
                    <li>
                      <span>Register</span>
                    </li>
                  </ol>
                </div>
              </div>
            </nav>
          </div>

          {/* <!-- main --> */}
          <div id="wrapper-site">
            <div className="container">
              <div className="row">
                <div
                  id="content-wrapper"
                  className="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol"
                >
                  <div id="main">
                    <div id="content" className="page-content">
                      <div className="register-form text-center">
                        <h1 className="text-center title-page">
                          Create Account
                        </h1>
                        <form
                          id="customer-form"
                          className="js-customer-form"
                          onSubmit={(e) => this.regiterAccount(e)}
                        >
                          <div>
                            <div className="form-group">
                              <div>
                                <input
                                  className="form-control"
                                  name="first_name"
                                  type="text"
                                  placeholder="First name"
                                  onChange={this.onChageFirstName}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <input
                                  className="form-control"
                                  name="last_name"
                                  type="text"
                                  placeholder="Last name"
                                  onChange={this.onChangeLastName}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <input
                                  className="form-control"
                                  name="user_name"
                                  type="text"
                                  placeholder="Full name"
                                  onChange={this.onChangeUserName}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <input
                                  className="form-control"
                                  name="email"
                                  type="email"
                                  placeholder="Email"
                                  onChange={this.onChangeEmail}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div className="input-group js-parent-focus">
                                  <input
                                    className="form-control js-child-focus js-visible-password"
                                    name="password"
                                    type="password"
                                    placeholder="Password"
                                    onChange={this.onChangePassword}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div className="input-group js-parent-focus">
                                  <input
                                    className="form-control js-child-focus js-visible-password"
                                    name="address"
                                    type="text"
                                    placeholder="Address"
                                    onChange={this.onChangeAddress}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div className="input-group js-parent-focus">
                                  <input
                                    className="form-control js-child-focus js-visible-password"
                                    name="birthday"
                                    type="date"
                                    placeholder="Birthday"
                                    onChange={this.onChangeBirthday}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div className="input-group js-parent-focus">
                                  <input
                                    className="form-control js-child-focus js-visible-password"
                                    name="nation"
                                    type="text"
                                    placeholder="Nation"
                                    onChange={this.onChangeNation}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div className="input-group js-parent-focus">
                                  <input
                                    className="form-control js-child-focus js-visible-password"
                                    name="phone"
                                    type="number"
                                    min={5}
                                    placeholder="Phone"
                                    onChange={this.onChangePhone}
                                  />
                                </div>
                              </div>
                            </div>
                          </div>
                          <div className="clearfix">
                            <div>
                              {/* <!-- Button trigger modal --> */}
                              <button
                                className="btn btn-primary"
                                type="submit"
                                data-toggle="modal"
                                data-target="#exampleModal"
                              >
                                Create Account
                              </button>
                            </div>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Register;
