
<?php
/*PROGRAM 77 Crating a program that implement control flow and decision-making statement in php.*/

// Control Flow with if-else statements
$age = 25;

if ($age < 18) {
    echo "You are under 18 years old. You cannot vote.<br>";
} elseif ($age >= 18 && $age < 65) {
    echo "You are eligible to vote.<br>";
} else {
    echo "You are 65 or older. You can still vote!<br>";
}

// Control Flow with a switch statement
$dayOfWeek = 3;

switch ($dayOfWeek) {
    case 1:
        echo "Today is Monday.<br>";
        break;
    case 2:
        echo "Today is Tuesday.<br>";
        break;
    case 3:
        echo "Today is Wednesday.<br>";
        break;
    case 4:
        echo "Today is Thursday.<br>";
        break;
    case 5:
        echo "Today is Friday.<br>";
        break;
    default:
        echo "It's the weekend!<br>";
}

// Control Flow with a while loop
$num = 1;
while ($num <= 5) {
    echo "While loop iteration: $num<br>";
    $num++;
}

// Control Flow with a for loop
for ($i = 1; $i <= 5; $i++) {
    echo "For loop iteration: $i<br>";
}
//do-while
$j=1;
do{
   echo "DO-while loop iteration: $j<br>";
   $j++;
 }while($j<=5)

?>
