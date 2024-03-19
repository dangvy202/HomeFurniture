import { BrowserRouter, Routes, Route } from 'react-router-dom';
import React, { Component } from "react";
import Dashboard from './page/Dashboard';
import Order from './page/Order';
import Header from './component/header/Header';
import Footer from './component/footer/Footer';
import OrderDetail from './page/OrderDetail';
import InformationOrder from './page/InformationOrder';

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

