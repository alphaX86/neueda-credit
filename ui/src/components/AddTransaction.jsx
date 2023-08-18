import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";

const AddTransaction = () => {
    const [custId, setCustomerID] = useState('');
    const [amt, setAmt] = useState('');
    const [category, setCategory] = useState('');
    const [merchant, setMerchant] = useState('');
    const [city, setCity] = useState('');
    const [state, setState] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch(`https://pbwmchallenge7.conygre.com:8080/api/transactions/${custId}/${amt}/${category}/${merchant}/${city}/${state}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ custId, amt, category, merchant, city, state }),
        });

        if (response.ok) {
            alert('Transaction added successfully to your account!');
            console.log(response);
            setCustomerID('');
            setAmt('');
            setCategory('');
            setCity('');
            setState('');
            setMerchant('');
        } else {
            alert('Failed to add transaction');
            console.log(response);
        }
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="amt">
                <Form.Label>Amount</Form.Label>
                <Form.Control
                    type="number"
                    name="amt"
                    value={amt}
                    placeholder="100"
                    required
                    onChange={(e) => setAmt(e.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="custId">
                <Form.Label>Customer ID</Form.Label>
                <Form.Control
                    type="text"
                    name="custId"
                    value={custId}
                    placeholder="543"
                    required
                    onChange={(e) => setCustomerID(e.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="city">
                <Form.Label>City</Form.Label>
                <Form.Control
                    type="text"
                    name="city"
                    value={city}
                    placeholder="New York"
                    required
                    onChange={(e) => setCity(e.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="state">
                <Form.Label>State</Form.Label>
                <Form.Control
                    type="text"
                    name="state"
                    value={state}
                    placeholder="NY"
                    required
                    onChange={(e) => setState(e.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="merchant">
                <Form.Label>Merchant</Form.Label>
                <Form.Control
                    type="text"
                    name="merchant"
                    placeholder="Amazon"
                    value={merchant}
                    required
                    onChange={(e) => setMerchant(e.target.value)}
                />
            </Form.Group>

            <Form.Group controlId="category">
                <Form.Label>Category</Form.Label>
                <Form.Control
                    type="text"
                    name="category"
                    value={category}
                    placeholder="Shopping"
                    required
                    onChange={(e) => setCategory(e.target.value)}
                />
            </Form.Group>
            <br />
            <Button className="btn-block me-2" variant="primary" type="submit">
                Submit
            </Button>
            <Button className="btn-block me-2" variant="secondary" type="button" onClick={() => {
                setCustomerID('');
                setAmt('');
                setCategory('');
                setMerchant('');
                setCity('');
                setState('');
            }}>
                Clear Form
            </Button>
        </Form>
    );
};

export default AddTransaction;
