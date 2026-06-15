let myPromise = new Promise(function(resolve, reject) {
    // some code that takes time, like loading data
    let success = true; // change this to false to check error
    if (success) {
      resolve("The data has loaded successfully!");
    } else {
      reject("There was an error loading the data.");
    }
  });
  myPromise.then(function(message) {
    // This runs if the promise is fulfilled
      console.log(message); 
    }).catch(function(error) {
    // This runs if the promise is rejected
      console.log(error); 
    });
    let promise = new Promise(function (resolve, reject) {
        const x = "We are NIET ians";
        const y = "We are NIET ians";
        if (x === y) {
            resolve("We are NIET ians");
        } else {
            reject("We are NIET");
        }
    });
    
    promise.then(function () {
            console.log('Success, You are a GENIUS');
        }).catch(function () {
            console.log('Some error has occurred');
        });