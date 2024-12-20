# Class-8 Shop Backend

---

## Project Overview

EasyShop is a backend API for an online shopping platform built with **Spring Boot** and connected to a **MySQL database**. The goal is to provide a fully functional e-commerce system that enables users to browse, search, and purchase products. This project is designed to extend the features of an existing e-commerce application, focusing on fixing bugs, enhancing functionality, and ensuring performance and security for a smooth online shopping experience.

---
## User Stories

### As a **User**:
- I want to browse products organized by category, so I can easily explore items that interest me.
- I want to filter products by price range, so I can shop within my budget.
- I want to search for products by color, so I can find items that match my style.
- I want the interface to be intuitive, so I can navigate through the system easily.

### As an **Owner**:
- I want to manage product categories, so I can keep my store's inventory organized.
- I want to manage products, so I can update product details, prices, or remove items as needed.
- I want to view the system's activity logs, so I can monitor and manage all operations.

### As a **Developer**:
- I want proper **user authentication** in the API, so I can secure the application and prevent unauthorized access.
- I want error messages to be meaningful, so I can easily debug and fix issues.
- I want the codebase to be modular and maintainable, so I can extend or modify features easily.
- 
## Features

### ✅ **Core Features**
- **User Authentication**: Users can register, log in, and manage their profiles securely.
- **Product Browsing**: Users can view products categorized by type, color, and price range.
- **Search Functionality**: Users can search for products based on filters like category, price range, or color.
- **Admin Controls**: Admin users can manage product categories and products with full CRUD functionality.

### 🐞 **Bug Fixes**
- Fixed issues with product filtering by category, price, and color.
- Resolved problems related to updating and duplicating products in the inventory.

### ✨ **New Features**
- **Category Management**: Admins can create, update, and delete product categories.
- **Product Management**: Admins can add, modify, or remove products from the inventory.
- **User Profiles**: Users can view and update their profiles after logging in.
- **Error Handling**: More descriptive and user-friendly error messages to improve debugging and user experience.

---

## 📂 Project Structure

- `src/`: Contains the core application code.
    - `controllers/`: Handles requests and responses.
    - `models/`: Data models for the database.
    - `services/`: Business logic for the application.
    - `repositories/`: Interfaces for database interaction.
- `application.properties`: Configuration file for database connection and other settings.

---

## 🛠️ Technologies

### **Framework & Tools**
- **Backend**: Spring Boot
- **Database**: MySQL Workbench
- **API Testing**: Postman & JUnit
- **API Authorization**: JWT (JSON Web Token)

---
## Demo
- No duplicates
![SCS.png](imgs%2FSCS.png)
- Filtering by color and Price
![SCS2.png](imgs%2FSCS2.png)
- Postman test passed
![3.png](imgs%2F3.png)

## How to Run

### Prerequisites
- **IntelliJ IDEA**: Make sure IntelliJ IDEA is installed.
- **Java SDK**: Ensure you have Java SDK 17 or higher.
- **MySQL**: A MySQL database is required for persistence.

### Running the Application
1. Clone the repository to your local machine.
2. Open the project in **IntelliJ IDEA**.
3. Configure your database connection in `application.properties`.
4. Run the application by right-clicking on `EasyShopApplication.main()` and selecting **Run**.

---

## Future Enhancements
- Develop the front-end to integrate with the backend API for a complete shopping experience.
- Implement a **cart** and **checkout** system to allow users to purchase products.
- Add **order tracking** features so users can track the status of their purchases.
- Expand user authentication by adding role-based access control for better security.

---

## Resources

- **Skeleton code** provided by Raymond
- **Stack Overflow** and **w3schools** for troubleshooting
- A healthy dose of **caffeine** to keep the code flowing

---

## Acknowledgements

Special thanks to:

- **Raymond** (Aspect of Taters) for constant guidance and support.
- **Aaron** and **Corrie** for their patience as I navigated through challenges in Life.

---

## Links

- [🔗 Front-End Repository](https://github.com/albacarmen/Frontendshop.git)

