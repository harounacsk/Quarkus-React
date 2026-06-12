import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../auth/AuthContext';

const loginForm = {
    display: " flex",
    flexDirection: "column",
    /*Horizontal center*/
    justifyContent: "center",
    /*vertical center*/
    alignItems: "center",
    height: "100vh"
}
const inputField = {
    padding: "2px",
    margin: "2px"
}

const Login = () => {

    let [email, setEmail] = useState("");
    let [password, setPassword] = useState("");
    let navigate = useNavigate();
    let { login } = useAuth();

    let handleLogin = (e) => {
        e.preventDefault();
        let user = {
            email: email,
            password: password
        }
        login(user);
    };

    return (
        <>
            <div>
                <form style={loginForm} onSubmit={handleLogin}>
                    <h3>Login</h3>
                    <input style={inputField} placeholder='email' onChange={(e) => setEmail(e.target.value)} value={email} />
                    <input style={inputField} placeholder='Passwort' type="password" onChange={(e) => setPassword(e.target.value)} value={password} /><br />
                    <button type='submit'>Login</button>
                </form>
            </div>
        </>
    )
}

export default Login