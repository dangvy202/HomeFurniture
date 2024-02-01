import axios from 'axios';

const COMMENT_API_BASE_URL = "http://localhost:8007/comment";
class CommentService {

    commentBlog(token , email , content, idBlog){
        const request = {
                            "token": token,
                            "email" : email,
                            "content": content,
                            "idBlog" : idBlog
                        }
        return axios.post(COMMENT_API_BASE_URL, request ,{
            headers:{
                       'Content-Type': 'application/json',
               }
         });
    }
}

export default new CommentService();