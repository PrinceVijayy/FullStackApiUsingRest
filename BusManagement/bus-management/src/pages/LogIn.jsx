import React, { useState } from "react";
import { useParams } from "react-router-dom";
import CredentialServices from "../services/CredentialServices";

const LogIn = () => {
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const [error, setError] = useState();
  const params = useParams();
  const handleSubmit = (e) => {
    e.preventDefault();
    CredentialServices.getCredential(params.username).then((res) => {
        obj=res.data;
        console.log(res.data)
        console.log(res.data.username);
    //   if (res.data != null) {
    //     console.log(res.data.username);
    //     setUsername(res.data.username);
    //     setPassword(res.data.password);
    //   } else {
    //     setError("data does not exists");
    //   }
    });
  };
  return (
    <div>
      <center>
        <h1>Login Page</h1>
      </center>
      <form>
        <div className="mb-3">
          <label forname="exampleInputEmail1" class="form-label">
            UserName or Email
          </label>
          <input
            type="text"
            className="form-control"
            id="busId"
            onChange={(e) => {
              setUsername(e.target.value);
            }}
          />
        </div>
        <div className="mb-3">
          <label forname="exampleInputEmail1" class="form-label">
            Password
          </label>
          <input
            type="password"
            className="form-control"
            id="busName"
            onChange={(e) => {
              setPassword(e.target.value);
            }}
          />
        </div>

        <button onClick={handleSubmit} className="btn btn-primary">
          Create Bus
        </button>
      </form>
      <p>{error}</p>
    </div>
  );
};

export default LogIn;
