import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Layout from './layouts/Layout';
import './App.css'
import CoinViewer from './pages/coin-viewer/CoinViewer';
import BuyTransaction from './pages/buy-transaction/BuyTransaction';
import LoginForm from './pages/login-form/LoginForm';
import SignupForm from './pages/signup-form/SignupForm';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Layout/>}>
                <Route path="/" element={<CoinViewer/>}/>
                <Route path="/coin-list" element={<CoinViewer/>}/>
                <Route path="/buy/:symbol" element={<BuyTransaction />} />
                <Route path="/register" element={<SignupForm/>}/>
                <Route path="/login" element={<LoginForm/>}/>
            </Route>
        </Routes>
    );
}

export default App
