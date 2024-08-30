<?php

    $file = $_GET['file'];
    $filepath = 'F:/uploadphp/' . $file;

    // Check if the file exists
    if (file_exists($filepath)) {
         header('Content-Type: application/octet-stream');
         header('Content-Disposition: attachment; filename="'.basename($filepath).'"');
         readfile($filepath);
        exit;
    } else {
        echo "File does not exist.";
    }
?>
