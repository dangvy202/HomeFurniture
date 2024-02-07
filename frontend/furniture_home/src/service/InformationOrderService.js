import axios from 'axios';

const INFORMATION_ORDER_API_BASE_URL = "http://localhost:8005/information-order";
class InformationOrderService {

    addInformationOrder(username,email,phone,address,orderCode){
        const request = {
            username : username,
            email : email,
            phone : phone,
            address : address,
            orderCode : orderCode
        }
        return axios.post(INFORMATION_ORDER_API_BASE_URL + `/add` , request , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          }
        });
    }
}

export default new InformationOrderService();