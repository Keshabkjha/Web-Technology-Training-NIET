<!DOCTYPE html>
<html>
<head>
    <title>File Upload and Download</title>
</head>
<body>
    <h2>File Upload and Download</h2>

    <!-- File Upload Form -->
    <form action="upload.php" method="post" enctype="multipart/form-data">
        <label for="file">Upload a File:</label>
        <input type="file" name="file" id="file">
        <input type="submit" name="upload" value="Upload">
    </form>

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

    <!-- File Download Links -->
    <h3>Download Uploaded Files</h3>
    <?php
    $uploadDirectory = 'uploads/';
    if (is_dir($uploadDirectory)) {
        $files = scandir($uploadDirectory);
        foreach ($files as $file) {
            if ($file != "." && $file != "..") {
                echo "<p><a href='download.php?file=" . urlencode($file) . "'>$file</a></p>";
            }
        }
    } else {
        echo "<p>No uploaded files available for download.</p>";
    }
    ?>

</body>
</html>
