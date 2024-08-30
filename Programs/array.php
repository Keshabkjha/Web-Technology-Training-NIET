<!DOCTYPE html>
<html>
<head>
    <title>PHP Array Example</title>
</head>
<body>
    <h2>PHP Array Example</h2>

    <?php
    // Creating an indexed array
    $fruits = array("Apple", "Banana", "Cherry", "Date");
    // Display the contents of the array
    echo "<p>Indexed Array:</p>";
    echo "<pre>";
    print_r($fruits);
    echo "</pre>";

    // Accessing elements in an indexed array
    echo "<p>Accessing elements:</p>";
    echo "Element at index 1: " . $fruits[1] . "<br>";
    echo "Element at index 3: " . $fruits[3] . "<br>";

    // Adding an element to the end of an array
    $fruits[] = "Fig";

    echo "<p>After adding 'Fig':</p>";
    echo "<pre>";
    print_r($fruits);
    echo "</pre>";

    // Creating an associative array
    $person = array("name" => "Anil", "branch" => "CSE", "college" => "NIET");

    echo "<p>Associative Array:</p>";
    echo "<pre>";
    print_r($person);
    echo "</pre>";

    // Accessing elements in an associative array
    echo "<p>Accessing elements:</p>";
    echo "Name: " . $person["name"] . "<br>";
    echo "Branch: " . $person["branch"] . "<br>";
    echo "College: " . $person["college"] . "<br>";

    // Check if a key exists in an associative array
    $keyToCheck = "email";
    if (array_key_exists($keyToCheck, $person)) {
        echo "Key '$keyToCheck' exists in the array.<br>";
    } else {
        echo "Key '$keyToCheck' does not exist in the array.<br>";
    }

    // Removing an element from an associative array
    unset($person["college"]);

    echo "<p>After removing 'college':</p>";
    echo "<pre>";
    print_r($person);
    echo "</pre>";

    // Counting the number of elements in an array
    echo "<p>Count of elements in 'fruits': " . count($fruits) . "</p>";

    // Sorting an indexed array
    sort($fruits);

    echo "<p>After sorting 'fruits':</p>";
    echo "<pre>";
    print_r($fruits);
    echo "</pre>";
    ?>

</body>
</html>
