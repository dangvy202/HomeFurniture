import axios from 'axios';

const TAGBLOG_API_BASE_URL = "http://localhost:8007/tagblog";
class TagBlogService {

    getTagBlog(){
        return axios.get(TAGBLOG_API_BASE_URL);
    }
}

const tagBlogService = new TagBlogService();
export default tagBlogService;
