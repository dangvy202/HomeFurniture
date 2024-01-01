import axios from 'axios';

const BLOG_API_BASE_URL = "http://localhost:8007/blog";

class BlogService {

    getBlogByIdCategory(id){
        return axios.get(BLOG_API_BASE_URL + `/${id}`);
    }
}

export default new BlogService();