<?php
//non parameterized function
function fun1()
{
 echo "this is fun1()";
}
fun1();//function called

// parameterized function
function fun2($x,$y)
{
  return $x+$y;
}
$z=fun2(20,40);
echo "<br>X+Y=",$z;
?>
<?php
echo "<br>*call by value*<br>";
function fun3($x)
{
  $x=$x+20;
  echo "<br>In fun3() x=",$x;
}
$x=200;
echo "before x=",$x;
fun3($x);
echo "<br> after X=",$x;


echo "<br><br>Call by Reference*";
function fun4(&$y)
{
 $y=$y+20;
 echo "<br>inside y=",$y;
}
$y=200;
echo "<br>before y=",$y;
fun4($y);
echo "<br>after y=",$y;
?>