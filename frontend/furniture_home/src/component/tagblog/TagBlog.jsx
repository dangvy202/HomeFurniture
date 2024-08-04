import React from "react";
import { Component } from "react";
import TagBlogService from "../../service/TagBlogService";

class TagBlog extends Component {
    constructor(props) {
        super(props);
        this.state = {
            tagBlog: [],
        };
    }


    componentDidMount() {
        TagBlogService.getTagBlog().then((res) => {
            this.setState({ tagBlog: res.data });
        });
    }

    changeCooperate(id) {
        window.location.href = "/blog-tag/"+id;
    }

    render() {
        return (
            <div className="sidebar-block product-tags">
                <div className="title-block">Blog Tags</div>
                <div className="block-content">
                    <ul className="listSidebarBlog list-unstyled">
                    {this.state.tagBlog.map((item) => (
                        <li key={item.id}>
                            <a
                                href="#"
                                title="Show products matching tag Hot Trend"
                                onClick={() => this.changeCooperate(item.id)}
                            >
                                {item.tagName}
                            </a>
                        </li> 
                    ))}               
                    </ul>
                </div>
            </div>
        );
    }
}

export default TagBlog;
