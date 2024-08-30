<!DOCTYPE html>
<html>
<head>
    <title>PHP Do-While Loop Example</title>
</head>
<body>
    <h2>PHP Do-While Loop Example</h2>

    <?php
    // Using a do-while loop to count from 1 to 10
    echo "<p>Counting from 1 to 10:</p>";
    echo "<ul>";
    $i = 1;
    do {
        echo "<li>$i</li>";
        $i++;
    } while ($i <= 10);
    echo "</ul>";
    ?>

</body>
</html>
