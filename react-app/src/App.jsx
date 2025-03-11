import { Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './pages/Home';
import Games from './pages/Games';
import Upcoming from './pages/Upcoming';
import News from './pages/News';
import Store from './pages/Store';
import About from './pages/About';
import Feedback from './pages/Feedback';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

function App() {
  return (
    <div className="App">
      <Header />
      <main className="container-fluid">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/games" element={<Games />} />
          <Route path="/upcoming" element={<Upcoming />} />
          <Route path="/news" element={<News />} />
          <Route path="/store" element={<Store />} />
          <Route path="/about" element={<About />} />
          <Route path="/feedback" element={<Feedback />} />
        </Routes>
      </main>
      <Footer />
    </div>
  );
}

export default App;