import Footer from './component/footer/Footer';
import Navbar from './component/navbar/Navbar';
import Home from './page/Home';
import Login from './page/Login';
import Infomation from './page/Infomation';
import { BrowserRouter,Routes,Route  } from 'react-router-dom';

function App() {
  var dateNow = new Date().getTime();
  if (sessionStorage.getItem("expired") > dateNow) {
      console.log("het time");
      sessionStorage.removeItem("status");
      sessionStorage.removeItem("message");
      sessionStorage.removeItem("token");
      sessionStorage.removeItem("expired");
  }
  return (
    <div>
      <BrowserRouter>
        <Navbar />
          <Routes>
          <Route path="/" element={<Home />} />
          <Route path='/infomation' element={<Infomation />} />
          <Route path="/login" element={<Login />} />
          </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
