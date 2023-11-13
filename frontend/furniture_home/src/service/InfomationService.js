import axios from "axios";

const INFOMATION_API_BASE_URL = "http://localhost:8005/user";

class InfomationService {

    async infomation(email) {
         return await axios.get(INFOMATION_API_BASE_URL + `/infomation/${email}`, {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        }) 
  }
   register(firstName, lastName, userName, email, password, address, birthday, nation, phone, picture) {
    var formData = new FormData();
    formData.append("firstName", firstName);
    formData.append("lastName", lastName);
    formData.append("userName", userName);
    formData.append("email", email);
    formData.append("password", password);
    formData.append("address", address);
    formData.append("birthday", birthday);
    formData.append("nation", nation);
    formData.append("phone", phone);
    return axios.post(INFOMATION_API_BASE_URL + '/register', formData, {
      headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
          }
    });
  }
}
export default new InfomationService();