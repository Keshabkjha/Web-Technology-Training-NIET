<?php
$sourceFile = "source.txt";
$renamedFile = "renamed.txt";
$destinationFile = "copy.txt";


// Copying the file
if (copy($sourceFile, $destinationFile)) {
    echo "File copied successfully.\n";
} else {
    echo "Failed to copy the file.\n";
}

// Renaming the file
if (rename($destinationFile, $renamedFile)) {
    echo "File renamed successfully.\n";
} else {
    echo "Failed to rename the file.\n";
}

// Deleting the file
if (unlink($renamedFile)) {
    echo "File deleted successfully.\n";
} else {
    echo "Failed to delete the file.\n";
}
?>
