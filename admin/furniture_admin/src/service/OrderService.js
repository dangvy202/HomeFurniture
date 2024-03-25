import axios from 'axios';

const ORDER_API_BASE_URL = "http://localhost:9036/order";

class OrderService {

    getAllOrder(){
        return axios.get(ORDER_API_BASE_URL);
    }

    deleteOrder(orderCode) {
        return axios.delete(ORDER_API_BASE_URL + '/delete/' + `${orderCode}`);
    }

    updateOrderStatus(order) {
        return axios.post(ORDER_API_BASE_URL + "/update/status" , order ,{
            headers:{
                       'Content-Type': 'application/json',
               }
         });
    }
    
}

const orderService = new OrderService();
export default orderService;