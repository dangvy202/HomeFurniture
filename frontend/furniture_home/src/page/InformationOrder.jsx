import React, { Component } from "react";
import InformationOrderService from "../service/InformationOrderService";

class InformationOrder extends Component {
    constructor(props) {
        super(props);
        const pathName = window.location.pathname;
        var arrPath = pathName.split("/");
        var orderCodeParameter = arrPath[arrPath.length - 1];
        this.state = {
            notification : "",
            username : "",
            email : "",
            phone : "",
            address : "",
            orderCode : orderCodeParameter
        };
        this.onChangeUserName = this.onChangeUserName.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.onChangePhone = this.onChangePhone.bind(this);
        this.onChangeAddress = this.onChangeAddress.bind(this);
        this.addInformationOrder = this.addInformationOrder.bind(this);
    }
    addInformationOrder(e) {
        
        InformationOrderService.addInformationOrder(this.state.username,this.state.email,this.state.phone,this.state.address,this.state.orderCode).then((res) => {

        }).catch((error) => {
            this.setState({notification: error.response.data.message })
            alert(this.state.notification)
        })
    }

    onChangeUserName(e) {
        this.setState({ username: e.target.value });
    }

    onChangeEmail(e) {
        this.setState({ email: e.target.value });
    }

    onChangePhone(e) {
        this.setState({ phone: e.target.value });
    }

    onChangeAddress(e) {
        this.setState({ address: e.target.value });
    }



    render() {
        return (
            <div class="product-checkout checkout-cart">
        {/* // < !--main content-- > */}
                <div id="checkout" class="main-content">
                    <div class="wrap-banner">
                        {/* <!-- breadcrumb --> */}
                        <nav class="breadcrumb-bg">
                            <div class="container no-index">
                                <div class="breadcrumb">
                                    <ol>
                                        <li>
                                            <a href="/">
                                                <span>Home</span>
                                            </a>
                                        </li>
                                        <li>
                                            <span>Checkout</span>
                                        </li>
                                    </ol>
                                </div>
                            </div>
                        </nav>

                        {/* <!-- main --> */}
                        <div id="wrapper-site">
                            <div class="container">
                                <div class="row">
                                    <div id="content-wrapper" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol">
                                        <div id="main">
                                            <div class="cart-grid row">
                                                <div class="col-md-9 check-info">
                                                    <div class="checkout-personal-step">
                                                        <h3 class="step-title h3 info">
                                                            PERSONAL INFORMATION ORDER
                                                        </h3>
                                                    </div>
                                                    <div class="content">
                                                        <div class="tab-content">
                                                            <div class="tab-pane fade in active show" id="checkout-guest-form" role="tabpanel">
                                                                <form id="customer-form" class="js-customer-form" onSubmit={(e) => this.addInformationOrder(e)}>
                                                                    <div>
                                                                        <input type="hidden" name="id_customer" value="" />
                                                                        <div class="form-group row">
                                                                            <input class="form-control" name="username" type="text" placeholder="Full name" onChange={this.onChangeUserName} />
                                                                        </div>
                                                                        <div class="form-group row">
                                                                            <input class="form-control" name="email" type="email" placeholder="Email" onChange={this.onChangeEmail}/>
                                                                        </div>
                                                                        <div class="form-group row">
                                                                            <input class="form-control" name="phone" type="number" placeholder="Phone" onChange={this.onChangePhone}/>
                                                                        </div>
                                                                        <div class="form-group row">
                                                                            <input class="form-control" name="phone" type="text" placeholder="Address" onChange={this.onChangeAddress}/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="clearfix">
                                                                        <div class="row">
                                                                            <input type="hidden" name="submitCreate" value="1" />

                                                                            <button class="continue btn btn-primary pull-xs-right" name="continue" data-link-action="register-new-customer" type="submit"
                                                                                value="1">
                                                                                Continue
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="cart-grid-right col-xs-12 col-lg-3">
                                                    
                                                    <div id="block-reassurance">
                                                        <ul>
                                                            <li>
                                                                <div className="block-reassurance-item">
                                                                    <img
                                                                        src={require("../component/asset/product/check1.png")}
                                                                        alt="Security policy (edit with Customer reassurance module)"
                                                                    />
                                                                    <span>
                                                                        Security policy (edit with Customer
                                                                        reassurance module)
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div className="block-reassurance-item">
                                                                    <img
                                                                        src={require("../component/asset/product/check2.png")}
                                                                        alt="Delivery policy (edit with Customer reassurance module)"
                                                                    />
                                                                    <span>
                                                                        Delivery policy (edit with Customer
                                                                        reassurance module)
                                                                    </span>
                                                                </div>
                                                            </li>
                                                            <li>
                                                                <div className="block-reassurance-item">
                                                                    <img
                                                                        src={require("../component/asset/product/check3.png")}
                                                                        alt="Return policy (edit with Customer reassurance module)"
                                                                    />
                                                                    <span>
                                                                        Return policy (edit with Customer reassurance
                                                                        module)
                                                                    </span>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default InformationOrder;
