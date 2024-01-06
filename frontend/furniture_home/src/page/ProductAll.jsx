import React, { Component } from "react";
import CategoryService from "../service/CategoryService";
import ProductService from "../service/ProductService";
import RoomService from "../service/RoomService";

class ProductsAll extends Component {
  constructor(props) {
    super(props);
    var url = window.location.search;
    var arrPath = url.split("=");
    var extension = arrPath[arrPath.length - 1];

    var urlPathName = window.location.pathname;
    var arrPathName = urlPathName.split("/");
    var extensionCategory = arrPathName[arrPathName.length - 1];
    this.state = {
      room: [],
      category: [],
      products: [],
      title: extension,
      pathname: extensionCategory,
      navbar: "",
      quantityProduct: 0,
    };
  }

  componentDidMount() {
    RoomService.getAllRoom().then((res) => {
      this.setState({ room: res.data });
    });
    CategoryService.getCategory().then((res) => {
      this.setState({ category: res.data });
    });
    if (this.state.pathname === "category") {
      ProductService.getProductByCategoryRedirect(this.state.title)
        .then((res) => {
          this.setState({ products: res.data });
          this.setState({ navbar: res.data[0].category.categoryName });
          var count = 0;
          for (var i = 0; i < res.data.length; i++) {
            if (res.data[i].inventory.message.message === "AVAILABLE") {
              count++;
            }
          }
          this.setState({ quantityProduct: count });
        })
        .catch((error) => {
          window.location.href = "/404";
        });
    } else if (this.state.pathname === "room") {
      ProductService.getProductByRoomRedirect(this.state.title)
        .then((res) => {
          this.setState({ products: res.data });
          this.setState({ navbar: res.data[0].room.roomName });
          var count = 0;
          for (var i = 0; i < res.data.length; i++) {
            if (res.data[i].inventory.message.message === "AVAILABLE") {
              count++;
            }
          }
          this.setState({ quantityProduct: count });
        })
        .catch((error) => {
          window.location.href = "/404";
        });
    } else {
      window.location.href = "/404";
    }
  }

  render() {
    return (
      <div id="product-sidebar-left" class="product-grid-sidebar-left">
        <div class="main-content">
          <div id="wrapper-site">
            <div id="content-wrapper" class="full-width">
              <div id="main">
                <div class="page-home">
                  {/* <!-- breadcrumb --> */}
                  <nav class="breadcrumb-bg">
                    <div class="container no-index">
                      <div class="breadcrumb">
                        <ol>
                          <li>
                            <a href="/">
                              <span>Home</span>
                            </a>
                          </li>
                          <li>
                            <span>{this.state.title}</span>
                          </li>
                        </ol>
                      </div>
                    </div>
                  </nav>

                  <div class="container">
                    <div class="content">
                      <div class="row">
                        <div class="sidebar-3 sidebar-collection col-lg-3 col-md-4 col-sm-4">
                          {/* <!-- category menu --> */}
                          <div class="sidebar-block">
                            <div class="title-block">Rooms</div>
                            <div class="block-content">
                              {this.state.room.map((item) => (
                                <div class="cateTitle hasSubCategory open level1">
                                  <a
                                    class="cateItem"
                                    href={"/product/room?=" + item.roomRedirect}
                                  >
                                    {item.roomName}
                                  </a>
                                </div>
                              ))}
                            </div>
                          </div>

                          <div class="sidebar-block">
                            <div class="title-block">Categories</div>
                            <div class="block-content">
                              {this.state.category.map((item) => (
                                <div class="cateTitle hasSubCategory open level1">
                                  <a
                                    class="cateItem"
                                    href={
                                      "/product/category?=" +
                                      item.categoryRedirect
                                    }
                                  >
                                    {item.categoryName}
                                  </a>
                                </div>
                              ))}
                            </div>
                          </div>

                          {/* <!-- best seller --> */}
                          <div class="sidebar-block">
                            {/* PRICE */}
                            <div class="tiva-filter-price new-item-content sidebar-block">
                              <h3 class="title-product">By Price</h3>
                              <div id="block_price_filter" class="block">
                                <div class="block-content">
                                  <div id="slider-range" class="tiva-filter">
                                    <div class="filter-itemprice-filter">
                                      <div class="layout-slider">
                                        <input
                                          id="price-filter"
                                          name="price"
                                          value="0;100"
                                        />
                                      </div>
                                      <div class="layout-slider-settings"></div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="col-sm-8 col-lg-9 col-md-8 product-container">
                          <h1>{this.state.navbar}</h1>
                          <div class="js-product-list-top firt nav-top">
                            <div class="d-flex justify-content-around row">
                              <div class="col col-xs-12">
                                <ul class="nav nav-tabs">
                                  <li>
                                    <a
                                      href="#grid"
                                      data-toggle="tab"
                                      class="active show fa fa-th-large"
                                    ></a>
                                  </li>
                                  <li>
                                    <a
                                      href="#list"
                                      data-toggle="tab"
                                      class="fa fa-list-ul"
                                    ></a>
                                  </li>
                                </ul>
                                <div class="hidden-sm-down total-products">
                                  <p>
                                    There are {this.state.quantityProduct}{" "}
                                    products.
                                  </p>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="tab-content product-items">
                            <div
                              id="grid"
                              class="related tab-pane fade in active show"
                            >
                              <div class="row">
                                {this.state.products.map((item) => {
                                  if (
                                    item.inventory.message.message ===
                                    "AVAILABLE"
                                  ) {
                                    return (
                                      <div class="item text-center col-md-4">
                                        <div class="product-miniature js-product-miniature item-one first-item">
                                          <div class="thumbnail-container border">
                                            <a href="product-detail.html">
                                              <img
                                                class="img-fluid image-cover"
                                                src={require("../component/asset/product/" +
                                                  item.picture.pictureFirst)}
                                                alt="img"
                                              />
                                              <img
                                                class="img-fluid image-secondary"
                                                src={require("../component/asset/product/" +
                                                  item.picture.pictureSecond)}
                                                alt="img"
                                              />
                                            </a>
                                          </div>
                                          <div class="product-description">
                                            <div class="product-groups">
                                              <div class="product-title">
                                                <a href="product-detail.html">
                                                  {item.productName}
                                                </a>
                                              </div>
                                              <div class="rating">
                                                <div class="star-content">
                                                  <div class="star"></div>
                                                  <div class="star"></div>
                                                  <div class="star"></div>
                                                  <div class="star"></div>
                                                  <div class="star"></div>
                                                </div>
                                              </div>
                                              <div class="product-group-price">
                                                <div class="product-price-and-shipping">
                                                  {(() => {
                                                    if (
                                                      item.productSaleoff != 0
                                                    ) {
                                                      return (
                                                        <>
                                                          <ul>
                                                            <li className="item col-md-6 float-left">
                                                              <span className="price">
                                                                {Intl.NumberFormat(
                                                                  "vi-VN",
                                                                  {
                                                                    style:
                                                                      "currency",
                                                                    currency:
                                                                      "VND",
                                                                  }
                                                                ).format(
                                                                  item.productPrice -
                                                                    item.productSaleoff
                                                                )}
                                                              </span>
                                                            </li>
                                                            <li className="item col-md-6 float-left">
                                                              <del className="regular-price">
                                                                {Intl.NumberFormat(
                                                                  "vi-VN",
                                                                  {
                                                                    style:
                                                                      "currency",
                                                                    currency:
                                                                      "VND",
                                                                  }
                                                                ).format(
                                                                  item.productPrice
                                                                )}
                                                              </del>
                                                            </li>
                                                          </ul>
                                                        </>
                                                      );
                                                    } else {
                                                      return (
                                                        <span className="price">
                                                          {Intl.NumberFormat(
                                                            "vi-VN",
                                                            {
                                                              style: "currency",
                                                              currency: "VND",
                                                            }
                                                          ).format(
                                                            item.productPrice
                                                          )}
                                                        </span>
                                                      );
                                                    }
                                                  })()}
                                                </div>
                                              </div>
                                            </div>
                                            <div class="product-buttons d-flex justify-content-center">
                                              <form
                                                action="#"
                                                method="post"
                                                class="formAddToCart"
                                              >
                                                <input
                                                  type="hidden"
                                                  name="id_product"
                                                  value="1"
                                                />
                                                <a
                                                  class="add-to-cart"
                                                  href="#"
                                                  data-button-action="add-to-cart"
                                                >
                                                  <i
                                                    class="fa fa-shopping-cart"
                                                    aria-hidden="true"
                                                  ></i>
                                                </a>
                                              </form>
                                              <a
                                                class="addToWishlist"
                                                href="#"
                                                data-rel="1"
                                                onclick=""
                                              >
                                                <i
                                                  class="fa fa-heart"
                                                  aria-hidden="true"
                                                ></i>
                                              </a>
                                              <a
                                                href="#"
                                                class="quick-view hidden-sm-down"
                                                data-link-action="quickview"
                                              >
                                                <i
                                                  class="fa fa-eye"
                                                  aria-hidden="true"
                                                ></i>
                                              </a>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                    );
                                  }
                                })}
                              </div>
                            </div>

                            <div id="list" class="related tab-pane fade">
                              {this.state.products.map((item) => {
                                if (
                                  item.inventory.message.message === "AVAILABLE"
                                ) {
                                  return (
                                    <div class="row">
                                      <div class="item col-md-12">
                                        <div class="product-miniature item-one first-item">
                                          <div class="row">
                                            <div class="col-md-4">
                                              <div class="thumbnail-container border">
                                                <a href="product-detail.html">
                                                  <img
                                                    class="img-fluid image-cover"
                                                    src={require("../component/asset/product/" +
                                                      item.picture
                                                        .pictureFirst)}
                                                    alt="img"
                                                  />
                                                  <img
                                                    class="img-fluid image-secondary"
                                                    src={require("../component/asset/product/" +
                                                      item.picture
                                                        .pictureSecond)}
                                                    alt="img"
                                                  />
                                                </a>
                                              </div>
                                            </div>
                                            <div class="col-md-8">
                                              <div class="product-description">
                                                <div class="product-groups">
                                                  <div class="product-title">
                                                    <a href="product-detail.html">
                                                      {item.productName}
                                                    </a>
                                                  </div>
                                                  <div class="rating">
                                                    <div class="star-content">
                                                      <div class="star"></div>
                                                      <div class="star"></div>
                                                      <div class="star"></div>
                                                      <div class="star"></div>
                                                      <div class="star"></div>
                                                    </div>
                                                  </div>
                                                  <div class="product-group-price">
                                                    <div class="product-price-and-shipping">
                                                      {(() => {
                                                        if (
                                                          item.productSaleoff !=
                                                          0
                                                        ) {
                                                          return (
                                                            <>
                                                              <ul>
                                                                <li>
                                                                  <span className="price">
                                                                    {Intl.NumberFormat(
                                                                      "vi-VN",
                                                                      {
                                                                        style:
                                                                          "currency",
                                                                        currency:
                                                                          "VND",
                                                                      }
                                                                    ).format(
                                                                      item.productPrice -
                                                                        item.productSaleoff
                                                                    )}
                                                                  </span>
                                                                </li>
                                                                <li>
                                                                  <del className="regular-price">
                                                                    {Intl.NumberFormat(
                                                                      "vi-VN",
                                                                      {
                                                                        style:
                                                                          "currency",
                                                                        currency:
                                                                          "VND",
                                                                      }
                                                                    ).format(
                                                                      item.productPrice
                                                                    )}
                                                                  </del>
                                                                </li>
                                                              </ul>
                                                            </>
                                                          );
                                                        } else {
                                                          return (
                                                            <span className="price">
                                                              {Intl.NumberFormat(
                                                                "vi-VN",
                                                                {
                                                                  style:
                                                                    "currency",
                                                                  currency:
                                                                    "VND",
                                                                }
                                                              ).format(
                                                                item.productPrice
                                                              )}
                                                            </span>
                                                          );
                                                        }
                                                      })()}
                                                    </div>
                                                  </div>
                                                  <div class="discription">
                                                    {item.productDescription}
                                                  </div>
                                                </div>
                                                <div class="product-buttons d-flex">
                                                  <form
                                                    action="#"
                                                    method="post"
                                                    class="formAddToCart"
                                                  >
                                                    <a
                                                      class="add-to-cart"
                                                      href="#"
                                                      data-button-action="add-to-cart"
                                                    >
                                                      <i
                                                        class="fa fa-shopping-cart"
                                                        aria-hidden="true"
                                                      ></i>
                                                      Add to cart
                                                    </a>
                                                  </form>
                                                  <a
                                                    class="addToWishlist"
                                                    href="#"
                                                    data-rel="1"
                                                    onclick=""
                                                  >
                                                    <i
                                                      class="fa fa-heart"
                                                      aria-hidden="true"
                                                    ></i>
                                                  </a>
                                                  <a
                                                    href="#"
                                                    class="quick-view hidden-sm-down"
                                                    data-link-action="quickview"
                                                  >
                                                    <i
                                                      class="fa fa-eye"
                                                      aria-hidden="true"
                                                    ></i>
                                                  </a>
                                                </div>
                                              </div>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  );
                                }
                              })}
                            </div>
                          </div>

                          {/* <!-- pagination --> */}
                          <div class="pagination">
                            <div class="js-product-list-top ">
                              <div class="d-flex justify-content-around row">
                                <div class="showing col col-xs-12">
                                  <span>SHOWING 1-3 OF 3 ITEM(S)</span>
                                </div>
                                <div class="page-list col col-xs-12">
                                  <ul>
                                    <li>
                                      <a
                                        rel="prev"
                                        href="#"
                                        class="previous disabled js-search-link"
                                      >
                                        Previous
                                      </a>
                                    </li>
                                    <li class="current active">
                                      <a
                                        rel="nofollow"
                                        href="#"
                                        class="disabled js-search-link"
                                      >
                                        1
                                      </a>
                                    </li>
                                    <li>
                                      <a
                                        rel="nofollow"
                                        href="#"
                                        class="disabled js-search-link"
                                      >
                                        2
                                      </a>
                                    </li>
                                    <li>
                                      <a
                                        rel="nofollow"
                                        href="#"
                                        class="disabled js-search-link"
                                      >
                                        3
                                      </a>
                                    </li>

                                    <li>
                                      <a
                                        rel="next"
                                        href="#"
                                        class="next disabled js-search-link"
                                      >
                                        Next
                                      </a>
                                    </li>
                                  </ul>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>

                        {/* <!-- end col-md-9-1 --> */}
                      </div>
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

export default ProductsAll;
