# Donation Management System

## Description

The Donation Management System is a Java-based application designed to manage and track donations. It provides functionalities to add, view, delete, and iterate through donation records efficiently using a `TreeMap` for ordered storage.

## Installation

1. Ensure you have Java Development Kit (JDK) installed on your machine.
2. Clone the repository or download the source code.
3. Compile the Java files using a Java compiler:
   ```bash
   javac DonationData.java
   ```
4. Compile the Java files using a Java compiler:
	```bash 
	java DonationData
	```
## Usage

### Menu Options

1. Show the first donation: Displays the first donation in the records.
2. Next donation: Moves to the next donation and displays it.
3. Previous donation: Moves to the previous donation and displays it.
4. Show current donation: Displays the current donation.
5. Delete current donation: Deletes the current donation from the records.
6. Add a new donation: Prompts the user to add a new donation with specified details.
7. Print all donations: Prints all the donation records.

### Example Execution

1. Adding Donations

	```Java
	Donation donacion1 = registro.donationParse("15/04/2023;12345678N;ACN;ACN8455;15.50");
	registro.donationDataAdd(donacion1);
	
2. Deleting a Donation:

	```Java
	registro.donationDataDel("15/04/2023", "12345678N", "ACN8455");


## Methods Explained

- donationDataInit(): Initializes the TreeMap to store donations.
- donationParse(String formatoDonacion): Parses a formatted string to create a Donation object.
- donationDataAdd(Donation donacion): Adds a new donation to the TreeMap.
- donationDataGet(String codDonacion): Retrieves and prints a donation based on its project code.
- donationDataDel(String fecha, String documento, String codProyecto): Deletes a donation based on the provided details.
- imprimirTreeMap(TreeMap<String, Donation> Mapa): Prints all the entries in the TreeMap.
- crearRegistroDon(): Prompts the user to input donation details and returns a formatted string.
## Contributing

1. Fork the repository.
2. Create a new branch (git checkout -b feature/your-feature).
3. Commit your changes (git commit -am 'Add some feature').
4. Push to the branch (git push origin feature/your-feature).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

##Contact

For questions or comments, please reach out to [alvaro94cervantes@gmail.com].


