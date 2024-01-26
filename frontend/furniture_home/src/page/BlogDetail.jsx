import React, { Component } from "react";
import CategoryBlog from "../component/sidebar/CategoryBlog";
import TagBlog from "../component/tagblog/TagBlog";
import BlogService from "../service/BlogService";

class BlogDetail extends Component {
    constructor(props) {
        super(props);
        this.state = {
            blogTitle:"",
            content:"",
            shortContent:"",
            blogAvatar:"",
            updateBy:"",
            updateDate:"",
            comment:[]
        };
    }

    componentDidMount() {
        const pathName = window.location.pathname;
        var arrPath = pathName.split("/");
        var idBlog = arrPath[arrPath.length-1];
        BlogService.getBlogDetailById(idBlog).then((res) => {
            this.setState({blogTitle: res.data.blogTitle})
            this.setState({content: res.data.content})
            this.setState({shortContent: res.data.shortContent})
            this.setState({blogAvatar: res.data.blogAvatar})
            this.setState({updateBy: res.data.updateBy})
            this.setState({updateDate: res.data.updateDate})
            this.setState({comment: res.data.commentBlog.comment})
            debugger;
        }).catch((error) => {
            window.location.href="/404"
        })
        
    }

    render() {
        return (
            <div id="blog-detail" className="blog">
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

                                                <div class="col-sm-8 col-lg-9 col-md-9 flex-xs-first main-blogs">
                                                    <h3>Rutrum Nonvopxe Sapiente Delectus Aut Bonbde</h3>
                                                    <div class="hover-after">
                                                        <img src={require("../component/asset/blog/detail.jpg")} alt="img" class="img-fluid" />
                                                    </div>
                                                    <div class="late-item">
                                                    {/* <img class="img-fluid" src={require("../../public/image/img/blog/1.jpg")} alt="banner-1" title="banner-1" /> */}

                                                        <div dangerouslySetInnerHTML={{ __html: this.state.content }}></div>

                                                        <div class="border-detail">
                                                            <p class="post-info float-left">
                                                                <span>3 minitunes ago</span>
                                                                <span>113 Comments</span>
                                                                <span>TIVATHEME</span>
                                                            </p>
                                                            <div class="btn-group">
                                                                <a href="#">
                                                                    <i class="zmdi zmdi-share"></i>
                                                                    <span>Share</span>
                                                                </a>
                                                                <a href="#" class="email">
                                                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                                                    <span>SEN TO A FRIEND</span>
                                                                </a>
                                                                <a href="#" class="print">
                                                                    <i class="zmdi zmdi-print"></i>
                                                                    <span>Print</span>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="admin">

                                                        <img src="img/blog/user.jpg" alt="img" class="float-left right" />
                                                        <div class="info">
                                                            <p>
                                                                <a href="#">
                                                                    <span class="content-title">
                                                                        John doe
                                                                    </span>
                                                                </a>
                                                                <span>Administrator, Web Designer</span>
                                                            </p>
                                                            <p class="descript">
                                                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, do eiusmod tempor incididunt. ut labore et dolore magna aliqua.
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <div class="reply late-item">
                                                        <div class="blog-comment" id="blog-comment">
                                                            <h2 class="title-block">Comments</h2>
                                                        </div>

                                                        {this.state.comment.map(
                                                            (item) => (
                                                            <>

                                                                <div class="blog-comment">
                                                                    <div class="avatar">
                                                                        <img style={{borderRadius:"100%", height:"100px", width:"100px"}} src={require("../component/asset/infomation/"+item.user.picture)}
                                                                         alt="img" class="float-left right" />
                                                                    </div>
                                                                    <div class="comment-content">
                                                                        <p class="user-title">
                                                                            <a href="#">{item.user.userName}</a>
                                                                            <span class="time">Posted on {item.updateDate}</span>
                                                                        </p>
                                                                        <p class="content-comment"> {item.content} </p>
                                                                    </div>
                                                                </div> <br/>

                                                        
                                                                {/* <img style={{borderRadius:"100%"}}
                                                                src={require("../component/asset/blog/user1.jpg")} alt="img" class="float-left right" />
                                                                <div class="comment-content">
                                                                    <p class="user-title">
                                                                        <a href="#">{item.content}</a>
                                                                        <span class="time">Posted on Mar 17, 2017 at 6:57am 
                                                                        </span>
                                                                    </p>
                                                                    <p class="content-comment">{item.content}</p>
                                                                </div> */}
                                                            </>
                                                            )
                                                        )}

                                                        

                                                        
                                                    </div>
                                                    <div class="submit-comment" id="respond">
                                                        <h2 class="title-block">Submit comment</h2>
                                                        <div id="commentInput">
                                                            <form action="#" method="post" id="commentform">
                                                                <input type="hidden" name="comment_parent" id="comment_parent" value="0" />
                                                                <div class="row">
                                                                    <div class="form-group col col-sm-12 col-md-4 ">
                                                                        <input type="text" class="inputName form-control" name="name" placeholder="Your Name *" />
                                                                    </div>
                                                                    <div class="form-group col col-sm-12  col-md-4">
                                                                        <input type="text" class="inputMail form-control" name="mail" placeholder="Your E-mail *" />
                                                                    </div>
                                                                    <div class="form-group col col-sm-12  col-md-4">
                                                                        <input type="text" class="form-control" name="website" placeholder="Your Website" />
                                                                    </div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="form-group col col-md-12">
                                                                        <textarea tabindex="4" class="inputContent form-control grey" rows="10" name="comment" placeholder="Your Message"></textarea>
                                                                    </div>
                                                                </div>
                                                                <div class="submit">
                                                                    <input type="submit" name="addComment" id="submitComment" class="btn btn-default" value="Send Message" />
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
