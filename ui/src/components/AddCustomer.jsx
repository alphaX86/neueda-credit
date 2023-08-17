import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

// const API_LINK = `http://localhost:8080/api/new_Customer?_first=${first}&_last=${last}&_dob=${dob}&_gender=${gender}&_job=${job}`;

const AddCustomer = () => {
    const [first, setFirst] = useState('');
    const [last, setLast] = useState('');
    const [gender, setGender] = useState('');
    const [job, setJob] = useState('');
    const [dob, setDob] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const response = await fetch(`http://localhost:8080/api/new_Customer?_first=${first}&_last=${last}&_gender=${gender}&_job=${job}&_dob=${dob}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ first, last, gender, job, dob }),
        });

        if (response.ok) {
            alert('Customer added successfully! Please note your customer ID on view page');
            setFirst('');
            setLast('');
            setGender('');
            setJob('');
            setDob('');
        } else {
            alert('Failed to add customer');
        }
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="formFirst">
                <Form.Label>First Name</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="John "
                    value={first}
                    onChange={(event) => setFirst(event.target.value)}
                    required
                />
            </Form.Group>

            <Form.Group controlId="formLast">
                <Form.Label>Last Name</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Smith "
                    value={last}
                    onChange={(event) => setLast(event.target.value)}
                    required
                />
            </Form.Group>

            <Form.Group controlId="formGender">
                <Form.Label>Gender</Form.Label>
                <div>
                    <Form.Check
                        inline
                        label="Male"
                        type="radio"
                        name="gender"
                        value="M"
                        checked={gender === "M"}
                        onChange={(event) => setGender(event.target.value)}
                        required
                    />
                    <Form.Check
                        inline
                        label="Female"
                        type="radio"
                        name="gender"
                        value="F"
                        checked={gender === "F"}
                        onChange={(event) => setGender(event.target.value)}
                        required
                    />
                </div>
            </Form.Group>

            <Form.Group controlId="formJob">
                <Form.Label>Job</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Developer"
                    value={job}
                    onChange={(event) => setJob(event.target.value)}
                    required
                />
            </Form.Group>

            <Form.Group controlId="formDob">
                <Form.Label>Date of Birth</Form.Label>
                <Form.Control
                    type="date"
                    placeholder="01/01/2000"
                    value={dob}
                    onChange={(event) => setDob(event.target.value)}
                    required
                />
            </Form.Group>
            <br />
            <Button className="btn-block me-2" variant="primary" type="submit">
                Add Customer
            </Button>
            <Button className="btn-block me-2" variant="secondary" type="button" onClick={() => {
                setFirst('');
                setLast('');
                setGender('');
                setJob('');
                setDob('');
            }}>
                Clear Form
            </Button>
        </Form>
    );
};

export default AddCustomer;
