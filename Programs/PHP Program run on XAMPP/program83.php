<?php
$directory = "new_directory";

// Creating a directory
if (mkdir($directory)) {
    echo "Directory created successfully.\n";
} else {
    echo "Failed to create directory.\n";
}

// Deleting the directory
if (rmdir($directory)) {
    echo "Directory deleted successfully.\n";
} else {
    echo "Failed to delete directory.\n";
}
?>
