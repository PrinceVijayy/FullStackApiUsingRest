import axios from "axios";
const baseUrl="http://localhost:8080/SimpleEats/rest/credentials"
class CredentialsService{
    getAllCredentials(){
        return axios.get(baseUrl+"/list")
    }
    getCredentialsById(id){
        return axios.get(`${baseUrl}/view/${id}`)
    }
    deleteCredentialsById(id){
        return axios.delete(`${baseUrl}/delete/${id}`)
    }
    createCredentials(credentials){
        return axios.post(`${baseUrl}/create/${credentials.id}/${credentials.username}/${credentials.password}/${credentials.type}`)
    }
    updateCredentials(id,credentials){
        return axios.put(`${baseUrl}/update/${id}/${credentials.username}/${credentials.password}/${credentials.type}`)
    }

}
export default new CredentialsService();