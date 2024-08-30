<?php
    //create directory
    $dirname="niet24";
    if(mkdir($dirname))
    {echo "Directory is created successfully!";}
    else
    {echo "Unable to create directory";}

    //create subdirectory
    $subdir="$dirname/CSE_V";
    if(mkdir($subdir,0777,true))
    {echo "subdirectory created!!";}
    else
    {echo "unable to create subdirectory!!";}

// delete directory
// $dirname="niet24";
// $subdir="$dirname/CSE_V";
// if(rmdir($subdir))
// echo "deleted subdir successfully!";
// else
// echo "unable to delete subdirectory";

?>