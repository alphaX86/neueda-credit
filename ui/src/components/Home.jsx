import React from 'react';
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div className='text-center'>
            <h1>Welcome to CreDeX</h1>
            <p>Explore our services and find the best credit options for you.</p>
            <p>Here's a short description about the links</p>
            <div>
                <h3>Add</h3>
                <p>Add a new customer/transaction to the system.</p>
                <Link to='/add'>Go to Add page</Link>
            </div>
            <div>
                <h3>View</h3>
                <p>View all customer records in the system.</p>
                <Link to='/view'>Go to View page</Link>
            </div>
            <div>
                <h3>Delete</h3>
                <p>Delete a customer record from the system.</p>
                <Link to='/delete'>Go to Delete page</Link>
            </div>
            <div>
                <h3>Analyze</h3>
                <p>Analyze credit records in the system based on conditions given.</p>
                <Link to='/analyze'>Go to Analyze page</Link>
            </div>
        </div>
    );
};

export default Home;
