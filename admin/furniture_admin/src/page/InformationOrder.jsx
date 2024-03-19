import React, { Component } from "react";
import MUIDataTable from "mui-datatables";
import informationOrderService from "../service/InformationOrderService";



class InformationOrder extends Component {
  constructor(props) {
    super(props);
    this.state = {
      informationOrderList: [],
      notification: "",
    };
  }

  componentDidMount() {
    informationOrderService.getAllInformationOrder().then((res) => {
      this.setState({ informationOrderList: res.data.resultData });
    });
  }

  render() {
    const columns = ['Id', 'QR Code', 'User Name' , 'Email', 'Phone', 'Status', 'Date'];
    const informationOrderListSet = new Array();
    var id = 0;
    this.state.informationOrderList.map((informationOrder) => {
        id = id + 1
      var qrCode = informationOrder.order.orderCode;
      var email = informationOrder.email;
      var userName = informationOrder.userName;
      var phone = informationOrder.phone;
      var status = informationOrder.order.orderStatus
      var date = informationOrder.order.updateDate.split("T")[0];


      const data = {
        'Id': id,
        'QR Code': qrCode,
        'User Name': userName,
        'Email': email,
        'Phone': phone,
        'Status': status,
        'Date': date,
      }
      informationOrderListSet.push(data);
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
                      <li className="breadcrumb-item active">Information Order</li>
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
                          title={"Information Order List"}
                          data={informationOrderListSet}
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

export default InformationOrder;
