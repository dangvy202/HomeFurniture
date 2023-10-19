import React, { Component } from "react";

class Filter extends Component {
  render() {
    return (
      <div className="title-tab-content d-flex">
        {/* <!-- tab product --> */}
        <div className="dropdown-toggle toggle-category tab-category-none">
          Select Category
        </div>
        <ul className="nav nav-tabs wibkit row">
          <li className="col-xs-6">
            <a href="#all" data-toggle="tab" className="active">
              ALL PRODUCTS
            </a>
          </li>
          <li className="col-xs-6">
            <a href="#table" data-toggle="tab">
              SIDE TABLE
            </a>
          </li>
          <li className="col-xs-6">
            <a href="#armchair" data-toggle="tab">
              ARMCHAIR
            </a>
          </li>
          <li className="col-xs-6">
            <a href="#cushion" data-toggle="tab">
              CUSHION
            </a>
          </li>
        </ul>

        {/* <!-- Sort by --> */}
        <div className="filter-sortby open ">
          <select>
            <option value="">Sort by</option>
            <option value="">Name, A to Z</option>
            <option value="">Name, Z to A</option>
            <option value="">Price, low to high</option>
            <option value="">Price, high to low</option>
          </select>

          <div
            className="toggle-filter btn ml-3 dropdown-toggle"
            data-label="Filter"
            data-label-hidden="Hide Filter"
          >
            Filter
          </div>
          <div
            className="hide-filter toggle-filter btn"
            data-label="Filter"
            data-label-hidden="Hide Filter"
          >
            <i className="fa fa-times-circle" aria-hidden="true"></i>Hide Filter
          </div>
        </div>
      </div>
    );
  }
}

export default Filter;
