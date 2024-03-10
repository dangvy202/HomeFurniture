import React, { Component } from "react";
import orderService from "../service/OrderService";

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

  render() {
    return (
      <div className="sidebar-mini" style={{ height: "auto" }}>
        <div class="content-wrapper" style={{ minHeight: "1302.12px" }}>
          <section class="content-header">
            <div class="container-fluid">
              <div class="row mb-2">
                <div class="col-sm-6">
                  <h1>Order List</h1>
                </div>
                <div class="col-sm-6">
                  <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item">
                      <a href="/">Home</a>
                    </li>
                    <li class="breadcrumb-item active">Order</li>
                  </ol>
                </div>
              </div>
            </div>
          </section>

          <section class="content">
            <div class="container-fluid">
              <div class="row">
                <div class="col-12">
                  <div class="card">
                    <div class="card-header">
                      <h3 class="card-title">Collection Order</h3>
                    </div>
                    <div class="card-body">
                      <div
                        id="example1_wrapper"
                        class="dataTables_wrapper dt-bootstrap4"
                      >
                        <div class="row">
                          <div class="col-sm-12 col-md-6">
                            <div class="dt-buttons btn-group flex-wrap">
                              {" "}
                              <button
                                class="btn btn-secondary buttons-copy buttons-html5"
                                tabindex="0"
                                aria-controls="example1"
                                type="button"
                              >
                                <span>Copy</span>
                              </button>{" "}
                              <button
                                class="btn btn-secondary buttons-csv buttons-html5"
                                tabindex="0"
                                aria-controls="example1"
                                type="button"
                              >
                                <span>CSV</span>
                              </button>{" "}
                              <button
                                class="btn btn-secondary buttons-excel buttons-html5"
                                tabindex="0"
                                aria-controls="example1"
                                type="button"
                              >
                                <span>Excel</span>
                              </button>{" "}
                              <button
                                class="btn btn-secondary buttons-pdf buttons-html5"
                                tabindex="0"
                                aria-controls="example1"
                                type="button"
                              >
                                <span>PDF</span>
                              </button>{" "}
                              <button
                                class="btn btn-secondary buttons-print"
                                tabindex="0"
                                aria-controls="example1"
                                type="button"
                              >
                                <span>Print</span>
                              </button>{" "}
                              <div class="btn-group">
                                <button
                                  class="btn btn-secondary buttons-collection dropdown-toggle buttons-colvis"
                                  tabindex="0"
                                  aria-controls="example1"
                                  type="button"
                                  aria-haspopup="true"
                                >
                                  <span>Column visibility</span>
                                  <span class="dt-down-arrow"></span>
                                </button>
                              </div>{" "}
                            </div>
                          </div>
                          <div class="col-sm-12 col-md-6">
                            <div id="example1_filter" class="dataTables_filter">
                              <label>
                                Search:
                                <input
                                  type="search"
                                  class="form-control form-control-sm"
                                  placeholder=""
                                  aria-controls="example1"
                                />
                              </label>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-sm-12">
                            <table
                              id="example1"
                              class="table table-bordered table-striped dataTable dtr-inline"
                              aria-describedby="example1_info"
                            >
                              <thead>
                                <tr>
                                  <th
                                    class="sorting sorting_asc"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-sort="ascending"
                                    aria-label="Rendering engine: activate to sort column descending"
                                  >
                                    Id Order
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="Browser: activate to sort column ascending"
                                  >
                                    Order Code
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="Platform(s): activate to sort column ascending"
                                  >
                                    Email
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="Engine version: activate to sort column ascending"
                                  >
                                    Name
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="CSS grade: activate to sort column ascending"
                                  >
                                    Phone
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="CSS grade: activate to sort column ascending"
                                  >
                                    Status
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="CSS grade: activate to sort column ascending"
                                  >
                                    Date
                                  </th>
                                  <th
                                    class="sorting"
                                    tabindex="0"
                                    aria-controls="example1"
                                    rowspan="1"
                                    colspan="1"
                                    aria-label="CSS grade: activate to sort column ascending"
                                  >
                                    Action
                                  </th>
                                </tr>
                              </thead>
                                                        <tbody>
                                                            
                                <tr class="odd">
                                  <td
                                    class="dtr-control sorting_1"
                                    tabindex="0"
                                  >
                                    Gecko
                                  </td>
                                  <td>Firefox 1.0</td>
                                  <td>Win 98+ / OSX.2+</td>
                                  <td>1.7</td>
                                  <td>A</td>
                                </tr>
                                <tr class="even">
                                  <td
                                    class="dtr-control sorting_1"
                                    tabindex="0"
                                  >
                                    Gecko
                                  </td>
                                  <td>Firefox 1.5</td>
                                  <td>Win 98+ / OSX.2+</td>
                                  <td>1.8</td>
                                  <td>A</td>
                                </tr>
                                
                              </tbody>
                              <tfoot>
                                <tr>
                                  <th rowspan="1" colspan="1">
                                    Rendering engine
                                  </th>
                                  <th rowspan="1" colspan="1">
                                    Browser
                                  </th>
                                  <th rowspan="1" colspan="1">
                                    Platform(s)
                                  </th>
                                  <th rowspan="1" colspan="1">
                                    Engine version
                                  </th>
                                  <th rowspan="1" colspan="1">
                                    CSS grade
                                  </th>
                                </tr>
                              </tfoot>
                            </table>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-sm-12 col-md-5">
                            <div
                              class="dataTables_info"
                              id="example1_info"
                              role="status"
                              aria-live="polite"
                            >
                              Showing 1 to 10 of 57 entries
                            </div>
                          </div>
                          <div class="col-sm-12 col-md-7">
                            <div
                              class="dataTables_paginate paging_simple_numbers"
                              id="example1_paginate"
                            >
                              <ul class="pagination">
                                <li
                                  class="paginate_button page-item previous disabled"
                                  id="example1_previous"
                                >
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="0"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    Previous
                                  </a>
                                </li>
                                <li class="paginate_button page-item active">
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="1"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    1
                                  </a>
                                </li>
                                <li class="paginate_button page-item ">
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="2"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    2
                                  </a>
                                </li>
                                <li class="paginate_button page-item ">
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="3"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    3
                                  </a>
                                </li>
                                <li class="paginate_button page-item ">
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="4"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    4
                                  </a>
                                </li>
                                <li class="paginate_button page-item ">
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="5"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    5
                                  </a>
                                </li>
                                <li class="paginate_button page-item ">
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="6"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    6
                                  </a>
                                </li>
                                <li
                                  class="paginate_button page-item next"
                                  id="example1_next"
                                >
                                  <a
                                    href="#"
                                    aria-controls="example1"
                                    data-dt-idx="7"
                                    tabindex="0"
                                    class="page-link"
                                  >
                                    Next
                                  </a>
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
          </section>
        </div>
      </div>
    );
  }
}

export default Order;
