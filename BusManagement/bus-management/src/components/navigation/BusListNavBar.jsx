import React from 'react'
import {Link} from "react-router-dom"
const BusListNavBar = () => {
  return (
    <div>
        <ul>
        <li className="float-style">
          <Link to="/">Home</Link>
        </li>
        <li className="float-style">
          <Link to="/createBus">Create</Link>
        </li>
      </ul>
    </div>
  )
}

export default BusListNavBar
