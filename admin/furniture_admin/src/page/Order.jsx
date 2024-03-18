import React, { Component } from "react";
import orderService from "../service/OrderService";
import MUIDataTable from "mui-datatables";



class Order extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orderList: [],
      notification: "",
    };
    this.detail = this.detail.bind(this);
    this.changeStatus = this.changeStatus.bind(this);
    this.trash = this.trash.bind(this);
  }

  componentDidMount() {
    orderService.getAllOrder().then((res) => {
      this.setState({ orderList: res.data });
    });
  }

  detail(order) {
    window.location.href="/order-detail/" + order.orderCode;
  }

  changeStatus(order) {
    var request = {
      "order_code": order.orderCode
    }
    orderService.updateOrderStatus(request).then((res) => {
      window.location.href="/order"
    })
  }

  async trash(order) {
    orderService.deleteOrder(order.orderCode).then((res) => {
      this.setState({ notification: res.data })
    }).catch((error) => {
      this.setState({ notification: error.response.data.message })
    })
    console.log(this.state.notification)
  }

  render() {
    const columns = ['Id', 'QR Code', 'User Name', 'Email', 'Phone', 'Status', 'Date', 'Action'];
    const orderListSet = new Array();
    this.state.orderList.map((order) => {
      var id = order.numberOrder;
      var qrCode = order.orderCode;
      var userName = order.userName;
      var email = order.email;
      var phone = order.phone;
      var status = order.orderStatus
      var date = order.updateDate.split("T")[0];


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
            <button onClick={() => this.detail(order) } className="btn btn-app bg-success">
              <i className="fas fa-barcode"></i> Detail
            </button>
            <button onClick={() => this.trash(order)} className="btn btn-app bg-danger"
              data-toggle="modal"
              data-target="#exampleModal"
              >
              <i className="fas fa-trash"></i> Delete
            </button>
            <button onClick={() => this.changeStatus(order) } className="btn btn-app bg-warning">
              <i className="fas fa-barcode"></i> Change Status
            </button>
          </>
        )
      }
      orderListSet.push(data);
    })

    // }
    const options = {
      filter: true,
      selectableRows: 'none',
      filterType: 'dropdown',
      responsive: 'vertical',
    };

    return (
      <div className="hold-transition sidebar-mini">
        <div
          className="modal fade"
          id="exampleModal"
          tabIndex="-1"
          role="dialog"
          aria-labelledby="exampleModalLabel"
          aria-hidden="true"
        >
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="exampleModalLabel">
                  {this.state.notification === "ORDER_SUCCESS" ? "Notification" : "Error!"}
                </h5>
              </div>
              <div className="modal-body">
                {(() => {
                  if (this.state.notification === "ORDER_SUCCESS") {
                    return <>DELETE SUCCESS</>;
                  } else {
                    return <>DELETE FAIL , PLEASE CHECK AGAIN</>;
                  }
                })()}
              </div>
              <div className="modal-footer">
                <a href="/order" className="btn btn-primary">
                  Back
                </a>
              </div>
            </div>
          </div>
        </div>
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
