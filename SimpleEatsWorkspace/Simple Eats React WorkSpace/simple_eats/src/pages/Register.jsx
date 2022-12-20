import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import RegisterNavbar from "../components/navbar/RegisterNavbar";
import CredentialsService from "../services/CredentialsService";

const Register = () => {
  const [id, setId] = useState();
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const [type, setType] = useState();
  //================================================
  const navigate = useNavigate();
  //================================================
  const handleRegister = async () => {
    let obj = {
      id: id,
      username: username,
      password: password,
      type: type
    };
    await CredentialsService.createCredentials(obj);
    navigate("/login");
  };
  return (
    <div>
      <RegisterNavbar />
      <br />
      <div class="content">
        <h1 class="inner-shadow brand">Register</h1>
      </div>
      <br />
      <form className="form container">
        {/* <!-- Id input --> */}
        <div class="form-outline mb-4">
          <input
            onChange={(e) => {
              setId(e.target.value);
            }}
            type="number"
            id="registerName"
            name="id"
            class="form-control"
            value={id}
          />
          <label class="form-label" for="registerName">
            Id
          </label>
        </div>

        {/* <!-- Username input --> */}
        <div class="form-outline mb-4">
          <input
            type="text"
            id="registerUsername"
            name="username"
            class="form-control"
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
            }}
          />
          <label class="form-label" for="registerUsername">
            Username
          </label>
        </div>

        {/* <!-- Password input --> */}
        <div class="form-outline mb-4">
          <input
            type="password"
            id="registerPassword"
            name="password"
            class="form-control"
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
            }}
          />
          <label class="form-label" for="registerPassword">
            Password
          </label>
        </div>
        <div>
          <label class="form-label" for="chooseYourRole">
            Choose Your Role
          </label>
          <select
            class="form-select"
            onChange={(e) => {
              setType(e.target.value);
            }}
          >
            <option value="user">User</option>
            <option value="admin">Admin</option>
          </select>
        </div>

        {/* <!-- Submit button --> */}
        <button
          type="button"
          onClick={handleRegister}
          class=" btn_clr_style btn btn-primary btn-block mb-3"
        >
          Sign in
        </button>
      </form>
    </div>
  );
};

export default Register;
