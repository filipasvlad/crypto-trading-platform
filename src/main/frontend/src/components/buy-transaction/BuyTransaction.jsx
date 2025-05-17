import React, {useState} from "react";
import "./BuyTransaction.css"

function BuyTransaction(props) {
    const [spendAmount, setSpendAmount] = useState("");
    const [receiveAmount, setReceiveAmount] = useState(0);

    const handleSpendChange = (event) => {
        const inputValue = event.target.value;
        setSpendAmount(inputValue);

        const receiveValue = inputValue / props.item.buyPrice;
        setReceiveAmount(receiveValue);

    }

    return (
        <div className="container">
            <h1 className="title">Buy {props.item.symbol} with {props.item.currency}</h1>
            <p className="exchange-rate">Curs de schimb:
                1 {props.item.symbol} ≈ {props.item.buyPrice} {props.item.currency}</p>

            <div className="input-section">
                <div className="input-row">
                    <label>Spend</label>
                    <input type="text" placeholder="Enter amount" value={spendAmount} onChange={handleSpendChange}/>
                    <span className="currency">{props.item.currency}</span>
                </div>
                <div className="input-row">
                    <label>Receive</label>
                    <input type="text" value={receiveAmount.toFixed(7)} disabled/>
                    <span className="currency">{props.item.symbol}</span>
                </div>
            </div>
            <button className="buy-button"> Buy {props.item.symbol} </button>
        </div>
    );
}

export default BuyTransaction;