import React from "react";
import {Link} from "react-router-dom";
import "./Navbar.css";
import {useAuth} from "../../context/AuthContext.jsx";

function Navbar() {
    const {isAuthenticated} = useAuth();

    return (
        <nav className="navbar">
            <div className="navbar-container">
                <Link to="/" className="navbar-logo">
                    CryptoExchange
                </Link>
                <ul className="navbar-menu">
                    <li className="navbar-item">
                        <Link to="/" className="navbar-link">
                            Home
                        </Link>
                    </li>
                    <li className="navbar-item">
                        <Link to="/coin-list" className="navbar-link">
                            Coin List
                        </Link>
                    </li>
                    {isAuthenticated ? (
                        <>
                            <li className="navbar-item">
                                <Link to="/login" className="navbar-link">
                                    Login
                                </Link>
                            </li>
                            <li className="navbar-item">
                                <Link to="/register" className="navbar-link">
                                    Register
                                </Link>
                            </li>
                        </>
                    ) : (
                        <li className="navbar-item">
                            <img
                                src="/icons/bitcoin.png"
                                alt="User"
                                className="navbar-avatar"
                                style={{width: "32px", height: "32px", borderRadius: "50%"}}
                            />
                        </li>
                    )}
                </ul>
            </div>
        </nav>
    );
}

export default Navbar;
