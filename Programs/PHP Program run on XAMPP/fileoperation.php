<!DOCTYPE html>
<html>
<head>
    <title>Copying, Renaming and Deleting File</title>
</head>
<body>
    <h2>Copying, Renaming and Deleting File</h2>

    <?php
    // Define the source file and destination file paths
    $sourceFile = "source.txt";
    $destinationFile = "destination.txt"; 

    // Copying a file
    if (copy($sourceFile, $destinationFile)) {
        echo "<p>File '$sourceFile' has been successfully copied to '$destinationFile'.</p>";
    } else {
        echo "<p>Error: File copy failed.</p>";
    }

    // // Renaming a file
    // $newName = "renamed.txt";
    // if (rename($destinationFile, $newName)) {
    //     echo "<p>File '$destinationFile' has been successfully renamed to '$newName'.</p>";
    // } else {
    //     echo "<p>Error: File renaming failed.</p>";
    // }

    // // Deleting a file
    // if (unlink($newName)) {
    //     echo "<p>File '$newName' has been successfully deleted.</p>";
    // } else {
    //     echo "<p>Error: File deletion failed.</p>";
    // }
    // ?>

</body>
</html>
