import { Injectable } from '@angular/core';
import { HELP_DESK_API } from './helpdesk.api';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TitleService {

  startYear :number;
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

  find(){
    this.findByStartYear(this.startYear);
  }

  findByStartYear(startYear: number) {
    console.log('findByStartYear');
    if (startYear > 0)
      this.param = 'startYear='+startYear;
    
    return this.http.get(`${HELP_DESK_API}/api/title/findByStartYear?`+this.param);
  }

}