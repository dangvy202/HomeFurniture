import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:9036/user";

class UserService {

    getAllUser(){
        return axios.get(USER_API_BASE_URL);
    }

    getUserDetailByEmail(email) {
        return axios.get(USER_API_BASE_URL + `/${email}`);
    }

    saveEditUser(firstName,lastName,userName,email,password,address,birthday,role,nation,phone) {
        var formData = new FormData();
        formData.append("firstName", firstName);
        formData.append("lastName", lastName);
        formData.append("userName", userName);
        formData.append("email", email);
        formData.append("password", password);
        formData.append("address", address);
        formData.append("birthday", birthday);
        formData.append("role", role);
        formData.append("nation", nation);
        formData.append("phone", phone);
        return axios.put(USER_API_BASE_URL + '/edit/save', formData, {
          headers:{
                    Accept: 'application/json',
                      'Content-Type': 'application/json',
              }
        });
    }
    
}

const userService = new UserService();
export default userService;