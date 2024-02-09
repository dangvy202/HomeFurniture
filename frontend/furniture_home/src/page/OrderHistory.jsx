import React from "react";
import { Component } from "react";
import OrderService from "../service/OrderService";

class OrderHistory extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orderHistory: [],
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
      OrderService.getOrderHistory(sessionStorage.getItem("email"))
        .then((res) => {
          this.setState({ orderHistory: res.data });
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
                      <span>Order History</span>
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
                        <h1 class="title-page">My Orders</h1>
                        <div id="block-history" class="block-center">
                          <table class="std table">
                            <thead>
                              <tr>
                                <th class="first_item">Order Code</th>
                                <th class="item mywishlist_first">
                                  Order Status
                                </th>
                                <th class="item mywishlist_first">
                                  Total Price
                                </th>
                                <th class="item mywishlist_second">Created</th>
                                <th class="item mywishlist_second">
                                  Name Purchased
                                </th>
                                <th class="item mywishlist_first">Viewed</th>
                                <th class="item mywishlist_first">Purchased</th>
                              </tr>
                            </thead>
                            <tbody>
                              {this.state.orderHistory.map((item) => (
                                <tr id="wishlist_1">
                                  <td>
                                    <a href={"/order-detail/" + item.orderCode}>
                                      {item.orderCode}
                                    </a>
                                  </td>
                                  <td class="bold align_center">
                                    {item.orderStatus}
                                  </td>
                                  <td>
                                    {Intl.NumberFormat("vi-VN", {
                                      style: "currency",
                                      currency: "VND",
                                    }).format(item.totalOrder)}
                                  </td>
                                  <td>{item.updateDate.split("T")[0]}</td>
                                  <td>{item.userName}</td>
                                  <td class="wishlist_default">
                                    <a href={"/order-detail/" + item.orderCode}>
                                      View
                                    </a>
                                  </td>
                                  <td class="wishlist_default">
                                    <a
                                      href="javascript:;"
                                      onclick="javascript:WishlistManage('block-order-detail', '1');"
                                    >
                                      Purchased
                                    </a>
                                  </td>
                                </tr>
                              ))}
                            </tbody>
                          </table>
                        </div>
                        <div class="page-home">
                          <a class="btn btn-default" href="/">
                            <i class="fa fa-home" aria-hidden="true"></i>
                            <span>Homepage</span>
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

export default OrderHistory;
