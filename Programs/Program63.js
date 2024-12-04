//Implementing a program for de-structuring of an array in ES6
// Array for demonstration
const numbers = [1, 2, 3, 4, 5];
const nestedArray = [1, [2, 3], 4];

// Basic destructuring
const [first, second, third] = numbers;
console.log('Basic Destructuring:');
console.log(first);  // 1
console.log(second); // 2
console.log(third);  // 3

// Skipping elements
const [firstSkipped, , thirdSkipped, , fifth] = numbers;
console.log('\nSkipping Elements:');
console.log(firstSkipped);  // 1
console.log(thirdSkipped);  // 3
console.log(fifth);         // 5

// Default values
const [firstDefault, secondDefault = 2] = [1];
console.log('\nDefault Values:');
console.log(firstDefault);  // 1
console.log(secondDefault); // 2

// Rest elements
const [firstRest, secondRest, ...rest] = numbers;
console.log('\nRest Elements:');
console.log(firstRest);  // 1
console.log(secondRest); // 2
console.log(rest);       // [3, 4, 5]

// Nested array destructuring
const [firstNested, [secondNested, thirdNested], fourthNested] = nestedArray;
console.log('\nNested Array Destructuring:');
console.log(firstNested);  // 1
console.log(secondNested); // 2
console.log(thirdNested);  // 3
console.log(fourthNested); // 4
