import React from "react";
import { Component } from "react";
import ProductService from "../service/ProductService";
import { useParams } from "react-router-dom";

class ProductDetail extends Component {
  constructor(props) {
    super(props);
    const pathName = window.location.pathname;
    var arrPath = pathName.split("/");
    var idProduct = arrPath[arrPath.length - 1];
    this.state = {
      id: idProduct,
      productName: "",
      productDescription: "",
      productPrice: "",
      productSaleoff: "",
      productColor: "",
      productProperty: "",
      pictureFirst: "",
      pictureSecond: "",
      pictureThird: "",
      categoryName: "",
      roomName: "",
      quantity: 1,
    };
    this.increaseProduct = this.increaseProduct.bind(this);
    this.reductionProduct = this.reductionProduct.bind(this);
  }

  componentDidMount() {
    ProductService.getProductDetail(this.state.id)
      .then((res) => {
        this.setState({ productName: res.data.productName });
        this.setState({ productDescription: res.data.productDescription });
        this.setState({ productPrice: res.data.productPrice });
        this.setState({ productSaleoff: res.data.productSaleoff });
        this.setState({ productColor: res.data.productColor });
        this.setState({ productProperty: res.data.productProperty });
        this.setState({
          pictureFirst: require("../component/asset/product/" +
            res.data.picture.pictureFirst),
        });
        this.setState({
          pictureSecond: require("../component/asset/product/" +
            res.data.picture.pictureSecond),
        });
        this.setState({
          pictureThird: require("../component/asset/product/" +
            res.data.picture.pictureThird),
        });
        this.setState({ categoryName: res.data.category.categoryName });
        this.setState({ roomName: res.data.room.roomName });
      })
      .catch((error) => {});
  }

  increaseProduct() {
    var sum = this.state.quantity + 1;
    this.setState({ quantity: sum });
  }

  reductionProduct() {
    if (this.state.quantity > 1) {
      var sum = this.state.quantity - 1;
      this.setState({ quantity: sum });
    }
  }
  render() {
    return (
      <div id="product-detail">
        <div className="main-content">
          <div id="wrapper-site">
            <div id="content-wrapper">
              <div id="main">
                <div className="page-home">
                  {/* <!-- breadcrumb --> */}
                  <nav className="breadcrumb-bg">
                    <div className="container no-index">
                      <div className="breadcrumb">
                        <ol>
                          <li>
                            <a href="/">
                              <span>Home</span>
                            </a>
                          </li>
                          <li>
                            <span>Product Detail</span>
                          </li>
                        </ol>
                      </div>
                    </div>
                  </nav>
                  <div className="container">
                    <div className="content">
                      <div className="row">
                        <div className="col-sm-8 col-lg-12 col-md-12">
                          <div className="main-product-detail">
                            <h2>{this.state.productName}</h2>
                            <div className="product-single row">
                              <div className="product-detail col-xs-12 col-md-5 col-sm-5">
                                <div className="page-content" id="content">
                                  <div className="images-container">
                                    <div className="js-qv-mask mask tab-content border">
                                      <div
                                        id="item1"
                                        className="tab-pane fade active in show"
                                      >
                                        <img
                                          src={this.state.pictureFirst}
                                          alt="img"
                                        />
                                      </div>
                                      <div id="item2" className="tab-pane fade">
                                        <img
                                          src={this.state.pictureSecond}
                                          alt="img"
                                        />
                                      </div>
                                      <div id="item3" className="tab-pane fade">
                                        <img
                                          src={this.state.pictureThird}
                                          alt="img"
                                        />
                                      </div>
                                      <div
                                        className="layer hidden-sm-down"
                                        data-toggle="modal"
                                        data-target="#product-modal"
                                      >
                                        <i className="fa fa-expand"></i>
                                      </div>
                                    </div>
                                    <ul className="product-tab nav nav-tabs d-flex">
                                      <li className="active col">
                                        <a
                                          href="#item1"
                                          data-toggle="tab"
                                          aria-expanded="true"
                                          className="active show"
                                        >
                                          <img
                                            src={this.state.pictureFirst}
                                            alt="img"
                                          />
                                        </a>
                                      </li>
                                      <li className="col">
                                        <a href="#item2" data-toggle="tab">
                                          <img
                                            src={this.state.pictureSecond}
                                            alt="img"
                                          />
                                        </a>
                                      </li>
                                      <li className="col">
                                        <a href="#item3" data-toggle="tab">
                                          <img
                                            src={this.state.pictureThird}
                                            alt="img"
                                          />
                                        </a>
                                      </li>
                                    </ul>
                                    <div
                                      className="modal fade"
                                      id="product-modal"
                                      role="dialog"
                                    >
                                      <div className="modal-dialog">
                                        {/* <!-- Modal content--> */}
                                        <div className="modal-content">
                                          <div className="modal-header">
                                            <div className="modal-body">
                                              <div className="product-detail">
                                                <div>
                                                  <div className="images-container">
                                                    <div className="js-qv-mask mask tab-content">
                                                      <div
                                                        id="modal-item1"
                                                        className="tab-pane fade active in show"
                                                      >
                                                        <img
                                                          src={
                                                            this.state
                                                              .pictureFirst
                                                          }
                                                          alt="img"
                                                        />
                                                      </div>
                                                      <div
                                                        id="modal-item2"
                                                        className="tab-pane fade"
                                                      >
                                                        <img
                                                          src={
                                                            this.state
                                                              .pictureSecond
                                                          }
                                                          alt="img"
                                                        />
                                                      </div>
                                                      <div
                                                        id="modal-item3"
                                                        className="tab-pane fade"
                                                      >
                                                        <img
                                                          src={
                                                            this.state
                                                              .pictureThird
                                                          }
                                                          alt="img"
                                                        />
                                                      </div>
                                                    </div>
                                                    <ul className="product-tab nav nav-tabs">
                                                      <li className="active">
                                                        <a
                                                          href="#modal-item1"
                                                          data-toggle="tab"
                                                          className=" active show"
                                                        >
                                                          <img
                                                            src={
                                                              this.state
                                                                .pictureFirst
                                                            }
                                                            alt="img"
                                                          />
                                                        </a>
                                                      </li>
                                                      <li>
                                                        <a
                                                          href="#modal-item2"
                                                          data-toggle="tab"
                                                        >
                                                          <img
                                                            src={
                                                              this.state
                                                                .pictureSecond
                                                            }
                                                            alt="img"
                                                          />
                                                        </a>
                                                      </li>
                                                      <li>
                                                        <a
                                                          href="#modal-item3"
                                                          data-toggle="tab"
                                                        >
                                                          <img
                                                            src={
                                                              this.state
                                                                .pictureThird
                                                            }
                                                            alt="img"
                                                          />
                                                        </a>
                                                      </li>
                                                    </ul>
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
                              </div>
                              <div className="product-info col-xs-12 col-md-7 col-sm-7">
                                <div className="detail-description">
                                  <div className="price-del">
                                    {(() => {
                                      if (this.state.productSaleoff != 0) {
                                        return (
                                          <>
                                            <span className="price">
                                              {Intl.NumberFormat("vi-VN", {
                                                style: "currency",
                                                currency: "VND",
                                              }).format(
                                                this.state.productPrice -
                                                  this.state.productSaleoff
                                              )}
                                            </span>
                                            <del style={{ marginLeft: "20px" }}>
                                              {Intl.NumberFormat("vi-VN", {
                                                style: "currency",
                                                currency: "VND",
                                              }).format(
                                                this.state.productPrice
                                              )}
                                            </del>
                                          </>
                                        );
                                      } else {
                                        return (
                                          <span className="price">
                                            {Intl.NumberFormat("vi-VN", {
                                              style: "currency",
                                              currency: "VND",
                                            }).format(this.state.productPrice)}
                                          </span>
                                        );
                                      }
                                    })()}
                                    <span className="float-right">
                                      <span className="availb">
                                        Availability:{" "}
                                      </span>
                                      <span className="check">
                                        <i
                                          className="fa fa-check-square-o"
                                          aria-hidden="true"
                                        ></i>
                                        IN STOCK
                                      </span>
                                    </span>
                                  </div>
                                  <p className="description">
                                    {this.state.productDescription}
                                  </p>
                                  <div className="has-border cart-area">
                                    <div className="product-quantity">
                                      <div className="qty">
                                        <div className="input-group">
                                          <div className="quantity">
                                            <span className="control-label">
                                              QTY :{" "}
                                            </span>
                                            <input
                                              type="text"
                                              name="qty"
                                              id="quantity_wanted"
                                              className="input-group form-control"
                                              value={this.state.quantity}
                                              min={1}
                                            />

                                            <span className="input-group-btn-vertical">
                                              <button
                                                className="btn btn-touchspin js-touchspin bootstrap-touchspin-up"
                                                type="button"
                                                onClick={(e) => {
                                                  e.preventDefault();
                                                  this.increaseProduct();
                                                }}
                                              >
                                                +
                                              </button>
                                              <button
                                                className="btn btn-touchspin js-touchspin bootstrap-touchspin-down"
                                                type="button"
                                                onClick={(e) => {
                                                  e.preventDefault();
                                                  this.reductionProduct();
                                                }}
                                              >
                                                -
                                              </button>
                                            </span>
                                          </div>
                                          <span className="add">
                                            <button
                                              className="btn btn-primary add-to-cart add-item"
                                              data-button-action="add-to-cart"
                                              type="submit"
                                            >
                                              <i
                                                className="fa fa-shopping-cart"
                                                aria-hidden="true"
                                              ></i>
                                              <span>Add to cart</span>
                                            </button>
                                            <a
                                              className="addToWishlist"
                                              href="#"
                                            >
                                              <i
                                                className="fa fa-heart"
                                                aria-hidden="true"
                                              ></i>
                                            </a>
                                          </span>
                                        </div>
                                      </div>
                                    </div>
                                    <div className="clearfix"></div>
                                    <p className="product-minimal-quantity"></p>
                                  </div>
                                  <div className="d-flex2 has-border">
                                    <div className="btn-group">
                                      <a href="#">
                                        <i className="zmdi zmdi-share"></i>
                                        <span>Share</span>
                                      </a>
                                      <a href="#" className="email">
                                        <i
                                          className="fa fa-envelope"
                                          aria-hidden="true"
                                        ></i>
                                        <span>SEN TO A FRIEND</span>
                                      </a>
                                      <a href="#" className="print">
                                        <i className="zmdi zmdi-print"></i>
                                        <span>Print</span>
                                      </a>
                                    </div>
                                  </div>
                                  <div className="content">
                                    <p>
                                      SKU :
                                      <span className="content2">
                                        <a href="#">e-02154</a>
                                      </span>
                                    </p>
                                    <p>
                                      Color :
                                      <span className="content2">
                                        {this.state.productColor}
                                      </span>
                                    </p>
                                    <p>
                                      Categories :
                                      <span className="content2">
                                        {this.state.categoryName}
                                      </span>
                                    </p>
                                    <p>
                                      Room :
                                      <span className="content2">
                                        {this.state.roomName}
                                      </span>
                                    </p>
                                    <p>
                                      Material :
                                      <span className="content2">
                                        {this.state.productProperty}
                                      </span>
                                    </p>
                                  </div>
                                  <div>
                                    <div className="review">
                                      <ul className="nav nav-tabs">
                                        <li className="active">
                                          <a
                                            data-toggle="tab"
                                            href="#description"
                                            className="active show"
                                          >
                                            Description
                                          </a>
                                        </li>
                                      </ul>

                                      <div className="tab-content">
                                        <div
                                          id="description"
                                          className="tab-pane fade in active show"
                                        >
                                          {this.state.productDescription}
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

export default ProductDetail;
