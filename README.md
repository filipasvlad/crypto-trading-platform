# Crypto Trading Platform

## Overview

The **Crypto Trading Platform** is a backend service designed to enable users to manage their cryptocurrency portfolio and perform transactions such as buying, selling, and tracking their crypto holdings. The platform exposes a set of **RESTful APIs** that can be integrated into a **web frontend** or **mobile application**.

The application is built with **Spring Boot** and uses **PostgreSQL** as the database to store user data, cryptocurrency information, transaction history, and portfolio details.

## Features

- **User Authentication**: Secure user registration and login functionality.
- **Balance Management**: Users can add or withdraw funds from their balance.
- **Crypto Management**: View available cryptocurrencies, their current prices, and manage portfolio items.
- **Transaction Handling**: Buy and sell cryptocurrencies, with transaction records available.
- **Portfolio Management**: Add or remove cryptocurrencies from the user’s portfolio.

## Technologies Used

- **Spring Boot** - Backend framework for building the REST API.
- **Spring Security** - For user authentication and authorization.
- **JPA/Hibernate** - ORM for interacting with the PostgreSQL database.
- **PostgreSQL** - Database for storing user data, transactions, and portfolio information.
- **DTOs (Data Transfer Objects)** - Used to ensure consistency and separation of concerns in data handling.
- **RESTful APIs** - Facilitates communication between the backend and frontend applications.

## API Endpoints

The platform provides several RESTful endpoints for various actions. Below is a summary of the available controllers:

### 1. **Balance Controller** (`/balance`)
Handles balance-related operations.

- `GET /balance`: Retrieve current balance.
- `POST /balance/add`: Add funds to the balance.
  - **Parameters**: `amount` (Double)
- `POST /balance/withdraw`: Withdraw funds from the balance.
  - **Parameters**: `amount` (Double)

### 2. **CryptoCurrency Controller** (`/crypto`)
Manages operations related to cryptocurrencies.

- `GET /crypto`: Get all available cryptocurrencies.
- `GET /crypto/price/{symbol}`: Get the current price of a specific cryptocurrency.
  - **Parameters**: `symbol` (String)

### 3. **Portfolio Controller** (`/portfolio`)
Manages the user’s portfolio.

- `GET /portfolio`: Get all portfolio items for the logged-in user.
- `POST /portfolio/add`: Add cryptocurrency to the portfolio.
  - **Parameters**: `cryptoCurrencyId` (String), `quantity` (Double)
- `POST /portfolio/remove`: Remove cryptocurrency from the portfolio.
  - **Parameters**: `cryptoCurrencyId` (String), `quantity` (Double)

### 4. **Transaction Controller** (`/transaction`)
Handles buy and sell transactions.

- `GET /transaction`: Get all transactions.
- `POST /transaction/buy`: Buy cryptocurrency.
  - **Parameters**: `cryptoCurrencyId` (String), `quantity` (Double)
- `POST /transaction/sell`: Sell cryptocurrency.
  - **Parameters**: `cryptoCurrencyId` (String), `quantity` (Double)

### 5. **User Controller** (`/auth`)
Manages user authentication.

- `POST /auth/register`: Register a new user.
  - **Request Body**: `UserRegisterDto` (contains username, password, email, etc.)
- `POST /auth/login`: Login and authenticate an existing user.
  - **Request Body**: `UserLoginDto` (contains username and password)

## Security

- **JWT Authentication** is used for securing API endpoints, ensuring that only authenticated users can access certain resources like balance or portfolio.
- The backend uses **Spring Security** to manage authentication and authorization.

## Database Initialization

The application automatically creates necessary tables and relationships upon the first run. Predefined cryptocurrencies can be added to the database using a custom SQL script. The application ensures that cryptocurrencies are inserted only if they do not already exist in the database.

---

**Contact**

For any questions, feel free to reach out to [your_email@example.com].
