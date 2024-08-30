<?php
// Start a new or resume the existing session
session_start();

// Check if the session variable 'counter' is set, if not, initialize it to 0
if (!isset($_SESSION['counter'])) {
    $_SESSION['counter'] = 0;
}

// Increment the counter in the session
$_SESSION['counter']++;

// Display the current session counter value
echo "Session Counter: " . $_SESSION['counter'] . "<br>";

// Destroy the session (you can use this link to trigger session destruction)
if (isset($_GET['destroy'])) {
    session_destroy();
    echo "Session destroyed. <a href='crud.php'>Reload</a> to start a new session.";
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Session Example</title>
</head>
<body>
    <a href="?destroy=true">Destroy Session</a>
</body>
</html>
