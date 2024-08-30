<?php
// Starting a session
//PHP program to create  and destroy a session. 
session_start();

// Storing a session variable
$_SESSION['username'] = 'JohnDoe';
echo "Session started and session variable set.";

// Destroying the session
session_destroy();
echo "Session destroyed.";
?>
