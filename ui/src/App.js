import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import AddCustomer from './components/AddCustomer';
import AddTransaction from './components/AddTransaction';
import DeleteCustomer from './components/DeleteCustomer';
import ViewCustomer from './components/ViewCustomer';

function App() {
  return (
    <div>
        <Router>
              <Header />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {Home}></Route>
                          <Route path = "/add/customer" component = {AddCustomer}></Route>
                          <Route path = "/add/transaction" component = {AddTransaction}></Route>
                          <Route path = "/delete/customer" component = {DeleteCustomer}></Route>
                          <Route path = "/view/customer" component = {ViewCustomer}></Route>
                          {/* <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route> */}
                    </Switch>
                </div>
              <Footer />
        </Router>
    </div>
    
  );
}

export default App;
