import logo from './logo.svg';
import './App.css';
import {Route, Routes, BrowserRouter as Router} from 'react-router-dom'
import Home from './components/Home';
import Navbar from './components/Navbar';
import View from './components/View';
import Exist from './components/Exist';

function App() {
  return (
    <Router>
      <div className="container">
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/view" element={<View />} />
          <Route path="/exist" element={<Exist />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
