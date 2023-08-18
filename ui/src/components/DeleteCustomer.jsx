import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

function DeleteCustomer() {
    const [customerId, setCustomerId] = useState('');
    const [customer, setCustomer] = useState(null);

    const handleFetch = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch(`https://pbwmchallenge7.conygre.com:8080/api/customer?_customerID=${customerId}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            if (response.ok || response.status === 302) {
                const customerData = await response.json();
                setCustomer(customerData);
            } else {
                alert('Failed to fetch customer');
            }
        } catch (error) {
            console.log(error);
        }
    };

    const handleDelete = async (event) => {
        event.preventDefault();
        if (window.confirm('Are you sure you want to delete this customer?')) {
            try {
                const response = await fetch(`https://pbwmchallenge7.conygre.com:8080/api?_customerID=${customerId}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
                if (response.ok) {
                    // Handle successful deletion here
                    alert('Customer deleted successfully!');
                    setCustomer(null);
                    setCustomerId('');
                } else {
                    // Handle unsuccessful deletion here
                    alert('Failed to delete customer');
                }
            } catch (error) {
                // Handle error here
                console.log(error);
            }
        }
    };

    return (
        <>
            <Form onSubmit={handleFetch}>
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
                <Button variant="primary" type="submit">
                    Fetch Customer
                </Button>
            </Form>
            {customer && (
                <>
                    <br />
                    <h3>Customer Details</h3>
                    <p><strong>First Name:</strong> {customer.first}</p>
                    <p><strong>Last Name:</strong> {customer.last}</p>
                    <p><strong>Gender:</strong> {customer.gender}</p>
                    <p><strong>Job:</strong> {customer.job}</p>
                    <p><strong>DOB:</strong> {customer.dob}</p>
                    <br />
                    <Form onSubmit={handleDelete}>
                        <Button variant="danger" type="submit">
                            Delete Customer
                        </Button>
                    </Form>
                </>
            )}
        </>
    );
}

export default DeleteCustomer;
