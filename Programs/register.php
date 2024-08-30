<?php
// Database connection parameters
$servername = "localhost";
$username = "root"; // Change to your MySQL username
$password = "";     // Change to your MySQL password
$database = "registration"; // Change to your database name

// Create a connection
$conn = new mysqli($servername, $username, $password, $database);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve user input from the form
$name = $_POST['name'];
$father_name = $_POST['father_name'];
$email = $_POST['email'];
$password = $_POST['password'];
$dob = $_POST['dob'];
// password_hash($_POST['password'], PASSWORD_DEFAULT); // Hash the password


// Insert user data into the database
$sql = "INSERT INTO register
 (name, father_name, email, password,dob) VALUES ('$name', '$father_name', '$email', '$password', '$dob')";

if ($conn->query($sql) === TRUE) {
    echo "Registration successful";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
