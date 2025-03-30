import { useState, useEffect } from 'react';
import GameCard from '../components/GameCard';
import { getGames } from '../services/api';

function Upcoming() {
  const [games, setGames] = useState([]);

  useEffect(() => {
    const fetchGames = async () => {
      const data = await getGames();
      console.log('Upcoming page - Fetched data:', data);
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
            id: '7',
            title: 'Assassin’s Creed Shadows',
            genre: ['action', 'stealth', 'historical'],
            platform: ['PS5', 'Xbox Series X/S', 'PC'],
            releaseDate: '2025-11-15',
            image: '/assets/images/acs.jpeg',
            status: 'upcoming',
          },
        ]);
      } else {
        const upcomingGames = data.filter((game) => game.status === 'upcoming');
        console.log('Upcoming page - Upcoming games:', upcomingGames);
        setGames(upcomingGames);
      }
    };
    fetchGames();
  }, []);

  return (
    <section className="upcoming-section py-4">
      <h2 className="text-center mb-4 text-warning">Upcoming Games</h2>
      {games.length === 0 ? (
        <p className="text-center">Loading upcoming games...</p>
      ) : (
        <div className="d-flex flex-wrap justify-content-center gap-0">
          {games.map((game) => (
            <div key={game.id} style={{ width: '300px' }}>
              <GameCard game={game} />
            </div>
          ))}
        </div>
      )}
    </section>
  );
}

export default Upcoming;