import axios from 'axios';

const SHOWROOM_API_BASE_URL = "http://localhost:8002/showroom";
class ShowroomService {

    getAllShowroom(){
        return axios.get(SHOWROOM_API_BASE_URL);
    }
}

const showroomService = new ShowroomService();
export default showroomService;