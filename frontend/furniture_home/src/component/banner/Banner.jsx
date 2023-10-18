import React from "react";
import imgBanner1 from "../asset/home/home1-tolltip1.jpg";
import imgBanner2 from "../asset/home/home1-tolltip2.jpg";
import imgBanner3 from "../asset/home/home1-tolltip3.jpg";
import product1 from "../asset/home/icon-tolltip1.jpg";
import product2 from "../asset/home/icon-tolltip2.jpg";
import product3 from "../asset/home/icon-tolltip5.jpg";
import product4 from "../asset/home/icon-tolltip6.jpg";
import product5 from "../asset/home/icon-tolltip4.jpg";
import product6 from "../asset/home/icon-tolltip4.jpg";
import product7 from "../asset/home/icon-tolltip4.jpg";
import product8 from "../asset/home/icon-tolltip6.jpg";

const Banner = () => {
  return (
    // <!-- SHOP THE LOOK -->
    <div className="section spacing-10 groupbanner-special">
      <div className="title-block">
        <span>Shop The LookBook 2018</span>
        <span>LookBook</span>
        <span>HAND-PICKED ARRIVALS FROM THE BEST DESIGNER</span>
      </div>

      <div className="row">
        <div className="lookbook owl-carousel owl-theme owl-loaded owl-drag">
          <div className="item">
            {/* <!-- Module Lookbooks --> */}
            <div className="tiva-lookbook defaul">
              <div className="items col-lg-12 col-sm-12 col-xs-12">
                <div className="tiva-content-lookbook">
                  <img
                    className="img-fluid img-responsive"
                    src={imgBanner1}
                    alt="lookbook"
                  />

                  <div className="item-lookbook item1">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook lookbook-custom">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product2}
                              alt="lorem-ipsum-dolor-sit-amet"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">Lorem ipsum dolor</a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£52.00</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="item-lookbook item2">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product1}
                              alt="contrary-to-popular-belief"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">
                              Sed vel malesuada lorem
                            </a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£68.00</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div className="item">
            {/* <!-- Module Lookbooks --> */}
            <div className="tiva-lookbook default">
              <div className="items col-lg-12 col-sm-12 col-xs-12">
                <div className="tiva-content-lookbook">
                  <img
                    className="img-fluid img-responsive"
                    src={imgBanner2}
                    alt="lookbook"
                  />

                  <div className="item-lookbook item3">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product3}
                              alt="lorem-ipsum-dolor-sit-amet"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">
                              Lorem ipsum dolor sit
                            </a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£45.00</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="item-lookbook item4">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product4}
                              alt="lorem-ipsum-dolor-sit-amet"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">Lorem ipsum dolor</a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£21.00</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="item-lookbook item5">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook lookbook-custom">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product5}
                              alt="mug-the-adventure-begins"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">
                              Sed vel malesuada lorem
                            </a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£11.90</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div className="item">
            {/* <!-- Module Lookbooks --> */}
            <div className="tiva-lookbook default">
              <div className="items col-lg-12 col-sm-12 col-xs-12">
                <div className="tiva-content-lookbook">
                  <img
                    className="img-fluid img-responsive"
                    src={imgBanner3}
                    alt="lookbook"
                  />

                  <div className="item-lookbook item6">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product6}
                              alt="mug-the-adventure-begins"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">
                              Sed vel malesuada lorem
                            </a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£11.90</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="item-lookbook item7">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product7}
                              alt="brown-bear-vector-graphics"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">
                              Orci varius natoque penatibus
                            </a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£9.00</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="item-lookbook item8">
                    <span className="number-lookbook">+</span>
                    <div className="content-lookbook">
                      <div className="main-lookbook d-flex align-items-center">
                        <div className="item-thumb">
                          <a href="product-detail.html">
                            <img
                              src={product8}
                              alt="lorem-ipsum-dolor-sit-amet"
                            />
                          </a>
                        </div>
                        <div className="content-bottom">
                          <div className="item-title">
                            <a href="product-detail.html">
                              Etiam congue nisl nec
                            </a>
                          </div>
                          <div className="rating">
                            <div className="star-content">
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                              <div className="star"></div>
                            </div>
                          </div>
                          <div className="item-price">£16.00</div>
                          <div className="readmore">
                            <a href="product-detail.html">View More</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div className="info-lookbook"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Banner;
