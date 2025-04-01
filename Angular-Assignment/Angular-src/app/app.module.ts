import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { GameCardComponent } from './components/game-card/game-card.component';
import { NewsItemComponent } from './components/news-item/news-item.component';
import { HomeComponent } from './pages/home/home.component';
import { GamesComponent } from './pages/games/games.component';
import { UpcomingComponent } from './pages/upcoming/upcoming.component';
import { NewsComponent } from './pages/news/news.component';
import { StoreComponent } from './pages/store/store.component';
import { AboutComponent } from './pages/about/about.component';
import { ReleaseDatePipe } from './pipes/release-date.pipe';
import { GenreFilterPipe } from './pipes/genre-filter.pipe';
import { FeedbackComponent } from './feedback/feedback.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    GameCardComponent,
    NewsItemComponent,
    HomeComponent,
    GamesComponent,
    UpcomingComponent,
    NewsComponent,
    StoreComponent,
    AboutComponent,
    ReleaseDatePipe,
    GenreFilterPipe,
    FeedbackComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AppRoutingModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }