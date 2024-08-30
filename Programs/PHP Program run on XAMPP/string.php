<!DOCTYPE html>
<html>
<head>
    <title>String</title>
</head>
<body>
    <h2>String</h2>

    <?php
    // Creating a string
    $str = "This is String example";

    // Display the string
    echo "<p>Original String: $str</p>";

    // String Length
    $length = strlen($str);
    echo "<p>String Length: $length</p>";

    // Uppercase and Lowercase
    $uppercase = strtoupper($str);
    $lowercase = strtolower($str);
    echo "<p>Uppercase: $uppercase</p>";
    echo "<p>Lowercase: $lowercase</p>";

    // Substring
    $substring = substr($str, 0, 5); // Get the first 5 characters
    echo "<p>Substring (0-4): $substring</p>";

    // String Replace
    $newStr = str_replace("World", "PHP", $str);
    echo "<p>After Replacing 'World' with 'PHP': $newStr</p>";

    // String Concatenation
    $greeting = "Hello, ";
    $name = "Sumit";
    $fullGreeting = $greeting . $name;
    echo "<p>Concatenated String: $fullGreeting</p>";

    // String Splitting
    $csv = "apple,banana,cherry,date";
    $splitArray = explode(",", $csv);
    echo "<p>Split String: ";
    print_r($splitArray);
    echo "</p>";

    // Trimming Whitespace
    $text = "   This is a sentence with leading and trailing spaces.   ";
    $trimmedText = trim($text);
    echo "<p>Trimmed Text: '$trimmedText'</p>";

    // Checking if a string contains a substring
    $search = "Hello";
    if (strpos($str, $search) !== false) {
        echo "<p>'$search' found in the string.</p>";
    } else {
        echo "<p>'$search' not found in the string.</p>";
    }
    ?>
</body>
</html>
