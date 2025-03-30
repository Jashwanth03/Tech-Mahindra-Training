document.addEventListener('DOMContentLoaded', () => {
    const path = window.location.pathname;

    if (path.includes('home.html')) {
        loadFeaturedMovies();
        setupSearch();
    } else if (path.includes('movie-details.html')) {
        loadMovieDetails();
    } else if (path.includes('search-results.html')) {
        loadSearchResults();
    } else if (path.includes('user-reviews.html')) {
        loadUserReviews();
    }
});

function loadFeaturedMovies() {
    fetch('../assets/data/movies.json')
        .then(response => response.json())
        .then(movies => {
            const movieList = document.getElementById('movie-list');
            movies.forEach(movie => {
                const div = document.createElement('div');
                div.className = 'movie-card';
                div.innerHTML = `
                    <img src="${movie.poster}" alt="${movie.title}" onclick="goToMovie(${movie.id})">
                    <h3>${movie.title}</h3>
                    <p class="description">${movie.description}</p>
                    <button class="read-more" onclick="toggleDescription(this)">Read More</button>
                `;
                movieList.appendChild(div);
            });
        });
}

function toggleDescription(button) {
    const description = button.previousElementSibling;
    if (description.classList.contains('show')) {
        description.classList.remove('show');
        button.textContent = 'Read More';
    } else {
        description.classList.add('show');
        button.textContent = 'Read Less';
    }
}

function setupSearch() {
    const searchBar = document.getElementById('search-bar');
    searchBar.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            window.location.href = `search-results.html?q=${searchBar.value}`;
        }
    });
}

function loadMovieDetails() {
    const urlParams = new URLSearchParams(window.location.search);
    const movieId = urlParams.get('id');
    fetch('../assets/data/movies.json')
        .then(response => response.json())
        .then(movies => {
            const movie = movies.find(m => m.id == movieId);
            document.getElementById('movie-poster').src = movie.poster;
            document.getElementById('movie-title').textContent = movie.title;
            document.getElementById('movie-rating').textContent = `Rating: ${movie.rating}`;
            document.getElementById('movie-description').textContent = movie.description;
            const castList = document.getElementById('movie-cast');
            movie.cast.forEach(actor => {
                const li = document.createElement('li');
                li.textContent = actor;
                castList.appendChild(li);
            });
            const reviewsList = document.getElementById('reviews-list');
            movie.reviews.forEach(review => {
                reviewsList.innerHTML += `<p>${review.user}: ${review.text} (${review.rating}/5)</p>`;
            });
        });
}

function loadSearchResults() {
    const urlParams = new URLSearchParams(window.location.search);
    const query = urlParams.get('q').toLowerCase();
    fetch('../assets/data/movies.json')
        .then(response => response.json())
        .then(movies => {
            const resultsList = document.getElementById('results-list');
            const filteredMovies = movies.filter(m => m.title.toLowerCase().includes(query));
            filteredMovies.forEach(movie => {
                const div = document.createElement('div');
                div.innerHTML = `<img src="${movie.poster}" alt="${movie.title}" onclick="goToMovie(${movie.id})">`;
                resultsList.appendChild(div);
            });
        });
}

function loadUserReviews() {
    fetch('../assets/data/movies.json')
        .then(response => response.json())
        .then(movies => {
            const reviewsList = document.getElementById('reviews-list');
            movies.forEach(movie => {
                // Create a section for each movie
                const movieSection = document.createElement('div');
                movieSection.className = 'movie-section';

                // Add movie title
                const movieTitle = document.createElement('h3');
                movieTitle.className = 'movie-title';
                movieTitle.textContent = movie.title;
                movieSection.appendChild(movieTitle);

                // Add reviews for this movie
                movie.reviews.forEach(review => {
                    const reviewP = document.createElement('p');
                    reviewP.className = 'review';
                    reviewP.textContent = `${review.user}: ${review.text} (${review.rating}/5)`;
                    movieSection.appendChild(reviewP);
                });

                reviewsList.appendChild(movieSection);
            });
        });
}

function goToMovie(id) {
    window.location.href = `movie-details.html?id=${id}`;
}