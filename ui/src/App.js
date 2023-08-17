import logo from './logo.svg';
import './App.css';
import {Route, Routes} from 'react-router-dom'
import Home from './components/Home';
import Navbar from './components/Navbar';
import View from './components/View';
import Exist from './components/Exist';

function App() {
  return (
    <div className="container">
      <Home />
      <Navbar/>
      <Exist/>
    </div>
  );
}

export default App;
