import { Component, OnInit } from '@angular/core';
import { Collection } from '../model/collection';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(private service: MovieService) {}
  images!: string[];
  data: Collection[] = [];
  titles!: string[];
  ngOnInit(): void {
    this.titles = [
      'Trending Movies',
      'Bollywood Movies',
      'Comedy Movies',
      'Horror Movies',
    ];

    this.images = this.service.getSliderImages();
    this.titles.forEach((tt) => {
      this.service.getAllMovies().subscribe((res) => {
        this.data.push({
          title: tt,
          content: res,
        });
      });
    });
  }
}
