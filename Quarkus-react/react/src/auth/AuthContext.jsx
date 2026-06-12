
import React, { createContext, useContext, useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

let authApi = axios.create({
  baseURL: "http://localhost:8080/auth"
})

// Étape A : Initialiser le contexte
const AuthContext = createContext(null);
// Étape B : Créer le composant Provider qui englobe l'application
export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState("");
  const navigate = useNavigate();

  const login = async ({ "email": email, "password": password }) => await authApi.post("login", { email: email, password: password })
    .then(resp => {
      setToken(resp.data.token);
      navigate("/home");
    }).catch(err => console.log(err))

  const logout = () => setToken(null); localStorage.clear()

  return (
    <AuthContext.Provider value={{ token, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};
// Étape C : Créer un hook personnalisé pour simplifier l'usage de useContext
export const useAuth = () => useContext(AuthContext);