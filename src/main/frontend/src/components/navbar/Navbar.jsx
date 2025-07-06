import React, { useState, useEffect, useRef } from "react";
import { Link } from "react-router-dom";
import styles from "./Navbar.module.css";
import { useAuth } from "../../context/AuthContext.jsx";

function Navbar() {
    const { isAuthenticated } = useAuth();
    const [open, setOpen] = useState(false);
    const wrapperRef = useRef(null);

    /* click-outside pentru a închide meniul */
    useEffect(() => {
        const handleClickOutside = (e) => {
            if (wrapperRef.current && !wrapperRef.current.contains(e.target)) {
                setOpen(false);
            }
        };
        document.addEventListener("mousedown", handleClickOutside);
        return () => document.removeEventListener("mousedown", handleClickOutside);
    }, []);

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
                        <li className={styles.navbarItem} ref={wrapperRef}>
                            {/* wrapper comun avatar + dropdown */}
                            <div
                                className={styles.avatarWrapper}
                                /* desktop hover */
                                onMouseEnter={() => setOpen(true)}
                                onMouseLeave={() => setOpen(false)}
                                /* mobile click */
                                onClick={() => setOpen((prev) => !prev)}
                            >
                                <img
                                    src="/user_default.png"
                                    alt="User"
                                    className={styles.navbarAvatar}
                                />

                                {/* meniul rămâne în DOM; doar vizibilitatea variază */}
                                <ul
                                    className={`${styles.dropdownMenu} ${
                                        open ? styles.show : ""
                                    }`}
                                >
                                    <li className={styles.dropdownItem}>Profile</li>
                                    <li className={styles.dropdownItem}>Settings</li>
                                    <li className={styles.dropdownItem}>Logout</li>
                                </ul>
                            </div>
                        </li>
                    )}
                </ul>
            </div>
        </nav>
    );
}

export default Navbar;
