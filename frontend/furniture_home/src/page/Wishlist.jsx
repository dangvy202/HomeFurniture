import React from "react";
import { Component } from "react";
import wishlistService from "../service/WishlistService";

class Wishlist extends Component {
  constructor(props) {
    super(props);
    this.state = {
      productList: [],
      notification: "",
    };
    this.increaseProduct = this.increaseProduct.bind(this);
    this.reductionProduct = this.reductionProduct.bind(this);
    this.trash = this.trash.bind(this);
    this.addToCart = this.addToCart.bind(this);
  }

  componentDidMount() {
    if (
      sessionStorage.getItem("status") != null &&
      sessionStorage.getItem("message") != null &&
      sessionStorage.getItem("token") != null &&
      sessionStorage.getItem("expired") != null &&
      sessionStorage.getItem("email") != null
    ) {
      wishlistService
        .getAllWishlistByEmail(sessionStorage.getItem("email"))
        .then((res) => {
          this.setState({ productList: res.data.resultData.product });
        })
        .catch((error) => {});
    } else {
      window.location.href = "/login";
    }
  }

  trash(product) {
    const request = {
      email: sessionStorage.getItem("email"),
      id_product: product.id,
    };
    wishlistService
      .deleteWishlistOrder(request)
      .then((res) => {
        this.setState({ notification: res.data.message });
      })
      .catch((error) => {
        this.setState({ notification: "FAIL" });
      });
    window.location.reload();
  }

  reductionProduct(product, quantity) {
    if (quantity > 1) {
      const request = {
        email: sessionStorage.getItem("email"),
        id_product: product.id,
      };
      wishlistService
        .subtractWishlist(request)
        .then((res) => {
          this.setState({ notification: res.data.message });
        })
        .catch((error) => {
          this.setState({ notification: "FAIL" });
        });
      window.location.reload();
    }
  }

  increaseProduct(product) {
    const request = {
      email: sessionStorage.getItem("email"),
      id_product: product.id,
    };
    wishlistService
      .addWishlist(request)
      .then((res) => {
        this.setState({ notification: res.data.message });
      })
      .catch((error) => {
        this.setState({ notification: "FAIL" });
      });
    window.location.reload();
  }

  addToCart(productList) {
    sessionStorage.setItem("cart", JSON.stringify(productList));
  }
  render() {
    return (
      <div class="user-wishlist blog">
        {/* <!-- main content --> */}
        <div class="main-content">
          <div class="wrap-banner">
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
                      <span>Wishlist</span>
                    </li>
                  </ol>
                </div>
              </div>
            </nav>
          </div>

          {/* <!-- main --> */}
          <div id="wrapper-site">
            <div class="container">
              <div class="row">
                <div
                  id="content-wrapper"
                  class="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol"
                >
                  <div id="main">
                    <div id="content" class="page-content">
                      <div id="mywishlist">
                        <h1 class="title-page">My Wishlist</h1>
                        <p style={{ fontStyle: "italic", color: "red" }}>
                          *** Wishlist will be delete when you click add to cart
                          and
                        </p>
                        <div id="block-history" class="block-center">
                          <table class="std table">
                            <thead>
                              <tr>
                                <th class="item mywishlist_first">Picture</th>
                                <th class="item mywishlist_first">
                                  Name Product
                                </th>
                                <th class="item mywishlist_second">Quantity</th>
                                <th class="item mywishlist_second">Price</th>
                                <th class="item mywishlist_first">Viewed</th>
                                <th class="item mywishlist_first">Action</th>
                              </tr>
                            </thead>
                            <tbody>
                              {(() => {
                                if (this.state.productList !== null) {
                                  return (
                                    <>
                                      {this.state.productList.map((item) => (
                                        <tr id="wishlist_1">
                                          <td style={{ textAlign: "center" }}>
                                            <img
                                              className="img-fluid"
                                              src={require("../component/asset/product/" +
                                                item.picture.picture)}
                                              width={"100px"}
                                              height={"100px"}
                                            />
                                          </td>
                                          <td class="bold align_center">
                                            {item.productName}
                                          </td>
                                          <td>{item.quantity}</td>
                                          <td>
                                            {Intl.NumberFormat("vi-VN", {
                                              style: "currency",
                                              currency: "VND",
                                            }).format(item.totalPrice)}
                                          </td>
                                          <td class="wishlist_default">
                                            <a
                                              href={
                                                "/product-detail/" + item.id
                                              }
                                            >
                                              View
                                            </a>
                                          </td>
                                          <td
                                            class="wishlist_default"
                                            style={{
                                              display: "flex",
                                              justifyContent: "space-around",
                                              height: "125px",
                                              alignItems: "center",
                                            }}
                                          >
                                            <button
                                              class="button-design plus"
                                              onClick={(e) => {
                                                e.preventDefault();
                                                this.increaseProduct(item);
                                              }}
                                            >
                                              <i class="fa-solid fa-plus"></i>
                                            </button>
                                            <button
                                              class="button-design subtract"
                                              onClick={(e) => {
                                                e.preventDefault();
                                                this.reductionProduct(
                                                  item,
                                                  item.quantity
                                                );
                                              }}
                                            >
                                              <i class="fa-solid fa-minus"></i>
                                            </button>
                                            <button
                                              class="button-design trash"
                                              onClick={(e) => {
                                                e.preventDefault();
                                                this.trash(item);
                                              }}
                                            >
                                              <i class="fa-regular fa-trash-can"></i>
                                            </button>
                                          </td>
                                        </tr>
                                      ))}
                                    </>
                                  );
                                }
                              })()}
                            </tbody>
                          </table>
                        </div>
                        <div class="page-home">
                          <a
                            class="btn btn-default"
                            href="#"
                            onClick={(e) => {
                              e.preventDefault();
                              this.addToCart(this.state.productList);
                            }}
                          >
                            <i class="fa-solid fa-cart-plus"></i>
                            <span>Add to cart</span>
                          </a>
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

export default Wishlist;
