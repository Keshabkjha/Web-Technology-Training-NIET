<!DOCTYPE html>
<html>
<head>
    <title>File Handling (Open & Close)</title>
</head>
<body>
    <h2>File Handling (Open & Close)</h2>

    <?php
    // Define the file name
    $filename = "mynewfile.txt";

    // Opening a file for writing (creates the file if it doesn't exist)
    $file = fopen($filename, "w");
    // Check if the file was successfully opened
    if ($file) {
        // Write content to the file
        $content = "Hi, I have written content in this file.\n";
        fwrite($file, $content);
        // Close the file
        fclose($file);
        echo "<p>File '$filename' has been successfully written and closed.</p>";
    } else {
        echo "<p>Error: Unable to open the file for writing.</p>";
    }

    // Opening a file for reading
    $file = fopen($filename, "r");

    // Check if the file was successfully opened
    if ($file) {
        // Read and display the file contents
        echo "<p>File Contents:</p>";
        while (!feof($file)) {
            echo fgets($file);
        }

        // Close the file
        fclose($file);
    } else {
        echo "<p>Error: Unable to open the file for reading.</p>";
    }
    ?>

</body>
</html>
