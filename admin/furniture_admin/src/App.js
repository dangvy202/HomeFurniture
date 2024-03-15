import { BrowserRouter, Routes, Route } from 'react-router-dom';
import React, { Component } from "react";
import Dashboard from './page/Dashboard';
import Order from './page/Order';
import Header from './component/header/Header';
import Navbar from './component/navbar/Navbar';
import Footer from './component/footer/Footer';

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
          {/* <Navbar /> */}
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/order" element={<Order />} />
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

