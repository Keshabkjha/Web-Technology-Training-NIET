<!DOCTYPE html>
<html>
<head>
    <title>Operators and Expressions</title>
</head>
<body>
    <h2>Operators and Expressions</h2>

    <?php
    // Arithmetic Operators
    $num1 = 10;
    $num2 = 5;
    
    $addition = $num1 + $num2;
    $subtraction = $num1 - $num2;
    $multiplication = $num1 * $num2;
    $division = $num1 / $num2;
    $modulus = $num1 % $num2;
    
    echo "<p>Arithmetic Operators:</p>";
    echo "Addition: $addition<br>";
    echo "Subtraction: $subtraction<br>";
    echo "Multiplication: $multiplication<br>";
    echo "Division: $division<br>";
    echo "Modulus: $modulus<br>";

    // Comparison Operators
    $a = 10;
    $b = 5;
    
    $isEqual = ($a == $b);
    $isNotEqual = ($a != $b);
    $isGreaterThan = ($a > $b);
    $isLessThan = ($a < $b);
    
    echo "<p>Comparison Operators:</p>";
    echo "Equal: " . ($isEqual ? 'true' : 'false') . "<br>";
    echo "Not Equal: " . ($isNotEqual ? 'true' : 'false') . "<br>";
    echo "Greater Than: " . ($isGreaterThan ? 'true' : 'false') . "<br>";
    echo "Less Than: " . ($isLessThan ? 'true' : 'false') . "<br>";

    // Logical Operators
    $x = true;
    $y = false;
    
    $andResult = $x && $y;
    $orResult = $x || $y;
    $notResult = !$x;
    
    echo "<p>Logical Operators:</p>";
    echo "AND: " . ($andResult ? 'true' : 'false') . "<br>";
    echo "OR: " . ($orResult ? 'true' : 'false') . "<br>";
    echo "NOT: " . ($notResult ? 'true' : 'false') . "<br>";

    // Conditional (Ternary) Operator
    $age = 25;
    $isAdult = ($age >= 18) ? "Yes" : "No";
    
    echo "<p>Conditional (Ternary) Operator:</p>";
    echo "Is the person an adult? $isAdult<br>";

    // String Concatenation
    $firstName = "NIET,";
    $lastName = "Greater Noida";
    $fullName = $firstName . " " . $lastName;
    
    echo "<p>String Concatenation:</p>";
    echo "Full Name: $fullName<br>";
    ?>
</body>
</html>
