<!DOCTYPE html>
<html>
<head>
    <title>Directory Operations</title>
</head>
<body>
    <h2>Directory Operations</h2>

    <?php
    // Define the directory name
    $directoryName = "My_Folder";

    // Creating a directory
    if (!is_dir($directoryName)) {
        mkdir($directoryName);
        echo "<p>Folder '$directoryName' has been successfully created.</p>";
    } else {
        echo "<p>Folder '$directoryName' already exists.</p>";
    }

    // Listing the contents of the directory
    echo "<p>Contents of directory '$directoryName':</p>";
    if (is_dir($directoryName)) {
        $contents = scandir($directoryName);
        foreach ($contents as $item) {
            if ($item != "." && $item != "..") {
                echo $item . "<br>";
            }
        }
    } else {
        echo "<p>Directory '$directoryName' does not exist.</p>";
    }

    // // Deleting the directory
    // if (is_dir($directoryName)) {
    //     rmdir($directoryName);
    //     echo "<p>Directory '$directoryName' has been successfully deleted.</p>";
    // } else {
    //     echo "<p>Directory '$directoryName' does not exist.</p>";
    // }
    // ?>

</body>
</html>
