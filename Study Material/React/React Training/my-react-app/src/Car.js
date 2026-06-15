import React from 'react';

function Car({ info }) {
  return (
    <div className="car-card">
      <h2>Details of the Car:</h2>
      <p><strong>Make:</strong> {info.make}</p>
      <p><strong>Model:</strong> {info.model}</p>
      <p><strong>Year:</strong> {info.year}</p>
      <p><strong>Color:</strong> {info.color}</p>
    </div>
  );
}

export default Car;
