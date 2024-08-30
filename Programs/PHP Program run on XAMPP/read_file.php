<?php
$filename="Demo.txt";
$file=fopen($filename,"r");
if($file==true)
{echo "file opened successfully!";}
else
{echo "unable to open file";
 exit();}
$filesize=filesize($filename);
 $text=fread($file,$filesize);
echo $text;
fclose($file);
//delete file
// unlink($filename);
// echo "file is deleted successfully!";

?>