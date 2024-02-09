import React from "react";
import { Component } from "react";
import OrderService from "../service/OrderService";

class OrderDetail extends Component {
  constructor(props) {
    super(props);
    const pathName = window.location.pathname;
    var arrPath = pathName.split("/");
    var orderCodeParameter = arrPath[arrPath.length - 1];
    this.state = {
      orderDetail: [],
      orderCode: orderCodeParameter,
    };
  }
  componentDidMount() {
    if (
      sessionStorage.getItem("status") != null &&
      sessionStorage.getItem("message") != null &&
      sessionStorage.getItem("token") != null &&
      sessionStorage.getItem("expired") != null &&
      sessionStorage.getItem("email") != null
    ) {
      OrderService.getOrderDetail(
        sessionStorage.getItem("email"),
        this.state.orderCode
      )
        .then((res) => {
          this.setState({ orderDetail: res.data.orderDetails });
        })
        .catch((error) => {});
    } else {
      window.location.href = "/login";
    }
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
                      <span>Home</span>
                    </li>
                    <li>
                      <span>Order Detail</span>
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
                        <h1 class="title-page">My Orders Detail</h1>
                        <div class="std" id="customer-form">
                          <fieldset>
                            <h3>Order Code : {this.state.orderCode}</h3>
                          </fieldset>
                        </div>
                        <div id="block-history" class="block-center">
                          <table class="std table">
                            <thead>
                              <tr>
                                <th class="first_item">Picture</th>
                                <th class="item mywishlist_first">
                                  Product Name
                                </th>
                                <th class="item mywishlist_first">
                                  Product Price
                                </th>
                                <th class="item mywishlist_second">Quantity</th>
                                <th class="item mywishlist_second">Total</th>
                              </tr>
                            </thead>
                            <tbody>
                              {this.state.orderDetail.map((item) => (
                                <tr id="wishlist_1">
                                  <td style={{ textAlign: "center" }}>
                                    <img
                                      src={require("../component/asset/product/" +
                                        item.product.picture.picture)}
                                      width={"100px"}
                                      height={"100px"}
                                    />
                                  </td>
                                  <td class="bold align_center">
                                    {item.product.productName}
                                  </td>
                                  <td>
                                    {Intl.NumberFormat("vi-VN", {
                                      style: "currency",
                                      currency: "VND",
                                    }).format(
                                      item.product.productPrice -
                                        item.product.productSaleoff
                                    )}
                                  </td>
                                  <td>{item.product.orderQuantity}</td>

                                  <td class="wishlist_default">
                                    {Intl.NumberFormat("vi-VN", {
                                      style: "currency",
                                      currency: "VND",
                                    }).format(
                                      (item.product.productPrice -
                                        item.product.productSaleoff) *
                                        item.product.orderQuantity
                                    )}
                                  </td>
                                </tr>
                              ))}
                            </tbody>
                          </table>
                        </div>
                        <div class="page-home">
                          <a class="btn btn-default" href="/order-history">
                            <i class="fa fa-home" aria-hidden="true"></i>
                            <span>Order History</span>
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

export default OrderDetail;
