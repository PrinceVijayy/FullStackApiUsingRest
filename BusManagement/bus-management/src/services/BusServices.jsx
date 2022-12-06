import axios from "axios";
const baseUrl="http://localhost:8081/BusTicketManagementSystem/rest/bus";


class BusServices{
    getAllBuses(){
        return axios.get(`${baseUrl}/list`);
    }
    getBus(busId){
        return axios.get(`${baseUrl}/view/${busId}`)
    }
    addBus(bus){
        return axios.post(`${baseUrl}/create/${bus.busId}/${bus.busName}/${bus.busSeats}`)
    }
    updateBus(busId, bus){
        return axios.put(`${baseUrl}/update/${busId}/${bus.busName}/${bus.busSeats}`)
    }
    deleteBus(busId){
        return axios.delete(`${baseUrl}/delete/${busId}`)
    }

}
export default new BusServices();