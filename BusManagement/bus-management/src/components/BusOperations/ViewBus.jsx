import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useParams } from "react-router-dom";
import BusServices from "../../services/BusServices";
import BusListNavBar from "../navigation/BusListNavBar";

const ViewBus = () => {
  const [busId, setBusId] = useState();
  const [busName, setBusName] = useState();
  const [busSeats, setBusSeats] = useState();
  const params = useParams();
  useEffect(() => {
    settingData();
    console.log(busId)
    console.log(busName)
    console.log(busSeats)
  });
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
      <pre>
        Bus ID : {busId} <br/>
        Bus Name : {busName} <br/>
        Bus Seats : {busSeats}
      </pre>
    </div>
  );
};

export default ViewBus;
