import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
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
                </ul>
            </div>
        </nav>
    );
}

export default Navbar;
