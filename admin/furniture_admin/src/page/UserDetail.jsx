
import React, { Component } from "react";
import MUIDataTable from "mui-datatables";
import userService from "../service/UserService";



class User extends Component {
  constructor(props) {
    super(props);
    const pathName = window.location.pathname;
    var arrPath = pathName.split("/");
    var userParameter = arrPath[arrPath.length - 1];
    this.state = {
        firstName: "",
        lastName: "",
        userName: "",
        email: "",
        password: "",
        address: "",
        birthday: "",
        role: "",
        nation: "",
        phone: "",
        picture: "",
        updateDate: "",
        param: userParameter
    };
  }

  componentDidMount() {
    userService.getUserDetailByEmail(this.state.param).then((res) => {
        debugger;
        this.setState({ firstName : res.data.resultData.firstName});
        this.setState({ lastName : res.data.resultData.lastName});
        this.setState({ userName : res.data.resultData.userName});
        this.setState({ email : res.data.resultData.email});
        this.setState({ password : res.data.resultData.password});
        this.setState({ address : res.data.resultData.address});
        this.setState({ birthday : res.data.resultData.birthday.split("T")[0]});
        this.setState({ role : res.data.resultData.role});
        this.setState({ nation : res.data.resultData.nation});
        this.setState({ phone : res.data.resultData.phone});
        this.setState({ picture : res.data.resultData.picture});
        this.setState({ updateDate : res.data.resultData.updateDate.split("T")[0]});
    })
  }

  render() {
    const columns = ['Id', 'First Name', 'Last Name', 'User Name', 'Email', 'Password', 'Address' , 'Birthday', 'Role', 'Nation', 'Phone', 'Picture', 'Date'];
    var id = 1;
    const data = {
    'Id': id,
    'First Name': this.state.firstName,
    'Last Name': this.state.lastName,
    'User Name': this.state.userName,
    'Email': this.state.email,
    'Password': this.state.password,
    'Address': this.state.address,
    'Birthday': this.state.birthday,
    'Role': this.state.role,
    'Nation': this.state.nation,
    'Phone': this.state.phone,
    'Picture': this.state.picture,
    'Date': this.state.date,
    }
    const userData = new Array();
    userData.push(data)
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
                        <a href="/user">User</a>
                      </li>
                      <li className="breadcrumb-item active">User Detail</li>
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
                          title={"User Detail"}
                          data={userData}
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

export default User;
