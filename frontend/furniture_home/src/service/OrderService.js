import axios from 'axios';

const ORDER_API_BASE_URL = "http://localhost:8005/order";

class OrderService {

    orderProducts(orderList){
        return axios.post(ORDER_API_BASE_URL + `/add`, orderList , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        });
    }
}

export default new OrderService();