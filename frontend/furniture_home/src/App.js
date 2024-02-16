import Footer from './component/footer/Footer';
import Navbar from './component/navbar/Navbar';
import Category from './component/categories/Category';
import Home from './page/Home';
import Login from './page/Login';
import Infomation from './page/Infomation';
import { BrowserRouter,Routes,Route  } from 'react-router-dom';
import Register from './page/Register';
import Blog from './page/Blog';
import EditAccount from './page/EditAccount';
import ProductAll from './page/ProductAll';
import NotFound from './page/NotFound';
import React, { Component } from "react";
import Contact from './page/Contact';
import BlogDetail from './page/BlogDetail';
import Cart from './page/Cart';
import InformationOrder from './page/InformationOrder';
import OrderHistory from './page/OrderHistory';
import OrderDetail from './page/OrderDetail';
import ProductDetail from './page/ProductDetail';


class App extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      dateNow: new Date().getTime(),
    };
  }
  componentDidMount() {
    if (sessionStorage.getItem("expired") < this.state.dateNow) {
      console.log("het time");
      sessionStorage.removeItem("status");
      sessionStorage.removeItem("message");
      sessionStorage.removeItem("token");
      sessionStorage.removeItem("expired");
      sessionStorage.removeItem("email");
    }
    console.log("cart" + sessionStorage.getItem("cart"));
  }

  render() {

    return (
      <div>
        <BrowserRouter>
          <Navbar />
          <Category />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path='/infomation' element={<Infomation />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/blog/:idCategory" element={<Blog />} />
            <Route path="/blog-tag/:idTag" element={<Blog />} />
            <Route path="/editAccount" element={<EditAccount />} />
            <Route path="/product/:category" element={<ProductAll />} />
            <Route path="/product/:room" element={<ProductAll />} />
            <Route path="/contact" element={<Contact/>} />
            <Route path="/blog-detail/:idBlog" element={<BlogDetail />} />
            <Route path="/cart" element={<Cart/>} />
            <Route path="/information-order/:orderCode" element={<InformationOrder />} />
            <Route path="/order-history" element={<OrderHistory />} />
            <Route path="/order-detail/:orderCode" element={<OrderDetail />} />
            <Route path="/product-detail/:idProduct" element={<ProductDetail/>} />
            
            {/* NOT FOUND PAGE */}
            <Route path="*" element={<NotFound />} />
            <Route path="/404" element={<NotFound />} />
          </Routes>
          <Footer />
        </BrowserRouter>
      </div>
    );
  }
}
export default App;

// class App extends Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       dateNow: new Date().getTime(),
//     };
//   }
//   componentDidMount() {
//     if (sessionStorage.getItem("expired") < this.state.dateNow) {
//         console.log("het time");
//         sessionStorage.removeItem("status");
//         sessionStorage.removeItem("message");
//         sessionStorage.removeItem("token");
//         sessionStorage.removeItem("expired");
//         sessionStorage.removeItem("email");
//     }
//   }
//   render() {

//     return (
//       <div>
//         <BrowserRouter>
//           <Navbar />
//           <Category />
//             <Routes>
//               <Route path="/" element={<Home />} />
//               <Route path="/home" element={<Home />} />
//               <Route path='/infomation' element={<Infomation />} />
//               <Route path="/login" element={<Login />} />
//               <Route path="/register" element={<Register />} />
//               <Route path="/blog/3" element={<Blog />} />
//               <Route path="/editAccount" element={<EditAccount />} />
//               <Route path="/product/:category" element={<ProductAll />} />
//               <Route path="/product/:room" element={<ProductAll />} />
            


//               <Route path="*" element={<NotFound />} />
            
//               <Route path="/404" element={<NotFound />} />
      
//             </Routes>
//           <Footer />
//         </BrowserRouter>
//       </div>
//     );
//   }
// }

