import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TitleService } from 'src/app/service/title.service';
import { GenreService } from 'src/app/service/genre.service';
import { ResponseApi } from 'src/app/model/response-api';
import { Title } from 'src/app/model/title';

@Component({
  selector: 'app-list-movies',
  templateUrl: './list-movies.component.html',
  styleUrls: ['./list-movies.component.css']
})
export class ListMoviesComponent implements OnInit {
  
  message: {};
  classCss: {};

  constructor(private http: HttpClient, 
    private titleService: TitleService, 
    private genreService: GenreService) { 

    }

  ngOnInit() {
  }
  
  private showMessage(message: { type: string, text: string }): void {
    this.message = message;
    this.buildClasses(message.type);
    setTimeout(() => {
      this.message = undefined;
    }, 3000);
  }

  private buildClasses(type: string): void {
    this.classCss = {
      'alert': true
    }
    this.classCss['alert-' + type] = true;
  }

}