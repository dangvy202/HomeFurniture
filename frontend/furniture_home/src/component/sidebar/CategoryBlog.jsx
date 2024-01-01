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

  changeBlog(id) {
    window.location.href = "/blog/"+id;
  }

  render() {
    return (
      <div className="sidebar-block">
        <div className="title-block">Categories</div>
        <div className="block-content">
          {this.state.categoryBlog.map((item) => (
            <div className="cateTitle hasSubCategory open level1">
              <a href="#" className="cateItem" onClick={() => this.changeBlog(item.id)}>
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
