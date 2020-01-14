import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TitleService } from 'src/app/service/title.service';
import { ResponseApi } from 'src/app/model/response-api';

@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.css']
})
export class TitleComponent implements OnInit {
  listaGenres: [];
  genres: string;
  message: {};  
  classCss: {};

  constructor(private http: HttpClient
              ,  private titleService: TitleService
              ) { 
      this.listGenres();
    }

  ngOnInit() { 
    
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
