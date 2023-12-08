import React, { Component } from "react";
import CategoryBlog from "../component/sidebar/CategoryBlog";
import TagBlog from "../component/tagblog/TagBlog";
import BlogService from "../service/BlogService";
import CooperateBlogTagService from "../service/CooperateBlogTagService";
import Pagination from "../service/Pagination"

class Blog extends Component {
  constructor(props) {
    super(props);
    const pathName = window.location.pathname;
    var arrPath = pathName.split("/");
    var id = arrPath[arrPath.length - 1];
    var domain = arrPath[1];
    this.state = {
      id: id,
      domail: domain,
      blog: [],
      currentPage: null,
      totalPages: null
    }
  }

  onPageChanged = data => {
    const { blog } = this.state;
    const { currentPage, totalPages, pageLimit } = data;

    const offset = (currentPage - 1) * pageLimit;
    const currentCountries = blog.slice(offset, offset + pageLimit);

    this.setState({ currentPage, currentCountries, totalPages });
  };

  componentDidMount() {
    if(this.state.domail === "blog-tag"){
      CooperateBlogTagService.getCooperateBlogTagId(this.state.id).then((res) => {
        this.setState({ blog: res.data.blog.blogResponse });
      });
    }else{
      BlogService.getBlogByIdCategory(this.state.id).then((res) => {
        this.setState({ blog: res.data });
      });
    }
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

                          {/* <!-- tag blog --> */}
                          <TagBlog />

                          {/* <!-- advertising --> */}
                          <div className="sidebar-block group-image-special">
                            <div className="effect">
                              <a href="#">
                                <img
                                  className="img-fluid"
                                  src={require("../component/asset/blog/advertising.jpg")}
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
                                  <img src={require("../component/asset/blog/"+item.blogAvatar)}  alt="img" />
                                </a>
                              </div>
                              <div className="late-item col-md-7 col-xs-12">
                                <p className="content-title">
                                  <a href="blog-detail.html">
                                    {item.blogTitle}
                                  </a>
                                </p>
                                <p className="post-info">
                                  <span>{item.updateDate.split("T")[0]}</span>
                                  <span>{item.commentBlog.total} Comments</span>
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

<Pagination
                totalRecords={totalCountries}
                pageLimit={18}
                pageNeighbours={1}
                onPageChanged={this.onPageChanged}
              />
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
