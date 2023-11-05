import React, { Component } from "react";

class Register extends Component {
  render() {
    return (
      <div className="user-register blog">
        {/* <!-- main content --> */}
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
                          action="#"
                          id="customer-form"
                          className="js-customer-form"
                          method="post"
                        >
                          <div>
                            <div className="form-group">
                              <div>
                                <input
                                  className="form-control"
                                  name="firstname"
                                  type="text"
                                  placeholder="First name"
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <input
                                  className="form-control"
                                  name="lastname"
                                  type="text"
                                  placeholder="Last name"
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
                                    max={13}
                                    placeholder="Phone"
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div className="input-group js-parent-focus">
                                  <input
                                    className="form-control js-child-focus js-visible-password"
                                    name="picture"
                                    type="file"
                                    placeholder="Picture"
                                  />
                                </div>
                              </div>
                            </div>
                          </div>
                          <div className="clearfix">
                            <div>
                              <button
                                className="btn btn-primary"
                                data-link-action="sign-in"
                                type="submit"
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
