import React from "react";
import tableLamp from "../asset/home/table-lamp.png";

const Category = () => {
  return (
    <div className="wrap-banner">
      {/* <!-- menu category --> */}
      <div className="menu-banner d-xs-none">
        <div className="tiva-verticalmenu block" data-count_showmore="17">
          <div className="box-content block_content">
            <div className="verticalmenu" role="navigation">
              <ul className="menu level1">
                <li className="item parent">
                  <a href="#" className="hasicon" title="SIDE TABLE">
                    <img src={tableLamp} alt="img" />
                    SIDE TABLE
                  </a>
                </li>
                <li className="more item">Show More</li>
              </ul>
            </div>
            <div className="d-flex justify-content-center align-items-center header-top-left pull-left">
              <div className="toggle-nav act">
                <div className="btnov-lines-large">
                  <i className="zmdi zmdi-close"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Category;
