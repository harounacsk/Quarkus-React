import apiClient from "../interceptor/ApiClient";



export const getTopTen = async () => {
	return await apiClient.get("users/ten");
}