package com.wizion.androidarchitecturecomponentsandjetpack.database

class Definations {
    /**
     * What is SQLite Database?
     * SQLite is a built-in database engine for Android that allows you to store and manage structured data within your app. It uses SQL queries and offers CRUD operations. SQLite is lightweight, persistent, and doesn't require a separate server. It's easy to integrate with Android using the SQLiteOpenHelper class. Overall, SQLite provides a reliable and efficient solution for storing and retrieving data in Android applications.
     *
     * What is Room Database?
     * Room is a powerful persistence library provided by the Android Jetpack architecture components. It is  designed to simplify and streamline the process of working with a SQLite database in Android applications. Room provides an abstraction layer over SQLite, allowing you to work with objects and annotations instead of raw SQL queries.

    Here are the key components of Room and their functionalities:

    1.Entity: An entity represents a table in the database. It is a Java or Kotlin class annotated with @Entity that defines the schema of the table. Each entity corresponds to a row in the table, and each field in the entity class represents a column in the table.

    2.DAO (Data Access Object): The DAO is an interface annotated with @Dao that defines the database operations you can perform. It provides methods for inserting, updating, deleting, and querying the data stored in the database. You write these methods using annotations such as @Insert, @Update, @Delete, and @Query.

    3.Database: The database class is an abstract class annotated with @Database that serves as the main access point to the underlying SQLite database. It defines the entities and their relationships, and provides methods to obtain DAO instances. The database class is responsible for creating and managing the database.

    To use Room in your Android app, you need to perform the following steps:

    1.Define the Entity: Create a class representing your data with the necessary fields and annotate it with @Entity. Each field represents a column in the corresponding table.

    2.Create the DAO: Define an interface annotated with @Dao. Declare the methods to perform database operations, such as inserting, updating, deleting, and querying data. Annotate each method with the appropriate annotations like @Insert, @Update, @Delete, or @Query.

    3.Build the Database: Create an abstract class annotated with @Database. Define the entities and their relationships within this class. Specify the database version and migration strategy. This class will act as the entry point to your database.

    4.Obtain a Database Instance: Use the Room.databaseBuilder() method to obtain an instance of the database by passing the application context, the database class you created, and the database name. You can then access the DAO and perform database operations.

    By using Room, you can easily handle common database tasks, such as creating tables, executing queries, and managing data persistence. Room also provides compile-time checks and validations to help catch errors early in the development process.
     *
     *
     * Difference between SQLite Database and Room Database.
     * SQLite and Room are both database solutions for Android, but they differ in terms of their level of abstraction and the features they provide. Here are the key differences between SQLite and Room:

    1.Abstraction Level:
    ->SQLite: SQLite is a low-level database engine that directly interacts with the underlying database file. It requires writing raw SQL queries to perform database operations.

    ->Room: Room is a higher-level abstraction built on top of SQLite. It provides an object-relational mapping (ORM) approach, allowing you to work with objects and annotations instead of raw SQL queries.

    2.SQL Queries:
    ->SQLite: With SQLite, you have full control over writing and executing SQL queries. You write and manage your own queries to perform CRUD (Create, Read, Update, Delete) operations on the database.

    ->Room: Room eliminates the need for writing complex SQL queries by providing a set of annotations that generate the necessary SQL code. It uses compile-time checks to validate queries and provides type-safe queries using annotations like @Query.

    3.Code Generation:
    ->SQLite: SQLite does not provide code generation. You have to manually write SQL queries and manage the mapping between objects and database tables.

    ->Room: Room generates boilerplate code for you based on annotations in your entity and DAO classes. It automatically generates the necessary code for creating, updating, and querying the database, reducing the amount of manual coding required.

    4.Object-Relational Mapping (ORM):
    ->SQLite: SQLite does not provide built-in support for object-relational mapping. You need to manually map the data between your Java or Kotlin objects and the database tables.

    ->Room: Room includes built-in support for object-relational mapping. It maps your entity classes to database tables automatically, eliminating the need for manual mapping. Room also supports relationships between entities, making it easier to work with complex data structures.

    5.Database Operations:
    ->SQLite: In SQLite, you have to manage database operations manually, including handling transactions, managing connections, and handling database upgrades.

    ->Room: Room simplifies database operations by providing built-in support for common tasks like inserting, updating, deleting, and querying data. It handles database transactions and connection management for you. Additionally, Room provides support for database migrations when the schema needs to be changed.

    In summary, SQLite is a low-level database engine that requires writing raw SQL queries and manual mapping between objects and tables. Room, on the other hand, is a higher-level abstraction that provides an ORM approach, automatic code generation, and simplified database operations. Room makes it easier and more efficient to work with databases in Android applications, reducing the amount of boilerplate code and providing compile-time checks for query correctness.
     */

}