<?php
session_start();
//Destroy session
session_unset();
session_destroy();
echo "you have logout<br><br>";
echo "<a href='mysession.html'>Login again</a>";
?>