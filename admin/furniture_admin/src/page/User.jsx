import React, { Component } from "react";
import MUIDataTable from "mui-datatables";
import userService from "../service/UserService";



class User extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userList: [],
      notification: "",
    };
    this.detail = this.detail.bind(this);
    this.editUser = this.editUser.bind(this);
    this.blockAccount = this.blockAccount.bind(this);
  }

  componentDidMount() {
    userService.getAllUser().then((res) => {
      this.setState({ userList: res.data.resultData });
    })
  }

  detail(user) {
    window.location.href = "/user-detail/" + user.email;
  }

  editUser(user) {
    window.location.href = "/user-edit/" + user.email;
  }

  blockAccount(user) {
    debugger;
    userService.blockAccount(user.email).then((res) => {
      window.location.href = "/user";
    })
  }

  render() {
    const columns = ['Id', 'First Name', 'Last Name', 'User Name', 'Email', 'Password', 'Address', 'Birthday', 'Role', 'Nation', 'Phone', 'Picture', 'Date','Status', 'Action'];
    const userListSet = new Array();
    var id = 0;
    this.state.userList.map((user) => {
      id = id + 1;
      var firstName = user.firstName;
      var lastName = user.lastName;
      var userName = user.userName;
      var email = user.email;
      var password = user.password;
      var address = user.address;
      var birthday = user.birthday.split("T")[0];
      var role = user.role;
      var nation = user.nation;
      var picture = user.picture
      var date = user.updateDate.split("T")[0];
      var phone = user.phone;
      var status = user.status;

      const data = {
        'Id': id,
        'First Name': firstName,
        'Last Name': lastName,
        'User Name': userName,
        'Email': email,
        'Password': password,
        'Address': address,
        'Birthday': birthday,
        'Role': role,
        'Nation': nation,
        'Phone': phone,
        'Picture': picture,
        'Date': date,
        'Status': status,
        'Action': (
          <>
            <button onClick={() => this.detail(user)} className="btn btn-app bg-success">
              <i className="fas fa-barcode"></i> Detail
            </button>
            <button onClick={() => this.blockAccount(user)} className="btn btn-app bg-danger"
              data-toggle="modal"
              data-target="#exampleModal"
            >
              <i className="fas fa-trash"></i> Block
            </button>
            <button onClick={() => this.editUser(user)} className="btn btn-app bg-warning">
              <i className="fas fa-barcode"></i> Edit
            </button>
          </>
        )
      }
      userListSet.push(data);
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
                      <li className="breadcrumb-item active">User</li>
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
                          title={"User List"}
                          data={userListSet}
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
