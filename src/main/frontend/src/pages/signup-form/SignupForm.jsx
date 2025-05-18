import {useState} from "react";
import styles from "./SignupForm.module.css"


function SignupForm() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [error, setError] = useState("");
    const [success, setSuccess] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError("")
        setSuccess(false)

        if (password !== confirmPassword) {
            setError("Passwords do not match!");
            return;
        }

        try {
            const response = await fetch("/api/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    username: username,
                    password: password
                })
            });

            if (response.ok) {
                setSuccess(true);
                setError("");
            } else {
                const result = await response.json();
                setError(result.message || "Registration failed!");
            }
        } catch (err) {
            setError("Something went wrong!");
        }
    }


    return (
        <div className={styles.container}>
            <h1>Create a new account</h1>
            <form className={styles.inputSection} onSubmit={handleSubmit}>
                <div className={styles.inputRow}>
                    <label>USERNAME</label>
                    <input type="text" className={styles.input} value={username}
                           onChange={(e) => setUsername(e.target.value)}></input>
                </div>
                <div className={styles.inputRow}>
                    <label>PASSWORD</label>
                    <input type="password" className={styles.input} value={password}
                           onChange={(e) => setPassword(e.target.value)}></input>
                </div>
                <div className={styles.inputRow}>
                    <label>CONFIRM PASSWORD</label>
                    <input type="password" className={styles.input} value={confirmPassword}
                           onChange={(e) => setConfirmPassword(e.target.value)}></input>
                </div>
                {error && <p style={{color: "red"}}>{error}</p>}
                {success && <p style={{color: "green"}}>Account created successfully!</p>}
                <button type="submit" className={styles.signupButton}>Register</button>
            </form>
            <p>Already have an account? <a href="/login">Login here!</a></p>
        </div>
    );
}

export default SignupForm;