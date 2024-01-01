import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:8001/product";
class ProductService {

    getProduct(){
        return axios.get(PRODUCT_API_BASE_URL);
    }
    getProductByCategory(id){
        return axios.get(PRODUCT_API_BASE_URL + `/category/${id}`);
    }
    
    getProductByIdRoom(id){
        return axios.get(PRODUCT_API_BASE_URL + `/room/${id}`);
    }

    getProductByCategoryRedirect(categoryRedirect) {
        return axios.get(PRODUCT_API_BASE_URL + `/category-redirect/${categoryRedirect}`);
    }

    getProductByRoomRedirect(roomRedirect) {
        return axios.get(PRODUCT_API_BASE_URL + `/room-redirect/${roomRedirect}`);
    }
}

export default new ProductService();