import React, { Component } from "react";
import bannerService from "../../service/BannerService";


class Banner extends Component {
  constructor(props) {
    super(props);
    this.state = {
      imgBanner1: "",
      imgBanner2: "",
      imgBanner3: "",
    }
  }

  async componentDidMount() {
    bannerService.getBanner().then((res) => {
      this.setState({ 
        imgBanner1: require("../asset/home/" + res.data[0].bannerUrl),
        imgBanner2: require("../asset/home/" + res.data[1].bannerUrl),
        imgBanner3: require("../asset/home/" + res.data[2].bannerUrl),
      })
    })
  }

  render() {
    return (
      // <!-- SHOP THE LOOK -->
      <div className="main-content" id="home3">
        <div className="wrap-banner">
          <div className="slideshow">
            <div className="tiva-slideshow-wrapper">
              <div id="tiva-slideshow" className="nivoSlider">

                <a href="#" title="Slideshow image">
                  <img className="img-responsive" src={this.state.imgBanner1} title="#caption1" alt="Slideshowimage" />
                </a>
                <a href="#" title="Slideshow image">
                  <img className="img-responsive" src={this.state.imgBanner2} title="#caption2" alt="Slideshowimage" />
                </a>
                <a href="#" title="Slideshow image">
                  <img className="img-responsive" src={this.state.imgBanner3} title="#caption3" alt="Slideshowimage" />
                </a>
              </div>
              <div id="caption1" className="nivo-html-caption">
                <div className="tiva-caption">
                  <div className="left-right hidden-xs">
                    <p className="caption-1">
                      <span className="text-1"><a href="/contact">Contact Us</a></span>
                      <span className="text-2"><a href="tel:0708517856">Tel: 0708517856</a></span>
                    </p>
                  </div>
                </div>
              </div>
              <div id="caption2" className="nivo-html-caption caption">
                <div className="tiva-caption">
                  <div className="left-right hidden-xs">
                    <p className="caption-2">
                      <span className="text-1"><a href="/contact">Contact Us</a></span>
                      <span className="text-2"><a href="tel:0708517856">Tel: 0708517856</a></span>
                    </p>
                  </div>
                </div>
              </div>
              <div id="caption3" className="nivo-html-caption caption">
                <div className="left-right hidden-xs">
                  <div className="tiva-caption">
                    <p className="caption-3">
                      <span className="text-1"><a href="/contact">Contact Us</a></span>
                      <span className="text-2"><a href="tel:0708517856">Tel: 0708517856</a></span>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
};

export default Banner;
