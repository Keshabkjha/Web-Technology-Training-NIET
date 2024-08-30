<?php
// Starting a session
//PHP program to store the session data on one page and would be available on second page. 
session_start();

// Storing session data
$_SESSION['favorite_color'] = 'Blue';
echo "Favorite color stored in session.";
?>
<a href="Program89_page2.php">Go to page 2</a>
