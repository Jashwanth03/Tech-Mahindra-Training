import { useState, useEffect } from 'react';
import GameCard from '../components/GameCard';
import { getGames } from '../services/api';

function Games() {
  const [games, setGames] = useState([]);
  const [filteredGames, setFilteredGames] = useState([]);
  const [platform, setPlatform] = useState('');

  useEffect(() => {
    const fetchGames = async () => {
      const data = await getGames();
      console.log('Games page - Fetched data:', data);
      if (data.length === 0) {
        console.log('Using fallback data');
        const fallbackData = [
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
          {
            id: '4',
            title: 'Uncharted',
            genre: ['adventure', 'action', 'cinematic'],
            platform: ['PS4', 'PS5', 'PC'],
            releaseDate: '2016-05-10',
            image: '/assets/images/uncharted.jpeg',
            status: 'released',
          },
        ];
        setGames(fallbackData);
        setFilteredGames(fallbackData);
      } else {
        setGames(data);
        setFilteredGames(data);
      }
    };
    fetchGames();
  }, []);

  useEffect(() => {
    console.log('Games page - Platform filter:', platform);
    console.log('Games page - Filtered games:', filteredGames);
    if (platform) {
      setFilteredGames(
        games.filter((game) =>
          game.platform.some((p) => p.toLowerCase() === platform.toLowerCase())
        )
      );
    } else {
      setFilteredGames(games);
    }
  }, [platform, games]);

  return (
    <section className="games-section py-4">
      <h2 className="text-center mb-4 text-warning">Games</h2>
      <div className="filter-container mb-4">
        <label htmlFor="platformFilter" className="me-2">Filter by Platform:</label>
        <select
          id="platformFilter"
          value={platform}
          onChange={(e) => setPlatform(e.target.value)}
          className="form-select d-inline-block w-auto bg-dark text-white border-secondary"
        >
          <option value="">All Platforms</option>
          <option value="PC">PC</option>
          <option value="PS5">PS5</option>
          <option value="PS4">PS4</option>
          <option value="Xbox One">Xbox One</option>
          <option value="Xbox Series X/S">Xbox Series X/S</option>
          <option value="Switch">Switch</option>
          <option value="GameCube">GameCube</option>
        </select>
      </div>
      {filteredGames.length === 0 ? (
        <p className="text-center">No games available or loading...</p>
      ) : (
        <div className="row row-cols-1 row-cols-md-3 g-0">
          {filteredGames.map((game) => (
            <div className="col mb-4" key={game.id}>
              <GameCard game={game} />
            </div>
          ))}
        </div>
      )}
    </section>
  );
}

export default Games;