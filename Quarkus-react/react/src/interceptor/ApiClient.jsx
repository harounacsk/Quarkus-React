import axios from "axios";
import { useAuth } from "../auth/AuthContext";

const apiClient = axios.create({
    baseURL: 'http://localhost:8080/',
    headers: {
        'Content-Type': 'application/json'
    }
})

export default apiClient;