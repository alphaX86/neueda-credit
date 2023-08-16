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
            alert('Customer added successfully!');
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
                <Form.Label>First </Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter first "
                    value={first}
                    onChange={(event) => setFirst(event.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="formLast">
                <Form.Label>Last </Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter last "
                    value={last}
                    onChange={(event) => setLast(event.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="formGender">
                <Form.Label>Gender</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter gender"
                    value={gender}
                    onChange={(event) => setGender(event.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="formJob">
                <Form.Label>Job</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter job"
                    value={job}
                    onChange={(event) => setJob(event.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="formDob">
                <Form.Label>Date of Birth</Form.Label>
                <Form.Control
                    type="date"
                    placeholder="Enter date of birth"
                    value={dob}
                    onChange={(event) => setDob(event.target.value)}
                />
            </Form.Group>
            <br />
            <Button variant="primary" type="submit">
                Add Customer
            </Button>
        </Form>
    );
};

export default AddCustomer;
