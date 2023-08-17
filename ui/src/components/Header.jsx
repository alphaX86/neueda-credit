import React from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';

const Header = () => {
    return (
        <Navbar bg="light" expand="lg" className="justify-content-center p-3">
            <Navbar.Brand href="/">CreDeX</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link href="/">Home</Nav.Link>
                    <NavDropdown title="Add" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/add/customer">Customer</NavDropdown.Item>
                        <NavDropdown.Item href="/add/transactions">Transactions</NavDropdown.Item>
                    </NavDropdown>
                    <NavDropdown title="View" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/view/customer">Customer</NavDropdown.Item>
                    </NavDropdown>
                    <Nav.Link href="/delete/customer">Delete</Nav.Link>
                    <Nav.Link href="/analyse">Analyse</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
};

export default Header;
