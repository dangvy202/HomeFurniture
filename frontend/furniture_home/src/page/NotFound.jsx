import React from "react";
import { Component } from "react";

class NotFound extends Component {
  render() {
    return (
      <div id="page-404" class="blog">
        <div class="main-content">
          <div id="wrapper-site">
            <div id="content-wrapper">
              <section class="page-home">
                <div class="container">
                  <div class="row center">
                    <div class="content-404 col-lg-6 col-sm-6 text-center">
                      <div class="image">
                        <img
                          class="img-fluid"
                          src={require("../component/asset/other/image-404.png")}
                          alt="Image 404"
                        />
                      </div>
                      <h2 class="h4">
                        We're sorry — something has gone wrong on our end.
                      </h2>
                      <div class="info">
                        <p>
                          If difficulties persist, please contact the System
                          Administrator of this site and report the error below.
                        </p>
                      </div>
                      <a class="btn btn-default" href="/">
                        <i class="fa fa-home" aria-hidden="true"></i>
                        <span>Back to homepage</span>
                      </a>
                    </div>
                    <div class="content-right-404 col-lg-6 col-sm-6 text-center">
                      <a href="#">
                        <img
                          class="img-fluid"
                          src={require("../component/asset/other/background.jpg")}
                          alt="image 404 right"
                        />
                      </a>
                    </div>
                  </div>
                </div>
              </section>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default NotFound;
