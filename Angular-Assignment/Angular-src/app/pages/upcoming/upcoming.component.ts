import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';
import { Game } from '../../models/game.model';

@Component({
  selector: 'app-upcoming',
  templateUrl: './upcoming.component.html',
  styleUrls: ['./upcoming.component.css']
})
export class UpcomingComponent implements OnInit {
  upcomingGames: Game[] = [];

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getGames().subscribe(games => {
      this.upcomingGames = games.filter(game => game.status === 'upcoming');
    });
  }
}