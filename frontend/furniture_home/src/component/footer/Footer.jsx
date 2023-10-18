import React from "react";
import homepolicy1 from "../asset/home/home1-policy.png";
import homepolicy2 from "../asset/home/home1-policy2.png";
import homepolicy3 from "../asset/home/home1-policy3.png";
import payment from "../asset/home/payment.jpg";

const Footer = () => {
  return (
    <footer class="footer-one">
      <div class="inner-footer background-none">
        <div class="container">
          <div class="footer-top">
            <div class="row">
              <div class="tiva-html col-lg-3 col-md-3 col-xs-12">
                <div class="block">
                  <div class="block-content">
                    <div class="title-block">WHO WE ARE</div>
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
              <div class="tiva-html col-lg-3 col-md-3">
                <div class="block">
                  <div class="block-content">
                    <div class="title-block">CUSTOMER SERVICES</div>
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
              <div class="tiva-html col-lg-6 col-md-6">
                <div class="block">
                  <div class="block-content">
                    <div class="title-block">CONTACT US</div>
                    <div class="contact-content">
                      <div class="data align-self-stretch d-flex">
                        <i class="fa fa-home float-left" aria-hidden="true"></i>
                        <div class="content-data">
                          <b class="mr-2">Showroom:</b>123 Suspendis matti,
                          Visaosang Building, VST District NY Accums, Kansas
                          City, North American
                        </div>
                      </div>
                      <div class="data align-self-stretch d-flex">
                        <i
                          class="fa fa-clock-o float-left"
                          aria-hidden="true"
                        ></i>
                        <div class="content-data">
                          <b class="mr-2">Opening Hours:</b>Monday - Sunday /
                          08.00AM - 19.00 (Except Holidays)
                        </div>
                      </div>
                      <div class="support align-self-stretch d-flex">
                        <div class="data d-flex align-self-stretch mail-support">
                          <i class="fa fa-envelope" aria-hidden="true"></i>
                          <div class="email">support@domain.com</div>
                        </div>
                        <div class="data d-flex align-self-stretch phone-support">
                          <div class="title-icon">
                            <i class="fa fa-phone" aria-hidden="true"></i>
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
      <div class="policy-home">
        <div class="container">
          <div class="row">
            <div class="col-lg-4 col-md-4">
              <div class="block">
                <div class="block-content">
                  <div class="policy-item">
                    <div class="policy-content iconpolicy1">
                      <img src={homepolicy1} alt="img" />
                      <div class="policy-name mb-5">
                        FREE DELIVERY FROM $ 250
                      </div>
                      <div class="policy-des">
                        Lorem ipsum dolor amet consectetur
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="tiva-html col-lg-4 col-md-4">
              <div class="block">
                <div class="block-content">
                  <div class="policy-item">
                    <div class="policy-content iconpolicy2">
                      <img src={homepolicy2} alt="img" />
                      <div class="policy-name mb-5">FREE INSTALLATION</div>
                      <div class="policy-des">
                        Lorem ipsum dolor amet consectetur
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="tiva-html col-lg-4 col-md-4">
              <div class="block">
                <div class="block-content">
                  <div class="policy-item">
                    <div class="policy-content iconpolicy3">
                      <img src={homepolicy3} alt="img" />
                      <div class="policy-name mb-5">MONEY BACK GUARANTEED</div>
                      <div class="policy-des">
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
        <div class="container">
          <div class="row">
            <div class="payment-image col-md-6 align-items-center justify-content-md-start justify-content-sm-center d-flex flex-center">
              <span>
                <a href="https://www.templatespoint.net" target="_blank">
                  Templates Point
                </a>
              </span>
            </div>
            <div class="col-md-6 align-items-center justify-content-md-end justify-content-sm-center d-flex pb-xs-max-20 flex-center">
              <img src={payment} alt="img" />
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
