import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  database_url: string = 'http://localhost:8080/'

  constructor(public http: HttpClient) { }

  getProductWhereNameLike(naam: string) {
    return this.http.post<string>(this.database_url + '/', naam)
  }
}
