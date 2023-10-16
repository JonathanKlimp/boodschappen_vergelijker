import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { SearchService } from './search.service';
import { Product } from 'src/app/result-page/product/product';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  zoekterm!: string
  database_url: string = 'http://localhost:8080/zoek'
  resultaten!: Product[]
  constructor(public ss: SearchService, public http: HttpClient) { }

  opSubmit() {
    this.getProductWhereNameLike(this.zoekterm)
  }

  getProductWhereNameLike(naam: string) {
    return this.http.post<Product[]>(this.database_url, naam).subscribe((data) => {
      this.resultaten = data;
    })
  }
}
