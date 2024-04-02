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
      <div className="section testimonial-block col-lg-12 col-xs-12">
        <div className="row">
          <div className="col-lg-12 col-md-12 ">
            <div className="block">
              <div className="owl-carousel owl-theme testimonial-type-one">
                <div className="item type-one d-flex align-items-center flex-column">
                  <div className="textimonial-image">
                    <i className="icon-testimonial"></i>
                  </div>
                  <div className="desc-testimonial">
                    <div className="testimonial-content">
                      <div className="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div className="testimonial-info">
                      <h5 className="mt-0 box-info">David Jame</h5>
                      <p className="box-dress">DESIGNER</p>
                    </div>
                  </div>
                </div>
                <div className="item type-one d-flex align-items-center flex-column">
                  <div className="textimonial-image">
                    <i className="icon-testimonial"></i>
                  </div>
                  <div className="desc-testimonial">
                    <div className="testimonial-content">
                      <div className="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div className="testimonial-info">
                      <h5 className="mt-0 box-info">Max Control</h5>
                      <p className="box-dress">DEVELOPER</p>
                    </div>
                  </div>
                </div>
                <div className="item type-one d-flex align-items-center flex-column">
                  <div className="textimonial-image">
                    <i className="icon-testimonial"></i>
                  </div>
                  <div className="desc-testimonial">
                    <div className="testimonial-content">
                      <div className="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div className="testimonial-info">
                      <h5 className="mt-0 box-info">John Do</h5>
                      <p className="box-dress">CSS - HTML</p>
                    </div>
                  </div>
                </div>
                <div className="item type-one d-flex align-items-center flex-column">
                  <div className="textimonial-image">
                    <i className="icon-testimonial"></i>
                  </div>
                  <div className="desc-testimonial">
                    <div className="testimonial-content">
                      <div className="text">
                        <p>
                          " Liquam quis risus viverra, ornare ipsum vitae,
                          congue tellus. Vestibulum nunc lorem, scelerisque a
                          tristique non, accumsan ornare eros. Nullam sapien
                          metus, volutpat dictum, accumsan ornare eros. Nullam
                          sapien metus, volutpat dictum "
                        </p>
                      </div>
                    </div>
                    <div className="testimonial-info">
                      <h5 className="mt-0 box-info">Elizabeth Pham</h5>
                      <p className="box-dress">DEVELOPER</p>
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
