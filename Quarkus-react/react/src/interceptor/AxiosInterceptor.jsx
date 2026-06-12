import React, { useEffect } from 'react'

import apiClient from './ApiClient';
import { useAuth } from '../auth/AuthContext';

export const AxiosInterceptor = ({ children }) => {
   
    let { token } = useAuth();
   
    useEffect(() => {
        // Injecte le token dans chaque requête sortante
        const requestInterceptor = apiClient.interceptors.request.use(
            (config) => {
                if (token) {
                    config.headers.Authorization = `Bearer ${token}`;
                }
                return config;
            },
            (error) => Promise.reject(error)
        );

        // Nettoyage pour éviter de dupliquer l'interceptor au changement de token
        return () => {
            apiClient.interceptors.request.eject(requestInterceptor);
        };
    }, [token]); // Se déclenche à chaque fois que le token change

    return children;
};

