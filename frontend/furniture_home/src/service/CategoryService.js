import axios from 'axios';

const CATEGORY_API_BASE_URL = "http://localhost:8001/category";
class CategoryService {

    getCategory(){
        return axios.get(CATEGORY_API_BASE_URL);
    }
}

export default new CategoryService();