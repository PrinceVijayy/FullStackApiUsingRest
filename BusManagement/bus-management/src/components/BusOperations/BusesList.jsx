import React, { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import BusServices from "../../services/BusServices";
import BusListNavBar from "../navigation/BusListNavBar";

const BusesList = () => {
  const [buses, setBuses] = useState([]);

  //===============================================
  const navigate = useNavigate();
  //================================================
  useEffect(() => {
    getAllBuses();
  },[]);
  const getAllBuses = () => {
    BusServices.getAllBuses().then((res) => {
      setBuses(res.data);
      console.log(res.data);
    });
  };
  const handleEditBus = (busId) => {
    navigate(`/updateBus/${busId}`);
  };
  const handleViewBus = (busId) => {
    navigate(`/viewBus/${busId}`);
  };
  const handleDeleteBus = (busId) => {
    BusServices.deleteBus(busId).then((res) => {
      getAllBuses();
    });
  };
  return (
    <div>
      <BusListNavBar />
      <table className="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">SEATS</th>
          </tr>
        </thead>
        <tbody>
          {buses.map((bus) => {
            return (
              <tr key={bus.busId}>
                <td>{bus.busId}</td>
                <td>{bus.busName}</td>
                <td>{bus.busSeats}</td>
                <td>
                  <button
                    className="btn btn-info"
                    onClick={() => handleEditBus(bus.busId)}
                  >
                    Edit
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-primary"
                    onClick={() => handleViewBus(bus.busId)}
                  >
                    View
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-secondary"
                    onClick={(e) => handleDeleteBus(bus.busId)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default BusesList;
