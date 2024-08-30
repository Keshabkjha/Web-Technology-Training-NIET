<?php  
$target_path = "F:/uploadphp/";  
$target_path = $target_path.basename( $_FILES['fileupload']['name']);   
  
if(move_uploaded_file($_FILES['fileupload']['tmp_name'], $target_path)) {  
    echo "File uploaded successfully!";  
} else{  
    echo "Sorry, file not uploaded, please try again!";  
}  
?>  