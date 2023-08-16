import React, { useState, useEffect } from 'react';
import { Button, Container, Row, Col, DropdownButton, Dropdown } from 'react-bootstrap';
import { PieChart, Pie, LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';

const Charts = () => {
    const [data, setData] = useState([]);
    const [showPieChart, setShowPieChart] = useState(false);
    const [showLineChart, setShowLineChart] = useState(false);
    const [lineChartKey, setLineChartKey] = useState('pv');

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const response = await fetch('https://mongodb-api-url.com/data');
            const jsonData = await response.json();
            setData(jsonData);
        } catch (error) {
            console.error(error);
        }
    };

    const handlePieChartClick = () => {
        setShowPieChart(true);
        setShowLineChart(false);
    };

    const handleLineChartClick = () => {
        setShowPieChart(false);
        setShowLineChart(true);
    };

    const handleLineChartKeyChange = (eventKey) => {
        setLineChartKey(eventKey);
    };

    return (
        <Container>
            <Row>
                <Col>
                    <Button onClick={handlePieChartClick}>Pie Chart</Button>
                </Col>
                <Col>
                    <DropdownButton id="dropdown-basic-button" title="Line Chart">
                        <Dropdown.Item eventKey="pv" onSelect={handleLineChartKeyChange}>PV</Dropdown.Item>
                        <Dropdown.Item eventKey="uv" onSelect={handleLineChartKeyChange}>UV</Dropdown.Item>
                        <Dropdown.Item eventKey="amt" onSelect={handleLineChartKeyChange}>AMT</Dropdown.Item>
                    </DropdownButton>
                </Col>
            </Row>
            {showPieChart && (
                <PieChart width={600} height={300}>
                    <Pie data={data} dataKey="value" nameKey="name" cx="50%" cy="50%" outerRadius={50} fill="#8884d8" label />
                    <Tooltip />
                </PieChart>
            )}
            {showLineChart && (
                <LineChart width={600} height={300} data={data}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" />
                    <YAxis />
                    <Tooltip />
                    <Legend />
                    <Line type="monotone" dataKey={lineChartKey} stroke="#8884d8" activeDot={{ r: 8 }} />
                </LineChart>
            )}
        </Container>
    );
};

export default Charts;