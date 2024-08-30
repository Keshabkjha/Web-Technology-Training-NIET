
<!DOCTYPE html>
<html>
<head>     
    <title>Addition Program</title>
</head>
<body>
    <h2>Add Three Numbers</h2>
    <form method="post" action="">
        Enter the first number: <input type="text" name="num1"><br>
        Enter the second number: <input type="text" name="num2"><br>
        Enter Third number: <input type="text" name ="num3"><br>
        <input type="submit" name="submit" value="Add">
    </form>

    <?php
    // Check if the form has been submitted
    if (isset($_POST['submit'])) {
        // Retrieve the values of num1 and num2 from the form
        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];
        $num3 = $_POST['num3'];

        // Check if both values are numeric
        if (is_numeric($num1) && is_numeric($num2) && is_numeric($num3)) {
            // Calculate the sum
            $sum = $num1 + $num2 + $num3;
            echo "The sum of $num1,$num2 and $num3 is: $sum";
        } else {
            echo "Please enter valid numeric values for both numbers.";
        }
    }
    ?>
</body>
</html>