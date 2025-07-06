INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'bitcoin', 'btc', 1 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'bitcoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'ethereum', 'eth', 2 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'ethereum');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'tether', 'usdt', 3 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'tether');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'ripple', 'xrp', 4 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'ripple');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'solana', 'sol', 5 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'solana');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'binancecoin', 'bnb', 6 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'binancecoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'dogecoin', 'doge', 7 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'dogecoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'usd-coin', 'usdc', 8 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'usd-coin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'cardano', 'ada', 9 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'cardano');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'staked-ether', 'steth', 10 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'staked-ether');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'tron', 'trx', 11 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'tron');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'avalanche-2', 'avax', 12 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'avalanche-2');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'shiba-inu', 'shib', 13 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'shiba-inu');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'the-open-network', 'ton', 14 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'the-open-network');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'wrapped-steth', 'wsteth', 15 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'wrapped-steth');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'chainlink', 'link', 16 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'chainlink');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'polkadot', 'dot', 17 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'polkadot');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'stellar', 'xlm', 18 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'stellar');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'wrapped-bitcoin', 'wbtc', 19 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'wrapped-bitcoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'bitcoin-cash', 'bch', 20 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'bitcoin-cash');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'sui', 'sui', 21 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'sui');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'hedera-hashgraph', 'hbar', 22 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'hedera-hashgraph');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'pepe', 'pepe', 23 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'pepe');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'weth', 'weth', 24 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'weth');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'uniswap', 'uni', 25 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'uniswap');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'litecoin', 'ltc', 26 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'litecoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'leo-token', 'leo', 27 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'leo-token');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'near', 'near', 28 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'near');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'wrapped-eeth', 'weeth', 29 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'wrapped-eeth');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'aptos', 'apt', 30 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'aptos');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'internet-computer', 'icp', 31 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'internet-computer');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'ethena-usde', 'usde', 32 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'ethena-usde');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'polygon-ecosystem-token', 'pol', 33 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'polygon-ecosystem-token');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'usds', 'usds', 34 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'usds');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'ethereum-classic', 'etc', 35 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'ethereum-classic');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'crypto-com-chain', 'cro', 36 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'crypto-com-chain');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'vechain', 'vet', 37 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'vechain');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'render-token', 'render', 38 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'render-token');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'fetch-ai', 'fet', 39 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'fetch-ai');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'bittensor', 'tao', 40 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'bittensor');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'kaspa', 'kas', 41 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'kaspa');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'arbitrum', 'arb', 42 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'arbitrum');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'filecoin', 'fil', 43 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'filecoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'hyperliquid', 'hype', 44 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'hyperliquid');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'mantle', 'mnt', 45 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'mantle');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'aave', 'aave', 46 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'aave');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'algorand', 'algo', 47 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'algorand');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'cosmos', 'atom', 48 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'cosmos');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'blockstack', 'stx', 49 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'blockstack');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'mantra-dao', 'om', 50 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'mantra-dao');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'bitget-token', 'bgb', 51 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'bitget-token');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'monero', 'xmr', 52 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'monero');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'whitebit', 'wbt', 53 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'whitebit');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'fantom', 'ftm', 54 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'fantom');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'dogwifcoin', 'wif', 55 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'dogwifcoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'dai', 'dai', 56 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'dai');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'okb', 'okb', 57 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'okb');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'celestia', 'tia', 58 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'celestia');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'bonk', 'bonk', 59 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'bonk');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'immutable-x', 'imx', 60 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'immutable-x');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'optimism', 'op', 61 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'optimism');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'injective-protocol', 'inj', 62 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'injective-protocol');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'ethena', 'ena', 63 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'ethena');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'theta-token', 'theta', 64 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'theta-token');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'the-graph', 'grt', 65 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'the-graph');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'floki', 'floki', 66 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'floki');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'worldcoin-wld', 'wld', 67 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'worldcoin-wld');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'solana-swap', 'sos', 68 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'solana-swap');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'sei-network', 'sei', 69 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'sei-network');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'thorchain', 'rune', 70 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'thorchain');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'gala', 'gala', 71 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'gala');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'ondo-finance', 'ondo', 72 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'ondo-finance');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'quant-network', 'qnt', 73 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'quant-network');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'coinbase-wrapped-btc', 'cbbtc', 74 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'coinbase-wrapped-btc');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'jasmycoin', 'jasmy', 75 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'jasmycoin');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'the-sandbox', 'sand', 76 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'the-sandbox');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'rocket-pool-eth', 'reth', 77 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'rocket-pool-eth');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'based-brett', 'brett', 78 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'based-brett');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'movement', 'move', 79 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'movement');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'eos', 'eos', 80 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'eos');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'maker', 'mkr', 81 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'maker');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'first-digital-usd', 'fdusd', 82 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'first-digital-usd');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'lido-dao', 'ldo', 83 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'lido-dao');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'mantle-staked-ether', 'meth', 84 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'mantle-staked-ether');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'beam-2', 'beam', 85 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'beam-2');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'pyth-network', 'pyth', 86 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'pyth-network');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'kaia', 'kaia', 87 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'kaia');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'jupiter-exchange-solana', 'jup', 88 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'jupiter-exchange-solana');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'dydx-chain', 'dydx', 89 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'dydx-chain');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'flow', 'flow', 90 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'flow');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'tezos', 'xtz', 91 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'tezos');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'arweave', 'ar', 92 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'arweave');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'kucoin-shares', 'kcs', 93 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'kucoin-shares');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'stau', 'stau', 94 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'stau');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'gatechain-token', 'gt', 95 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'gatechain-token');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'flare-networks', 'flr', 96 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'flare-networks');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'iota', 'iota', 97 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'iota');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'kelp-dao-restaked-eth', 'rseth', 98 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'kelp-dao-restaked-eth');

INSERT INTO cryptocurrencies (id, symbol, order_index)
SELECT 'starknet', 'strk', 99 WHERE NOT EXISTS (SELECT 1 FROM cryptocurrencies WHERE id = 'starknet');