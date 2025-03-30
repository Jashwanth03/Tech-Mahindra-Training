function GameCard({ game }) {
  if (!game) {
    return <p>Game data missing</p>;
  }

  // Normalize image path to always start with '/'
  const imagePath = game.image.startsWith('/') ? game.image : `/${game.image}`;

  return (
    <div className="card bg-dark text-white border-0 shadow-sm game-card">
      <img
        src={imagePath || '/assets/images/placeholder.jpeg'}
        className="card-img-top"
        alt={game.title}
        style={{ maxHeight: '300px', width: '100%', objectFit: 'contain' }} // Adjusted for better scaling
        onError={(e) => {
          console.log(`Failed to load image: ${imagePath}`);
          e.target.src = '/assets/images/placeholder.jpeg';
        }}
      />
      <div className="card-body">
        <h5 className="card-title">{game.title}</h5>
        <p className="card-text text-muted">{game.genre.join(', ')}</p>
        <p className="card-text">
          <small>
            Platforms: {game.platform.join(', ')} | Release: {new Date(game.releaseDate).toLocaleDateString()}
          </small>
        </p>
        <p className={`card-text ${game.status === 'released' ? 'text-success' : 'text-warning'}`}>
          {game.status}
        </p>
      </div>
    </div>
  );
}

export default GameCard;