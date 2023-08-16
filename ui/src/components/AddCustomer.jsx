import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const API_LINK = 'https://example.com/api/customers';

const AddCustomer = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [gender, setGender] = useState('');
    const [job, setJob] = useState('');
    const [dob, setDob] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const response = await fetch(API_LINK, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ firstName, lastName, gender, job, dob }),
        });

        if (response.ok) {
            alert('Customer added successfully!');
            setFirstName('');
            setLastName('');
            setGender('');
            setJob('');
            setDob('');
        } else {
            alert('Failed to add customer');
        }
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="formFirstName">
                <Form.Label>First Name</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter first name"
                    value={firstName}
                    onChange={(event) => setFirstName(event.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="formLastName">
                <Form.Label>Last Name</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter last name"
                    value={lastName}
                    onChange={(event) => setLastName(event.target.value)}
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

            <Button variant="primary" type="submit">
                Add Customer
            </Button>
        </Form>
    );
};

export default AddCustomer;
