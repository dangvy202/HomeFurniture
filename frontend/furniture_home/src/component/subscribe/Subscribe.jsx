import React, { Component } from "react";
import "./style.css";

class Subscribe extends Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {}

  render() {
    return (
      <div className="section newsletter">
        <div className="container">
          <div className="row">
            <div className="news-content">
              <div className="tiva-modules">
                <div className="block">
                  <div className="title-block">Newsletter</div>
                  <div className="sub-title">
                    Sign up to our newsletter to get the latest articles,
                    lookbooks voucher codes direct to your inbox
                  </div>
                  <div className="block-newsletter">
                    <form action="#" method="post">
                      <div className="input-group">
                        <input
                          type="text"
                          className="form-control"
                          name="email"
                          value=""
                          placeholder="Enter Your Email"
                        />
                        <span className="input-group-btn">
                          <button
                            className="effect-btn btn btn-secondary"
                            name="submitNewsletter"
                            type="submit"
                          >
                            <span>subscribe</span>
                          </button>
                        </span>
                      </div>
                      <input type="hidden" name="action" value="0" />
                    </form>
                  </div>
                </div>
                <div className="block">
                  <div className="social-content">
                    <div id="social-block">
                      <div className="social">
                        <ul className="list-inline mb-0 justify-content-end">
                          <li className="list-inline-item mb-0">
                            <a href="#" target="_blank">
                              <i className="fa fa-facebook"></i>
                            </a>
                          </li>
                          <li className="list-inline-item mb-0">
                            <a href="#" target="_blank">
                              <i className="fa fa-twitter"></i>
                            </a>
                          </li>
                          <li className="list-inline-item mb-0">
                            <a href="#" target="_blank">
                              <i className="fa fa-google"></i>
                            </a>
                          </li>
                          <li className="list-inline-item mb-0">
                            <a href="#" target="_blank">
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
