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
      <div class="main-content" id="home3">
        <div class="wrap-banner">
          <div class="slideshow">
            <div class="tiva-slideshow-wrapper">
              <div id="tiva-slideshow" class="nivoSlider">

                <a href="#" title="Slideshow image">
                  <img class="img-responsive" src={this.state.imgBanner1} title="#caption1" alt="Slideshowimage" />
                </a>
                <a href="#" title="Slideshow image">
                  <img class="img-responsive" src={this.state.imgBanner2} title="#caption2" alt="Slideshowimage" />
                </a>
                <a href="#" title="Slideshow image">
                  <img class="img-responsive" src={this.state.imgBanner3} title="#caption3" alt="Slideshowimage" />
                </a>
              </div>
              <div id="caption1" class="nivo-html-caption">
                <div class="tiva-caption">
                  <div class="left-right hidden-xs">
                    <p class="caption-1">
                      <span class="text-1"><a href="/contact">Contact Us</a></span>
                      <span class="text-2"><a href="tel:0708517856">Tel: 0708517856</a></span>
                    </p>
                  </div>
                </div>
              </div>
              <div id="caption2" class="nivo-html-caption caption">
                <div class="tiva-caption">
                  <div class="left-right hidden-xs">
                    <p class="caption-2">
                      <span class="text-1"><a href="/contact">Contact Us</a></span>
                      <span class="text-2"><a href="tel:0708517856">Tel: 0708517856</a></span>
                    </p>
                  </div>
                </div>
              </div>
              <div id="caption3" class="nivo-html-caption caption">
                <div class="left-right hidden-xs">
                  <div class="tiva-caption">
                    <p class="caption-3">
                      <span class="text-1"><a href="/contact">Contact Us</a></span>
                      <span class="text-2"><a href="tel:0708517856">Tel: 0708517856</a></span>
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
