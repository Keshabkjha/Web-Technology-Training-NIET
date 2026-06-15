import React, { useState } from "react";
const Form = () => {
  <h1>Form</h1>

const [formData, setFormData] = useState({
  name: "",
  email: "",
  message: "",
});

const handleChange = (event) => {
  const { name, value } = event.target;
  setFormData((prevFormData) => ({
    ...prevFormData,
    [name]: value,
  }));
};

const handleSubmit = (event) => {
  event.preventDefault();
  alert(`Name: ${formData.name}\nEmail: ${formData.email}\nMessage: ${formData.message}\nGender: ${formData.gender}\nAge: ${formData.age}\nCountry: ${formData.country}\nLiked Or Not: ${formData.question}\nTerms: ${formData.terms}\nCreated: ${formData.created}\nUpdated: ${formData.updated}`);
};

return (
  <form onSubmit={handleSubmit} >
    <div>
      <label htmlFor="name">Name:</label>
      <input
        type="text"
        id="name"
        name="name"
        value={formData.name}
        onChange={handleChange}
        placeholder="Enter your name"
        required
      />
    </div>

    <div>
      <label htmlFor="email">Email:</label>
      <input
        type="email"
        id="email"
        name="email"
        value={formData.email}
        onChange={handleChange}
        placeholder="Enter your email"
        required
      />
    </div>
    <div>
      <label htmlFor="gender">Gender:</label>
      <select id="gender" name="gender" required>
        <option value="">Select your gender</option>
        <option value="male">Male</option>
        <option value="female">Female</option>
      </select>
    </div>
    <div>
      <label htmlFor="age">Age:</label>
      <input
        type="number"
        id="age"
        name="age"
        value={formData.age}
        onChange={handleChange}
        placeholder="Enter your age"
        min="18"
        required
      />
    </div>
    <div>
      <label htmlFor="country">Country:</label>
      <select id="country" name="country" required>
        <option value="">Select your country</option>
        <option value="india">India</option>
        <option value="australia">Australia</option>
        <option value="usa">USA</option>
        <option value="uk">UK</option>
        <option value="canada">Canada</option>
      </select>
    </div>
    <div>
      <label htmlFor="message">Message:</label>
      <textarea
        id="message"
        name="message"
        value={formData.message}
        onChange={handleChange}
        placeholder="Enter your message"
        required
      />
    </div>  
    <div>
      <label htmlFor="question">Do you Like React</label>
      <input type="radio" id="yes" name="question" value="yes" required />
      <label htmlFor="yes">Yes</label>
      <input type="radio" id="no" name="question" value="no" required />
      <label htmlFor="no">No</label>
    </div>
    <div>
      <label htmlFor="terms">I agree to the terms and conditions:</label>
      <input type="checkbox" id="terms" name="terms" required />
    </div>

    <button type="submit">Submit</button>
  </form>
);
};

  export default Form;
  