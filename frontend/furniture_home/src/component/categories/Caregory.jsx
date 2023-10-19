import React, { Component } from "react";
import CategoryService from "../../service/CategoryService";

class Category extends Component {
  constructor(props) {
    super(props);

    this.state = {
      category: [],
    };
  }

  componentDidMount() {
    CategoryService.getCategory().then((res) => {
      this.setState({ category: res.data });
    });
  }

  render() {
    return (
      <div className="wrap-banner">
        {/* <!-- menu category --> */}
        <div className="menu-banner d-xs-none">
          <div className="tiva-verticalmenu block" data-count_showmore="17">
            <div className="box-content block_content">
              <div className="verticalmenu" role="navigation">
                <ul className="menu level1">
                  {/* {arrayDataItems} */}

                  {this.state.category.map((item) => (
                    <li className="item parent" key={item.id}>
                      <a href="#" className="hasicon" title={item.categoryName}>
                        <img
                          src={require("../asset/home/" + item.categoryPicture)}
                          alt="img"
                        />
                        {item.categoryName}
                      </a>
                    </li>
                  ))}
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
  }
}

export default Category;
