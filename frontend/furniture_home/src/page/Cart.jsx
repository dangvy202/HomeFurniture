import React, { Component } from "react";
import ProductService from "../service/ProductService";
import OrderService from "../service/OrderService";

class Cart extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cartInstant: [],
      totalProduct: "",
      notification: "",
    };
    this.addOrderCart = this.addOrderCart.bind(this);
    this.informationOrder = this.informationOrder.bind(this);
    this.increaseProduct = this.increaseProduct.bind(this);
    this.reductionProduct = this.reductionProduct.bind(this);
    this.trashProduct = this.trashProduct.bind(this);
  }

  trashProduct(idProduct) {
    var listSessionStorageCart = JSON.parse(sessionStorage.getItem("cart"));
    const delProducts = listSessionStorageCart.filter(
      (product) => product.id !== idProduct
    );
    sessionStorage.setItem("cart", JSON.stringify(delProducts));
    window.location.reload();
  }

  increaseProduct(idProduct) {
    var listSessionStorageCart = JSON.parse(sessionStorage.getItem("cart"));

    const updateProduct = listSessionStorageCart.map((item) => {
      if (item.id === idProduct) {
        item.quantity = item.quantity + 1;
      }
      return item;
    });
    sessionStorage.setItem("cart", JSON.stringify(updateProduct));
    window.location.reload();
  }

  reductionProduct(idProduct) {
    var listSessionStorageCart = JSON.parse(sessionStorage.getItem("cart"));

    const updateProduct = listSessionStorageCart.map((item) => {
      if (item.id === idProduct && item.quantity > 1) {
        item.quantity = item.quantity - 1;
      }
      return item;
    });
    sessionStorage.setItem("cart", JSON.stringify(updateProduct));
    window.location.reload();
  }

  componentDidMount() {
    var listIdAddCart = JSON.parse(sessionStorage.getItem("cart"));
    if (listIdAddCart != null) {
      ProductService.getProductByIdCart()
        .then((res) => {
          var arrCartInstant = new Array();
          var totalPrice = 0;
          for (var i = 0; i < res.data.length; i++) {
            arrCartInstant.push({
              ...res.data[i],
              quantity: listIdAddCart[i].quantity,
            });
            totalPrice +=
              (res.data[i].productPrice - res.data[i].productSaleoff) *
              listIdAddCart[i].quantity;
          }
          this.setState({ cartInstant: arrCartInstant });
          this.setState({ totalProduct: totalPrice });
        })
        .catch((error) => {});
    }
  }

  addOrderCart(e) {
    e.preventDefault();
    if (
      sessionStorage.getItem("status") != null &&
      sessionStorage.getItem("message") != null &&
      sessionStorage.getItem("token") != null &&
      sessionStorage.getItem("expired") != null &&
      sessionStorage.getItem("email") != null
    ) {
      if (this.state.cartInstant.length > 0) {
        var orderList = new Array();

        for (var i = 0; i < this.state.cartInstant.length; i++) {
          const jsonDetailProduct = {
            order_quantity: this.state.cartInstant[i].quantity,
            id_product: this.state.cartInstant[i].id,
            total_price:
              (this.state.cartInstant[i].productPrice -
                this.state.cartInstant[i].productSaleoff) *
              this.state.cartInstant[i].quantity,
            user: {
              email: sessionStorage.getItem("email"),
            },
          };
          orderList.push(jsonDetailProduct);
        }

        OrderService.orderProducts(orderList)
          .then((res) => {
            this.setState({ notification: res.data });
            sessionStorage.removeItem("cart");
          })
          .catch((error) => {
            this.setState({ notification: error.response.data.message });
          });
      } else {
        this.setState({ notification: "EMPTY_CART" });
      }
    } else {
      window.location.href = "/login";
    }
  }

  informationOrder() {
    if (this.state.notification === "ORDER_SUCCESS") {
      window.location.href = "";
    }
  }
  render() {
    return (
      <div className="product-cart checkout-cart blog">
        <div className="main-content" id="cart">
          <div
            className="modal fade"
            id="exampleModal"
            tabIndex="-1"
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
          >
            <div className="modal-dialog" role="document">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title" id="exampleModalLabel">
                    {(() => {
                      if (this.state.notification === "ORDER_SUCCESS") {
                        return <>Notification</>;
                      } else {
                        return <>Error !</>;
                      }
                    })()}
                  </h5>
                  <button
                    type="button"
                    className="close"
                    data-dismiss="modal"
                    aria-label="Close"
                  >
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div className="modal-body">
                  {(() => {
                    if (this.state.notification === "ORDER_SUCCESS") {
                      return <>Success, next step</>;
                    } else if (this.state.notification === "EMPTY_CART") {
                      return <>Fail, cart is empty</>;
                    } else {
                      return <>Fail</>;
                    }
                  })()}
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-primary"
                    data-dismiss="modal"
                    onClick={this.informationOrder}
                  >
                    Close
                  </button>
                </div>
              </div>
            </div>
          </div>
          {/* <!-- main --> */}
          <div id="wrapper-site">
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
                      <span>Shopping Cart</span>
                    </li>
                  </ol>
                </div>
              </div>
            </nav>
            <div className="container">
              <div className="row">
                <div
                  id="content-wrapper"
                  className="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol"
                >
                  <section id="main">
                    <div className="cart-grid row">
                      <div className="col-md-9 col-xs-12 check-info">
                        <h1 className="title-page">Shopping Cart</h1>
                        <p style={{ fontStyle: "italic", color: "red" }}>
                          *** Products will delete when account expired login
                          and go back home page, please click continue for the
                          process order begin
                        </p>
                        <div className="cart-container">
                          <div className="cart-overview js-cart">
                            <ul className="cart-items">
                              {this.state.cartInstant.map((item) => (
                                <li className="cart-item">
                                  <div className="product-line-grid row justify-content-between">
                                    {/* <!--  product left content: image--> */}
                                    <div className="product-line-grid-left col-md-2">
                                      <span className="product-image media-middle">
                                        <a href="product-detail.html">
                                          <img
                                            className="img-fluid"
                                            src={require("../component/asset/product/" +
                                              item.picture.pictureFirst)}
                                            alt="Organic Strawberry Fruits"
                                          />
                                        </a>
                                      </span>
                                    </div>
                                    <div className="product-line-grid-body col-md-6">
                                      <div className="product-line-info">
                                        <a
                                          className="label"
                                          href="product-detail.html"
                                          data-id_customization="0"
                                        >
                                          {item.productName}
                                        </a>
                                      </div>
                                      <div className="product-line-info product-price">
                                        <span className="label-atrr">
                                          Price:
                                        </span>
                                        <span
                                          style={{ marginLeft: "5px" }}
                                          className="value"
                                        >
                                          {Intl.NumberFormat("vi-VN", {
                                            style: "currency",
                                            currency: "VND",
                                          }).format(
                                            item.productPrice -
                                              item.productSaleoff
                                          )}
                                        </span>
                                      </div>
                                      <span className="price"></span>
                                    </div>
                                    <div className="product-line-grid-right text-center product-line-actions col-md-4">
                                      <div className="row">
                                        <div className="col-md-5 col qty">
                                          <div className="label">Qty:</div>
                                          <div className="quantity">
                                            <input
                                              type="text"
                                              name="qty"
                                              value={item.quantity}
                                              className="input-group form-control"
                                            />

                                            <span className="input-group-btn-vertical">
                                              <button
                                                className="btn btn-touchspin js-touchspin bootstrap-touchspin-up"
                                                type="button"
                                                onClick={(e) =>
                                                  this.increaseProduct(item.id)
                                                }
                                              >
                                                +
                                              </button>
                                              <button
                                                className="btn btn-touchspin js-touchspin bootstrap-touchspin-down"
                                                type="button"
                                                onClick={(e) =>
                                                  this.reductionProduct(item.id)
                                                }
                                              >
                                                -
                                              </button>
                                            </span>
                                          </div>
                                        </div>
                                        <div className="col-md-5 col price">
                                          <div className="label">Total:</div>
                                          <div className="product-price total">
                                            {Intl.NumberFormat("vi-VN", {
                                              style: "currency",
                                              currency: "VND",
                                            }).format(
                                              (item.productPrice -
                                                item.productSaleoff) *
                                                item.quantity
                                            )}
                                          </div>
                                        </div>
                                        <div className="col-md-2 col text-xs-right align-self-end">
                                          <div className="cart-line-product-actions ">
                                            <a
                                              className="remove-from-cart"
                                              rel="nofollow"
                                              href="#"
                                              onClick={() =>
                                                this.trashProduct(item.id)
                                              }
                                              data-link-action="delete-from-cart"
                                              data-id-product="1"
                                            >
                                              <i
                                                className="fa fa-trash-o"
                                                aria-hidden="true"
                                              ></i>
                                            </a>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </li>
                              ))}
                            </ul>
                          </div>
                        </div>
                        <a
                          href="#"
                          onClick={(e) => this.addOrderCart(e)}
                          className="continue btn btn-primary pull-xs-right btn-default"
                          data-toggle="modal"
                          data-target="#exampleModal"
                        >
                          Accept Order
                        </a>
                      </div>
                      <div className="cart-grid-right col-xs-12 col-lg-3">
                        <div className="cart-summary">
                          <div className="cart-detailed-totals">
                            <div className="cart-summary-products">
                              <div className="summary-label">
                                There are {this.state.cartInstant.length} item
                                in your cart
                              </div>
                            </div>
                            <div
                              className="cart-summary-line"
                              id="cart-subtotal-products"
                            >
                              <span className="label js-subtotal">
                                Total products:
                              </span>
                              <span className="value">
                                {Intl.NumberFormat("vi-VN", {
                                  style: "currency",
                                  currency: "VND",
                                }).format(this.state.totalProduct)}
                              </span>
                            </div>
                            <div
                              className="cart-summary-line"
                              id="cart-subtotal-shipping"
                            >
                              <span className="label">Total Shipping:</span>
                              <span className="value">Free</span>
                              <div>
                                <small className="value"></small>
                              </div>
                            </div>
                            <div className="cart-summary-line cart-total">
                              <span className="label">Total:</span>
                              <span className="value">Free</span>
                            </div>
                          </div>
                        </div>
                        <div id="block-reassurance">
                          <ul>
                            <li>
                              <div className="block-reassurance-item">
                                <img
                                  src={require("../component/asset/product/check1.png")}
                                  alt="Security policy (edit with Customer reassurance module)"
                                />
                                <span>
                                  Security policy (edit with Customer
                                  reassurance module)
                                </span>
                              </div>
                            </li>
                            <li>
                              <div className="block-reassurance-item">
                                <img
                                  src={require("../component/asset/product/check2.png")}
                                  alt="Delivery policy (edit with Customer reassurance module)"
                                />
                                <span>
                                  Delivery policy (edit with Customer
                                  reassurance module)
                                </span>
                              </div>
                            </li>
                            <li>
                              <div className="block-reassurance-item">
                                <img
                                  src={require("../component/asset/product/check3.png")}
                                  alt="Return policy (edit with Customer reassurance module)"
                                />
                                <span>
                                  Return policy (edit with Customer reassurance
                                  module)
                                </span>
                              </div>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </section>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Cart;
