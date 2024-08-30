<?php
// Starting a session
//PHP program to manually destroy the session variable 
session_start();

// Destroying a specific session variable
unset($_SESSION['user_id']);
echo "Session variable 'user_id' destroyed.";
?>
