<?php
// Starting a session
//87. PHP program to manually register the session variable 
session_start();

// Manually registering a session variable
$_SESSION['user_id'] = 12345;
echo "Session variable 'user_id' registered with value: " . $_SESSION['user_id'];
?>
