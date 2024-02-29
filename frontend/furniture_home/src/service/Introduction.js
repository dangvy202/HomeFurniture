import axios from 'axios';

const INTRODUCTION_API_BASE_URL = "http://localhost:8002/introduction";
class IntroductionService {

    getIntroduction(){
        return axios.get(INTRODUCTION_API_BASE_URL);
    }

}

const introductionService = new IntroductionService();
export default introductionService;