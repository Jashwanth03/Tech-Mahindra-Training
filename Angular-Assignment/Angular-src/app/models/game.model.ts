export interface Game {
    id: string;
    title: string;
    genre: string[]; // Changed from string to string[]
    platform: string[];
    releaseDate: string;
    description: string;
    image: string;
    price: number;
    status: 'released' | 'upcoming';
    developer: string;
    rating: string;
    trailer: string;
}