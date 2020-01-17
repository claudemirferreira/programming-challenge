import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TitleService } from 'src/app/service/title.service';
import { GenreService } from 'src/app/service/genre.service';
import { ResponseApi } from 'src/app/model/response-api';
import { Title } from 'src/app/model/title';
import { Genre } from 'src/app/model/genre';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-list-movies',
  templateUrl: './list-movies.component.html',
  styleUrls: ['./list-movies.component.css']
})
export class ListMoviesComponent implements OnInit {

  displayedColumns: string[] = ['tconst', 'titleType', 'primaryTitle', 'originalTitle', 'startYear'];
   listGenre: Genre[];
  genre : Genre;
  list: Title[];

  message: {};
  classCss: {};

  constructor(private http: HttpClient,
    private titleService: TitleService,
    private genreService: GenreService) {
    this.genre = {"id":0,"name":"Selecione the genre"};
    this.findGenres();   

  }

  ngOnInit() {
  }

  pesquisar() {
    this.find();
  }

  findGenres() {
    this.genreService.findAll().subscribe((responseApi: ResponseApi) => {
      this.listGenre = responseApi['data'];
      console.log("listGenre = " + JSON.stringify(this.listGenre));
    }, err => {
      this.showMessage({
        type: 'error',
        text: err['error']['errors'][0]
      });
    });
  }

  find() {
    this.titleService.findTitleGenre(this.genre.id).subscribe((responseApi: ResponseApi) => {
      this.list = responseApi['data'];      // pageable
      console.log("title = " + JSON.stringify(this.list));

    }, err => {
      this.showMessage({
        type: 'error',
        text: err['error']['errors'][0]
      });
    });
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