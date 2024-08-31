// Example using 'var'
function exampleVar() {
    var x = 10;
    console.log(x); // Outputs: 10

    if (true) {
        var x = 20; // Re-declares x
        console.log(x); // Outputs: 20
    }

    console.log(x); // Outputs: 20 (var is function-scoped)
}

exampleVar();
