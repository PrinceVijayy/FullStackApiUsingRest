import React from "react";
import { useState } from "react";
import {useNavigate} from "react-router-dom"
import BusServices from "../../services/BusServices";
import BusListNavBar from "../navigation/BusListNavBar";

const CreateBus = () => {
  const [busId, setBusId] = useState();
  const [busName, setBusName] = useState();
  const [busSeats, setBusSeats] = useState();
  const navigate=useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    const bus = {
      busId: busId,
      busName: busName,
      busSeats: busSeats,
    };

    BusServices.addBus(bus).then((res) => {
      console.log(res.data);
      navigate("/busList")
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
            onChange={(e) => {
              setBusSeats(e.target.value);
            }}
          />
        </div>
        <button onClick={handleSubmit} class="btn btn-primary">
          Create Bus
        </button>
      </form>
    </div>
  );
};

export default CreateBus;
