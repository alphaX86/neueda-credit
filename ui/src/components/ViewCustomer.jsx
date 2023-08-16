import React, { useState, useEffect } from 'react';
import { Table, Pagination, Form } from 'react-bootstrap';

function ViewCustomer() {
    const [data, setData] = useState([]);
    const [currentPage, setCurrentPage] = useState(1);
    const [itemsPerPage, setItemsPerPage] = useState(10);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch('mongodb-api-url');
            const jsonData = await response.json();
            setData(jsonData);
        };
        fetchData();
    }, []);

    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;

    // Filter data based on search query
    const filteredData = data.filter((item) =>
        item.column1.toLowerCase().includes(searchQuery.toLowerCase())
    );

    const currentItems = filteredData.slice(indexOfFirstItem, indexOfLastItem);

    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    const handleSearch = (event) => {
        setSearchQuery(event.target.value);
        setCurrentPage(1); // Reset pagination when search query changes
    };

    return (
        <div>
            <Form.Group controlId="search">
                <Form.Control
                    type="text"
                    placeholder="Search by Column 1"
                    value={searchQuery}
                    onChange={handleSearch}
                />
            </Form.Group>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Column 1</th>
                        <th>Column 2</th>
                        <th>Column 3</th>
                    </tr>
                </thead>
                <tbody>
                    {currentItems.map((item) => (
                        <tr key={item.id}>
                            <td>{item.column1}</td>
                            <td>{item.column2}</td>
                            <td>{item.column3}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>
            <Pagination>
                {Array.from({ length: Math.ceil(filteredData.length / itemsPerPage) }).map(
                    (item, index) => (
                        <Pagination.Item
                            key={index}
                            active={index + 1 === currentPage}
                            onClick={() => paginate(index + 1)}
                        >
                            {index + 1}
                        </Pagination.Item>
                    )
                )}
            </Pagination>
        </div>
    );
}

export default ViewCustomer;
