import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/model/movie';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent implements OnInit {
  @Input() title!: string;
  @Input() data!: Movie[];

  @ViewChild('widgetsContent') widgetsContent!: ElementRef;

  constructor(private route: Router) {}
  ngOnInit(): void {}

  scrollLeft() {
    this.widgetsContent.nativeElement.scrollLeft -= 150;
  }

  scrollRight() {
    this.widgetsContent.nativeElement.scrollLeft += 150;
  }

  onClick(d: Movie) {
    this.route.navigateByUrl('movie/' + d?.id);
  }
}
