<?php
    // File Upload Handling
    if (isset($_POST['upload'])) {
        if (isset($_FILES['file'])) {
            $uploadDirectory = 'uploads/'; // Directory to store uploaded files

            // Ensure the uploads directory exists
            if (!is_dir($uploadDirectory)) {
                mkdir($uploadDirectory);
            }

            $file = $_FILES['file'];
            $fileName = $file['name'];
            $fileTempName = $file['tmp_name'];

            // Move the uploaded file to the uploads directory
            if (move_uploaded_file($fileTempName, $uploadDirectory . $fileName)) {
                echo "<p>File '$fileName' has been successfully uploaded.</p>";
            } else {
                echo "<p>Error: File upload failed.</p>";
            }
        }
    }
    ?>