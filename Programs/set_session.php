<?php
session_start();
if($_SERVER['REQUEST_METHOD']==="POST")
{
$name=htmlspecialchars($_POST['uname']);
$course=htmlspecialchars($_POST['ucourse']);
$_SESSION['name']=$name;
$_SESSION['course']=$course;

echo "<h3>Session variables are Set</h3><br>";
echo "Student name:".$_SESSION['name'];
echo "<br>Student course:".$_SESSION['course']."<br>";
echo "<a href='page02.php'> Click here for Page-02</a>";
}
?>