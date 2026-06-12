import React, { useState } from 'react'
import { useEffect } from 'react';
import { getTopTen } from '../service/TopTenService';
import MyBarChart from './MyBarChart';
import MyPieChart from './MyPieChart';

const pad = {
  padding: "10px",
  textAlign: "center"
}


const divDisplay = {
  display: "flex",
}
const Home = () => {

  let [topTen, setTopTen] = useState([]);
  useEffect(
    () => {
      handleGetTopTen()
    }, []
  )
  let handleGetTopTen = () => {
    getTopTen().then(resp => {
      setTopTen(resp.data)
    })
      .catch(err => console.log(err))
  }

  return (
    <div style={divDisplay}>
      <MyBarChart data={topTen} />
      <MyPieChart data={topTen} />

    </div>
  )
    ;
}

export default Home