import axios from 'axios';

export const getGames = async () => {
    try {
        const response = await axios.get('/assets/api.json');
        console.log('API response data:', response.data);
        return response.data;
    } catch (error) {
        console.error('Error fetching games:', error.message);
        return [];
    }
};