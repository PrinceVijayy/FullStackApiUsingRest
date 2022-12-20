import React from "react";
import { Link } from "react-router-dom";
import LoginNavbar from "../components/navbar/LoginNavbar";

const Login = () => {
  return (
    <div >
      <LoginNavbar />
      <br />
      <div class="content">
        <h1 class="inner-shadow brand">Login</h1>
      </div>
      <br />
      {/* <!-- Pills content --> */}
      <div class="tab-content container center_div">
        <form>
          {/* <!-- Email input --> */}
          <div class="form-outline mb-4">
            <input type="text" id="loginName" class="form-control" />
            <label class="form-label" for="loginName">
              Username
            </label>
          </div>

          {/* <!-- Password input --> */}
          <div class="form-outline mb-4">
            <input type="password" id="loginPassword" class="form-control" />
            <label class="form-label" for="loginPassword">
              Password
            </label>
          </div>

          {/* <!-- 2 column grid layout --> */}
          <div class="row mb-4">
            <div>
              {/* <!-- Simple link --> */}
              <a href="#!">Forgot password?</a>
            </div>
          </div>

          {/* <!-- Submit button --> */}
          <button type="submit" className=" btn_clr_style btn btn-primary btn-block mb-4">
            Sign in
          </button>

          {/* <!-- Register buttons --> */}
          <div>
            <p>
              Not a member? <Link to="/register">Register</Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
