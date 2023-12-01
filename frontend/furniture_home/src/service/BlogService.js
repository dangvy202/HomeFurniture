import axios from 'axios';

const BLOG_API_BASE_URL = "http://localhost:8007/blog/3";
class BlogService {

    getBlogByIdCategory(){
        return axios.get(BLOG_API_BASE_URL);// + `/${3}`);
    }
}

export default new BlogService();