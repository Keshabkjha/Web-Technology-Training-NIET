<?php
$hostname = "localhost";
$username = "root";
$password = "";
$database = "crud";

// Create a connection
$conn = mysqli_connect($hostname, $username, $password, $database);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// CREATE - Insert a new record
if (isset($_POST['create'])) {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $dob = $_POST['dob'];

    $sql = "INSERT INTO users (name, email, dob) VALUES ('$name', '$email', '$dob')";

    if (mysqli_query($conn, $sql)) {
        echo "Record created successfully.";
    } else {
        echo "Error: " . mysqli_error($conn);
    }
}

// READ - Retrieve records
$result = mysqli_query($conn, "SELECT * FROM users");

// UPDATE - Update a record
if (isset($_POST['update'])) {
    $id = $_POST['id'];
    $newName = $_POST['new_name'];
    $newEmail = $_POST['new_email'];
    $newDob = $_POST['new_dob'];

    $sql = "UPDATE users SET name='$newName', email='$newEmail', dob='$newDob' WHERE id='$id'";

    if (mysqli_query($conn, $sql)) {
        echo "Record updated successfully.";
    } else {
        echo "Error: " . mysqli_error($conn);
    }
}

// DELETE - Delete a record
if (isset($_GET['delete'])) {
    $id = $_GET['delete'];

    $sql = "DELETE FROM users WHERE id='$id'";

    if (mysqli_query($conn, $sql)) {
        echo "Record deleted successfully.";
    } else {
        echo "Error: " . mysqli_error($conn);
    }
}

?>

<!DOCTYPE html>
<html>
<head>
    <title>CRUD Example</title>
</head>
<body>

<h2>Create a Record</h2>
<form method="POST">
    ID: <input type="text" name="id"><br>
    Name: <input type="text" name="name"><br>
    Email: <input type="text" name="email"><br>
    DOB: <input type="date" name="dob"><br>
    <input type="submit" name="create" value="Create">

</form>

<h2>Records</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>DOB</th>
        <th>Action</th>
    </tr>
    <?php
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>";
        echo "<td>" . $row['id'] . "</td>";
        echo "<td>" . $row['name'] . "</td>";
        echo "<td>" . $row['email'] . "</td>";
        echo "<td>" . $row['dob'] . "</td>";
        echo "<td><a href='?delete=" . $row['id'] . "'>Delete</a> | <a href='crud.php?id=" . $row['id'] . "'>Edit</a></td>";
        echo "</tr>";
    }
    ?>
</table>

</body>
</html>

