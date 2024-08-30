<?php
$dirname="uploads";
$uploadDirectory = "uploads/";

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_FILES["fileToUpload"])) {
    $targetFile = $uploadDirectory . basename($_FILES["fileToUpload"]["name"]);
    $uploadOk = 1;
    $fileType = strtolower(pathinfo($targetFile, PATHINFO_EXTENSION));

    // Checking if file was uploaded without errors
    if ($_FILES["fileToUpload"]["error"] !== UPLOAD_ERR_OK) {
        echo "Error: There was an error uploading your file.";
        $uploadOk = 0;
    }

    // Checking if file already exists
    if (file_exists($targetFile)) {
        echo "Error: File already exists.";
        $uploadOk = 0;
    }
    // Checking file size (limit to 5MB)
    if ($_FILES["fileToUpload"]["size"] > 5000000) {
        echo "Error: Your file is too large.";
        $uploadOk = 0;
    }

    // Allowing only certain file formats
    $allowedTypes = ['jpg', 'jpeg', 'png', 'gif', 'pdf', 'txt'];
    if (!in_array($fileType, $allowedTypes)) {
        echo "Error: Only JPG, JPEG, PNG, GIF, PDF, and TXT files are allowed.";
        $uploadOk = 0;
    }

    // Checking if $uploadOk is set to 0 by an error
    if ($uploadOk == 0) {
        echo "Error: Your file was not uploaded.";
    } else {
        // Try to upload file
        if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $targetFile)) {
            echo "The file " . htmlspecialchars(basename($_FILES["fileToUpload"]["name"])) . " has been uploaded.";
        } else {
            echo "Error: There was an error uploading your file.";
        }
    }
}

if (isset($_GET['download'])) {
    // Handling file download
    $file = $uploadDirectory . basename($_GET['download']);

    if (file_exists($file)) {
        header('Content-Description: File Transfer');
        header('Content-Type: application/octet-stream');
        header('Content-Disposition: attachment; filename="' . basename($file) . '"');
        header('Expires: 0');
        header('Cache-Control: must-revalidate');
        header('Pragma: public');
        header('Content-Length: ' . filesize($file));
        readfile($file);
        exit;
    } else {
        echo "Error: File does not exist.";
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload and Download File</title>
</head>
<body>
    <!-- HTML Form for uploading files -->
    <form action="" method="post" enctype="multipart/form-data">
        <h2>Upload File</h2>
        Select file to upload:
        <input type="file" name="fileToUpload" id="fileToUpload">
        <input type="submit" value="Upload File" name="submit">
    </form>

<!-- HTML Form for downloading files -->
<form action="" method="get">
    <h2>Download File</h2>
    <label for="download">Select a file to download:</label>
    <select name="download" id="download">
        <?php
        // Listing all files in the upload directory
        if (is_dir($uploadDirectory)) {
            if ($handle = opendir($uploadDirectory)) {
                while (false !== ($entry = readdir($handle))) {
                    if ($entry != "." && $entry != "..") {
                        echo '<option value="' . htmlspecialchars($entry) . '">' . htmlspecialchars($entry) . '</option>';
                    }
                }
                closedir($handle);
            }
        }
        ?>
    </select>
    <input type="submit" value="Download File">
</form>

</body>
</html>
