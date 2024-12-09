import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Container } from '@mui/material';
import { Employee } from "./pages/Employee";
import { NoContent } from "./pages/NoContent";
import { Update } from "./pages/Update";
import { Add } from "./pages/Add";

function App() {
  return (
    <div className="bg-gradient-to-r from-blue-500 via-purple-600 to-pink-500 min-h-screen shadow-lg">
      <Container maxWidth="md" className="py-8">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Employee />} />
            <Route path="/update/:id" element={<Update />} />
            <Route path="/add" element={<Add />} />
            <Route path="*" element={<NoContent />} />
          </Routes>
        </BrowserRouter>
      </Container>
    </div>
  );
}

export default App;
