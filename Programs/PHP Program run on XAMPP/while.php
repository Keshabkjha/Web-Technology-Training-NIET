<!DOCTYPE html>
<html>
<head>
    <title>PHP While Loop Example</title>
</head>
<body>
    <h2>PHP While Loop Example</h2>

    <?php
    // Using a while loop to count from 1 to 10
    echo "<p>Counting from 1 to 10:</p>";
    echo "<ul>";
    $i = 1;
    while ($i <= 10) {
        echo "<li>$i</li>";
        $i++;
    }
    echo "</ul>";
    ?>

</body>
</html>
