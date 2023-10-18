import Footer from './component/footer/Footer';
import Navbar from './component/navbar/Navbar';
import Home from './page/Home';
import { BrowserRouter,Routes,Route } from 'react-router-dom';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Navbar />
          <Routes>
            <Route path="/" element={<Home />} />
          </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
