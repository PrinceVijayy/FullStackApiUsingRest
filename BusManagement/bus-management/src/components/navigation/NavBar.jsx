import React from 'react'
import { BrowserRouter, Routes, Route,  } from "react-router-dom";
import BusesList from '../BusOperations/BusesList';
import CreateBus from '../BusOperations/CreateBus';
import UpdateBus from '../BusOperations/UpdateBus';
import ViewBus from '../BusOperations/ViewBus';

const NavBar = () => {
  return (
    <div>
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<BusesList/>}/>
        <Route path='/busList' element={<BusesList/>}/>
        <Route path='/createBus' element={<CreateBus/>}/>
        <Route path='/updateBus/:busId' element={<UpdateBus/>}/>
        <Route path='/viewBus/:busId' element={<ViewBus/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default NavBar
