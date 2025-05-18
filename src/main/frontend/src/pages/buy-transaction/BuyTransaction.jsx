import { useState, useEffect } from "react";
import {Link, useParams} from "react-router-dom";
import styles from './BuyTransaction.module.css';
import {useAuth} from "../../context/AuthContext.jsx";

function BuyTransaction() {
    const { symbol } = useParams();
    const [coin, setCoin] = useState(null);
    const [loading, setLoading] = useState(true);
    const [spendAmount, setSpendAmount] = useState("");
    const [receiveAmount, setReceiveAmount] = useState(0);
    const {isAuthenticated} = useAuth();

    useEffect(() => {
        fetch(`/api/crypto/${symbol}`, {
        })
            .then(res => {
                if (!res.ok) throw new Error("Coin not found");
                return res.json();
            })
            .then(data => {
                setCoin(data);
                setLoading(false);
            })
            .catch(err => {
                console.error(err);
                setLoading(false);
            });
    }, [symbol]);

    const handleSpendChange = (event) => {
        const inputValue = event.target.value;
        setSpendAmount(inputValue);

        const receiveValue = inputValue / coin.buyPrice;
        setReceiveAmount(receiveValue);
    }

    if (loading) return <p>Loading...</p>;
    if (!coin) return <p>Coin not found.</p>;
    const coinSymbol = coin.symbol.toUpperCase();
    return (
        <div className={styles.container}>
            <h1 className={styles.title}>Buy {coinSymbol} with USD</h1>
            <p className={styles.exchangeRate}>Exchange rate: 1 {coinSymbol} ≈ {coin.buyPrice} USD</p>

            <div className={styles.inputSection}>
                <div className={styles.inputRow}>
                    <label>Spend</label>
                    <input type="text" placeholder="Enter amount" value={spendAmount} onChange={handleSpendChange}/>
                    <img src="/icons/usd.png" alt="USD" className={styles.currencyIcon} />
                    <span className={styles.currency}>
                        USD
                    </span>
                </div>
                <div className={styles.inputRow}>
                    <label>Receive</label>
                    <input type="text" value={receiveAmount.toFixed(7)} disabled/>
                    <img src={`/icons/${coin.id}.png`} alt={coinSymbol} className={styles.currencyIcon} />
                    <span className={styles.currency}>{coinSymbol}</span>
                </div>
            </div>
            {!isAuthenticated && (
                <p className={styles.authWarning}>
                    Please click  <Link to="/login">here</Link> to log into your existing account or register a new account.
                </p>
            )}
            <button className={styles.buyButton} disabled={isAuthenticated} onClick={isAuthenticated ? null : undefined}>
                Buy {coinSymbol}
            </button>
        </div>
    );
}

export default BuyTransaction;