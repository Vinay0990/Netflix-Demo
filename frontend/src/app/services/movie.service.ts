import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie';

@Injectable({
  providedIn: 'root',
})
export class MovieService {
  url: string = 'http://localhost:4500/api/v1/';
  constructor(private httpClient: HttpClient) {}
  getSliderImages() {
    const images = [
      '/assets/images/pic1.jpg',
      '/assets/images/pic2.jpg',
      '/assets/images/pic3.jpg',
      '/assets/images/pic4.jpg',
      '/assets/images/pic5.jpg',
    ];
    return images;
  }

  getAllMovies(page: number = 1, size: number = 20): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(
      this.url + 'Movies?page=' + page + '&size=' + size
    );
  }

  getMovie(id: string): Observable<Movie> {
    return this.httpClient.get<Movie>(this.url + 'Movies/' + id);
  }
}
