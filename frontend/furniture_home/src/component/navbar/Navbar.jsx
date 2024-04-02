import React, { Component } from "react";
import logo from "../asset/home/logo.png";
import logomobie from "../asset/home/logo-mobie.png";
import CategoryBlogService from "../../service/CategoryBlogService";
import CategoryService from "../../service/CategoryService";
import RoomService from "../../service/RoomService";

class Navbar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      categoryBlog: [],
      categoryProduct: [],
      room: [],
      cartInstant: [],
      totalProduct: "",
    };
    this.logout = this.logout.bind(this);
  }

  async componentDidMount() {
    CategoryBlogService.getCategory()
      .then((res) => {
        this.setState({ categoryBlog: res.data });
      })
      .catch((error) => {});
    CategoryService.getCategory().then((res) => {
      this.setState({ categoryProduct: res.data });
    });
    RoomService.getAllRoom().then((res) => {
      this.setState({ room: res.data });
    });
  }

  logout() {
    sessionStorage.removeItem("status");
    sessionStorage.removeItem("message");
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("expired");
    sessionStorage.removeItem("email");
    window.location.href = "/";
  }

  changeBlog(id) {
    window.location.href = "/blog/" + id;
  }

  render() {
    return (
      <header>
        <div className="header-mobile d-md-none">
          <div className="mobile hidden-md-up text-xs-center d-flex align-items-center justify-content-around">
            {/* <!-- menu left --> */}
            <div id="mobile_mainmenu" className="item-mobile-top">
              <i className="fa fa-bars" aria-hidden="true"></i>
            </div>

            {/* <!-- logo --> */}
            <div className="mobile-logo">
              <a href="home2.html">
                <img
                  className="logo-mobile img-fluid"
                  src={logomobie}
                  alt="Prestashop_Furnitica"
                />
              </a>
            </div>

            {/* <!-- menu right --> */}
            <div className="mobile-menutop" data-target="#mobile-pagemenu">
              <i className="zmdi zmdi-more"></i>
            </div>
          </div>

          {/* <!-- search --> */}
          <div id="mobile_search" className="d-flex">
            <div id="mobile_search_content">
              <form method="get" action="#">
                <input type="text" name="s" placeholder="Search" />
                <button type="submit">
                  <i className="fa fa-search"></i>
                </button>
              </form>
            </div>
            <div className="desktop_cart">
              <div className="blockcart block-cart cart-preview tiva-toggle">
                <div className="header-cart tiva-toggle-btn">
                  <span className="cart-products-count">1</span>
                  <i className="fa fa-shopping-cart" aria-hidden="true"></i>
                </div>
                <div className="dropdown-content">
                  <div className="cart-content">
                    <table>
                      <tbody>
                        <tr>
                          <td className="product-image">
                            <a href="product-detail.html">
                              <img src="img/product/5.jpg" alt="Product" />
                            </a>
                          </td>
                          <td>
                            <div className="product-name">
                              <a href="product-detail.html">
                                Organic Strawberry Fruits
                              </a>
                            </div>
                            <div>
                              2 x<span className="product-price">£28.98</span>
                            </div>
                          </td>
                          <td className="action">
                            <a className="remove" href="#">
                              <i
                                className="fa fa-trash-o"
                                aria-hidden="true"
                              ></i>
                            </a>
                          </td>
                        </tr>
                        <tr className="total">
                          <td colSpan="2">Total:</td>
                          <td>£92.96</td>
                        </tr>

                        <tr>
                          <td
                            colSpan="3"
                            className="d-flex justify-content-center"
                          >
                            <div className="cart-button d-flex justify-content-center">
                              <a href="product-cart.html" title="View Cart">
                                View Cart
                              </a>
                              <a href="product-checkout.html" title="Checkout">
                                Checkout
                              </a>
                            </div>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        {/* <!-- header desktop --> */}
        <div className="header-top d-xs-none">
          <div className="row margin-0">
            {/* <!-- menu --> */}
            <div className="d-flex icon-menu align-items-center justify-content-center">
              <i className="fa fa-bars" aria-hidden="true" id="icon-menu"></i>
            </div>
            <div className="main-menu d-flex align-items-center justify-content-start navbar-expand-md">
              <div className="menu navbar collapse navbar-collapse">
                <ul className="menu-top navbar-nav">
                  <li className="nav-link">
                    <a href="/" className="parent">
                      Home
                    </a>
                  </li>
                  <li>
                    <a href="#" className="parent">
                      Blog
                    </a>
                    <div className="dropdown-menu">
                      <ul>
                        {this.state.categoryBlog.map((item) => (
                          <li className="item" key={item.id}>
                            <a
                              href="#"
                              onClick={() => this.changeBlog(item.id)}
                            >
                              {item.categoryName}
                            </a>
                          </li>
                        ))}
                      </ul>
                    </div>
                  </li>
                  <li>
                    <a href="#" className="parent">
                      Products
                    </a>
                    <div className="dropdown-menu drop-tab">
                      <ul>
                        <li className="item container group">
                          <div className="dropdown-menu dropdown-tab">
                            <ul>
                              <li className="item col-md-6 float-left">
                                <span className="menu-title">
                                  Category Product
                                </span>
                                <div className="menu-content">
                                  <ul className="col">
                                    {this.state.categoryProduct.map((item) => (
                                      <li key={item.id}>
                                        <a
                                          href={
                                            "/product/category?=" +
                                            item.categoryRedirect
                                          }
                                        >
                                          {item.categoryName}
                                        </a>
                                      </li>
                                    ))}
                                  </ul>
                                </div>
                              </li>
                              <li className="item col-md-6 html  float-left">
                                <span className="menu-title">Room</span>
                                <div className="menu-content">
                                  <ul>
                                    {this.state.room.map((item) => (
                                      <li key={item.id}>
                                        <a
                                          href={
                                            "/product/room?=" +
                                            item.roomRedirect
                                          }
                                        >
                                          {item.roomName}
                                        </a>
                                      </li>
                                    ))}
                                  </ul>
                                </div>
                              </li>
                            </ul>
                          </div>
                        </li>
                      </ul>
                    </div>
                  </li>
                  <li>
                    <a href="/contact" className="parent">
                      Contact US
                    </a>
                  </li>
                </ul>
              </div>
            </div>

            {/* <!-- logo --> */}
            <div className="flex-2 d-flex align-items-center justify-content-center">
              <div id="logo">
                <a href="/">
                  <img src={logo} alt="logo" />
                </a>
              </div>
            </div>

            {/* <!-- search and acount --> */}
            <div
              id="search_widget"
              className="d-flex align-items-center justify-content-end"
            >
              <div className="search-header-top d-flex align-items-center justify-content-center">
                <i className="search fa fa-search"></i>
              </div>
              <div id="block_myaccount_infos">
                <div className="myaccount-title hidden-sm-down dropdown d-flex align-items-center justify-content-center">
                  <a href="#acount" data-toggle="collapse" className="acount">
                    <i
                      className="fa fa-user"
                      style={{ marginTop: "0px" }}
                      aria-hidden="true"
                    ></i>
                    {(() => {
                      if (sessionStorage.getItem("token")) {
                        return (
                          <>
                            <span
                              style={{ marginLeft: "10px", marginTop: "10px" }}
                            >
                              {sessionStorage.getItem("email")}
                            </span>
                            <i
                              className="fa fa-angle-down"
                              aria-hidden="true"
                            ></i>
                          </>
                        );
                      }
                    })()}
                  </a>
                </div>
                <div id="acount" className="collapse">
                  <div className="account-list-content">
                    <div>
                      <a
                        className="login"
                        href="/infomation"
                        rel="nofollow"
                        title="Log in to your customer account"
                      >
                        <i className="fa fa-cog"></i>
                        <span>My Account</span>
                      </a>
                    </div>

                    {(() => {
                      if (sessionStorage.getItem("token") == null) {
                        return (
                          <>
                            <div>
                              <a
                                className="login"
                                href="/login"
                                rel="nofollow"
                                title="Log in to your customer account"
                              >
                                <i className="fa fa-sign-in"></i>
                                <span>Sign in</span>
                              </a>
                            </div>
                            <div>
                              <a
                                className="register"
                                href="/register"
                                rel="nofollow"
                                title="Register Account"
                              >
                                <i className="fa fa-user"></i>
                                <span>Register Account</span>
                              </a>
                            </div>
                          </>
                        );
                      } else {
                        return (
                          <>
                            <div>
                              <a
                                className="login"
                                href="#"
                                rel="nofollow"
                                title="Log in to your customer account"
                                onClick={this.logout}
                              >
                                <i className="fa fa-sign-in"></i>
                                <span>Sign out</span>
                              </a>
                            </div>
                          </>
                        );
                      }
                    })()}
                    <div>
                      <a
                        className="check-out"
                        href="/order-history"
                        rel="nofollow"
                        title="Checkout"
                      >
                        <i className="fa fa-check" aria-hidden="true"></i>
                        <span>Order History</span>
                      </a>
                    </div>
                    <div>
                      <a href="/wishlist" title="My Wishlists">
                        <i className="fa fa-heart"></i>My Wishlists
                      </a>
                    </div>
                  </div>
                </div>
              </div>
              <div className="desktop_cart d-flex align-items-center">
                <div className="blockcart block-cart cart-preview tiva-toggle">
                  <div className="header-cart tiva-toggle-btn">
                    <a href="/cart">
                      <i className="fa fa-shopping-cart" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </header>
    );
  }
}

export default Navbar;
