import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

function DeleteCustomer() {
    const [customerId, setCustomerId] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/api?_customerID=${customerId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if (response.ok) {
                // Handle successful deletion here
                alert('Customer deleted successfully!');
            } else {
                // Handle unsuccessful deletion here
                alert('Failed to delete customer');
            }
        } catch (error) {
            // Handle error here
            console.log(error);
        }
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
            <br />
            <Button variant="danger" type="submit">
                Delete Customer
            </Button>
        </Form>
    );
}

export default DeleteCustomer;
