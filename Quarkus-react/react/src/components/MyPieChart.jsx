import { PieChart } from '@mui/x-charts'
import React from 'react'




const MyPieChart = ({ data }) => {
  const pieData = data.map((item, index) => ({
    id: index,
    value: item.amount,
    label: item.name
  }));

  return (
    <PieChart
      series={[
        {
          data: pieData,
        },
      ]}
      width={200}
      height={400}
    />
  )
}

export default MyPieChart