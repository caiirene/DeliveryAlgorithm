README for Java Task Manager Application
This Java application functions as a task manager, primarily designed to manage and optimize routes for delivery tasks using a Minimum Spanning Tree (MST) approach. It includes classes for managing tasks (App), handling map data (MyMap), and representing points or destinations (Point).

Prerequisites
Java Development Kit (JDK) - Make sure Java is installed on your machine. You can download it from the Oracle website.
Integrated Development Environment (IDE) - Any Java IDE like IntelliJ IDEA, Eclipse, or NetBeans.
Structure
App Class: Main controller of the application. It initializes the map, destinations, and route plan.
MyMap Class: Represents a custom map, storing all points and their distances.
Point Class: Represents a destination with coordinates and a name. It also manages connections to other points.
Main Class: The entry point of the application where the task manager is instantiated and operations are executed.
How to Run
Clone or Download the Code: Download the provided .java files to your local machine in the same directory.

Open in an IDE: Open the folder containing the files in your preferred Java IDE.

Build the Project: Use your IDE's build tool to compile the project.

Run the Application: Execute the Main class. This class contains the main method, the entry point of the Java application.

Using the Application
The application starts by creating an instance of the App class.
It then creates several Point instances representing different destinations.
These destinations are added to the task manager using addOneDestiny(Point newPoint).
The generateMST() method is called to generate a minimum spanning tree, optimizing the route.
Finally, generateRoute() creates the actual route plan based on the MST.
Customization
You can modify the destinations by changing the coordinates and names in the Main class.
The route planning logic can be altered by modifying the generateMST and generateRoute methods in the App class.
Note
Ensure all classes are in the same package if you are using package structure.
The application is a basic representation of a route planning system and can be extended for more complex functionalities.
Feel free to reach out if you have any questions or need further assistance with the application.
