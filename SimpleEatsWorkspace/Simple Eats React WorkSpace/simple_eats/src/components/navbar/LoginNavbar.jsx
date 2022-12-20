import React from "react";
import { Link } from "react-router-dom";

const LoginNavbar = () => {
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/home">Home</Link>
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default LoginNavbar;
