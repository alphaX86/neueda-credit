import React, { useState } from 'react';
import { Form, Container, Row, Col } from 'react-bootstrap';
import Charts from './Charts';

function Analyse() {
    const [options, setOptions] = useState({
        gender: false,
        city: false,
        state: false,
        job: false,
        merchant: false,
        category: false
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
                            <Col>
                                <Form.Check
                                    type="checkbox"
                                    label="Category VS Amount"
                                    checked={options.category}
                                    onChange={() => handleOptionChange('category')}
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
                            <div className='d-flex'>
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'64ddae70-c4a3-475f-8618-b60739251622'}
                            />
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'f7ff7746-32e4-47ea-a3e5-183b7608a34d'}
                            />
                            </div>
                        </div>
                    )}
                    {options.city && (
                        <div className="chart">
                            <h2>City VS Amount</h2>
                            <div className='d-flex'>
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'64ddb438-51cb-4d7f-8f62-40c93807b03e'}
                            />
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'e55c8762-c26e-4b95-af8d-e565cf4ba971'}
                            />
                            </div>
                        </div>
                    )}
                    {options.state && (
                        <div className="chart">
                            <h2>State VS Amount</h2>
                            <div className='d-flex'>
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'64ddb4cd-c65b-4eeb-89bc-d6c37cbb3ef9'}
                            />
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'c74719aa-ca83-4610-9334-6ace137b5e71'}
                            />
                            </div>
                        </div>
                    )}
                    {options.job && (
                        <div className="chart">
                            <h2>Job VS Amount</h2>
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'64ddb7c8-e2f1-47d7-8746-240a2ee63c05'}
                            />
                        </div>
                    )}
                    {options.merchant && (
                        <div className="chart">
                            <h2>Merchant VS Amount</h2>
                            <div className='d-flex'>
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'64ddb0bc-7533-4628-883a-b3dab00ecd52'}
                            />
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'7a73fb92-dd3e-44a3-a2cc-3c307694197a'}
                            />
                            </div>
                        </div>
                    )}
                    {options.merchant && (
                        <div className="chart">
                            <h2>Category VS Amount</h2>
                            <div className='d-flex'>
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'64ddb576-51cb-4d68-82f6-40c938086725'}
                            />
                            <Charts
                                height={'400px'}
                                width={'400px'}
                                chartId={'c0e18bab-4027-49a5-be35-8eb9288b369f'}
                            />
                            </div>
                        </div>
                    )}
                </Col>
            </Row>
        </Container>
    );
}

export default Analyse;
