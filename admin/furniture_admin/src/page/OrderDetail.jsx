import { React, Component } from "react";
import orderDetailService from "../service/OrderDetailService";
import MUIDataTable from "mui-datatables";

class OrderDetail extends Component {
    constructor(props) {
        super(props);
        const pathName = window.location.pathname;
        var arrPath = pathName.split("/");
        var orderCodeParameter = arrPath[arrPath.length - 1];
        this.state = {
            orderCode: orderCodeParameter,
            orderDetail: []
        }
    }

    componentDidMount() {
        orderDetailService.getOrderDetailByOrderCode(this.state.orderCode).then((res) => {
            this.setState({ orderDetail: res.data.orderDetails })
        })
    }

    render() {
        const columns = ['QR Code', 'Picture', 'Product Name', 'Product Price', 'Quantity', 'Total'];
        const orderDetailListSet = new Array();
        this.state.orderDetail.map((orderDetail) => {
            // var id = order.numberOrder;
            debugger;
            var qrCode = orderDetail.orderId;
            var picture = orderDetail.product.picture.picture;
            var productName = orderDetail.product.productName;
            var productPrice = orderDetail.product.productPrice - orderDetail.product.productSaleoff;
            var quantity = orderDetail.product.orderQuantity;
            var total = Intl.NumberFormat("vi-VN", {
                style: "currency",
                currency: "VND",
            }).format(orderDetail.totalPrice);


            const data = {
                // 'Id': id,
                'QR Code': qrCode,
                'Picture': picture,
                'Product Name': productName,
                'Product Price': productPrice,
                'Quantity': quantity,
                'Total': total,
            }
            orderDetailListSet.push(data);
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
                                            <li className="breadcrumb-item">
                                                <a href="/order">Order</a>
                                            </li>
                                            <li className="breadcrumb-item active">Order Detail</li>
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
                                                    title={"Order Detail"}
                                                    data={orderDetailListSet}
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
        )
    }
}

export default OrderDetail;