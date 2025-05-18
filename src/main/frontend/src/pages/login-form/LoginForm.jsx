import React from "react";
import {useNavigate} from 'react-router-dom';
import styles from "./LoginForm.module.css"

function LoginForm() {
    const navigate = useNavigate();
    return (
        <div className={styles.container}>
            <h1>Welcome back!</h1>
            <p>Access your existing account</p>
            <form method="POST" action="/api/login">
                <div className={styles.inputSection}>
                    <div className={styles.inputRow}>
                        <label>EMAIL</label>
                        <input name="username" type="text" className={styles.input}></input>
                    </div>
                    <div className={styles.inputRow}>
                        <label>PASSWORD</label>
                        <input name="password" type="password" className={styles.input}></input>
                    </div>
                </div>
                <button type="submit" className={styles.loginButton}>Log in</button>
            </form>
            <button className={styles.signupButton} onClick={() => navigate('/register')}>Create account</button>
        </div>
    );
}

export default LoginForm;