import { BrowserRouter, Routes, Route } from 'react-router-dom';
import React, { Component } from "react";
import Dashboard from './page/Dashboard';
import Order from './page/Order';
import Header from './component/header/Header';
import Footer from './component/footer/Footer';
import OrderDetail from './page/OrderDetail';
import InformationOrder from './page/InformationOrder';
import User from './page/User';
import UserDetail from './page/UserDetail';
import UserEdit from './page/UserEdit';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
    };
  }
  componentDidMount() {
  }

  render() {

    return (
      <div>
        <BrowserRouter>
          <Header />
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/order" element={<Order />} />
            <Route path="/order-detail/:orderCode" element={<OrderDetail />} />
            <Route path="/information-order" element={<InformationOrder />} />
            <Route path="/user" element={<User />} />
            <Route path="/user-detail/:email" element={<UserDetail />} />
            <Route path="/user-edit/:email" element={<UserEdit />} />
            {/* NOT FOUND PAGE */}
            {/* <Route path="*" element={<NotFound />} />
            <Route path="/404" element={<NotFound />} /> */}
          </Routes>
          <Footer />
        </BrowserRouter>
      </div>
    );
  }
}
export default App;

