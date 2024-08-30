<?php
// Setting a cookie
setcookie("user", "John Doe", time() + (86400 * 30), "/"); // 86400 = 1 day
echo "Cookie 'user' is set.<br>";
setcookie("user", "", time() - 3600, "/");
echo "Cookie 'user' is deleted.";
?>
