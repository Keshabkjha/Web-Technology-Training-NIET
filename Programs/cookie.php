<?php
// Set a cookie with a name, value, and expiration time
$cookie_name = "user";
$cookie_value = "Rajat";
$expiration_time = time() + 3600; // Cookie will expire in 1 hour

setcookie($cookie_name, $cookie_value, $expiration_time);

// Check if the cookie is set
if (isset($_COOKIE[$cookie_name])) {
    echo "Cookie '$cookie_name' is set with the value: " . $_COOKIE[$cookie_name];
} else {
    echo "Cookie '$cookie_name' is not set.";
}
?>
