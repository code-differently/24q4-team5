import { EmployeeTable } from "../components/EmployeeTable";
import { useNavigate } from "react-router-dom";

export const Employee = () => {
  const navigate = useNavigate();

  function addUser() {
    navigate("/add");
  }

  return (
    <div className="min-h-screen bg-[#EBEBEB] p-8"> 
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-3xl font-semibold text-[#323232]">Employees</h1> 
        <button
          onClick={addUser}
          className="bg-[#20368F] py-2 px-6 rounded-lg hover:bg-[#000B4F] focus:outline-none">
          Add Employee
        </button>
      </div>
      <EmployeeTable />
    </div>
  );
};
