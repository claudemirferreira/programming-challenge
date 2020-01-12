import { Injectable } from '@angular/core';
import { HELP_DESK_API } from './helpdesk.api';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TitleService {

  constructor(private http: HttpClient) { }  

  findAll() {
    return this.http.get(`${HELP_DESK_API}/title/findAll`);
  }

}