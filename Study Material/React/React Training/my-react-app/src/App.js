import React from 'react';
import Car from './Car';

function App() {
  // Car information object
  const carInfo = {
    make: "Tata nano",
    model: "Model S",
    year: 2010,
    color: "black",
  };

  return (
    <div className="App">
      <h1>Car Information</h1>
      {/* Passing carInfo as props */}
      <Car info={carInfo} />
    </div>
  );
}

export default App;
