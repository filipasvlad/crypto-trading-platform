import React, {createContext, useContext, useEffect, useState} from 'react';

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({children}) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    useEffect(() => {
        fetch('/api/auth/check', {
            credentials: 'include',
        })
            .then((res) => setIsAuthenticated(res.ok))
            .catch(() => setIsAuthenticated(false));
    }, []);

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
