<?php
// Check if the cookies are set
if (isset($_COOKIE['username']) && isset($_COOKIE['password'])) {
    echo "Welcome, " . $_COOKIE['username'] . "!<br>";
    echo "Your password is: " . $_COOKIE['password'] . "<br>";
    echo "<a href='page3.php'>Go to Page 3</a>";
} else {
    echo "Cookies are not set.";
}
?>
