import axios from 'axios';

const WISHLIST_API_BASE_URL = "http://localhost:8005/wishlist";
class WishlistService {

    addWishlist(wishlistOrder){
        return axios.post(WISHLIST_API_BASE_URL + "/add", wishlistOrder , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        });
    }

    deleteWishlistOrderWhenAddtocart(wishlistOrder){
        return axios.post(WISHLIST_API_BASE_URL + "/delete-wishlist", wishlistOrder , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        });
    }

    deleteWishlistOrder(wishlistOrder){
        return axios.post(WISHLIST_API_BASE_URL + "/delete", wishlistOrder , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        });
    }

    subtractWishlist(wishlistOrder){
        return axios.patch(WISHLIST_API_BASE_URL + "/subtract", wishlistOrder , {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        });
    }

    getAllWishlistByEmail(email) {
        return axios.get(WISHLIST_API_BASE_URL +`/${email}`, {
            headers:{
                Accept: 'application/json',
                  'Content-Type': 'application/json',
                  'Authorization': "Bearer " + sessionStorage.getItem("token"),
          },
        }) 
    }
}

const wishlistService = new WishlistService();
export default wishlistService;
