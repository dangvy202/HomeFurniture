import React from "react";
import { Component } from "react";
import CategoryBlogService from "../../service/CategoryBlogService";

class CategoryBlog extends Component {
  constructor(props) {
    super(props);
    this.state = {
      categoryBlog: [],
    };
  }

  componentDidMount() {
    CategoryBlogService.getCategory().then((res) => {
      this.setState({ categoryBlog: res.data });
    });
  }

  render() {
    return (
      <div class="sidebar-block">
        <div class="title-block">Categories</div>
        <div class="block-content">
          {this.state.categoryBlog.map((item) => (
            <div class="cateTitle hasSubCategory open level1">
              <a class="cateItem" href={() => this.changeTab(item.id)}>
                {item.categoryName}
              </a>
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default CategoryBlog;
