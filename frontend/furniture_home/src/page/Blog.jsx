import React, { Component } from "react";
import CategoryBlog from "../component/sidebar/CategoryBlog";
import BlogService from "../service/BlogService";

class Blog extends Component {
  constructor(props) {
    super(props);
    this.state = {
      blog: []
    }
  }

  componentDidMount() {
    BlogService.getBlogByIdCategory().then((res) => {
      this.setState({ blog: res.data });
    });
  }

  render() {
    return (
      <div id="blog-list-sidebar-left" className="blog">
        <div className="main-content">
          <div id="wrapper-site">
            <div id="content-wrapper">
              <div id="main">
                <div className="page-home">
                  {/* <!-- breadcrumb --> */}
                  <nav className="breadcrumb-bg">
                    <div className="container no-index">
                      <div className="breadcrumb">
                        <ol>
                          <li>
                            <a href="/">
                              <span>Home</span>
                            </a>
                          </li>
                          <li>
                            <span>Blog</span>
                          </li>
                        </ol>
                      </div>
                    </div>
                  </nav>
                  <div className="container">
                    <div className="content">
                      <div className="row">
                        <div className="sidebar-3 sidebar-collection col-lg-3 col-md-3 col-sm-4">
                          {/* <!-- category --> */}
                          <CategoryBlog />

                          {/* <!-- recent posts --> */}

                          {/* <!-- product tag --> */}
                          <div className="sidebar-block product-tags">
                            <div className="title-block">Blog Tags</div>
                            <div className="block-content">
                              <ul className="listSidebarBlog list-unstyled">
                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Hot Trend"
                                  >
                                    Hot Trend
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Jewelry"
                                  >
                                    Jewelry
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="man.html"
                                    title="Show products matching tag Man"
                                  >
                                    Man
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Party"
                                  >
                                    Party
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag SamSung"
                                  >
                                    SamSung
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Shirt Dresses"
                                  >
                                    Shirt Dresses
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Shoes"
                                  >
                                    Shoes
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Summer"
                                  >
                                    Summer
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Sweaters"
                                  >
                                    Sweaters
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Winter"
                                  >
                                    Winter
                                  </a>
                                </li>

                                <li>
                                  <a
                                    href="#"
                                    title="Show products matching tag Woman"
                                  >
                                    Woman
                                  </a>
                                </li>
                              </ul>
                            </div>
                          </div>

                          {/* <!-- advertising --> */}
                          <div className="sidebar-block group-image-special">
                            <div className="effect">
                              <a href="#">
                                <img
                                  className="img-fluid"
                                  src="img/blog/advertising.jpg"
                                  alt="banner-2"
                                  title="banner-2"
                                />
                              </a>
                            </div>
                          </div>
                        </div>
                        <div className="col-sm-8 col-lg-9 col-md-9 flex-xs-first main-blogs">
                          <h2>Recent Posts</h2>
                          {this.state.blog.map((item) => (
                            <div className="list-content row">
                              <div className="hover-after col-md-5 col-xs-12">
                                <a href="blog-detail.html">
                                  <img src="img/blog/4.jpg" alt="img" />
                                </a>
                              </div>
                              <div className="late-item col-md-7 col-xs-12">
                                <p className="content-title">
                                  <a href="blog-detail.html">
                                    {item.blogTitle}
                                  </a>
                                </p>
                                <p className="post-info">
                                  <span>{item.updateDate}</span>
                                  <span>113 Comments</span>
                                  {/* <span>TIVATHEME</span> */}
                                </p>
                                <p className="description">
                                  {item.shortContent}...
                                </p>
                                <span className="view-more">
                                  <a href="blog-detail.html">view more</a>
                                </span>
                              </div>
                            </div>
                          ))}
                          <div className="page-list col">
                            <ul className="justify-content-center d-flex">
                              <li>
                                <a
                                  rel="prev"
                                  href="#"
                                  className="previous disabled js-search-link"
                                >
                                  Previous
                                </a>
                              </li>
                              <li className="current active">
                                <a
                                  rel="nofollow"
                                  href="#"
                                  className="disabled js-search-link"
                                >
                                  1
                                </a>
                              </li>
                              <li>
                                <a
                                  rel="nofollow"
                                  href="#"
                                  className="disabled js-search-link"
                                >
                                  2
                                </a>
                              </li>
                              <li>
                                <a
                                  rel="next"
                                  href="#"
                                  className="next disabled js-search-link"
                                >
                                  Next
                                </a>
                              </li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>
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

export default Blog;
