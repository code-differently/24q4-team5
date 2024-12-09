import { useEffect, useState } from 'react';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import { useNavigate } from "react-router-dom";
import * as employeeService from '../services/EmployeeService';
import {
  IconButton,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
} from '@mui/material';

export const EmployeeTable = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    requestDataFromApi();
  }, []);

  function requestDataFromApi() {
    employeeService.getAllEmployees()
      .then(res => {
        setEmployees(res.data);
      });
  }

  function goToUpdate(id) {
    navigate(`/update/${id}`);
  }

  function deleteEmployee(id) {
    employeeService.deleteEmployee(id)
      .then(() => {
        requestDataFromApi();
      });
  }

  return (
    <div className="overflow-x-auto p-6 bg-white shadow-lg rounded-lg">
      <Table className="min-w-full">
        <TableHead className="bg-gray-100">
          <TableRow>
            <TableCell className="text-gray-700 font-semibold">ID</TableCell>
            <TableCell className="text-gray-700 font-semibold">First Name</TableCell>
            <TableCell className="text-gray-700 font-semibold">Last Name</TableCell>
            <TableCell className="text-gray-700 font-semibold">Email</TableCell>
            <TableCell className="text-right font-semibold">Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {employees.map((employee) => (
            <TableRow hover key={employee.id} className="transition-colors duration-200 ease-in-out">
              <TableCell>{employee.id}</TableCell>
              <TableCell>{employee.firstName}</TableCell>
              <TableCell>{employee.lastName}</TableCell>
              <TableCell>{employee.email}</TableCell>
              <TableCell className="text-right">
                <IconButton onClick={() => goToUpdate(employee.id)}>
                  <EditIcon className="text-blue-600" />
                </IconButton>
                <IconButton onClick={() => deleteEmployee(employee.id)}>
                  <DeleteIcon className="text-red-600" />
                </IconButton>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
}
