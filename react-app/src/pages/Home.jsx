import { useState, useEffect } from 'react';
import GameCard from '../components/GameCard';
import { getGames } from '../services/api';

function Home() {
  const [games, setGames] = useState([]);

  useEffect(() => {
    const fetchGames = async () => {
      const data = await getGames();
      console.log('Home page - Fetched data:', data);
      if (data.length === 0) {
        console.log('Using fallback data');
        setGames([
          {
            id: '1',
            title: 'GTA 6',
            genre: ['action', 'adventure', 'open-world'],
            platform: ['PS5', 'Xbox Series X/S'],
            releaseDate: '2025-10-31',
            image: '/assets/images/gta6.jpeg',
            status: 'upcoming',
          },
          {
            id: '2',
            title: 'Red Dead Redemption 2',
            genre: ['action', 'adventure', 'western'],
            platform: ['PC', 'PS4', 'Xbox One'],
            releaseDate: '2018-10-26',
            image: '/assets/images/rdr2.jpeg',
            status: 'released',
          },
          {
            id: '3',
            title: 'Black Myth Wukong',
            genre: ['action', 'RPG', 'mythological'],
            platform: ['PC', 'PS5'],
            releaseDate: '2024-08-20',
            image: '/assets/images/bmw.jpeg',
            status: 'released',
          },
        ]);
      } else {
        const featuredGames = data.filter((game) => ['1', '2', '3'].includes(game.id));
        console.log('Home page - Featured games:', featuredGames);
        setGames(featuredGames);
      }
    };
    fetchGames();
  }, []);

  return (
    <>
      <div className="hero text-center py-5 bg-dark text-white">
        <h1>Welcome to FragPunk</h1>
        <p>Experience gaming like never before</p>
      </div>
      <section className="featured-games py-4">
        <h2 className="text-center mb-4 text-warning">Featured Games</h2>
        {games.length === 0 ? (
          <p className="text-center">Loading games...</p>
        ) : (
          <div className="row row-cols-1 row-cols-md-3 g-0">
            {games.map((game) => (
              <div className="col mb-4" key={game.id}>
                <GameCard game={game} />
              </div>
            ))}
          </div>
        )}
      </section>
    </>
  );
}

export default Home;