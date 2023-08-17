import React, { useState } from 'react';
import { Form, Container, Row, Col } from 'react-bootstrap';
import Charts from './Charts';

function Analyse() {
    const [options, setOptions] = useState({
        gender: false,
        city: false,
        state: false,
        job: false,
        merchant: false
    });

    const handleOptionChange = (option) => {
        setOptions({
            ...options,
            [option]: !options[option]
        });
    };

    return (
        <Container>
            <Row>
                <Col>
                    <h1>Charts</h1>
                    <Form>
                        <Row>
                            <Col>
                                <Form.Check
                                    type="checkbox"
                                    label="Gender VS Amount"
                                    checked={options.gender}
                                    onChange={() => handleOptionChange('gender')}
                                />
                            </Col>
                            <Col>
                                <Form.Check
                                    type="checkbox"
                                    label="City VS Amount"
                                    checked={options.city}
                                    onChange={() => handleOptionChange('city')}
                                />
                            </Col>
                            <Col>
                                <Form.Check
                                    type="checkbox"
                                    label="State VS Amount"
                                    checked={options.state}
                                    onChange={() => handleOptionChange('state')}
                                />
                            </Col>
                            <Col>
                                <Form.Check
                                    type="checkbox"
                                    label="Job VS Amount"
                                    checked={options.job}
                                    onChange={() => handleOptionChange('job')}
                                />
                            </Col>
                            <Col>
                                <Form.Check
                                    type="checkbox"
                                    label="Merchant VS Amount"
                                    checked={options.merchant}
                                    onChange={() => handleOptionChange('merchant')}
                                />
                            </Col>
                        </Row>
                    </Form>
                </Col>
            </Row>
            <Row>
                <Col>
                    {options.gender && (
                        <div className="chart">
                            <h2>Gender VS Amount</h2>
                            <Charts
                                height={'600px'}
                                width={'800px'}
                                chartId={'64ddae70-c4a3-475f-8618-b60739251622'}
                            />
                        </div>
                    )}
                    {options.city && (
                        <div className="chart">
                            <h2>City VS Amount</h2>
                            <Charts
                                height={'600px'}
                                width={'800px'}
                                chartId={'64ddb438-51cb-4d7f-8f62-40c93807b03e'}
                            />
                        </div>
                    )}
                    {options.state && (
                        <div className="chart">
                            <h2>State VS Amount</h2>
                            <Charts
                                height={'600px'}
                                width={'800px'}
                                chartId={'64ddb4cd-c65b-4eeb-89bc-d6c37cbb3ef9'}
                            />
                        </div>
                    )}
                    {options.job && (
                        <div className="chart">
                            <h2>Job VS Amount</h2>
                            <Charts
                                height={'600px'}
                                width={'800px'}
                                chartId={'64ddb7c8-e2f1-47d7-8746-240a2ee63c05'}
                            />
                        </div>
                    )}
                    {options.merchant && (
                        <div className="chart">
                            <h2>Merchant VS Amount</h2>
                            <Charts
                                height={'600px'}
                                width={'800px'}
                                chartId={'64ddb0bc-7533-4628-883a-b3dab00ecd52'}
                            />
                        </div>
                    )}
                </Col>
            </Row>
        </Container>
    );
}

export default Analyse;
