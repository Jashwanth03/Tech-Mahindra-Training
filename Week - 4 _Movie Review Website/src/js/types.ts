interface Movie {
    id: number;
    title: string;
    rating: number;
    description: string;
    poster: string;
    reviews: Review[];
}

interface Review {
    user: string;
    text: string;
    rating: number;
}