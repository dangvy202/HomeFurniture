import React, { Component } from "react";
import InfomationService from "../service/InfomationService";

class editAccount extends Component {
  constructor(props) {
    super(props);
    this.state = {
      first_name: "",
      last_name: "",
      user_name: "",
      address: "",
      birthday: "",
      nation: "",
      phone: "",
      picture: "",
      status: false,
      error: "",
      message: "PROCESS",
    };
    this.onChageFirstName = this.onChageFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeUserName = this.onChangeUserName.bind(this);
    this.onChangeAddress = this.onChangeAddress.bind(this);
    this.onChangeBirthday = this.onChangeBirthday.bind(this);
    this.onChangeNation = this.onChangeNation.bind(this);
    this.onChangePhone = this.onChangePhone.bind(this);
    this.onChangePicture = this.onChangePicture.bind(this);
    this.editAccount = this.editAccount.bind(this);
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

  onChangePicture(e) {
    this.setState({ picture: e.target.value });
  }
  componentDidMount() {
    if (sessionStorage.getItem("email") != null) {
      InfomationService.infomation(sessionStorage.getItem("email")).then(
        (res) => {
          this.setState({ first_name: res.data.user.first_name });
          this.setState({ last_name: res.data.user.last_name });
          this.setState({ fullName: res.data.user.username });
          this.setState({ email: res.data.user.email });
          this.setState({ address: res.data.user.address });
          this.setState({ birthday: res.data.user.birthday });
          this.setState({ nation: res.data.user.nation });
          this.setState({ phone: res.data.user.phone });
          this.setState({ picture: res.data.user.picture });
        }
      );
    } else {
      window.location.href = "/login";
    }
  }

  editAccount(e) {
    e.preventDefault();
    // popup.hidden();
    InfomationService.editAccount(
      this.state.first_name,
      this.state.last_name,
      this.state.user_name,
      this.state.address,
      this.state.birthday,
      this.state.nation,
      this.state.phone,
      this.state.picture
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
                {/* {(() => {
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
                })()} */}
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
                      <span>Edit</span>
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
                        <h1 className="text-center title-page">Edit Account</h1>
                        <form
                          id="customer-form"
                          className="js-customer-form"
                          onSubmit={(e) => this.editAccount(e)}
                        >
                          <div>
                            <div className="form-group">
                              <div>
                                <p>First Name</p>
                                <input
                                  className="form-control"
                                  name="first_name"
                                  type="text"
                                  placeholder="First name"
                                  onChange={this.onChageFirstName}
                                  value={this.state.first_name}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <p>Last Name</p>
                                <input
                                  className="form-control"
                                  name="last_name"
                                  type="text"
                                  placeholder="Last name"
                                  onChange={this.onChangeLastName}
                                  value={this.state.last_name}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <p>Full Name</p>
                                <input
                                  className="form-control"
                                  name="user_name"
                                  type="text"
                                  placeholder="Full name"
                                  onChange={this.onChangeUserName}
                                  value={this.state.fullName}
                                />
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div>
                                  <p>Address</p>
                                  <input
                                    className="form-control"
                                    name="address"
                                    type="text"
                                    placeholder="Address"
                                    onChange={this.onChangeAddress}
                                    value={this.state.address}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div>
                                  <p>Birthday</p>
                                  <input
                                    className="form-control"
                                    name="birthday"
                                    type="date"
                                    placeholder="Birthday"
                                    onChange={this.onChangeBirthday}
                                    value={this.state.birthday}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div>
                                  <p>Nation</p>
                                  <input
                                    className="form-control"
                                    name="nation"
                                    type="text"
                                    placeholder="Nation"
                                    onChange={this.onChangeNation}
                                    value={this.state.nation}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div>
                                  <p>Phone Number</p>
                                  <input
                                    className="form-control"
                                    name="phone"
                                    type="number"
                                    min={5}
                                    placeholder="Phone"
                                    onChange={this.onChangePhone}
                                    value={"0" + this.state.phone}
                                  />
                                </div>
                              </div>
                            </div>
                            <div className="form-group">
                              <div>
                                <div>
                                  <p>Picture</p>
                                  <input
                                    className="form-control"
                                    name="picture"
                                    type="file"
                                    placeholder="Picture"
                                    onChange={this.onChangePicture}
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
                                Save Edit
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

export default editAccount;
