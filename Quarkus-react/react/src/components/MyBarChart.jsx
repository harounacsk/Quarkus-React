import { BarChart } from '@mui/x-charts'
import React from 'react'




const MyBarChart = ({ data }) => {

    return (
        <BarChart
            xAxis={[
                {
                    id: 'barCategories',
                    data: data.map(item => item.name),
                    height: 28,
                },
            ]}
            series={[
                {
                    data: data.map(item => item.amount),
                },
            ]}
            height={300}
        />
    )
}

export default MyBarChart