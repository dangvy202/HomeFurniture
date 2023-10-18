import React from "react";
import Banner from "../component/banner/Banner";
import Category from "../component/categories/Caregory";

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
            </section>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
