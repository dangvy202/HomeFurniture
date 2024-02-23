import axios from 'axios';

const CATEGORY_API_BASE_URL = "http://localhost:8007/categoryBlog";
class CategoryBlogService {

    getCategory(){
        return axios.get(CATEGORY_API_BASE_URL);
    }
}

const categoryBlogService = new CategoryBlogService();
export default categoryBlogService;