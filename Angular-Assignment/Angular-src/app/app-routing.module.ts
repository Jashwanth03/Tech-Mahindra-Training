import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { GamesComponent } from './pages/games/games.component';
import { UpcomingComponent } from './pages/upcoming/upcoming.component';
import { NewsComponent } from './pages/news/news.component';
import { StoreComponent } from './pages/store/store.component';
import { AboutComponent } from './pages/about/about.component';
import { FeedbackComponent } from './feedback/feedback.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'games', component: GamesComponent },
  { path: 'upcoming', component: UpcomingComponent },
  { path: 'news', component: NewsComponent },
  { path: 'store', component: StoreComponent },
  { path: 'about', component: AboutComponent },
  { path: 'feedback', component: FeedbackComponent } // Add feedback route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }