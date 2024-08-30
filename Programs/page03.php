<?php
session_start();
if(isset($_SESSION['name'])&& $_SESSION['course'])
{
  echo "Hello ".$_SESSION['name']."<br>";
  echo "Your academic course:".$_SESSION['course']."<br>";
  echo "<a href= 'log_out.php'>Logout</a>";
}
else 
echo "you need to login first";
?>