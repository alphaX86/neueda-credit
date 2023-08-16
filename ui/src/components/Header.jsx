import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';

const Header = () => {
    return (
        <Navbar bg="light" expand="lg" className="justify-content-center">
            <Navbar.Brand href="#home">Credit Card Manager</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link href="/">Home</Nav.Link>
                    <Nav.Link href="/add">Add</Nav.Link>
                    <Nav.Link href="/view">View</Nav.Link>
                    <Nav.Link href="/analyse">Analyse</Nav.Link>
                    <Nav.Link href="/delete/customer">Delete</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
};

export default Header;
