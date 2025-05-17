import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './layouts/Layout';
import { useState } from 'react'
import './App.css'
import Navbar from './components/navbar/Navbar'
import CoinCard from './components/coin-card/CoinCard';
import CoinViewer from './pages/coin-viewer/CoinViewer';
import BuyTransaction from './components/buy-transaction/BuyTransaction';
import LoginForm from './pages/login-form/LoginForm';
import SignupForm from './pages/signup-form/SignupForm';

const coins = [
  {
      name: "Bitcoin",
      symbol: "BTC",
      buyPrice: "96902.62",
      sellPrice: "94966.54",
      coinIconLink: "/icons/btc.png",
  },
  {
      name: "Ethereum",
      symbol: "ETH",
      buyPrice: "3195.45",
      sellPrice: "3123.67",
      coinIconLink: "/icons/eth.png",
  },
  {
      name: "Litecoin",
      symbol: "LTC",
      buyPrice: "151.25",
      sellPrice: "148.89",
      coinIconLink: "/icons/ltc.png",
  }

];

const selectedCoin = {
  name: "Bitcoin",
  symbol: "BTC",
  currency: "USD",
  buyPrice: "96902.62",
  sellPrice: "94966.54",
  coinIconLink: "/icons/btc.png",
}

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route path="/" element={<CoinViewer coins={coins} />} />
                    <Route path="/coin-list" element={<CoinViewer coins={coins} />} />
                    <Route path="/buy" element={<BuyTransaction item={selectedCoin} />} />
                    <Route path="/register" element={<SignupForm />} />
                    <Route path="/login" element={<LoginForm />} />
                </Route>
            </Routes>
        </Router>
    );
}
export default App
