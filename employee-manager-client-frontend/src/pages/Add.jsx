import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import * as employeeService from '../services/EmployeeService';
import { useNavigate } from "react-router-dom";
import { useUser } from '@clerk/clerk-react';  // Import Clerk's useUser hook

const theme = createTheme();

export function Add() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const { user } = useUser();  // Get the current signed-in user
  const [isUserLoaded, setIsUserLoaded] = useState(false);  // For checking if user data is loaded

  useEffect(() => {
    if (user) {
      setIsUserLoaded(true);
    }
  }, [user]);

  const handleSubmit = (event) => {
    event.preventDefault();
    if (!isUserLoaded) {
      alert("User not logged in");
      return;
    }
    
    const data = new FormData(event.currentTarget);
    const employee = {
      firstName: data.get('firstName'),
      lastName: data.get('lastName'),
      email: data.get('email'),
      createdBy: user.id  // Include the Clerk user's ID as createdBy
    };

    employeeService.createEmployee(employee)
      .then(response => {
        navigate("/");
      })
      .catch(error => {
        console.error("Error creating employee:", error);
      });
  };

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Typography component="h1" variant="h5">
            Add Employee
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="given-name"
                  name="firstName"
                  required
                  fullWidth
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                  id="firstName"
                  label="First Name"
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  id="lastName"
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                  label="Last Name"
                  name="lastName"
                  autoComplete="family-name"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                />
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Save
              </Button>

              </Box>
              </Box>
              </Container>
              </ThemeProvider>
);
}