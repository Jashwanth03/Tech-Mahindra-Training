import { Pipe, PipeTransform } from '@angular/core';
import { Game } from '../models/game.model';

@Pipe({
  name: 'genreFilter'
})
export class GenreFilterPipe implements PipeTransform {
  transform(games: Game[], genre: string): Game[] {
    if (!genre) return games;
    return games.filter(game =>
      game.genre.some(g => g.toLowerCase() === genre.toLowerCase())
    );
  }
}