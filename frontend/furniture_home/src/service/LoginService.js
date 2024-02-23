import axios from "axios";

const LOGIN_API_BASE_URL = "http://localhost:8005/user";

class LoginService {

    login(email, password) {
        return axios.post(LOGIN_API_BASE_URL + "/login",{email,password});
    }
}

const loginService = new LoginService();
export default loginService;