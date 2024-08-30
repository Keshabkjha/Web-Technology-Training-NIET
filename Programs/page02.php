<?php
session_start();
if(isset($_SESSION['name'])&& $_SESSION['course'])
{
  echo "Welcome ".$_SESSION['name']."<br>";
  echo "Your academic course:".$_SESSION['course']."<br>";
  echo "<a href= 'page03.php'>Next->Page03</a>";
}
//else 
//echo "you need to login first";
?>