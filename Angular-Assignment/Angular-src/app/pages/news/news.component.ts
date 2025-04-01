import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';
import { News } from '../../models/news.model';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  newsItems: News[] = [];

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getNews().subscribe(news => {
      this.newsItems = news;
    });
  }
}