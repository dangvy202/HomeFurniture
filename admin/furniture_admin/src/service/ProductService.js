import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:9036/order";

class ProductService {

    getAllOrder(){
        return axios.get(PRODUCT_API_BASE_URL);
    }
    
}

const orderService = new OrderService();
export default orderService;