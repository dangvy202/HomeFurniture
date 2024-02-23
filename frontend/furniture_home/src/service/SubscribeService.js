import axios from 'axios';

const SUBSCRIBE_API_BASE_URL = "http://localhost:9003/client-subscribe";
class SubscribeService {

    subscribeEmail(email){
        return axios.post(SUBSCRIBE_API_BASE_URL,{email});
    }
}

const subscribeService = new SubscribeService();
export default subscribeService;
