import React, { Component } from "react";
import homepolicy1 from "../asset/home/home1-policy.png";
import homepolicy2 from "../asset/home/home1-policy2.png";
import homepolicy3 from "../asset/home/home1-policy3.png";
import payment from "../asset/home/payment.jpg";
import productService from "../../service/ProductService";

class Footer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      productName: ""
    }
    this.searchProduct = this.searchProduct.bind(this);
    this.redirectProductSearch = this.redirectProductSearch.bind(this);
  }

  searchProduct(e) {
    this.setState({ productName : e.target.value });
  }

  redirectProductSearch() {
    if(this.state.productName !== "") {
      window.location.href = "/product/search?=" + this.state.productName
    }
  }

  render() {
    return (
      <footer className="footer-one">
        <div className="inner-footer background-none">
          <div className="container">
            <div className="footer-top">
              <div className="row">
                <div className="tiva-html col-lg-3 col-md-3 col-xs-12">
                  <div className="block">
                    <div className="block-content">
                      <div className="title-block">WHO WE ARE</div>
                      <ul>
                        <li>
                          <a href="#">About Us</a>
                        </li>
                        <li>
                          <a href="#">Reasons to shop</a>
                        </li>
                        <li>
                          <a href="#">What our customers say</a>
                        </li>
                        <li>
                          <a href="#">Meet the teaml</a>
                        </li>
                        <li>
                          <a href="#">Contact our buyers</a>
                        </li>
                        <li>
                          <a href="#">Cookies & privacy</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div className="tiva-html col-lg-3 col-md-3">
                  <div className="block">
                    <div className="block-content">
                      <div className="title-block">CUSTOMER SERVICES</div>
                      <ul>
                        <li>
                          <a href="#">Contact Us</a>
                        </li>
                        <li>
                          <a href="#">Help and advice</a>
                        </li>
                        <li>
                          <a href="#">Delivery</a>
                        </li>
                        <li>
                          <a href="#">Terms and conditions</a>
                        </li>
                        <li>
                          <a href="#">Refund Policy</a>
                        </li>
                        <li>
                          <a href="#">FAQs</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div className="tiva-html col-lg-6 col-md-6">
                  <div className="block">
                    <div className="block-content">
                      <div className="title-block">CONTACT US</div>
                      <div className="contact-content">
                        <div className="data align-self-stretch d-flex">
                          <i
                            className="fa fa-home float-left"
                            aria-hidden="true"
                          ></i>
                          <div className="content-data">
                            <b className="mr-2">Showroom:</b>123 Suspendis matti,
                            Visaosang Building, VST District NY Accums, Kansas
                            City, North American
                          </div>
                        </div>
                        <div className="data align-self-stretch d-flex">
                          <i
                            className="fa fa-clock-o float-left"
                            aria-hidden="true"
                          ></i>
                          <div className="content-data">
                            <b className="mr-2">Opening Hours:</b>Monday - Sunday
                            / 08.00AM - 19.00 (Except Holidays)
                          </div>
                        </div>
                        <div className="support align-self-stretch d-flex">
                          <div className="data d-flex align-self-stretch mail-support">
                            <i className="fa fa-envelope" aria-hidden="true"></i>
                            <div className="email">support@domain.com</div>
                          </div>
                          <div className="data d-flex align-self-stretch phone-support">
                            <div className="title-icon">
                              <i className="fa fa-phone" aria-hidden="true"></i>
                            </div>
                            <div>+0012-345-67890</div>
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

        {/* <!-- delivery form --> */}
        <div className="policy-home">
          <div className="container">
            <div className="row">
              <div className="col-lg-4 col-md-4">
                <div className="block">
                  <div className="block-content">
                    <div className="policy-item">
                      <div className="policy-content iconpolicy1">
                        <img src={homepolicy1} alt="img" />
                        <div className="policy-name mb-5">
                          FREE DELIVERY FROM $ 250
                        </div>
                        <div className="policy-des">
                          Lorem ipsum dolor amet consectetur
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="tiva-html col-lg-4 col-md-4">
                <div className="block">
                  <div className="block-content">
                    <div className="policy-item">
                      <div className="policy-content iconpolicy2">
                        <img src={homepolicy2} alt="img" />
                        <div className="policy-name mb-5">FREE INSTALLATION</div>
                        <div className="policy-des">
                          Lorem ipsum dolor amet consectetur
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="tiva-html col-lg-4 col-md-4">
                <div className="block">
                  <div className="block-content">
                    <div className="policy-item">
                      <div className="policy-content iconpolicy3">
                        <img src={homepolicy3} alt="img" />
                        <div className="policy-name mb-5">
                          MONEY BACK GUARANTEED
                        </div>
                        <div className="policy-des">
                          Lorem ipsum dolor amet consectetur
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div id="tiva-copyright">
          <div className="container">
            <div className="row">
              <div className="payment-image col-md-6 align-items-center justify-content-md-start justify-content-sm-center d-flex flex-center">
                <span>
                  <a href="https://www.templatespoint.net" target="_blank">
                    Templates Point
                  </a>
                </span>
              </div>
              <div className="col-md-6 align-items-center justify-content-md-end justify-content-sm-center d-flex pb-xs-max-20 flex-center">
                <img src={payment} alt="img" />
              </div>
            </div>
          </div>
        </div>
        {/* <!-- Page Loader --> */}
        <div id="page-preloader">
            <div className="page-loading">
                <div className="dot"></div>
                <div className="dot"></div>
                <div className="dot"></div>
                <div className="dot"></div>
                <div className="dot"></div>
            </div>
        </div>
        {/* <!-- search --> */}
        <div id="tiva-searchBox" className="d-flex align-items-center text-center active">
          <div className="container">
            <span className="tiva-seachBoxClose">
              <i className="zmdi zmdi-close"></i>
            </span>
            <div className="tiva-seachBoxInner">
              <div className="title-search">
                <i className="fa fa-search" aria-hidden="true"></i>
                <span>Search</span>
              </div>
              <div className="description">
                Find your product with fast search. Enter some keyword such as dress, shirts, shoes etc. Or can search by product sku.
              </div>
              {/* <!-- Block search module TOP --> */}
              <div id="search" className="search-widget d-flex justify-content-center">
                <form  >
                  <span role="status" aria-live="polite" className="ui-helper-hidden-accessible"></span>
                  <input type="text" name="s" value={this.productName} onChange={this.searchProduct} placeholder="Search" className="ui-autocomplete-input" autocomplete="off" />
                  <button type="button" onClick={(e) => this.redirectProductSearch(e)}>
                    Search
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </footer>

    )
  };
};

export default Footer;
