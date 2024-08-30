

<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST')
{
 $uname=htmlspecialchars($_POST['uname']);
 $upswd= htmlspecialchars($_POST['pswd']);
// Set cookies that expire in 1 hour (3600 seconds)
setcookie("username", $uname, time() + 3600, "/");
setcookie("password", $upswd, time() + 3600, "/");

echo "Cookies have been set. <br>";
echo "<a href='page2.php'>Go to Page 2</a>";
}
?>
