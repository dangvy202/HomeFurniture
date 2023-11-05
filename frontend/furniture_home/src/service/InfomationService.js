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
  register() {
    axios.post(INFOMATION_API_BASE_URL + 'register');
  }
}
export default new InfomationService();