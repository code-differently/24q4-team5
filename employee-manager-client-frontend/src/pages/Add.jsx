import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "@clerk/clerk-react"; // Import Clerk's hook
import * as employeeService from "../services/EmployeeService";

export function Add() {
  const navigate = useNavigate();
  const { user } = useUser(); // Get the current user from Clerk
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    // Get the UserID from Clerk
    const userId = user.id; 
    // Build the employee object
    const employee = { firstName, lastName, email, userId };
    // Send the employee data to the backend
    employeeService.createEmployee(employee)
      .then(() => {
        navigate("/"); // Redirect after successful creation
      })
      .catch(error => {
        console.error("Failed to create employee:", error);
      });
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-[#EBEBEB]"> {/* Light background */}
      <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-md"> {/* Rounded corners and shadow */}
        <h1 className="text-2xl font-semibold text-center text-[#323232] mb-6">Add Employee</h1> {/* Darker title color */}
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label htmlFor="firstName" className="block text-sm font-medium text-[#6D6D6D]">First Name</label>
            <input
              type="text"
              id="firstName"
              name="firstName"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required
              className="w-full px-4 py-2 border border-[#829CD0] rounded-md focus:outline-none focus:ring-2 focus:ring-[#20368F]" />
          </div>
          <div className="mb-4">
            <label htmlFor="lastName" className="block text-sm font-medium text-[#6D6D6D]">Last Name</label>
            <input
              type="text"
              id="lastName"
              name="lastName"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              required
              className="w-full px-4 py-2 border border-[#829CD0] rounded-md focus:outline-none focus:ring-2 focus:ring-[#20368F]" />
          </div>
          <div className="mb-6">
            <label htmlFor="email" className="block text-sm font-medium text-[#6D6D6D]">Email Address</label>
            <input
              type="email"
              id="email"
              name="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
              className="w-full px-4 py-2 border border-[#829CD0] rounded-md focus:outline-none focus:ring-2 focus:ring-[#20368F]" />
          </div>
          <button
            type="submit"
            className="w-full bg-[#20368F] text-black py-2 px-4 rounded-md focus:outline-none focus:ring-2 focus:ring-[#000B4F] hover:bg-[#000B4F]">
            Save
          </button>
        </form>
      </div>
    </div>
  );
}