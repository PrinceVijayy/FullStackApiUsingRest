import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useParams,useNavigate } from "react-router-dom";
import BusServices from "../../services/BusServices";
import BusListNavBar from "../navigation/BusListNavBar";
const UpdateBus = () => {
  const [busId, setBusId] = useState();
  const [busName, setBusName] = useState();
  const [busSeats, setBusSeats] = useState();
  //===================================================

  const params = useParams();
const navigate=useNavigate();
  //===========================================================
  useEffect(() => {
    settingData();
  }, []);
  //==========================================================
  const handleSubmit = (e) => {
    e.preventDefault();
    let bus = {
      busId: busId,
      busName: busName,
      busSeats: busSeats,
    };

    BusServices.updateBus(busId,bus).then((res) => {
      console.log(res.data);
      navigate("/")
    });
  };
  const settingData = async () => {
    await BusServices.getBus(params.busId).then((res) => {
      setBusId(res.data.busId);
      setBusName(res.data.busName);
      setBusSeats(res.data.busSeats);
    });
  };

  return (
    <div>
      <BusListNavBar/>
      <form>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">
            Id
          </label>
          <input
            type="number"
            class="form-control"
            id="busId"
            value={busId}
            onChange={(e) => {
              setBusId(e.target.value);
            }}
          />
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">
            Name
          </label>
          <input
            type="text"
            class="form-control"
            id="busName"
            value={busName}
            onChange={(e) => {
              setBusName(e.target.value);
            }}
          />
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">
            Seats
          </label>
          <input
            type="text"
            class="form-control"
            id="busSeats"
            value={busSeats}
            onChange={(e) => {
              setBusSeats(e.target.value);
            }}
          />
        </div>
        <button onClick={handleSubmit} class="btn btn-primary">
          Update Bus
        </button>
      </form>
    </div>
  );
};

export default UpdateBus;
