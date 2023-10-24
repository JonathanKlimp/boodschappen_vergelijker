import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
  database_url: string = 'http://localhost:8080/zoek';
  resultaten!: Product[];
  resultatenCopy!: Product[];
  filters: Filters = {
    merkNamen: [],
  };
  columns: number = 4;
  showSpinner: boolean = true;

  constructor(private router: Router, private route: ActivatedRoute, private ss: SearchService, public http: HttpClient) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  @ViewChild('box', { static: false }) box!: ElementRef;


  onBoxResize() {
    if (this.box) {
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


 filterProducts(products: Product[], filters: Filters): Product[] {
  this.showSpinner = true;
  return this.resultaten.filter(product => {
    for(let i=0; i<this.filters.merkNamen!.length; i++) {
      if (product.supermarkt.merkNaam === this.filters.merkNamen![i]) {
        
        return false;
      } 
    }
      return true;
    });
  }

  onFilter() {
    let filteredProducts: Product[] = this.filterProducts(this.resultaten, this.filters);
    this.resultaten = filteredProducts;
    this.showSpinner= false;
  }

  filterResultaten(merkNaam: string) {
    console.log("in filter resultaat");
    console.log(merkNaam);
    this.filters.merkNamen?.push(merkNaam);
    this.onFilter();
  }

  getProductWhereNameLike(naam: string) {
    return this.http.post<Product[]>(this.database_url, naam).subscribe((data) => {
      this.resultaten = data;
      this.resultatenCopy = this.resultaten;
      this.showSpinner = false;
    })
  }

  sortPrijs() {
    this.showSpinner = true;
    this.resultaten.sort((a: Product, b: Product) => a.prijs - b.prijs);
    this.showSpinner = false;
    // products.sort((a: Product, b: Product) => a.price - b.price);
  }

  sortPrijsAsc() { 
    this.resultaten.sort((a: Product, b: Product) => b.prijs - a.prijs);
  }

  unSort() {
    this.resultaten = this.resultatenCopy;
  }
}

interface Filters {
  merkNamen?: string[];
  // Add more filter properties as needed
}