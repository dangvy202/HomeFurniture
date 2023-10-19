import React from "react";
import Banner from "../component/banner/Banner";
import Category from "../component/categories/Caregory";
import Filter from "../component/filter/Filter";
import Product from "../component/product/Product";

const Home = () => {
  return (
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
                          <Filter />
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
  );
};

export default Home;
