# Invoice Generator

This programme aims to help a restaurant keep track of meal orders and distribute them accordingly. It is a console-based application developed for `Food Quick` (a fictitious company). The system helps manage food delivery orders by tracking customer details, order information and driver assignments. It generates detailed invoices for each order and is built with robust error handling and clean code practices.

## Table of Contents

- [Features](#features)
- [Dialogue: Company Requirements vs. Implementation](#dialogue-company-requirements-vs-implementation)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Code Review & Highlights](#code-review--highlights)
- [Contributing](#contributing)
- [Credits](#credits)

## Features

- **Order Management**: Efficiently manage customer orders, including details of meals ordered and special instructions.
- **Invoice Generation**: Automatically generate and save invoices in a specified format.
- **Driver Assignment**: Assign the nearest available driver to deliver the order.
- **Robust Error Handling**: Incorporates multiple try-catch blocks for handling exceptions.
- **Code Quality**: Well-organised, readable code adhering to standard naming conventions and formatting.

## Dialogue: Company Requirements vs. Implementation

**Food Quick:** "We need a system to manage food delivery orders, storing detailed customer, order and driver information."

**Jediah:** "The Invoice Generator system includes comprehensive data management for customers, orders and drivers. It captures all necessary details and ensures seamless operation."

**Food Quick:** "We also need to generate invoices for each order, detailing customer and order information."

**Jediah:** "The system generates invoices in the following format, saved as text files:"

```txt
Order number: 1234
Customer: Jill Jack
Email: jilljack@yahoo.com
Phone number: 123 456 7890
Location: Cape Town

You have ordered the following from Aesop’s Pizza in Cape Town:

1 x Pepperoni pizza (R78.00)
2 x Hawaiian pizza (R82.00)

Special instructions: Extra tomato base on the Pepperoni pizza
Total: R242.00

John Krill is nearest to the restaurant and so he will be delivering your order to you at:
Address: 12 Cherry Road, Plumstead
Restaurant contact: 098 765 4321
```

**Food Quick:** "We want to ensure the application is robust, with proper error handling and adherence to coding standards."

**Jediah:** "I've implemented multiple try-catch blocks for error handling and refactored the code for clarity and efficiency. The project follows the prescribed naming conventions and formatting guidelines."

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or later
- Docker (optional, for containerisation)

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/jediahjireh/invoice-generator.git
   cd invoice-generator
   ```

2. Build the project (optional, if not using Docker):
   ```sh
   javac *.java
   ```

### Running the Application

#### Using Docker

1. Build the Docker image:

   ```sh
   docker build -t invoice-generator .
   ```

2. Run the Docker container:
   ```sh
   docker run -it --rm invoice-generator
   ```

#### Without Docker

1. Compile the Java files:

   ```sh
   javac *.java
   ```

2. Run the application:
   ```sh
   java InvoiceGenerator
   ```

## Project Structure

- **[Customer.java](/src/Customer.java)**: Manages customer information and order details, including meal names, quantities and prices.
- **[InputValidation.java](/src/InputValidation.java)**: Validates user input for accuracy and consistency.
- **[InvoiceGenerator.java](/src/InvoiceGenerator.java)**: Main class responsible for creating customer and restaurant objects, determining the nearest driver and generating invoices.
- **[Order.java](/src/Order.java)**: Base class for storing basic order information like name, location and contact number.
- **[Restaurant.java](/src/Restaurant.java)**: Subclass of [Order](/src/Order.java) representing restaurant details.
- **[driver-info.txt](/src/driver-info.txt)**: Text file containing driver information, including location and delivery load.

## Usage

1. Input customer and order details as prompted.
2. The system calculates the total amount and generates an invoice, saved in `src/invoice.txt`.
3. If no drivers are available in the customer's location, the system notifies the user.

### Code Review & Highlights

- **Efficient Data Management:** The use of appropriate data structures ensures efficient handling of customer, order and driver information.
- **Exception Handling:** The inclusion of try-catch blocks demonstrates a proactive approach to managing potential runtime errors.
- **Clean Code:** The code is well-organised, with clear naming conventions and consistent formatting, enhancing readability and maintainability. Modular code, coupled with descriptive comments, is easy to read, debug, reuse and maintain.
- **Scalable Design:** The modular structure of the classes and methods supports easy expansion and future enhancements.
- **Diverse Skill Set:** The project showcases proficiency in Java programming, including file handling, input validation and user interaction.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue to discuss your ideas.

## Credits

Project created by: [Jediah Jireh Naicker](https://github.com/jediahjireh)

Feel free to reach out to me at [jediahnaicker@gmail.com](mailto:jediahnaicker@gmail.com) for inquiries.
Happy Coding!
