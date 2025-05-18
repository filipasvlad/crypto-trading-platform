import React from "react"
import styles from './CoinCard.module.css';

function CoinCard(props) {
    return (
        <div className={styles.cardWrapper}>
            <div className={styles.coinInfo}>
                <img src={props.item.coinIconLink} className={styles.coinIcon}/>
                <div className={styles.coinText}>
                    <h3>{props.item.name}</h3>
                    <p>{props.item.symbol}-USD</p>
                </div>
            </div>
            <div className={styles.coinPrices}>
                <div className={styles.coinBuy}>
                    <a href={`/buy/${props.item.symbol.toLowerCase()}`}>Buy</a>
                    <p>{props.item.buyPrice}</p>
                </div>
                <div className={styles.coinSell}>
                    <a href="/">Sell</a>
                    <p>{props.item.sellPrice}</p>
                </div>

            </div>
        </div>
    );
}

export default CoinCard;