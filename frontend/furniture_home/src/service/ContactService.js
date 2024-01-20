import axios from 'axios';

const CONTACT_API_BASE_URL = "http://localhost:9003/contact";
class ContactService {

    getInformationContactAdmin(){
        return axios.get(CONTACT_API_BASE_URL + `/information/admin`);
    }

    saveContact(process, message,title,description,name,email,phone,address) {
        const contactData = {
                                process: process,
                                message: message,
                                contactDescription: {
                                    contactDescriptionRequest: {
                                        title: title,
                                        description: description
                                    }
                                },
                                informationContactClient: {
                                    informationContactClientRequest: {
                                        name: name,
                                        email: email,
                                        phone: phone,
                                        address: address
                                    }
                                }
                            };
        return axios.post(CONTACT_API_BASE_URL , contactData ,{
         headers:{
                    'Content-Type': 'application/json',
            }
      });
      
    }
}

export default new ContactService();