function News() {
  // Sample news data (could be fetched from an API in the future)
  const newsItems = [
    {
      id: 1,
      title: "GTA 6 Release Date Announced!",
      date: "March 5, 2025",
      content: "Rockstar Games has officially confirmed that GTA 6 will launch on October 31, 2025. Get ready for an epic open-world adventure in Leonida!",
    },
    {
      id: 2,
      title: "Black Myth Wukong Wins Game of the Year",
      date: "December 15, 2024",
      content: "Game Science’s Black Myth Wukong has taken the gaming world by storm, winning multiple awards at the 2024 Game Awards.",
    },
    {
      id: 3,
      title: "Assassin’s Creed Shadows Sneak Peek",
      date: "February 20, 2025",
      content: "Ubisoft Quebec dropped a new trailer for Assassin’s Creed Shadows, showcasing stealth gameplay in feudal Japan. Release set for November 15, 2025.",
    },
  ];

  return (
    <section className="news-section py-4 min-vh-100">
      <div className="container">
        <h2 className="text-center mb-4 text-warning">Latest Gaming News</h2>
        {newsItems.length === 0 ? (
          <p className="text-center">No news available at the moment.</p>
        ) : (
          <div className="row row-cols-1 row-cols-md-2 g-4">
            {newsItems.map((item) => (
              <div className="col" key={item.id}>
                <div className="card bg-dark text-white border-0 shadow-sm">
                  <div className="card-body">
                    <h5 className="card-title text-warning">{item.title}</h5>
                    <p className="card-text text-muted">
                      <small>{item.date}</small>
                    </p>
                    <p className="card-text">{item.content}</p>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </section>
  );
}

export default News;