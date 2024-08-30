<form method="post">

Enter value1 :<input type="text" name="n1"><br/>
Enter value2 :<input type="text" name="n2"><br/>
<input type="submit" value="Sum" name="submit">
<br><br>
<?php
if(isset($_POST["submit"]))
{
$sum=$_POST["n1"] + $_POST["n2"];
echo "The sum = ". $sum;

}
?>

</form>