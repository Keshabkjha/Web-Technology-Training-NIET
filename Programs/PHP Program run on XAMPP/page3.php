<?php
// Check if the cookies are set
if (isset($_COOKIE['username']) && isset($_COOKIE['password'])) {
    echo "Hello again, " . $_COOKIE['username'] . "!<br>";
    echo "Your password is: " . $_COOKIE['password'] . "<br>";
    echo "<a href='del_cookies.php'>Delete Cookies</a>";
} else {
    echo "Cookies are not set.";
}
?>
