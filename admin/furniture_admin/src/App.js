import { BrowserRouter, Routes, Route } from 'react-router-dom';
import React, { Component } from "react";
import Header from './component/header/Header';
import Dashboard from './page/Dashboard';
import Order from './page/Order';

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
            {/* NOT FOUND PAGE */}
            {/* <Route path="*" element={<NotFound />} />
            <Route path="/404" element={<NotFound />} /> */}
          </Routes>
        </BrowserRouter>
      </div>
    );
  }
}
export default App;

