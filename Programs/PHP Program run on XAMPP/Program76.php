<?php
//Creating PHP script that return any data types whatever you use. 

function returnDataType($input) {
    // Check the type of the input and return it accordingly
    if (is_string($input)) {
        return $input;
    } elseif (is_int($input)) {
        return $input;
    } elseif (is_float($input)) {
        return $input;
    } elseif (is_bool($input)) {
        return $input;
    } elseif (is_array($input)) {
        return $input;
    } elseif (is_null($input)) {
        return "null";
    } elseif (is_object($input)) {
        return $input;
    } elseif (is_resource($input)) {
        return $input;
    } else {
        return "Unknown data type";
    }
}

// Example usage:
$string = "Hello, World!";
$integer = 99;
$float = 3.14;
$boolean = true;
$array = array("apple", "banana", "cherry");
$object = (object) ['name' => 'Narendra Modi', 'age' => 74];
$nullValue = null;

echo returnDataType($string);echo "\n"; // Output: Hello, World!
echo returnDataType($integer);echo "\n"; // Output: 42
echo returnDataType($float);echo "\n"; // Output: 3.14
echo returnDataType($boolean);echo "\n"; // Output: 1
print_r(returnDataType($array));echo"\n"; // Output: Array ( [0] => apple [1] => banana [2] => cherry )
print_r(returnDataType($object));echo"\n"; // Output: stdClass Object ( [name] => John [age] => 30 )
echo returnDataType($nullValue);echo "\n"; // Output: null

?>