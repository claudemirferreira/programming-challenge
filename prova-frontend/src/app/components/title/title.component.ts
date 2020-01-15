import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TitleService } from 'src/app/service/title.service';
import { ResponseApi } from 'src/app/model/response-api';
import { Title } from 'src/app/model/title';

import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.css']
})
export class TitleComponent implements OnInit {
  displayedColumns: string[] = ['tconst', 'titleType', 'primaryTitle', 'originalTitle', 'startYear','averageRating'];
  length : number;
  pageSize : number;
  pageSizeOptions: number[] = [ 10];

  pageIndex : number;

  listaGenres: [];
  list: Title[];
  genres: string;
  message: {};
  classCss: {};
  startYear: number;
  // MatPaginator Output
  pageEvent: PageEvent;

  constructor(private http: HttpClient, private titleService: TitleService) {
    this.listGenres();
    this.startYear = 0;
    this.find();
  }

  ngOnInit() {
  }

  pageChange($event){
    this.pageIndex = $event.pageIndex;
    this.find();
  }

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  }


  listGenres() {
    this.titleService.listGenres().subscribe((responseApi: ResponseApi) => {
      this.listaGenres = responseApi['data'];
      console.log("genres = " + this.listaGenres);
    }, err => {
      this.showMessage({
        type: 'error',
        text: err['error']['errors'][0]
      });
    });
  }

  find() {
    this.titleService.find(this.startYear, this.pageIndex).subscribe((responseApi: ResponseApi) => {
      this.list = responseApi['content'];
      
      console.log("title = " + JSON.stringify( this.list));
      this.length = responseApi['totalElements'];
      this.pageSize = responseApi['totalPages'];

      console.log("genres = " + this.list);
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
