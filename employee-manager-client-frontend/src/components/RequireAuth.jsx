import React from 'react';
import { Navigate } from 'react-router-dom';
import { SignedIn, SignedOut } from '@clerk/clerk-react';

const RequireAuth = ({ children }) => {
  return (
    <SignedIn>
      {children}  {/* Render children only if the user is signed in */}
    </SignedIn>
  );
};

export default RequireAuth;