/* eslint-disable no-unused-expressions */
import React from "react";
import { Component } from "react";
import LoginService from "../service/LoginService";

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      password: "",
      isLogin: true,
    };
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.loginAccount = this.loginAccount.bind(this);
  }
  componentDidMount() {
    if (
      sessionStorage.getItem("status") != null ||
      sessionStorage.getItem("message") != null ||
      sessionStorage.getItem("token") != null ||
      sessionStorage.getItem("expired") != null ||
      sessionStorage.getItem("email") != null
    ) {
      window.location.href = "/infomation";
    }
  }

  onChangeEmail(e) {
    this.setState({ email: e.target.value });
  }
  onChangePassword(e) {
    this.setState({ password: e.target.value });
  }
  async loginAccount(e) {
    e.preventDefault();
    LoginService.login(this.state.email, this.state.password)
      .then((res) => {
        this.setState({ isLogin: "false" });
        sessionStorage.setItem("status", res.data.status);
        sessionStorage.setItem("message", "SUCCESS");
        sessionStorage.setItem("token", res.data.token);
        sessionStorage.setItem("expired", res.data.expired);
        sessionStorage.setItem("email", this.state.email);
      })
      .catch((error) => {
        this.setState({ isLogin: false });
      });
  }

  render() {
    return (
      <body className="user-login blog">
        <div className="main-content">
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
                    {this.state.isLogin === false ? "Error!" : "Message!"}
                  </h5>
                  {(() => {
                    if (this.state.isLogin === false) {
                      return (
                        <>
                          <button
                            type="button"
                            className="close"
                            data-dismiss="modal"
                            aria-label="Close"
                          >
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </>
                      );
                    } else {
                      return (
                        <>
                          <a href="/" className="close">
                            <span aria-hidden="true">&times;</span>
                          </a>
                        </>
                      );
                    }
                  })()}
                </div>
                <div className="modal-body">
                  {(() => {
                    if (this.state.isLogin === false) {
                      return <>LOGIN FAIL</>;
                    } else {
                      return <>LOGIN SUCCESS</>;
                    }
                  })()}
                </div>
                <div className="modal-footer">
                  {(() => {
                    if (this.state.isLogin === false) {
                      return (
                        <>
                          <button
                            type="button"
                            className="btn btn-secondary"
                            data-dismiss="modal"
                          >
                            Close
                          </button>
                        </>
                      );
                    }
                  })()}

                  <a href="/" className="btn btn-primary">
                    Back Home
                  </a>
                </div>
              </div>
            </div>
          </div>

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
                      <span>Login</span>
                    </li>
                  </ol>
                </div>
              </div>
            </nav>
          </div>

          {/* <!-- main --> */}
          <div id="wrapper-site">
            <div id="content-wrapper" className="full-width">
              <div id="main">
                <div className="container">
                  <h1 className="text-center title-page">Log In</h1>

                  <div className="login-form">
                    <form onSubmit={(e) => this.loginAccount(e)}>
                      <div>
                        <div className="form-group no-gutters">
                          <input
                            className="form-control"
                            name="email"
                            type="email"
                            placeholder=" Email"
                            onChange={this.onChangeEmail}
                          />
                        </div>
                        <div className="form-group no-gutters">
                          <div className="input-group js-parent-focus">
                            <input
                              className="form-control js-child-focus js-visible-password"
                              name="password"
                              type="password"
                              placeholder=" Password"
                              onChange={this.onChangePassword}
                            />
                          </div>
                        </div>
                        {/* <div className="form-group no-gutters">
                            <div className="input-group js-parent-focus">
                              <input
                                className="form-control js-child-focus js-visible-password"
                                name="password"
                                type="password"
                                value=""
                                placeholder="Password"
                              />
                            </div>
                          </div> */}
                        <div className="no-gutters text-center">
                          <div className="forgot-password">
                            <a href="user-reset-password.html" rel="nofollow">
                              Forgot your password?
                            </a>
                          </div>
                        </div>
                      </div>
                      <div className="clearfix">
                        <div className="text-center no-gutters">
                          <input type="hidden" name="submitLogin" value="1" />
                          <button
                            className="btn btn-primary"
                            data-toggle="modal"
                            data-target="#exampleModal"
                            type="submit"
                          >
                            Sign in
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
      </body>
    );
  }
}

export default Login;
