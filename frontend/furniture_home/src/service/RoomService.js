import axios from 'axios';

const ROOM_API_BASE_URL = "http://localhost:8001/room";
class RoomService {

    getAllRoom(){
        return axios.get(ROOM_API_BASE_URL);
    }
}

const roomService = new RoomService();
export default roomService;