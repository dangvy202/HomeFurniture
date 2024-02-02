import React, { Component } from "react";
import Banner from "../component/banner/Banner";
import Product from "../component/product/Product";
import Introduction from "../component/introduction/Introduction";
import RoomCategory from "../component/room/RoomCategory";
import Subscribe from "../component/subscribe/Subscribe";

class Home extends Component {
  render() {
    return (
      // <body id="home2">
      <div className="main-content">
        {/* <!-- main --> */}
        <div id="wrapper-site">
          <div id="content-wrapper" className="full-width">
            <div id="main">
              <section className="page-home">
                <Banner />
                <Introduction />

                {/* <!-- product living room --> */}
                <div
                  className="section living-room background-none"
                  style={{ marginTop: "-5%" }}
                >
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
                <RoomCategory />
                <Subscribe />
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
