// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import SignUpPage from './components/SignUpPage';
import AccountRegistrationPage from './components/AccountRegistrationPage';
import AccountManagementPage from './components/AccountManagementPage';

const App = () => {
  const isLoggedIn = true; 

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignUpPage />} />
        {isLoggedIn ? (
          <>
            <Route path="/account-registration" element={<AccountRegistrationPage />} />
            <Route path="/account-management" element={<AccountManagementPage />} />
          </>
        ) : (
          <Route path="*" element={<Navigate to="/login" />} />
        )}
      </Routes>
    </Router>
  );
};

export default App;
