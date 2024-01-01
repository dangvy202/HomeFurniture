import React, { Component } from "react";
import ProductService from "../../service/ProductService";
import CategoryService from "../../service/CategoryService";
import ProductByCategory from "./ProductByCategory";

class Product extends Component {
  constructor(props) {
    super(props);
    this.state = {
      product: [],
      products: [],
      category: [],
      visible: 4,
    };
    this.showMoreProduct = this.showMoreProduct.bind(this);
    this.hideProduct = this.hideProduct.bind(this);
  }

  componentDidMount() {
    ProductService.getProduct().then((res) => {
      this.setState({ product: res.data });
    });
    CategoryService.getCategory().then((res) => {
      this.setState({ category: res.data });
    });
  }

  changeTab(id) {
    ProductService.getProductByCategory(id).then((resProductByCategory) => {
      this.setState({ products: resProductByCategory.data });
    });
  }
  async setChangeTab(id) {
    ProductService.getProductByCategory(id).then((resProductByCategory) => {
      this.setState({ products: resProductByCategory.data });
    });
  }

  hideProduct() {
    this.setState(() => {
      return {
        visible: 4,
      };
    });
  }

  showMoreProduct() {
    this.setState((pre) => {
      return {
        visible: pre.visible + 4,
      };
    });
  }

  render() {
    return (
      <>
        <div className="title-tab-content d-flex">
          {/* <!-- tab product --> */}
          <div className="dropdown-toggle toggle-category tab-category-none">
            Select Category
          </div>
          <ul className="nav nav-tabs wibkit row">
            <li className="col-xs-6 all">
              <a href="#all" data-toggle="tab" className="active">
                ALL PRODUCTS
              </a>
            </li>
            {this.state.category.map((item) => (
              <li className="col-xs-6" key={item.id}>
                <a
                  href="#choice"
                  data-toggle="tab"
                  onClick={() => this.changeTab(item.id)}
                >
                  {item.categoryName}
                </a>
              </li>
            ))}
          </ul>
        </div>
        <div className="tab-content">
          <div id="choice" className="tab-pane fade">
            <div className="item text-center row">
              {this.state.products.slice(0, this.state.visible).map((item) => {
                if (
                  item.inventory.message.status == true &&
                  item.inventory.message.error == null
                ) {
                  return (
                    <div className="col-md-3 col-xs-12" key={item.id}>
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
                                </>
                              );
                            } else {
                              return (
                                <>
                                  <div
                                    className="product-flags discount"
                                    style={{ background: "#362d5900" }}
                                  ></div>
                                </>
                              );
                            }
                          })()}
                        </div>
                        <div className="product-description">
                          <div className="product-groups">
                            <div className="product-title">
                              <a href="product-detail.html">
                                {item.productName}
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
                              // onclick=""
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
              {(() => {
                if (this.state.visible != this.state.products.length) {
                  if (this.state.visible > this.state.products.length) {
                    return (
                      <button
                        type="button"
                        className="btn btn-default novShowMore"
                        name="novShowMore"
                        data-loading="Loading..."
                        data-loadmore="Load More Products"
                        onClick={this.hideProduct}
                      >
                        <span>Hide Products</span>
                      </button>
                    );
                  } else {
                    return (
                      <button
                        type="button"
                        className="btn btn-default novShowMore"
                        name="novShowMore"
                        data-loading="Loading..."
                        data-loadmore="Load More Products"
                        onClick={this.showMoreProduct}
                      >
                        <span>Load More Products</span>
                      </button>
                    );
                  }
                } else {
                  return (
                    <button
                      type="button"
                      className="btn btn-default novShowMore"
                      name="novShowMore"
                      data-loading="Loading..."
                      data-loadmore="Load More Products"
                      onClick={this.hideProduct}
                    >
                      <span>Hide Products</span>
                    </button>
                  );
                }
              })()}
              <input type="hidden" value="0" className="count_showmore" />
            </div>
          </div>
          {/* all product */}
          <div id="all" className="tab-pane fade in active show">
            <div className="item text-center row">
              {this.state.product.slice(0, this.state.visible).map((item) => {
                if (
                  item.inventory.message.status == true &&
                  item.inventory.message.error == null
                ) {
                  if (item.inventory.message.message === "AVAILABLE") {
                    return (
                      <div className="col-md-3 col-xs-12" key={item.id}>
                        <div className="product-miniature js-product-miniature item-one first-item">
                          <div
                            style={{ height: "100%" }}
                            className="thumbnail-container"
                          >
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
                                  <div className="product-flags discount">
                                    {(item.productSaleoff / item.productPrice) *
                                      100}
                                    %
                                  </div>
                                );
                              } else {
                                return (
                                  <div
                                    className="product-flags discount"
                                    style={{ background: "#362d5900" }}
                                  ></div>
                                );
                              }
                            })()}
                          </div>
                          <div className="product-description">
                            <div className="product-groups">
                              <div className="product-title">
                                <a href="product-detail.html">
                                  {item.productName}
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
                                // onclick=""
                              >
                                <i
                                  className="fa fa-heart"
                                  aria-hidden="true"
                                ></i>
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
                  } else {
                    return (
                      <div className="col-md-3 col-xs-12" key={item.id}>
                        <div className="product-miniature js-product-miniature item-one first-item">
                          <div
                            style={{ height: "100%" }}
                            className="thumbnail-container"
                          >
                            <a
                              href="product-detail.html"
                              style={{
                                backgroundColor: "gray",
                              }}
                            >
                              <h3
                                style={{
                                  color: "white",
                                  backgroundColor: "red",
                                  zIndex: 1000,
                                  textAlign: "center",
                                  width: "100%",
                                  marginTop: "100px",
                                  position: "absolute",
                                }}
                              >
                                SOLD OUT
                              </h3>
                              <img
                                style={{
                                  filter:
                                    "opacity(0.5) drop-shadow(0 0 0 gray)",
                                }}
                                className="img-fluid"
                                src={require("../asset/product/" +
                                  item.picture.pictureFirst)}
                                alt="img"
                              />
                            </a>
                            {(() => {
                              if (item.productSaleoff != 0) {
                                return (
                                  <div className="product-flags discount">
                                    {(item.productSaleoff / item.productPrice) *
                                      100}
                                    %
                                  </div>
                                );
                              } else {
                                return (
                                  <div
                                    className="product-flags discount"
                                    style={{ background: "#362d5900" }}
                                  ></div>
                                );
                              }
                            })()}
                          </div>
                          <div className="product-description">
                            <div className="product-groups">
                              <div className="product-title">
                                <a href="product-detail.html">
                                  {item.productName}
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
                          </div>
                        </div>
                      </div>
                    );
                  }
                }
              })}
            </div>

            <div className="content-showmore text-center has-showmore">
              {(() => {
                if (this.state.visible != this.state.product.length) {
                  if (this.state.visible > this.state.product.length) {
                    return (
                      <button
                        type="button"
                        className="btn btn-default novShowMore"
                        name="novShowMore"
                        data-loading="Loading..."
                        data-loadmore="Load More Products"
                        onClick={this.hideProduct}
                      >
                        <span>Hide Products</span>
                      </button>
                    );
                  } else {
                    return (
                      <button
                        type="button"
                        className="btn btn-default novShowMore"
                        name="novShowMore"
                        data-loading="Loading..."
                        data-loadmore="Load More Products"
                        onClick={this.showMoreProduct}
                      >
                        <span>Load More Products</span>
                      </button>
                    );
                  }
                } else {
                  return (
                    <button
                      type="button"
                      className="btn btn-default novShowMore"
                      name="novShowMore"
                      data-loading="Loading..."
                      data-loadmore="Load More Products"
                      onClick={this.hideProduct}
                    >
                      <span>Hide Products</span>
                    </button>
                  );
                }
              })()}
              <input type="hidden" value="0" className="count_showmore" />
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default Product;
