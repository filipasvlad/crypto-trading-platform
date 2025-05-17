import React from "react";
import "./SignupForm.css"


function SignupForm(){
    return(
        <div className="container">
            <h1>Create a new account</h1>
            <div className="input-section">
                <div className="input-row">
                    <label>EMAIL</label>
                    <input type="text" className="input"></input>
                </div>
                <div className="input-row">
                    <label>PASSWORD</label>
                    <input type="password" className="input"></input>
                </div>
                <div className="input-row">
                    <label>CONFIRM PASSWORD</label>
                    <input type="password" className="input"></input>
                </div>
            </div>
            <button className="signup-button">Register</button>
            <p>Already have an account? <a href="/">Login here!</a></p>
        </div>
    );
}

export default SignupForm;