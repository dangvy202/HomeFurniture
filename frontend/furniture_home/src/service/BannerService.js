import axios from 'axios';

const BANNER_API_BASE_URL = "http://localhost:8002/banner";

class BannerService {

    getBanner(){
        return axios.get(BANNER_API_BASE_URL);
    }
}

const bannerService = new BannerService();
export default bannerService;