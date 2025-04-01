import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';
import { Game } from '../../models/game.model';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {
  games: Game[] = [];
  filterForm: FormGroup;

  constructor(private gameService: GameService, private fb: FormBuilder) {
    this.filterForm = this.fb.group({
      genre: [''],
      platform: ['']
    });
  }

  ngOnInit() {
    this.gameService.getGames().subscribe(games => {
      this.games = games;
    });
  }
}