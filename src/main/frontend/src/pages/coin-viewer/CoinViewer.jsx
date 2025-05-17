import React, { useEffect, useState } from "react";
import "./CoinViewer.css"
import CoinCard from "../../components/coin-card/CoinCard";

function CoinViewer() {
    const [coins, setCoins] = useState([]);

    function formatPrice(value, decimals = 7) {
        return Number(value.toFixed(decimals)).toString();
    }

    const transformCoin = (raw) => {
        return {
            name: capitalize(raw.id),
            symbol: raw.symbol.toUpperCase(),
            buyPrice: formatPrice(raw.price),
            sellPrice: formatPrice(raw.price * 9 / 10),
            coinIconLink: `/icons/${raw.id}.png`
        };
    };

    function capitalize(str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
    }

    useEffect(() => {
        fetch("/api/crypto")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to fetch crypto data");
                }
                return response.json();
            })
            .then(data => {
                const formatted = data
                    .map(transformCoin)
                    .filter(Boolean);
                setCoins(formatted);
            })
            .catch(error => console.error("Error fetching crypto data:", error));
    }, []);

    console.log(coins);

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
