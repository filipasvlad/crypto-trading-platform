import React from "react"
import "./CoinCard.css"

function CoinCard(props) {
    return (
        <div className="card-wrapper">
            <div className="coin-info">
                <img src={props.item.coinIconLink} className="coin-icon"/>
                <div className="coin-text">
                    <h3>{props.item.name}</h3>
                    <p>{props.item.symbol}-USD</p>
                </div>
            </div>
            <div className="coin-prices">
                <div className="coin-buy">
                    <a href="/">Buy</a>
                    <p>{props.item.buyPrice}</p>
                </div>
                <div className="coin-sell">
                    <a href="/">Sell</a>
                    <p>{props.item.sellPrice}</p>
                </div>

            </div>
        </div>
    );
}

export default CoinCard;