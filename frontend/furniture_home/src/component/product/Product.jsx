import React, { Component } from "react";
import ProductService from "../../service/ProductService";

class Product extends Component {
  constructor(props) {
    super(props);
    this.state = {
      product: [],
    };
  }

  componentDidMount() {
    ProductService.getProduct().then((res) => {
      this.setState({ product: res.data });
    });
  }

  render() {
    return (
      <div className="tab-content">
        <div id="all" className="tab-pane fade in active show">
          <div className="item text-center row">
            {this.state.product.map((item) => {
              if (
                item.inventory.message.status == true &&
                item.inventory.message.error == null
              ) {
                return (
                  <div className="col-md-3 col-xs-12">
                    <div className="product-miniature js-product-miniature item-one first-item">
                      <div className="thumbnail-container">
                        <a href="product-detail.html">
                          <img
                            className="img-fluid"
                            src={require("../asset/product/" +
                              item.picture.pictureFirst)}
                            alt="img"
                          />
                        </a>
                        {(() => {
                          if (item.productSaleoff != 0) {
                            return (
                              <>
                                <div className="product-flags discount">
                                  {(item.productSaleoff / item.productPrice) *
                                    100}
                                  %
                                </div>
                                ;
                              </>
                            );
                          } else {
                            return (
                              <>
                                <div
                                  className="product-flags discount"
                                  style={{ background: "white" }}
                                ></div>
                                ;
                              </>
                            );
                          }
                        })()}
                        <div className="highlighted-informations">
                          <div className="variant-links">
                            <a
                              href="#"
                              className="color beige"
                              title="Beige"
                            ></a>
                            <a
                              href="#"
                              className="color orange"
                              title="Orange"
                            ></a>
                            <a
                              href="#"
                              className="color green"
                              title="Green"
                            ></a>
                          </div>
                        </div>
                      </div>
                      <div className="product-description">
                        <div className="product-groups">
                          <div className="product-title">
                            <a href="product-detail.html">{item.productName}</a>
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
                          <div className="product-group-price">
                            <div className="product-price-and-shipping">
                              {(() => {
                                if (item.productSaleoff != 0) {
                                  return (
                                    <>
                                      <span className="price">
                                        {Intl.NumberFormat("vi-VN", {
                                          style: "currency",
                                          currency: "VND",
                                        }).format(
                                          item.productPrice -
                                            item.productSaleoff
                                        )}
                                      </span>
                                      <del className="regular-price">
                                        {Intl.NumberFormat("vi-VN", {
                                          style: "currency",
                                          currency: "VND",
                                        }).format(item.productPrice)}
                                      </del>
                                    </>
                                  );
                                } else {
                                  return (
                                    <span className="price">
                                      {Intl.NumberFormat("vi-VN", {
                                        style: "currency",
                                        currency: "VND",
                                      }).format(item.productPrice)}
                                    </span>
                                  );
                                }
                              })()}
                            </div>
                          </div>
                        </div>
                        <div className="product-buttons d-flex justify-content-center">
                          <form
                            action="#"
                            method="post"
                            className="formAddToCart"
                          >
                            <input type="hidden" name="token" />
                            <a
                              className="add-to-cart"
                              href="#"
                              data-button-action="add-to-cart"
                            >
                              <i
                                className="fa fa-shopping-cart"
                                aria-hidden="true"
                              ></i>
                            </a>
                          </form>
                          <a
                            className="addToWishlist wishlistProd_1"
                            href="#"
                            data-rel="1"
                            onclick=""
                          >
                            <i className="fa fa-heart" aria-hidden="true"></i>
                          </a>
                          <a
                            href="#"
                            className="quick-view hidden-sm-down"
                            data-link-action="quickview"
                          >
                            <i className="fa fa-eye" aria-hidden="true"></i>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                );
              }
            })}
          </div>

          <div className="content-showmore text-center has-showmore">
            <button
              type="button"
              className="btn btn-default novShowMore"
              name="novShowMore"
              data-loading="Loading..."
              data-loadmore="Load More Products"
            >
              <span>Load More Products</span>
            </button>
            <input type="hidden" value="0" className="count_showmore" />
          </div>
        </div>
      </div>
    );
  }
}

export default Product;
