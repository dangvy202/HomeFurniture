import React from "react";
import logo from "../asset/home/logo.png";
import logomobie from "../asset/home/logo-mobie.png";

const Navbar = () => {
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
                            <i className="fa fa-trash-o" aria-hidden="true"></i>
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
                      <li className="item">
                        <a
                          href="blog-list-sidebar-left.html"
                          title="Blog List (Sidebar Left)"
                        >
                          Blog List (Sidebar Left)
                        </a>
                      </li>
                      <li className="item">
                        <a
                          href="blog-list-sidebar-left2.html"
                          title="Blog List (Sidebar Left) 2"
                        >
                          Blog List (Sidebar Left) 2
                        </a>
                      </li>
                      <li className="item">
                        <a
                          href="blog-list-sidebar-right.html"
                          title="Category Blog (Right column)"
                        >
                          Blog List (Sidebar Right)
                        </a>
                      </li>
                      <li className="item">
                        <a
                          href="blog-list-no-sidebar.html"
                          title="Blog List (No Sidebar)"
                        >
                          Blog List (No Sidebar)
                        </a>
                      </li>
                      <li className="item">
                        <a
                          href="blog-grid-no-sidebar.html"
                          title="Blog Grid (No Sidebar)"
                        >
                          Blog Grid (No Sidebar)
                        </a>
                      </li>
                      <li className="item">
                        <a href="blog-detail.html" title="Blog Detail">
                          Blog Detail
                        </a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li>
                  <a href="#" className="parent">
                    Page
                  </a>
                  <div className="dropdown-menu drop-tab">
                    <ul>
                      <li className="item container group">
                        <div className="dropdown-menu dropdown-tab">
                          <ul>
                            <li className="item col-md-4 float-left">
                              <span className="menu-title">Category Style</span>
                              <div className="menu-content">
                                <ul className="col">
                                  <li>
                                    <a href="product-grid-sidebar-left.html">
                                      Product Grid (Sidebar Left)
                                    </a>
                                  </li>
                                  <li>
                                    <a href="product-grid-sidebar-right.html">
                                      Product Grid (Sidebar Right)
                                    </a>
                                  </li>
                                  <li>
                                    <a href="product-list-sidebar-left.html">
                                      Product List (Sidebar left){" "}
                                    </a>
                                  </li>
                                </ul>
                              </div>
                            </li>
                            <li className="item col-md-4 html  float-left">
                              <span className="menu-title">
                                Product Detail Style
                              </span>
                              <div className="menu-content">
                                <ul>
                                  <li>
                                    <a href="product-detail.html">
                                      Product Detail (Sidebar Left)
                                    </a>
                                  </li>
                                  <li>
                                    <a href="#">
                                      Product Detail (Sidebar Right)
                                    </a>
                                  </li>
                                </ul>
                              </div>
                            </li>
                            <li className="item col-md-4 html  float-left">
                              <span className="menu-title">Bonus Page</span>
                              <div className="menu-content">
                                <ul>
                                  <li>
                                    <a href="404.html">404 Page</a>
                                  </li>
                                  <li>
                                    <a href="about-us.html">About Us Page</a>
                                  </li>
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
                  <a href="contact.html" className="parent">
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
                  <i className="fa fa-user" aria-hidden="true"></i>
                </a>
              </div>
              <div id="acount" className="collapse">
                <div className="account-list-content">
                  <div>
                    <a
                      className="login"
                      href="user-acount.html"
                      rel="nofollow"
                      title="Log in to your customer account"
                    >
                      <i className="fa fa-cog"></i>
                      <span>My Account</span>
                    </a>
                  </div>
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
                      href="user-register.html"
                      rel="nofollow"
                      title="Register Account"
                    >
                      <i className="fa fa-user"></i>
                      <span>Register Account</span>
                    </a>
                  </div>
                  <div>
                    <a
                      className="check-out"
                      href="product-checkout.html"
                      rel="nofollow"
                      title="Checkout"
                    >
                      <i className="fa fa-check" aria-hidden="true"></i>
                      <span>Checkout</span>
                    </a>
                  </div>
                  <div>
                    <a href="user-wishlist.html" title="My Wishlists">
                      <i className="fa fa-heart"></i>My Wishlists
                    </a>
                  </div>
                  <div
                    id="desktop_currency_selector"
                    className="currency-selector groups-selector hidden-sm-down"
                  >
                    <ul className="list-inline">
                      <li>
                        <a title="Euro" rel="nofollow" href="#">
                          EUR
                        </a>
                      </li>
                      <li className="current list-inline-item">
                        <a
                          title="British Pound Sterling"
                          rel="nofollow"
                          href="#"
                        >
                          GBP
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div
                    id="desktop_language_selector"
                    className="language-selector groups-selector hidden-sm-down"
                  >
                    <ul className="list-inline">
                      <li className="list-inline-item current">
                        <a href="#">
                          <img
                            className="img-fluid"
                            src="img/home/home1-flas.jpg"
                            alt="English"
                            width="16"
                            height="11"
                          />
                        </a>
                      </li>
                      <li className="list-inline-item">
                        <a href="#">
                          <img
                            className="img-fluid"
                            src="img/home/home1-flas2.jpg"
                            alt="Italiano"
                            width="16"
                            height="11"
                          />
                        </a>
                      </li>
                      <li className="list-inline-item">
                        <a href="#">
                          <img
                            className="img-fluid"
                            src="img/home/home1-flas3.jpg"
                            alt="Français"
                            width="16"
                            height="11"
                          />
                        </a>
                      </li>
                      <li className="list-inline-item">
                        <a href="#">
                          <img
                            className="img-fluid"
                            src="img/home/home1-flas4.jpg"
                            alt="Español"
                            width="16"
                            height="11"
                          />
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div className="desktop_cart d-flex align-items-center">
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
                            <div className="cart-button">
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
      </div>
    </header>
  );
};

export default Navbar;
