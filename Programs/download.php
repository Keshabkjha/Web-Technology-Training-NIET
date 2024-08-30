<?php
// Specify the directory where uploaded files are stored
$uploadDirectory = 'upload/';

// Check if the file parameter is set
if (isset($_GET['file'])) {
    $file = $_GET['file'];
    $filePath = $uploadDirectory . $file;

    // Check if the file exists
    if (file_exists($filePath)) {
        // Set the appropriate headers for file download
        header('Content-Type: application/octet-stream');
        header('Content-Disposition: attachment; filename="' . $file . '"');
        header('Content-Length: ' . filesize($filePath));

        // Output the file for download
        readfile($filePath);
    } else {
        echo "File not found.";
    }
} else {
    echo "Invalid request.";
}
?>
