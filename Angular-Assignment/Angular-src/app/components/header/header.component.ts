import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  menuItems = [
    { label: 'Games', route: '/games' },
    { label: 'Upcoming', route: '/upcoming' },
    { label: 'News', route: '/news' },
    { label: 'Store', route: '/store' },
    { label: 'About', route: '/about' },
    { label: 'Feedback', route: '/feedback' } // Optional addition
  ];

  currentRoute: string = '';

  constructor(private router: Router) {
    this.router.events.pipe(
      filter((event): event is NavigationEnd => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.currentRoute = event.urlAfterRedirects;
    });
  }
}