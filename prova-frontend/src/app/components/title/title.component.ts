import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TitleService } from 'src/app/service/title.service';
import { GenreService } from 'src/app/service/genre.service';
import { ResponseApi } from 'src/app/model/response-api';
import { Title } from 'src/app/model/title';

import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.css']
})
export class TitleComponent implements OnInit {
  displayedColumns: string[] = ['tconst', 'titleType', 'primaryTitle', 'originalTitle', 'startYear', 'averageRating'];
  totalElements: number;
  pageSize: number;  
  size: number;
  pageSizeOptions: number[] = [10];

  page : any;

  pageIndex: number;

  listaGenres: [];
  list: Title[];
  genres: string;
  message: {};
  classCss: {};
  startYear: number;
  pageEvent: PageEvent;

  constructor(private http: HttpClient, private titleService: TitleService
    , private genreService: GenreService) {
      this.startYear = 0;
    this.pageIndex = 0;
    this.find();
  }

  ngOnInit() {    
    
  }

  pageChange($event) {
    this.pageIndex = $event.pageIndex;
    this.find();
  }

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  }

  pesquisar(){
    this.pageIndex = 0;
    this.find();
  }

  find() {
    this.titleService.find(this.startYear, this.pageIndex).subscribe((responseApi: ResponseApi) => {
      this.list = responseApi['content'];      // pageable

      console.log("title = " + JSON.stringify(this.list));
      this.totalElements = responseApi['totalElements'];
      this.pageSize = responseApi['totalPages'];      
      this.pageIndex = responseApi['number'];    
      this.size = responseApi['size'];

      console.log('length = totalElements ='+this.totalElements);
      console.log('pageSize = totalPages ='+this.pageSize);
      console.log('pageIndex = number ='+this.pageIndex);
      console.log('size ='+this.size);

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
