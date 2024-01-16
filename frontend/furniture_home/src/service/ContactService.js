import axios from 'axios';

const CONTACT_API_BASE_URL = "http://localhost:9003/contact";
class ContactService {

    getInformationContactAdmin(){
        return axios.get(CONTACT_API_BASE_URL + `/information/admin`);
    }
}

export default new ContactService();