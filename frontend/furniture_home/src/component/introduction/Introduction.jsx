import React, { Component } from "react";
import logo from "../asset/home/logo.png";
import introductionService from "../../service/Introduction";

class Introduction extends Component {
  constructor(props) {
    super(props);
    this.state = {
      introductionList: [],
    };
  }

  // componentDidMount() {
  //   introductionService.getIntroduction().then((res) => {
  //     this.setState({ introductionList: res.data })
  //   })
  // }

  render() {
    return (
      <div class="section testimonial-block col-lg-12 col-xs-12">
        <div class="row">
          <div class="col-lg-12 col-md-12 ">
            <div class="block">
              <div class="owl-carousel owl-theme testimonial-type-one">
                <div class="item type-one d-flex align-items-center flex-column">
                  <div class="textimonial-image">
                    <i class="icon-testimonial"></i>
                  </div>
                  <div class="desc-testimonial">
                    <div class="testimonial-content">
                      <div class="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div class="testimonial-info">
                      <h5 class="mt-0 box-info">David Jame</h5>
                      <p class="box-dress">DESIGNER</p>
                    </div>
                  </div>
                </div>
                <div class="item type-one d-flex align-items-center flex-column">
                  <div class="textimonial-image">
                    <i class="icon-testimonial"></i>
                  </div>
                  <div class="desc-testimonial">
                    <div class="testimonial-content">
                      <div class="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div class="testimonial-info">
                      <h5 class="mt-0 box-info">Max Control</h5>
                      <p class="box-dress">DEVELOPER</p>
                    </div>
                  </div>
                </div>
                <div class="item type-one d-flex align-items-center flex-column">
                  <div class="textimonial-image">
                    <i class="icon-testimonial"></i>
                  </div>
                  <div class="desc-testimonial">
                    <div class="testimonial-content">
                      <div class="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div class="testimonial-info">
                      <h5 class="mt-0 box-info">John Do</h5>
                      <p class="box-dress">CSS - HTML</p>
                    </div>
                  </div>
                </div>
                <div class="item type-one d-flex align-items-center flex-column">
                  <div class="textimonial-image">
                    <i class="icon-testimonial"></i>
                  </div>
                  <div class="desc-testimonial">
                    <div class="testimonial-content">
                      <div class="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div class="testimonial-info">
                      <h5 class="mt-0 box-info">Elizabeth Pham</h5>
                      <p class="box-dress">DEVELOPER</p>
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

export default Introduction;
