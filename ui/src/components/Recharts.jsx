import React, { useState, useEffect } from 'react';
import { PieChart, Pie, Cell, Legend, Tooltip } from 'recharts';

const MyPieChart = ({API, key, value}) => {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch(API);
      const jsonData = await response.json();

      setData(jsonData);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const COLORS = ['#FF6384', '#36A2EB', '#FFCE56', '#4CAF50', '#FF5722'];

  return (
    <div>
      <h2>Pie Chart</h2>
      <PieChart width={400} height={400}>
        <Pie
          data={data}
          dataKey={key}
          nameKey={value}
          cx="50%"
          cy="50%"
          outerRadius={80}
          fill="#8884d8"
          label 
        >
          {data.map((entry, index) => (
            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
          ))}
        </Pie>
        <Legend verticalAlign="bottom" height={36} />
        <Tooltip />
      </PieChart>
    </div>
  );
};

export default MyPieChart;
