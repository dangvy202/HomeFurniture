import React, { Component } from "react";
import RoomService from "../../service/RoomService";
import logo from "../asset/home/logo.png";

class RoomCategory extends Component {
  constructor(props) {
    super(props);
    this.state = {
      room: [],
    };
  }

  componentDidMount() {
    RoomService.getAllRoom().then((res) => {
      this.setState({ room: res.data });
    });
  }

  render() {
    return (
      <div className="spacing-10 group-image-special">
        <div className="row">
          {this.state.room.map((item) => (
            <div className="col-lg-4 col-md-4">
              <div className="block">
                <div className="effect">
                  <a href={"/product/room?=" + item.roomRedirect}>
                    <span>{item.roomName}</span>
                    <img
                      className="img-fluid width-100"
                      src={require("../asset/home/" + item.picture)}
                      alt="banner-1"
                      title="banner-1"
                    />
                  </a>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default RoomCategory;
