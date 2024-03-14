import React, { Component } from "react";
import orderService from "../service/OrderService";
import $ from "jquery";
import MUIDataTable from "mui-datatables";



class Order extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orderList: [],
      notification: "",
      // id : "";
      // qrCode  : "";.orderCode;
      // userName  : "";.userName;
      // email  : "";.email;
      // phone  : "";.phone;
      // status  : "";.orderStatus;
      // date = this.state.orderList[i].updateDate.split("T")[0];

    };
    this.detail = this.detail.bind(this);
    this.edit = this.edit.bind(this);
    this.trash = this.trash.bind(this);
  }

  componentDidMount() {
    orderService.getAllOrder().then((res) => {
      this.setState({ orderList: res.data });
    });

  }

  detail(order) {
    alert("order = " + order)
  }

  edit(order) {
    alert("edit")
  }

  trash(order) {
    debugger;
    var z = this.state.orderList[order].numberOrder;
    alert("oke = " + z);
    // orderService.deleteOrder(order.orderCode).then((res) => {
    //   this.setState({ notification : res.data })
    // })
  }

  render() {
    const columns = ['Id', 'QR Code', 'User Name', 'Email', 'Phone', 'Status', 'Date', 'Action'];
    const orderListSet = new Array();
    for (var i = 0; i < this.state.orderList.length; i++) {
      var stt = i;
      var id = this.state.orderList[i].numberOrder;
      var qrCode = this.state.orderList[i].orderCode;
      var userName = this.state.orderList[i].userName;
      var email = this.state.orderList[i].email;
      var phone = this.state.orderList[i].phone;
      var status = this.state.orderList[i].orderStatus;
      var date = this.state.orderList[i].updateDate.split("T")[0];


      const data = {
        'Id': id,
        'QR Code': qrCode,
        'User Name': userName,
        'Email': email,
        'Phone': phone,
        'Status': status,
        'Date': date,
        'Action': (
          <>
            <button  onClick={(e) => {e.preventDefault() ;this.detail(this.state.orderList[i].orderCode)}} className="btn btn-app bg-success">
              <i className="fas fa-barcode"></i> Detail
            </button>
            <a onClick={() => this.edit(this.state.orderList[i])} className="btn btn-app bg-warning">
              <i className="fas fa-edit"></i> Edit
            </a>
            <button onClick={() => this.trash(stt)} className="btn btn-app bg-danger">
              <i className="fas fa-trash"></i> Delete
            </button>
          </>
        )
      }
      orderListSet.push(data);
    }
    const options = {
      filter: true,
      selectableRows: 'none',
      filterType: 'dropdown',
      responsive: 'vertical',
    };

    return (
      <div className="hold-transition sidebar-mini">
        <div className="wrapper">
          <div className="content-wrapper">
            {/* <!-- Content Header (Page header) --> */}
            <section className="content-header">
              <div className="container-fluid">
                <div className="row mb-2">
                  <div className="col-sm-6">
                    <h1>DataTables</h1>
                  </div>
                  <div className="col-sm-6">
                    <ol className="breadcrumb float-sm-right">
                      <li className="breadcrumb-item">
                        <a href="/">Home</a>
                      </li>
                      <li className="breadcrumb-item active">Order</li>
                    </ol>
                  </div>
                </div>
              </div>
            </section>

            {/* <!-- Main content --> */}
            <section className="content">
              <div className="container-fluid">
                <div className="row">
                  <div className="col-12">
                    <div className="card">
                      {/* <!-- /.card-header --> */}
                      <div className="card-body">
                        <MUIDataTable
                          title={"Order List"}
                          data={orderListSet}
                          columns={columns}
                          option={options}
                        />
                      </div>
                      {/* <!-- /.card-body --> */}
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>

          <aside className="control-sidebar control-sidebar-dark"></aside>
        </div>
      </div>
    );
  }
}

export default Order;
