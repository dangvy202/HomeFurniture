import axios from 'axios';

const TAGBLOG_API_BASE_URL = "http://localhost:8005/wishlist";
class WishlistService {

    addWishlist(wishlistOrder){
        return axios.post(TAGBLOG_API_BASE_URL + "/add", wishlistOrder , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        });
    }
}

export default new WishlistService();
