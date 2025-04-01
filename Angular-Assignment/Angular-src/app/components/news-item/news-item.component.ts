import { Component, Input } from '@angular/core';
import { trigger, style, animate, transition } from '@angular/animations';
import { News } from '../../models/news.model';

@Component({
  selector: 'app-news-item',
  templateUrl: './news-item.component.html',
  styleUrls: ['./news-item.component.css'],
  animations: [
    trigger('fadeIn', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('0.5s', style({ opacity: 1 }))
      ])
    ])
  ]
})
export class NewsItemComponent {
  @Input() news!: News;
}