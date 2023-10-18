import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SearchService } from '../landing/search/search.service';
import { HttpClient } from '@angular/common/http';
import { Product } from './product/product';


@Component({
  selector: 'app-result-page',
  templateUrl: './result-page.component.html',
  styleUrls: ['./result-page.component.css']
})
export class ResultPageComponent implements OnInit {
  zoekterm: string = '';
  database_url: string = 'http://localhost:8080/zoek'
  resultaten!: Product[]

  constructor(private route: ActivatedRoute, private ss: SearchService, public http: HttpClient) {
  }

  columns: number = 4;

  @ViewChild('box', { static: false }) box!: ElementRef;

  onBoxResize() {
    if (this.box) {
      console.log(this.box.nativeElement.clientWidth)
      let n = Math.floor(this.box.nativeElement.clientWidth / 300);
      this.columns = (n > 0 ? n : 1);
    } else {
      this.columns = 1;
    }
  }

  ngOnInit() {
    const zoek = this.route.snapshot.paramMap.get('zoekterm');
    if (zoek !== null) {
      this.zoekterm = zoek;
      this.getProductWhereNameLike(this.zoekterm)
    }

  }

  getProductWhereNameLike(naam: string) {
    return this.http.post<Product[]>(this.database_url, naam).subscribe((data) => {
      this.resultaten = data;
    })
  }

}
