<?php
//PHP program to store the session data on one page and would be available on second page. 
// Starting a session
session_start();

// Accessing session data7
if (isset($_SESSION['favorite_color'])) {
    echo "Your favorite color is " . $_SESSION['favorite_color'];
} else {
    echo "No favorite color found in session.";
}
?>
