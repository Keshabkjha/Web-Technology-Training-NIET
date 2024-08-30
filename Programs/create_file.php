<?php
//creating and writing a file
$myfile=fopen("Demo.txt","w")
 or die("unable to create file");
echo "file created successfully!";
$text="welcome to NIET Gr Noida";
fwrite($myfile,$text);
$text="<br>hello! NIET";
fwrite($myfile,$text);
fclose($myfile);
?>