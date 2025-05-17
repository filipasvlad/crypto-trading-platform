import React from "react";
import { useNavigate } from 'react-router-dom';
import "./LoginForm.css"

function LoginForm(){
    const navigate = useNavigate();
    return(
        <div className="container">
            <h1>Welcome back!</h1>
            <p>Access your existing account</p>
            <form method="POST" action="http://localhost:8080/auth/login">
                <div className="input-section">
                    <div className="input-row">
                        <label>EMAIL</label>
                        <input name="username" type="text" className="input"></input>
                    </div>
                    <div className="input-row">
                        <label>PASSWORD</label>
                        <input name="password" type="password" className="input"></input>
                    </div>
                </div>
                <button type="submit" className="login-button">Log in</button>
            </form>
            <button className="signup-button" onClick={() => navigate('/register')}>Create account</button>
        </div>
    );
}

export default LoginForm;