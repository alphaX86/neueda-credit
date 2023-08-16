import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";

const AddTransaction = () => {
    const [transaction, setTransaction] = useState({
        amt: "",
        customer_id: "",
        city: "",
        state: "",
        merchant: "",
        category: ""
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setTransaction((prevTransaction) => ({
            ...prevTransaction,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(transaction);
        // Add your code to submit the form data to the server here
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="amt">
                <Form.Label>Amount</Form.Label>
                <Form.Control
                    type="number"
                    name="amt"
                    value={transaction.amt}
                    placeholder="100"
                    onChange={handleChange}
                    required
                />
            </Form.Group>

            <Form.Group controlId="customer_id">
                <Form.Label>Customer ID</Form.Label>
                <Form.Control
                    type="text"
                    name="customer_id"
                    value={transaction.customer_id}
                    placeholder="543"
                    onChange={handleChange}
                    required
                />
            </Form.Group>

            <Form.Group controlId="city">
                <Form.Label>City</Form.Label>
                <Form.Control
                    type="text"
                    name="city"
                    value={transaction.city}
                    placeholder="New York"
                    onChange={handleChange}
                    required
                />
            </Form.Group>

            <Form.Group controlId="state">
                <Form.Label>State</Form.Label>
                <Form.Control
                    type="text"
                    name="state"
                    value={transaction.state}
                    placeholder="NY"
                    onChange={handleChange}
                    required
                />
            </Form.Group>

            <Form.Group controlId="merchant">
                <Form.Label>Merchant</Form.Label>
                <Form.Control
                    type="text"
                    name="merchant"
                    placeholder="Amazon"
                    value={transaction.merchant}
                    onChange={handleChange}
                    required
                />
            </Form.Group>

            <Form.Group controlId="category">
                <Form.Label>Category</Form.Label>
                <Form.Control
                    type="text"
                    name="category"
                    value={transaction.category}
                    placeholder="Shopping"
                    onChange={handleChange}
                    required
                />
            </Form.Group>
            <br />
            <Button className="btn-block me-2" variant="primary" type="submit">
                Submit
            </Button>
            <Button className="btn-block me-2" variant="secondary" type="button" onClick={() => {
                setTransaction({amt: "",
                customer_id: "",
                city: "",
                state: "",
                merchant: "",
                category: ""});
            }}>
                Clear Form
            </Button>
        </Form>
    );
};

export default AddTransaction;
