import { useState, useEffect } from 'react';
import GameCard from '../components/GameCard';
import { getGames } from '../services/api';

function Store() {
  const [games, setGames] = useState([]);

  useEffect(() => {
    const fetchGames = async () => {
      const data = await getGames();
      console.log('Store page - Fetched data:', data);
      if (data.length === 0) {
        console.log('Using fallback data');
        setGames([
          {
            id: '2',
            title: 'Red Dead Redemption 2',
            genre: ['action', 'adventure', 'western'],
            platform: ['PC', 'PS4', 'Xbox One'],
            releaseDate: '2018-10-26',
            image: '/assets/images/rdr2.jpeg',
            price: 59.99,
            status: 'released',
          },
          {
            id: '3',
            title: 'Black Myth Wukong',
            genre: ['action', 'RPG', 'mythological'],
            platform: ['PC', 'PS5'],
            releaseDate: '2024-08-20',
            image: '/assets/images/bmw.jpeg',
            price: 59.99,
            status: 'released',
          },
        ]);
      } else {
        const releasedGames = data.filter((game) => game.status === 'released');
        console.log('Store page - Released games:', releasedGames);
        setGames(releasedGames);
      }
    };
    fetchGames();
  }, []);

  const handleBuy = (game) => {
    alert(`Added ${game.title} to cart for $${game.price}!`);
  };

  return (
    <section className="store-section py-4">
      <h2 className="text-center mb-4 text-warning">Store</h2>
      {games.length === 0 ? (
        <p className="text-center">Loading store games...</p>
      ) : (
        <div className="row row-cols-1 row-cols-md-3 g-0">
          {games.map((game) => (
            <div className="col mb-4" key={game.id}>
              <GameCard game={game} />
              <button
                className="btn btn-warning w-100 mt-2"
                onClick={() => handleBuy(game)}
              >
                Buy Now - ${game.price}
              </button>
            </div>
          ))}
        </div>
      )}
    </section>
  );
}

export default Store;