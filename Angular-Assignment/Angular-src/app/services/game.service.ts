import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Game } from '../models/game.model';
import { News } from '../models/news.model';


@Injectable({
  providedIn: 'root'
})
export class GameService {
  private apiUrl = 'assets/api.json';

  constructor(private http: HttpClient) { }

  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(this.apiUrl);
  }

  getGameById(id: string): Observable<Game> {
    return this.http.get<Game>(`${this.apiUrl}/${id}`);
  }

  getNews(): Observable<News[]> {
    return this.getGames().pipe(
      map(games => games.map(game => ({
        id: `news-${game.id}`,
        title: `${game.title} - Latest Update`,
        date: this.generateNewsDate(game.releaseDate),
        summary: this.generateSummary(game),
        image: game.image,
        content: `Full details about the latest developments for ${game.title}.`,
        gameId: game.id
      })))
    );
  }

  private generateNewsDate(releaseDate: string): string {
    const release = new Date(releaseDate);
    const newsDate = new Date(release);
    newsDate.setMonth(release.getMonth() + 1); // News one month after release
    return newsDate.toISOString().split('T')[0];
  }

  private generateSummary(game: Game): string {
    if (game.status === 'upcoming') {
      return `Get ready! ${game.title}'s release date is confirmed for ${game.releaseDate}.`;
    }
    return `New patch available for ${game.title}! Check out the latest features and fixes.`;
  }


}