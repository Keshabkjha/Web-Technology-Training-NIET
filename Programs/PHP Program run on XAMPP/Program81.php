<?php
//creating a file
// $file=fopen("Program81.txt","w")
//  or die("unable to create file");
// $text="welcome to NIET Gr Noida";
// fwrite($file,$text);
// $text="<br>hello! NIET";
// fwrite($file,$text);
// fclose($file);

// Opening a file for reading
$file = fopen("Program81.txt", "r");

if ($file) {
    // Reading file contents
    while (($line = fgets($file)) !== false) {
        echo $line;
    }
    // Closing the file
    fclose($file);
} else {
    echo "Unable to open the file.";
}
?>
