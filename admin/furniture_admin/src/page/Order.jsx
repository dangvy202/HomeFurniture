import React, { Component } from "react";
import orderService from "../service/OrderService";
import 'datatables.net';
import $ from "jquery";
import 'datatables.net-buttons';



class Order extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orderList: [],
    };
  }

  componentDidMount() {
    orderService.getAllOrder().then((res) => {
      this.setState({ orderList: res.data });
    });
  }

  componentDidUpdate() {
    debugger;
    $("#example1").DataTable().destroy();
    $("#example1").DataTable({
      data: this.state.orderList,
      columns: [
        {targets:[0] , title: 'Id', data: 'numberOrder' },
        {targets:[1] ,  title: 'QR Code', data: 'orderCode' },
        {targets:[2] ,  title: 'User Name', data: 'userName' },
        {targets:[3] ,  title: 'Email', data: 'email' },
        {targets:[4] ,  title: 'Phone', data: 'phone' },
        {targets:[5] ,  title: 'Status', data: 'orderStatus' },
        {targets:[6] ,  title: 'Date', data: 'updateDate' }
    ]
    });
  }

  render() {
    return (
      <div class="hold-transition sidebar-mini">
        <div class="wrapper">
          <div class="content-wrapper">
            {/* <!-- Content Header (Page header) --> */}
            <section class="content-header">
              <div class="container-fluid">
                <div class="row mb-2">
                  <div class="col-sm-6">
                    <h1>DataTables</h1>
                  </div>
                  <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                      <li class="breadcrumb-item">
                        <a href="#">Home</a>
                      </li>
                      <li class="breadcrumb-item active">DataTables</li>
                    </ol>
                  </div>
                </div>
              </div>
            </section>

            {/* <!-- Main content --> */}
            <section class="content">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-12">
                    <div class="card">
                      <div class="card-header">
                        <h3 class="card-title">Order list</h3>
                      </div>
                      {/* <!-- /.card-header --> */}
                      <div class="card-body">
                        <table
                          id="example1"
                          class="table table-bordered table-striped"
                        >
                          <thead>
                            <tr>
                              <th>Id</th>
                              <th>QR Code</th>
                              <th>User Name</th>
                              <th>Email</th>
                              <th>Phone</th>
                              <th>Status</th>
                              <th>Date</th>
                            </tr>
                          </thead>
                        </table>
                      </div>
                      {/* <!-- /.card-body --> */}
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>

          <aside class="control-sidebar control-sidebar-dark"></aside>
        </div>
      </div>
    );
  }
}

export default Order;
