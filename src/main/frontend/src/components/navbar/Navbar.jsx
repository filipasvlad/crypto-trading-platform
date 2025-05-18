import React from "react";
import {Link} from "react-router-dom";
import styles from "./Navbar.module.css";
import {useAuth} from "../../context/AuthContext.jsx";

function Navbar() {
    const {isAuthenticated} = useAuth();

    return (
        <nav className={styles.navbar}>
            <div className={styles.navbarContainer}>
                <Link to="/" className={styles.navbarLogo}>
                    CryptoExchange
                </Link>
                <ul className={styles.navbarMenu}>
                    <li className={styles.navbarItem}>
                        <Link to="/" className={styles.navbarLink}>
                            Home
                        </Link>
                    </li>
                    <li className={styles.navbarItem}>
                        <Link to="/coin-list" className={styles.navbarLink}>
                            Coin List
                        </Link>
                    </li>
                    {!isAuthenticated ? (
                        <>
                            <li className={styles.navbarItem}>
                                <Link to="/login" className={styles.navbarLink}>
                                    Login
                                </Link>
                            </li>
                            <li className={styles.navbarItem}>
                                <Link to="/register" className={styles.navbarLink}>
                                    Register
                                </Link>
                            </li>
                        </>
                    ) : (
                        <li className={styles.navbarItem}>
                            <img
                                src="/icons/bitcoin.png"
                                alt="User"
                                className={styles.navbarAvatar}
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
