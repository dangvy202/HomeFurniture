import axios from 'axios';

const COOPERATE_API_BASE_URL = "http://localhost:8007/blog/tag";
class CooperateService {

    getCooperateBlogTagId(id){
        return axios.get(COOPERATE_API_BASE_URL + `/${id}`);
    }
}

export default new CooperateService();