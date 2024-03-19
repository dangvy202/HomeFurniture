import axios from 'axios';

const INFORMATION_ORDER_DETAIL_API_BASE_URL = "http://localhost:9036/information-order";

class InformationOrderService {

    getAllInformationOrder() {
        return axios.get(INFORMATION_ORDER_DETAIL_API_BASE_URL);
    }
    
}

const informationOrderService = new InformationOrderService();
export default informationOrderService;