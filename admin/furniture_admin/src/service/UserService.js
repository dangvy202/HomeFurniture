import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:9036/user";

class UserService {

    getAllUser(){
        return axios.get(USER_API_BASE_URL);
    }

    getUserDetailByEmail(email) {
        return axios.get(USER_API_BASE_URL + `/${email}`);
    }
    
}

const userService = new UserService();
export default userService;