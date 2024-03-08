import axios from 'axios';

const ORDER_API_BASE_URL = "http://localhost:9036/order";

class OrderService {

    getAllOrder(){
        return axios.get(ORDER_API_BASE_URL);
    }
    
}

const orderService = new OrderService();
export default orderService;