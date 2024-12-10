// src/App.jsx
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Container } from '@mui/material';
import { Employee } from './pages/Employee';
import { NoContent } from './pages/NoContent';
import { Update } from './pages/Update';
import { Add } from './pages/Add';
import { ClerkProvider, SignedIn, SignedOut, SignInButton, UserButton } from '@clerk/clerk-react';
import RequireAuth from './components/RequireAuth'; // Import the RequireAuth component

export default function App() {
  return (
    <>
      <header>
        <SignedOut>
          <SignInButton />
        </SignedOut>
        <SignedIn>
          <UserButton />
        </SignedIn>
      </header>

      <Container maxWidth="md">
        <BrowserRouter>
          <Routes>
            <Route
              path="/"
              element={
                <RequireAuth>
                  <Employee />
                </RequireAuth>
              }
            />
            <Route path="/sign-in" element={<SignedOut><SignInButton /></SignedOut>} />
            <Route path="/update/:id" element={<RequireAuth><Update /></RequireAuth>} />
            <Route path="/add" element={<RequireAuth><Add /></RequireAuth>} />
            <Route path="*" element={<NoContent />} />
          </Routes>
        </BrowserRouter>
      </Container>
    </>
  );
}