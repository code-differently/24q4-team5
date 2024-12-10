import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Container } from '@mui/material';
import { Employee } from './pages/Employee';
import { NoContent } from './pages/NoContent';
import { Update } from './pages/Update';
import { Add } from './pages/Add';
import { ClerkProvider, SignedIn, SignedOut, SignInButton, UserButton } from '@clerk/clerk-react';
import RequireAuth from './components/RequireAuth'; // Import the RequireAuth component
import './index.css';  

export default function App() {
  return (
    <>
      <header className="flex justify-between items-center p-4 bg-white shadow-md">
        <h1 className="text-2xl font-bold text-[#323232]">Employee Manager</h1>
        <div className="flex items-center">
          <SignedOut>
            <SignInButton className="bg-[#20368F] text-white py-2 px-4 rounded-md hover:bg-[#000B4F]">
              Sign In
            </SignInButton>
          </SignedOut>
          <SignedIn>
            <UserButton />
          </SignedIn>
        </div>
      </header>

      <div className="bg-gradient-to-r from-[#003366] via-[#1a3d8f] to-[#4d7ea8] min-h-screen shadow-lg">
        <Container maxWidth="md" className="py-8">
          <BrowserRouter>
            <Routes>
              {/* Protected Routes */}
              <Route
                path="/"
                element={
                  <RequireAuth>
                    <Employee />
                  </RequireAuth>
                }
              />
              <Route
                path="/update/:id"
                element={
                  <RequireAuth>
                    <Update />
                  </RequireAuth>
                }
              />
              <Route
                path="/add"
                element={
                  <RequireAuth>
                    <Add />
                  </RequireAuth>
                }
              />
              {/* Public Routes */}
              <Route path="/sign-in" element={<SignedOut><SignInButton /></SignedOut>} />
              <Route path="*" element={<NoContent />} />
            </Routes>
          </BrowserRouter>
        </Container>
      </div>
    </>
  );
}
