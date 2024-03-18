import axios from 'axios';

const ORDER_DETAIL_API_BASE_URL = "http://localhost:9036/order-detail";

class OrderDetailService {

    getOrderDetailByOrderCode(orderCode){
        return axios.get(ORDER_DETAIL_API_BASE_URL + `/${orderCode}`);
    }
    
}

const orderDetailService = new OrderDetailService();
export default orderDetailService;