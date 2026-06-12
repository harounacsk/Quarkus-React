import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { useAuth } from '../auth/AuthContext'

const nav = {
  display: "flex",
  gap: " 10px",
  padding: "10px"
}

const item = {
  flexGrow: 0
}

const itemL = {
  flexGrow: 1,
  textAlign: "center"
}

const Navigation = () => {

  let { token, logout } = useAuth();
  if (token) {
    return (
      <nav style={nav}>
        <Link style={item} to="home">Home</Link>
        <p style={itemL}>Dashboard</p>
        <Link style={item} to="login" onClick={logout}>Ausloggen</Link>
      </nav>
    )
  }
}

export default Navigation