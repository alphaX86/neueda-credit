import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

function DeleteCustomer() {
    const [customerId, setCustomerId] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        // Handle form submission here
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="customerId">
                <Form.Label>Customer ID</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter customer ID"
                    value={customerId}
                    onChange={(event) => setCustomerId(event.target.value)}
                    required
                />
            </Form.Group>
            <Button variant="danger" type="submit">
                Delete Customer
            </Button>
        </Form>
    );
}

export default DeleteCustomer;
