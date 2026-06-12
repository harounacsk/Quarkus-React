import { Navigate, Outlet, useNavigate } from "react-router-dom";
import { useAuth } from "./AuthContext";
import { useState } from "react";

const ProtectedRoute = () => {
  const { token } = useAuth();
  const navigate = useNavigate();
  // return <Outlet/> affiche les routes enfants 
  return token ? <Outlet /> : navigate("/login");
};

export default ProtectedRoute;