import React, {createContext, useContext, useEffect, useState, useCallback} from 'react';
import { useLocation } from "react-router-dom";
const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({children}) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const location = useLocation();
    const checkAuth = useCallback(() => {
        fetch('/api/auth/check', {
            credentials: 'include',
        })
            .then((res) => setIsAuthenticated(res.ok))
            .catch(() => setIsAuthenticated(false));
    }, []);

    useEffect(() => {
        checkAuth();
    }, [checkAuth, location.key]);

    const logout = () => {
        // request backend pentru delete cookie
        setIsAuthenticated(false);
    };

    return (
        <AuthContext.Provider value={{isAuthenticated, setIsAuthenticated, logout}}>
            {children}
        </AuthContext.Provider>
    );
};
