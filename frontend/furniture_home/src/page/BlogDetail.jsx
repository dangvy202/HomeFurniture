import React, { Component } from "react";
import CategoryBlog from "../component/sidebar/CategoryBlog";
import TagBlog from "../component/tagblog/TagBlog";
import BlogService from "../service/BlogService";
import moment from "moment";
import CommentService from "../service/CommentService";

class BlogDetail extends Component {
    constructor(props) {
        super(props);
        const pathName = window.location.pathname;
        var arrPath = pathName.split("/");
        var idBlog = arrPath[arrPath.length - 1];
        this.state = {
            blogTitle: "",
            content: "",
            shortContent: "",
            blogAvatar: "",
            updateBy: "",
            updateDate: "",
            comment: [],
            message: "",
            notification: "",
            blogId: idBlog
        };
        this.addComment = this.addComment.bind(this);
        this.onChangeMessage = this.onChangeMessage.bind(this);
    }

    componentDidMount() {
        BlogService.getBlogDetailById(this.state.blogId).then((res) => {
            this.setState({ blogTitle: res.data.blogTitle })
            this.setState({ content: res.data.content })
            this.setState({ shortContent: res.data.shortContent })
            this.setState({ blogAvatar: require("../component/asset/blog/" + res.data.blogAvatar) })
            this.setState({ updateBy: res.data.updateBy })
            this.setState({ updateDate: res.data.updateDate })
            this.setState({ comment: res.data.commentBlog.comment })
        }).catch((error) => {
            window.location.href = "/404"
        })
    }

    addComment(e) {
        e.preventDefault();
        if (
            sessionStorage.getItem("status") != null &&
            sessionStorage.getItem("message") != null &&
            sessionStorage.getItem("token") != null &&
            sessionStorage.getItem("expired") != null &&
            sessionStorage.getItem("email") != null &&
            this.state.message != null
        ) {
            CommentService.commentBlog(sessionStorage.getItem("token"), sessionStorage.getItem("email"), this.state.message, this.state.blogId).then((res) => {
                this.setState({ notification: res.data.message })
            }).catch((error) => {
                this.setState({ notification: error.response.data.message })
            })
        } else {
            this.setState({ notification: "Please login first and fill comment before submit" })
        }

    }

    onChangeMessage(e) {
        this.setState({ message: e.target.value });
    }

    loadPage() {
        window.location.reload();
    }

    render() {
        return (
            <div id="blog-detail" className="blog">
                <div className="main-content">
                    <div
                        className="modal fade"
                        id="exampleModal"
                        tabIndex="-1"
                        role="dialog"
                        aria-labelledby="exampleModalLabel"
                        aria-hidden="true"
                    >
                        <div className="modal-dialog" role="document">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLabel">
                                        {(() => {
                                            if (this.state.notification === "COMMENT_SUCCESS") {
                                                return <>Notification</>;
                                            } else {
                                                return <>Error !</>;
                                            }
                                        })()}
                                    </h5>
                                    <button
                                        type="button"
                                        className="close"
                                        data-dismiss="modal"
                                        aria-label="Close"
                                    >
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div className="modal-body">
                                    {(() => {
                                        if (this.state.notification === "COMMENT_SUCCESS") {
                                            return (
                                                <>Success, the comment added</>
                                            );
                                        } else {
                                            return <>{this.state.notification}</>;
                                        }
                                    })()}
                                </div>
                                <div className="modal-footer">
                                    <button
                                        type="button"
                                        className="btn btn-primary"
                                        data-dismiss="modal"
                                        aria-label="Close"
                                        onClick={this.loadPage}
                                    >
                                        Close
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
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
                                                    <h3>{this.state.blogTitle}</h3>
                                                    <div className="hover-after">
                                                        <img src={this.state.blogAvatar} alt="img" className="img-fluid" />
                                                    </div>
                                                    <div className="late-item">
                                                        {/* <img class="img-fluid" src={require("../../public/image/img/blog/1.jpg")} alt="banner-1" title="banner-1" /> */}

                                                        <div dangerouslySetInnerHTML={{ __html: this.state.content }}></div>

                                                        <div className="border-detail" style={{ marginTop: "30px" }}>
                                                            <p className="post-info float-left">
                                                                <span>{this.state.comment.length} Comments</span>
                                                            </p>
                                                            <div className="btn-group">
                                                                <a href="#">
                                                                    <i className="zmdi zmdi-share"></i>
                                                                    <span>Share</span>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div className="reply late-item">
                                                        <div className="blog-comment" id="blog-comment">
                                                            <h2 className="title-block">Comments</h2>
                                                        </div>

                                                        {this.state.comment.map(
                                                            (item) => (
                                                                <>
                                                                    <div className="blog-comment">
                                                                        <div className="avatar">
                                                                            <img width={"75px"} height={"75px"} style={{ borderRadius: "100%" }} src={require("../component/asset/infomation/" + item.user.picture)} alt="img" className="float-left right" />
                                                                        </div>
                                                                        <div className="comment-content">
                                                                            <p className="user-title">
                                                                                <a href="#">{item.user.userName}</a>
                                                                                <span className="time">Posted on {
                                                                                    moment
                                                                                        .utc(item.updateDate)
                                                                                        .format("DD/MM/YYYY")
                                                                                }
                                                                                </span>
                                                                            </p>
                                                                            <p className="content-comment">{item.content}</p>
                                                                        </div>
                                                                    </div><br />
                                                                </>
                                                            )
                                                        )}
                                                    </div>

                                                    <div className="submit-comment" id="respond">
                                                        <h2 className="title-block">Submit comment</h2>
                                                        <div id="commentInput">
                                                            <form id="commentform" onSubmit={(e) => this.addComment(e)}>
                                                                <div className="row">
                                                                    <div className="form-group col col-md-12">
                                                                        <textarea tabIndex="4" className="inputContent form-control grey" onChange={this.onChangeMessage} rows="10" name="comment" placeholder="Your Message"></textarea>
                                                                    </div>
                                                                </div>
                                                                <div className="submit">
                                                                    {/* <button
                                                                        className="btn btn-default"
                                                                        id="submitComment"
                                                                        data-toggle="modal"
                                                                        data-target="#exampleModal"
                                                                        type="submit"
                                                                    >
                                                                        Send Message
                                                                    </button> */}
                                                                    <input type="submit" data-toggle="modal"
                                                                        data-target="#exampleModal" name="addComment" id="submitComment" className="btn btn-default" value="Send Message" />
                                                                </div>
                                                            </form>
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
            </div>
        );
    }
}

export default BlogDetail;
