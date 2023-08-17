import React from 'react';
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div className='text-center p-3 m-3'>
            <h1>Welcome to CreDeX - Your Complete Credit Card Management Solution</h1>

            <p>Are you tired of juggling multiple credit cards and struggling to keep track of your transactions? Look no further! CreDeX is your one-stop solution for efficient credit card management. With a range of powerful features, we empower you to take control of your finances like never before.</p>

            <h2>Key Features:</h2>

            <ul>
                <li><strong>Add Customer/Transaction Records:</strong> Seamlessly input and manage customer and transaction data. Easily add new credit card accounts, record transactions, and keep your financial information up to date.</li>
                <li><strong>View Customer Data:</strong> Access a comprehensive overview of your customers and their credit card accounts. Stay organized with detailed customer profiles that include essential information and transaction history.</li>
                <li><strong>Delete Customer Data:</strong> Need to remove outdated records? CreDeX lets you effortlessly delete customer data while maintaining the integrity of your database.</li>
                <li><strong>Transaction Analysis with Interactive Charts:</strong> Gain deep insights into your credit card usage patterns. Our dynamic charts visually represent your transactions, making it easier than ever to understand your spending habits and trends.</li>
                <li><strong>Advanced Security Measures:</strong> Your data security is our priority. CreDeX employs state-of-the-art encryption and data protection protocols to ensure that your sensitive information remains private and secure.</li>
            </ul>

            <h2>Join CreDeX Today</h2>

            <p>Sign up now and embark on a journey towards better credit card management and financial clarity with CreDeX. Your financial data, simplified.</p>
            
            <Link to="/add/customer">
                <Button>Sign Up</Button>
            </Link>
            
        </div>
    );
};

export default Home;
