import React from "react";
import { Component } from "react";
import ContactService from "../service/ContactService";

class Contact extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      email: "",
      hotline: "",
      address: "",
      title: "",
      description: "",
      message: "",
      informationContactAdmin: [],
      contactDescription: {},
      informationContactClient: {},
    };
    this.onChageName = this.onChageName.bind(this);
    this.onChageEmail = this.onChageEmail.bind(this);
    this.onChageHotline = this.onChageHotline.bind(this);
    this.onChageAddress = this.onChageAddress.bind(this);
    this.onChageTitle = this.onChageTitle.bind(this);
    this.onChageDescription = this.onChageDescription.bind(this);
    this.addContact = this.addContact.bind(this);
  }

  onChageName(e) {
    this.setState({ name: e.target.value });
  }

  onChageEmail(e) {
    this.setState({ email: e.target.value });
  }

  onChageHotline(e) {
    this.setState({ hotline: e.target.value });
  }

  onChageAddress(e) {
    this.setState({ address: e.target.value });
  }

  onChageTitle(e) {
    this.setState({ title: e.target.value });
  }

  onChageDescription(e) {
    this.setState({ description: e.target.value });
  }

  componentDidMount() {
    ContactService.getInformationContactAdmin().then((res) => {
      this.setState({
        informationContactAdmin: res.data.informationContactAdminDetailList,
      });
    });
  }

  addContact(e) {
    e.preventDefault();
    let process = "CREATE";
    let message = "CONTACT SUCCESS";

    ContactService.saveContact(
      process,
      message,
      this.state.title,
      this.state.description,
      this.state.name,
      this.state.email,
      this.state.hotline,
      this.state.address
    )
      .then((res) => {
        this.setState({ message: res.data.message });
      })
      .catch((error) => {
        this.setState({ message: error.response.data.message });
      });
  }
  render() {
    return (
      <div id="contact">
        <div class="main-content">
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
                    {(() => {
                      if (this.state.message === "SUCCESS") {
                        return <>Notification</>;
                      } else {
                        return <>Error !</>;
                      }
                    })()}
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
                    if (this.state.message === "SUCCESS") {
                      return (
                        <>Success, we will send you a message to your gmail</>
                      );
                    } else {
                      return <>Fail, please try again !</>;
                    }
                  })()}
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-primary"
                    data-dismiss="modal"
                    aria-label="Close"
                  >
                    Close
                  </button>
                  {/* <a href="/" className="btn btn-primary">
                            
                          </a> */}
                </div>
              </div>
            </div>
          </div>

          {/* <!-- breadcrumb --> */}
          <nav class="breadcrumb-bg">
            <div class="container no-index">
              <div class="breadcrumb">
                <ol>
                  <li>
                    <a href="/">
                      <span>Home</span>
                    </a>
                  </li>
                  <li>
                    <span>Contact</span>
                  </li>
                </ol>
              </div>
            </div>
          </nav>
          <div id="wrapper-site">
            <div id="content-wrapper">
              <div id="main">
                <div class="page-home">
                  <div class="container">
                    <h1 class="text-center title-page">Contact Us</h1>
                    <div class="row-inhert">
                      <div class="header-contact">
                        <div class="row">
                          <div class="col-xs-12 col-sm-4 col-md-4">
                            <div class="item d-flex">
                              <div class="item-left">
                                <div class="icon">
                                  <i class="zmdi zmdi-email"></i>
                                </div>
                              </div>
                              <div class="item-right d-flex">
                                <div class="title">Email:</div>
                                <div class="contact-content">
                                  {this.state.informationContactAdmin.map(
                                    (item) => (
                                      <>
                                        <a href={"mailto:" + item.email}>
                                          {item.email}
                                        </a>
                                        <br />
                                      </>
                                    )
                                  )}
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="col-xs-12 col-sm-4 col-md-4">
                            <div class="item d-flex">
                              <div class="item-left">
                                <div class="icon">
                                  <i class="zmdi zmdi-home"></i>
                                </div>
                              </div>
                              <div class="item-right d-flex">
                                <div class="title">Address:</div>
                                {this.state.informationContactAdmin.map(
                                  (item) => (
                                    <>
                                      <div class="contact-content">
                                        {item.address}
                                      </div>
                                      <br />
                                    </>
                                  )
                                )}
                              </div>
                            </div>
                          </div>
                          <div class="col-xs-12 col-sm-4 col-md-4">
                            <div class="item d-flex justify-content-end  last">
                              <div class="item-left">
                                <div class="icon">
                                  <i class="zmdi zmdi-phone"></i>
                                </div>
                              </div>
                              <div class="item-right d-flex">
                                <div class="title">Hotline:</div>

                                {this.state.informationContactAdmin.map(
                                  (item) => (
                                    <>
                                      <div class="contact-content">
                                        <a href={"tel:" + item.hotline}>
                                          {item.hotline}
                                        </a>
                                        <br />
                                      </div>
                                      <br />
                                    </>
                                  )
                                )}
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="contact-map">
                        <div id="map">
                          <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.3785754726428!2d105.78134315594316!3d21.01753304734255!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454ab43c0c4db%3A0xdb6effebd6991106!2sKeangnam+Hanoi+Landmark+Tower!5e0!3m2!1svi!2s!4v1530175498947"
                            allowfullscreen
                          ></iframe>
                        </div>
                      </div>
                      <div class="input-contact">
                        <p class="text-intro text-center">
                          “Proin gravida nibh vel velit auctor aliquet. Aenean
                          sollicudin, lorem quis bibendum auctor, nisi elit
                          consequat ipsum, nec sagittis sem nibh id elit. Duis
                          sed odio sit amet nibh vultate cursus a sit amet
                          mauris. Proin gravida nibh vel velit auctor aliquet.”
                        </p>

                        <p class="icon text-center">
                          <a href="#">
                            <img
                              src={require("../component/asset/other/contact_mess.png")}
                              alt="img"
                            />
                          </a>
                        </p>

                        <div class="d-flex justify-content-center">
                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                            <div class="contact-form">
                              <form onSubmit={(e) => this.addContact(e)}>
                                <div class="form-fields">
                                  <div class="form-group row">
                                    <div class="col-md-6">
                                      <input
                                        class="form-control"
                                        name="name"
                                        placeholder="Your name"
                                        onChange={this.onChageName}
                                      />
                                    </div>
                                    <div class="col-md-6 margin-bottom-mobie">
                                      <input
                                        class="form-control"
                                        name="email"
                                        type="email"
                                        placeholder="Your email"
                                        onChange={this.onChageEmail}
                                      />
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <div class="col-md-6">
                                      <input
                                        class="form-control"
                                        name="hotline"
                                        type="number"
                                        placeholder="Number phone"
                                        onChange={this.onChageHotline}
                                      />
                                    </div>
                                    <div class="col-md-6 margin-bottom-mobie">
                                      <input
                                        class="form-control"
                                        name="address"
                                        type="text"
                                        placeholder="Your address"
                                        onChange={this.onChageAddress}
                                      />
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <div class="col-md-12 margin-bottom-mobie">
                                      <input
                                        class="form-control"
                                        name="title"
                                        type="text"
                                        placeholder="Subject"
                                        onChange={this.onChageTitle}
                                      />
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <div class="col-md-12">
                                      <textarea
                                        class="form-control"
                                        name="description"
                                        placeholder="Message"
                                        rows="8"
                                        onChange={this.onChageDescription}
                                      ></textarea>
                                    </div>
                                  </div>
                                </div>
                                <div>
                                  <button
                                    className="effect-btn btn btn-secondary"
                                    name="submitMessage"
                                    type="submit"
                                    data-target="#exampleModal"
                                    data-toggle="modal"
                                  >
                                    <img
                                      class="img-fl"
                                      src={require("../component/asset/other/contact_email.png")}
                                      alt="img"
                                    />
                                    Send message
                                  </button>
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
          </div>
        </div>
      </div>
    );
  }
}

export default Contact;
