import React from "react";
import "./CoinViewer.css"
import CoinCard from "../../components/coin-card/CoinCard";

function CoinViewer(props) {
    const {coins} = props;
    return (
        <div className="coin-list-cointainer">
            <div className="coin-list-grid">
                {coins.map((coin, index) => (
                    <CoinCard key={index} item={coin}/>
                ))}
            </div>
        </div>
    );

}

export default CoinViewer;
