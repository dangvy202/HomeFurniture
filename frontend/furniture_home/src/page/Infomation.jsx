import React, { Component } from "react";
import InfomationService from "../service/InfomationService";
import moment from "moment";
import OrderService from "../service/OrderService";

class Infomation extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: "",
      email: "",
      address: "",
      birthday: "",
      nation: "",
      phone: "",
      picture: "",
      orderHistory:[]
    };
  }

  componentDidMount() {
    if (sessionStorage.getItem("email") != null) {
      InfomationService.infomation(sessionStorage.getItem("email")).then(
        (res) => {
          let birthdayConvert = moment
            .utc(res.data.user.birthday)
            .format("DD/MM/YYYY");
          this.setState({ fullName: res.data.user.username });
          this.setState({ email: res.data.user.email });
          this.setState({ address: res.data.user.address });
          this.setState({ birthday: birthdayConvert });
          this.setState({ nation: res.data.user.nation });
          this.setState({ phone: res.data.user.phone });
          this.setState({
            picture: require("../component/asset/infomation/" +
              res.data.user.picture),
          });
        }
      );
      OrderService.getOrderHistory(sessionStorage.getItem("email"))
        .then((res) => {
          this.setState({ orderHistory: res.data });
        })
        .catch((error) => {});
    } else {
      window.location.href = "/login";
    }
  }
  render() {
    return (
      <body className="user-acount">
        <div className="main-content">
          <div className="wrap-banner">
            {/* <!-- breadcrumb --> */}
            <nav className="breadcrumb-bg">
              <div className="container no-index">
                <div className="breadcrumb">
                  <ol>
                    <li>
                      <a href="/">
                        <span>Home</span>
                      </a>
                    </li>
                    <li>
                      <span>My Account</span>
                    </li>
                  </ol>
                </div>
              </div>
            </nav>

            <div className="acount head-acount">
              <div className="container">
                <div id="main">
                  <h1 className="title-page">My Account</h1>
                  <div className="content" id="block-history">
                    <table className="std table">
                      <tbody>
                        <tr>
                          <th className="first_item">Picture :</th>
                          <td>
                            <img
                              src={this.state.picture}
                              alt="img"
                              width={"100px"}
                              height={"100px"}
                            />
                          </td>
                        </tr>
                        <tr>
                          <th className="first_item">My Name :</th>
                          <td>{this.state.fullName}</td>
                        </tr>
                        <tr>
                          <th className="first_item">Address :</th>
                          <td>{this.state.address}</td>
                        </tr>
                        <tr>
                          <th className="first_item">Nation :</th>
                          <td>{this.state.nation}</td>
                        </tr>
                        <tr>
                          <th className="first_item">Phone :</th>
                          <td>0{this.state.address}</td>
                        </tr>
                        <tr>
                          <th className="first_item">Birthday:</th>
                          <td>{this.state.birthday}</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <a href="/editAccount" className="btn btn-primary">
                    CHANGE INFOMATION
                  </a>
                  <div className="order">
                    <h4>
                      Order
                      <span className="detail">History</span>
                    </h4>

                    {this.state.orderHistory.length === 0 ? (
                      <p>You haven't placed any orders yet.</p>
                    ) : (
                      <ul>
                        {this.state.orderHistory.map((order) => (
                          <li key={order.id}>
                            Order ID: {order.orderCode} - Date: {moment(order.updateDate).format("DD/MM/YYYY")}
                          </li>
                        ))}
                      </ul>
                    )}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </body>
    );
  }
}
export default Infomation;
