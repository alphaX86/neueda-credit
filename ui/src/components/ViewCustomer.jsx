import React, { useState, useEffect } from 'react';
import { Table, Pagination, Form, Button } from 'react-bootstrap';

function ViewCustomer() {
    const [data, setData] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [itemsPerPage, setItemsPerPage] = useState(15);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch('http://localhost:8080/api/allCustomers');
            const jsonData = await response.json();
            setData(jsonData);
        };
        fetchData();
    }, []);

    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;
    const currentItems = data.filter((item) => {
        if (searchTerm === '') {
            return true;
        }
        const regex = new RegExp(searchTerm, 'i');
        return (
            regex.test(item.customer_id) ||
            regex.test(item.first) ||
            regex.test(item.last) ||
            regex.test(item.gender) ||
            regex.test(item.job) ||
            regex.test(item.dob)
        );
    }).slice(indexOfFirstItem, indexOfLastItem);

    const pageNumbers = [];
    for (let i = 1; i <= Math.ceil(data.length / itemsPerPage); i++) {
        pageNumbers.push(i);
    }

    const renderPageNumbers = pageNumbers.map((number) => {
        return (
            <Pagination.Item key={number} active={number === currentPage} onClick={() => setCurrentPage(number)}>
                {number}
            </Pagination.Item>
        );
    });

    return (
        <div>
            <Form inline>
                <Form.Control type="text" placeholder="Search" className="mr-sm-2" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} />
                <Button variant="outline-success" onClick={() => setCurrentPage(1)}>
                    Search
                </Button>
            </Form>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Customer ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Gender</th>
                        <th>Job</th>
                        <th>Date of Birth</th>
                    </tr>
                </thead>
                <tbody>
                    {currentItems.map((item) => (
                        <tr key={item.customer_id}>
                            <td>{item.customer_id}</td>
                            <td>{item.first}</td>
                            <td>{item.last}</td>
                            <td>{item.gender}</td>
                            <td>{item.job}</td>
                            <td>{item.dob}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
            <Pagination>
                <Pagination.First onClick={() => setCurrentPage(1)} />
                <Pagination.Prev onClick={() => setCurrentPage(currentPage - 1)} />
                
                <Pagination.Next onClick={() => setCurrentPage(currentPage + 1)} />
                <Pagination.Last onClick={() => setCurrentPage(pageNumbers.length)} />
            </Pagination>
        </div>
    );
}

export default ViewCustomer;
