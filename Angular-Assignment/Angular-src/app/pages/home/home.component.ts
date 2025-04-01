import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';
import { Game } from '../../models/game.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  featuredGames: Game[] = [];

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getGames().subscribe(games => {
      this.featuredGames = games.slice(0, 3);
    });
  }
}