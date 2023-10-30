import React, { Component } from "react";
import Banner from "../component/banner/Banner";
import Category from "../component/categories/Category";
import Product from "../component/product/Product";

class Home extends Component {
  render() {
    return (
      // <body id="home2">
      <div className="main-content">
        <Category />
        {/* <!-- main --> */}
        <div id="wrapper-site">
          <div id="content-wrapper" className="full-width">
            <div id="main">
              <section className="page-home">
                <Banner />
                {/* <!-- product living room --> */}
                <div className="section living-room background-none">
                  <div className="container">
                    <div className="tiva-row-wrap row">
                      <div className="col-md-12 col-xs-12 groupcategoriestab-vertical">
                        <div className="grouptab">
                          <div className="product-tab categoriestab-left flex-9">
                            {/* <Filter /> */}
                            <Product />
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </section>
            </div>
          </div>
        </div>
      </div>
      // </body>
    );
  }
}

export default Home;
