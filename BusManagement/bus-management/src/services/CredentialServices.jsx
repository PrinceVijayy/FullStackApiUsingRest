import axios from "axios";
const baseUrl="http://localhost:8081/BusTicketManagementSystem/rest/credential";


class CredentialServices{
    getAllCredentials(){
        return axios.get(`${baseUrl}/list`);
    }
    getCredential(id){
        return axios.get(`${baseUrl}/view/${id}`)
    }
    addCredential(credential){
        return axios.post(`${baseUrl}/create/${credential.id}/${credential.firstName}/${credential.lastName}/${credential.username}/${credential.email}/${credential.password}`)
    }
    updateCredential(id, credential){
        return axios.put(`${baseUrl}/update/${credential.id}/${credential.firstName}/${credential.lastName}/${credential.username}/${credential.email}/${credential.password}`)
    }
    deleteCredential(id){
        return axios.delete(`${baseUrl}/delete/${id}`)
    }
}
export default new CredentialServices();