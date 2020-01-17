import { Injectable } from '@angular/core';
import { HELP_DESK_API } from './helpdesk.api';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TitleService {
 
  page :string;
  size :string;

  param = '';

  constructor(private http: HttpClient) { }  

  findAll() {
    return this.http.get(`${HELP_DESK_API}/title/findAll`);
  }

  listGenres() {
    console.log('listGenres');
    return this.http.get(`${HELP_DESK_API}/api/title/listGenres`);
  }

  listTitle() {
    console.log('listTitle');
    return this.http.get(`${HELP_DESK_API}/api/title/listTitle`);
  }

  find(startYear: number, pageIndex : number) {
    console.log('findByStartYear');
    this.param = '';
    if (startYear > 0)
      this.param = 'startYear='+startYear;
    if (pageIndex > 0)
      this.param = this.param + '&page='+pageIndex;
    
    return this.http.get(`${HELP_DESK_API}/api/title/findByStartYear?`+this.param);
  }

  findTitleGenre(id : number) {
    console.log('findTitleGenre');
    return this.http.get(`${HELP_DESK_API}/api/title/findTitleGenre/`+id);
  }


}