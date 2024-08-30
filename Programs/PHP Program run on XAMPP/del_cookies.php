<?php
// Delete the cookies by setting their expiration time in the past
setcookie("username", "", time() - 3600, "/");
setcookie("password", "", time() - 3600, "/");

echo "Cookies have been deleted.<br>";
echo "<a href='cookies.html'>Set Cookies Again</a>";
?>
