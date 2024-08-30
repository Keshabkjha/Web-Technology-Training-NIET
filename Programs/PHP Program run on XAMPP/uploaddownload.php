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

    

    <!-- File Download Links -->
    <h3>Download Uploaded Files</h3>
    

</body>
</html>
