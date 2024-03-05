import axios from 'axios';

const SOCIAL_API_BASE_URL = "http://localhost:8002/social";
class SocialService {

    getAllSocial(){
        return axios.get(SOCIAL_API_BASE_URL);
    }
}

const socialService = new SocialService();
export default socialService;