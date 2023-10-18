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

  constructor() { }


}
