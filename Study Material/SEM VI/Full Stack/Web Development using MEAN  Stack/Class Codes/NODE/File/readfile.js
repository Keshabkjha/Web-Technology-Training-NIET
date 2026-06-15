// include fiel system module
var fs = require('fs');

// read file simple.html

fs.readFile('newfile.txt',
 
// callback function that is called when reading is done

function(err, data){
    if (err) throw err;
    // data is a buffer containing file content

    console.log(data.toString('utf8'))
});