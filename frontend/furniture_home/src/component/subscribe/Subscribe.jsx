import React, { Component } from "react";
import "./style.css";
import SubscribeService from "../../service/SubscribeService";
import socialService from "../../service/SocialService";

class Subscribe extends Component {
  constructor(props) {
    super(props);

    this.state = {
      message: "",
      email: "",
      facebook: "",
      twiter: "",
      tiktok: "",
      instagram: "",
    };
    this.onChangeEmail = this.onChangeEmail.bind(this);
  }

  componentDidMount() {
    socialService.getAllSocial().then((res) => {
      this.setState({ facebook: res.data.facebook });
      this.setState({ twiter: res.data.twiter });
      this.setState({ tiktok: res.data.tiktok });
      this.setState({ instagram: res.data.instagram });
    });
  }

  async subscribeForm(e) {
    e.preventDefault();
    SubscribeService.subscribeEmail(this.state.email)
      .then((res) => {
        this.setState({ message: res.data.message });
      })
      .catch((error) => {
        this.setState({ message: error.response.data.message });
      });
  }

  onChangeEmail(e) {
    this.setState({ email: e.target.value });
  }

  render() {
    return (
      <div className="section newsletter">
        <div className="container">
          <div className="row">
            <div className="news-content">
              <div className="tiva-modules">
                <div className="block">
                  <div className="title-block">Newsletter</div>

                  <div
                    className="modal fade"
                    id="exampleModalSubscribe"
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
                                <>Success, we will send you a discount ticket</>
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

                  <div className="sub-title">
                    Sign up to our newsletter to get the latest articles,
                    lookbooks voucher codes direct to your inbox
                  </div>
                  <div className="block-newsletter">
                    <form onSubmit={(e) => this.subscribeForm(e)}>
                      <div className="input-group">
                        <input
                          type="text"
                          className="form-control"
                          name="email"
                          onChange={this.onChangeEmail}
                          placeholder="Enter Your Email"
                        />
                        <span className="input-group-btn">
                          <button
                            className="effect-btn btn btn-secondary"
                            name="submitNewsletter"
                            type="submit"
                            data-target="#exampleModalSubscribe"
                            data-toggle="modal"
                          >
                            <span>subscribe</span>
                          </button>
                        </span>
                      </div>
                    </form>
                  </div>
                </div>
                <div className="block">
                  <div className="social-content">
                    <div id="social-block">
                      <div className="social">
                        <ul className="list-inline mb-0 justify-content-end">
                          <li className="list-inline-item mb-0">
                            <a href={this.state.facebook} target="_blank">
                              <i className="fa fa-facebook"> </i>
                            </a>
                          </li>
                          <li className="list-inline-item mb-0">
                            <a href={this.state.twiter} target="_blank">
                              <i className="fa fa-twitter"></i>
                            </a>
                          </li>
                          <li className="list-inline-item mb-0">
                            <a href={this.state.tiktok} target="_blank">
                              <i className="fa-brands fa-tiktok"></i>
                            </a>
                          </li>
                          <li className="list-inline-item mb-0">
                            <a href={this.state.instagram} target="_blank">
                              <i className="fa fa-instagram"></i>
                            </a>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>

                {/* <!-- Popup newsletter --> */}
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Subscribe;
