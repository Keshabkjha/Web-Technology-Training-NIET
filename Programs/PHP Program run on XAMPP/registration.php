<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h2>Registration Form</h2>
    <form action="register.php" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br>

        <label for="father_name">Father's Name:</label>
        <input type="text" name="father_name" required><br>

        <label for="email">Email:</label>
        <input type="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br>

        <label for="dob">DOB:</label>
        <input type="date" name="dob" required><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
