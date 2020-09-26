# **Restaurant Management System**

## **Aim of the Project**

The aim of the project is to make a simple Restaurant Management System, that would include the following features:

* A database to hold information about staff, menu items and orders.
* A means of authentication for the staff and displaying staff information.
* A means of viewing the menu.
* A means of viewing current orders and arranging them on the basis of priority.
* A means of placing new orders.
* A means of generating order receipt.

## **Prerequisites**

The project can be followed by anyone who is interested, but a basic knowledge in the following departments would help:

* Basic knowledge of some high-level programming language like Java,C++ or Python.
* Basic understanding of databases and how to work with them. (Preferably Structured Query Language or SQL)
* Basic understanding of Graphical User Interface(GUI) programming in any of the high-level programming languages.(Not mandatory)

## **Codebase Used**

Our version of the project uses **MySql** and **Java** to make the project, but the instructions for the project will be language independent. So it can be replicated using any programming language of your choice and isn't restricted to a particular codebase.

## **Initial Setup**

Following are instructions for installing **Java** and **MySql** on different platforms, so feel free to skip this section if you want to use a separate codebase. You will also need an IDE(Integrated Development Environment) to build the project. In our case, we chose the NetBeans IDE, but any other Java IDE like Eclipse or IntelliJ IDEA would suffice.

### **Installing Java**

* Head over to <https://www.oracle.com/in/java/technologies/javase-downloads.html> to download the Java Standard Edition.
* Choose the latest LTS version(currently it is Java SE 11), and click on JDK download.
* This will take us directly to the available installers for different Operating Systems. Choose the appropriate installer for your OS(.exe for Windows, .deb for Debian based Linux Systems and .dmg for macOS) and click to download.
* Once downloaded, proceed through the wizard and complete the installation and add the JDK path to the list of environment variables. If you have any issues with installation, you can always refer to the documentation and install instructions provided with the JDK version.

**Note:** You can also download the latest JDK(openjdk-11) from the APT package manager on Linux systems by executing the following commands on the terminal in the given sequence:

```shell
sudo apt update
sudo apt install default-jre
sudo apt install default-jdk
```

### **Installing MySql**

Head over to <https://dev.mysql.com/doc/mysql-getting-started/en/#mysql-getting-started-installing> and follow the install instructions for the appropriate OS.

For connecting to our local mysql database, you will also need to install the Connector/J JAR. You can download the zip file [here](https://dev.mysql.com/downloads/connector/j/5.1.html). After unzipping, add the jar to the list of external libraries for the project using the IDE tools.

### **Installing the IDE**

Head over to <https://netbeans.org/> to download the Apache NetBeans IDE.

## **The Project**

This section contains detailed instructions on how to make a working Restaurant Management System application, with little emphasis on platform-specific implementation.

### **Setting up the Database**

The database scheme chosen for the project depends entirely on the discretion of the developer, but we used SQL to store information. SQL stands for Structured Query Language. It is a database query language used for storing and manipulating data in Relational DBMS(Database Management Systems). The data is stored in the form of tables, where the columns represent the categories of the data being represented and the rows represent individual data items. The database is manipulated using a list of commands (SELECT, UPDATE, DELETE, INSERT, WHERE to name a few). You can learn more about SQL, [here](https://www.w3schools.com/sql/default.asp).

Start off by creating a separate database for the restaurant management system. You can name the database anything, for instance rms. In order to create a new database in **MySql**, type in the following command:

```sql
CREATE DATABASE <database name>;
```

To ensure that the database has been successfully created, type:

```sql
SHOW DATABASES;
```

It should list out the existing databases.

To use a particular database for storing information, type in the following:

```sql
USE DATABASE <database name>;
```

### **The Staff**

To store information about the staff, you need to create a separate table. A proper model for the Staff should include the following fields:

* A column for the **name**.
* A column for the **age**.
* A column for the **salary**.
* A column for the **password**. (Required for authentication)
* A column for the **salt**. (Referring to the process of salting a password before hashing, to make it hard to crack)

The first three fields are for reference inside the application. The fields **password** and **salt** will only be required during authentication. For added security, a hashing algorithm called SHA-512 is used to conceal the password and make it appear like gibberish in case information is compromised. Hashing algorithms are a common way to encrypt passwords and there are much more secure ones out there(PKDF2, BCrypt and so on). However, you can stick to SHA-512 as it suits our purpose without over-complicating the code and most high-level programming languages have it included in their libraries for encrypting code, so no need to reinvent the wheel.

If you want to know more about data encryption using SHA, head [here](https://brilliant.org/wiki/secure-hashing-algorithms/).

Tables in SQL are created as follows:

```sql
CREATE TABLE <table name>
(
 <column 1> <datatype>,
 <column 2> <datatype>,
 ...
 ...
 <column n> <datatype>
 PRIMARY KEY (<column name>),
);
```

The field for the `PRIMARY KEY` identifies all the data items uniquely and is supposed to be different for different rows.

Read more about table creation using SQL, [here](https://www.w3schools.com/sql/sql_create_table.asp).

After creating the database, you have to insert information into the table. Though the SQL keyword `INSERT` can be used here, encrypting all passwords before inserting is cumbersome and we need to come up with a better solution. For this purpose, we will need to write some code. Using the Object-Oriented approach helps as we can store and manipulate information better by creating a [class](https://en.wikipedia.org/wiki/Class_(computer_programming)) with some fields for the **name**,**age** and **salary** and some [functions](https://www.tutorialspoint.com/computer_programming/computer_programming_functions.htm) for this purpose. Make sure that password is not a field as we will only be storing that within the database.

This class can have a function called `registerStaff` which can take in the parameters name,age,salary and password and store them in the database. The pseudocode for the above operation will look something like this:

```java
registerStaff(name,age,salary,password){

    // Connecting to database
    connectToDatabase()

    // Generating random salt for added security
    salt = generateRandomSalt()

    // Encrypting password
    encPass = encryptPassword(salt,password)

    // Inserting information to database
    insertIntoDatabase(name,age,salary,salt,password)

}
```

Generation of a random salt can be achieved through a function for creating a [String](https://en.wikipedia.org/wiki/String_(computer_science)) with random alphanumeric characters. For help implementing in **Java**, refer [here](https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/).

For connecting to **MySql** database using **Java**, refer [here](https://www.tutorialspoint.com/connecting-to-a-mysql-database-with-java).

For inserting data into **MySql** database using **Java**, refer [here](https://www.tutorialspoint.com/how-to-insert-data-into-a-mysql-database-with-java).

Apart from registering users, there should also be a means for users to log in, so writing a `loginStaff` function is essential. You can also add a function for fetching all staff information for displaying in the application.

### **The Menu Items**

After setting up the staff database, the next element of focus should be the menu. The most important fields required for a menu database are the **name** and **price** of food items. Providing the items with a unique **id** helps in identification as you will see later. Apart from the fields mentioned, there are two more fields associated with each item, that will help in determining the priority of orders. These are the so called **tpp** and **nppt** fields, which represent the time to prepare a certain number of plates and the number of plates that can be prepared at the same time, respectively.

Once you have decided on the fields, go ahead and create a table for menu items and insert data in the following manner:

```sql
INSERT INTO <table name> (<column 1>,<column 2>,...,<column n>) VALUES (<value 1>,<value 2>,...,<value n>);
```

You can get a tabulated view of all the menu items you added, on typing:

```sql
SELECT * FROM <table name>;
```

The `*` in the above SQL query refers to all the data items present in the table. This is the go to command when you want to list out all the rows in a table.

Once the database is up and running, you should write a **Java** `class` for representing menu items and a set of functions for processing information received from the database. Along with the fields present in the menu database, an essential field would also be the quantity of a particular menu item in the order. Since this is a variable quantity, we are not going to store this in the database and will fetch it only from the order details. Some important functions for processing information would be displaying menu items, fetching a list of all menu items, getting information about an item with a certain **id**, and so on.

### **The Orders**

The most essential part of any restaurant management system is the proper tracking and processing of orders. Just like the staff and menu, you will also need a table for storing information related to current orders. An order should probably have the following fields:

* A unique order **id**.
* The time of placing the order.
* The contents and specifics of the order.

The datatypes for the first two fields are easy to decide. However, the menu items for an order are supposed to be part of a list. SQL does not provide a datatype for storing a list of [objects](https://en.wikipedia.org/wiki/Object_(computer_science)), so you'll need to find a workaround. One strategy that we chose is to store the items in `String` variable, while adhering to a certain format.

The format used here consists of the **id** of the menu item under consideration and the quantity of that menu item. The format is as follows:

**id 1**:**qty 1**,**id 2**:**qty 2**,...,**id n**:**qty n**,

where **qty** represents quantity.

This provides us a simple yet comprehensive solution to our problem and information about the orders can be extracted from the given `String`. Head [here](https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html) to learn how to extract tokens from a `String` in **Java**.

After creating the database, similar to the other [model](https://en.wikipedia.org/wiki/Data_model) `classes` for manipulating data, you will need to create a class for orders. The model for orders, as mentioned before should contain a unique **id**, a field for storing the time of placement of orders(say **timePlaced**), and a list of menu items(say **items**). The **Order** `class` should contain some methods for displaying order related details, processing orders from the database, and getting the list of all current orders. It should also have the means to add or remove an order.

Now you need to implement the most crucial part of the project, i.e. arranging the orders on the basis of priority, so that none of the customers leave dissatisfied for having to wait too long. For this purpose, use of a suitable algorithm and data structure is of utmost importance. Looking at the problem statement, it is easy to identify that the most suitable approach would be to use a [Priority Queue](https://en.wikipedia.org/wiki/Priority_queue).

A Queue is a very popular and frequently used ADT(Abstract Data Type) which is used to store data. It resembles a real-world queue where the first piece of data inserted is the first one to be invoked and served, i.e. it follows the FIFO(First In First Out) approach. A Priority Queue is a special type of Queue which is used to arrange and serve up data based on their priority. The criteria for priority can be absolutely any quantity that can be compared. Generally, Priority Queues use the [heap](https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/) data structure for storing information, which typically requires O(log n) time for insertion and [sorting](https://en.wikipedia.org/wiki/Sorting_algorithm) and O(1) time for pulling elements. The above notation used is called the [Big-O Notation](https://en.wikipedia.org/wiki/Big_O_notation) and is a common means to express the complexity of algorithms. There are various implementations of Priority Queues depending on specialized heaps and most high-level programming languages have libraries that provide their own efficient implementation of a Priority Queue.

The library implementation of a Priority Queue can be modified to one's desire using something called a `Comparator` function. The pseudocode for the project's purpose would look something like this:

```java
int compare(Order o1, Order o2){

    if(o1.priority > o2.priority)
        return -1 // Represents a position of higher priority.
    else if(o1.priority < o2.priority)
        return 1 // Represents a position of lower priority.
    return 0 // In the case of equal priority, the order inserted earlier has greater preference.

}
```

To learn how Priority Queues using `Comparator` functions work in **Java**, click [here](https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/).

Now you need to decide what constitutes as priority for the orders. In our case, we used the following simple idea:

The priority of a particular order is calculated as the sum of the amount of time that has passed since the order was placed and the amount of time required to prepare the menu items in the order, based on their quantity, and the fields **tpp** and **nppt** we mentioned earlier.

The scheme for priority depends entirely on the developers' intuition of the problem and can be refined further to make it more efficient.

### **Putting it Together**

Now that all the screws are in place, the only thing left to implement is the user interface. A simple CLI(Command Line Interface) would address the following aspects:

* A login function, that would enable the staff to authenticate.

* A menu-driven interface, that would provide the staff with a variety of options including but not limited to:
  
  * An option to view staff information.

  * An option to view the menu.

  * An option to view current orders and print an order receipt.

  * An option to add/remove orders.

The menu-driven interface can be best achieved through a [switch-case](https://en.wikipedia.org/wiki/Switch_statement) construct. If you've followed the guide in proper order, all these functions are already present in the existing `classes`, so all you need to do is to invoke them to serve their proper purpose. The `main` function in **Java** serves as the starting point of the application and hence, the code for the CLI should be written here.

### **Setting up the Graphical User Interface**

As mentioned earlier, the GUI(Graphical User Interface) is not a necessity and even a CLI would have worked. However, to make it easier for the user to interact with a piece of software is an essential concern, which is why this project includes a Graphical Interface.

We have used the **NetBeans GUI builder**, which makes it easy to build complicated UI, by handling the code behind the placement of the components on screen in the background, while all we need to worry about is where to place a component and what functionality to add to it.

The following section outlines the steps necessary for building UI using the **NetBeans GUI builder**:

#### **The Basics**

In order to build a GUI using **Java**, it is essential to know the basics of what the GUI will comprise. The most fundamental part of building any GUI is to have a window for your application. To create window in **Java**, you need to make use of the `JFrame` class, which is present in the `javax.swing` package. The `javax.swing` package contains many such classes that help in building UI elements, as you'll see as we explain further. Once a window has been created, a `JPanel` is used to cover the entire area of the window. What this means is that the `JPanel` serves as a container for the UI elements to be added, so we essentially add the `JPanel` to the `JFrame` using the `add` method(Not going further into implementation details, as this code generation will be automated). The other frequently used components provided by the `javax.swing` package comprise `JLabel`, `JButton`, `JTextField`, `JList`, `JTable` and many more. Most of these components have mnemonic names, so it is easier to understand what purpose they serve and we will be explaining the ones used by us. For more on **Java Swing**, visit <https://docs.oracle.com/javase/tutorial/uiswing/index.html>.

## **Conclusion**

You should have a fairly capable Restaurant Management System application by the end of the guide. You can always improve the features mentioned in the guide, to tweak it to your own satisfaction. Hope you found this insightful and be sure to leave an honest feedback.
