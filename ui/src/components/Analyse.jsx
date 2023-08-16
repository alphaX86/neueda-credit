import React, { useState, useEffect } from 'react';
import { Button, Container, Row, Col } from 'react-bootstrap';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';

const Analyse = () => {
    const [data, setData] = useState([]);
    const [showChart1, setShowChart1] = useState(false);
    const [showChart2, setShowChart2] = useState(false);

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

    const handleChart1Click = () => {
        setShowChart1(true);
        setShowChart2(false);
    };

    const handleChart2Click = () => {
        setShowChart1(false);
        setShowChart2(true);
    };

    return (
        <Container>
            <Row>
                <Col>
                    <Button onClick={handleChart1Click}>Chart 1</Button>
                </Col>
                <Col>
                    <Button onClick={handleChart2Click}>Chart 2</Button>
                </Col>
            </Row>
            {showChart1 && (
                <LineChart width={600} height={300} data={data}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" />
                    <YAxis />
                    <Tooltip />
                    <Legend />
                    <Line type="monotone" dataKey="pv" stroke="#8884d8" activeDot={{ r: 8 }} />
                    <Line type="monotone" dataKey="uv" stroke="#82ca9d" />
                </LineChart>
            )}
            {showChart2 && (
                <LineChart width={600} height={300} data={data}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name" />
                    <YAxis />
                    <Tooltip />
                    <Legend />
                    <Line type="monotone" dataKey="amt" stroke="#8884d8" activeDot={{ r: 8 }} />
                </LineChart>
            )}
        </Container>
    );
};

export default Analyse;
