import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:8001/product";
class ProductService {

    getProduct(){
        return axios.get(PRODUCT_API_BASE_URL);
    }
    getProductByCategory(id){
        return axios.get(PRODUCT_API_BASE_URL + `/category/${id}`);
    }
    
    getProductByIdRoom(id){
        return axios.get(PRODUCT_API_BASE_URL + `/room/${id}`);
    }

    getProductByCategoryRedirect(categoryRedirect) {
        return axios.get(PRODUCT_API_BASE_URL + `/category-redirect/${categoryRedirect}`);
    }

    getProductByRoomRedirect(roomRedirect) {
        return axios.get(PRODUCT_API_BASE_URL + `/room-redirect/${roomRedirect}`);
    }

    getProductDetail(id) {
        return axios.get(PRODUCT_API_BASE_URL + `/detail/${id}`);
    }

    getProductByIdCart() {
        var listIdAddCart = JSON.parse(sessionStorage.getItem("cart"));
        if (listIdAddCart != null) {
            var arrId = new Array();
            for (var i = 0; i < listIdAddCart.length; i++){
                arrId.push(listIdAddCart[i].id)
            }
            return axios.post(PRODUCT_API_BASE_URL + `/cart`, arrId,{
                headers:{
                            'Content-Type': 'application/json',
                    }
            });
        }
    }
}

const productService = new ProductService();
export default productService;