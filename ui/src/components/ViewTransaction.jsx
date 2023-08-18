import React, { useState } from 'react';
import { Form, Button, Table } from 'react-bootstrap';

function ViewTransaction() {
    const [customerId, setCustomerId] = useState('');
    const [transactions, setTransactions] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [transactionsPerPage] = useState(100);

    const handleSubmit = async (event) => {
        event.preventDefault();
        const response = await fetch(`http://localhost:8080/api/customer/transaction?_customerID=${customerId}`);
        const data = await response.json();
        setTransactions(data);
    };

    const indexOfLastTransaction = currentPage * transactionsPerPage;
    const indexOfFirstTransaction = indexOfLastTransaction - transactionsPerPage;
    const currentTransactions = transactions.slice(indexOfFirstTransaction, indexOfLastTransaction);

    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="customerId">
                    <Form.Label>Customer ID:</Form.Label>
                    <Form.Control type="text" value={customerId} onChange={(event) => setCustomerId(event.target.value)} />
                </Form.Group>
                <br/>
                <Button variant="primary" type="submit">View Transactions</Button>
            </Form>
            <br/>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Transaction Date/Time</th>
                        <th>Amount</th>
                        <th>Customer ID</th>
                        <th>Transaction Number</th>
                        <th>Category</th>
                        <th>Merchant</th>
                    </tr>
                </thead>
                <tbody>
                    {currentTransactions.map((transaction) => (
                        <tr key={transaction.trans_num}>
                            <td>{transaction.trans_date_trans_time}</td>
                            <td>{transaction.amt}</td>
                            <td>{transaction.customer_id}</td>
                            <td>{transaction.trans_num}</td>
                            <td>{transaction.category}</td>
                            <td>{transaction.merchant}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
            <Pagination
                transactionsPerPage={transactionsPerPage}
                totalTransactions={transactions.length}
                paginate={paginate}
            />
        </div>
    );
}

export default ViewTransaction;

const Pagination = ({ transactionsPerPage, totalTransactions, paginate }) => {
    const pageNumbers = [];

    for (let i = 1; i <= Math.ceil(totalTransactions / transactionsPerPage); i++) {
        pageNumbers.push(i);
    }

    return (
        <nav>
            <ul className="pagination">
                {pageNumbers.map(number => (
                    <li key={number} className="page-item">
                        <a onClick={() => paginate(number)} href="#" className="page-link">
                            {number}
                        </a>
                    </li>
                ))}
            </ul>
        </nav>
    );
};
