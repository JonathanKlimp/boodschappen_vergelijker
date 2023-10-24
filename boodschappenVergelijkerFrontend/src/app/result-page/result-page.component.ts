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
    merkNamen: ['AH'], 
  };
  

  constructor(private router: Router, private route: ActivatedRoute, private ss: SearchService, public http: HttpClient) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  columns: number = 4;
  showSpinner: boolean = true;

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

  // Sample array of products

// Define filters

// Function to filter products based on the provided filters
 filterProducts(products: Product[], filters: Filters): Product[] {
  return this.resultaten.filter(product => {
    // Apply filters
    for(let i=0; i<this.filters.merkNamen!.length; i++) {
      console.log("merknaam: " + this.filters.merkNamen![i]);
      if (product.supermarkt.merkNaam === this.filters.merkNamen![i]) {
        console.log("LOGG")
        console.log(this.filters.merkNamen![i]);
        console.log(product.supermarkt.merkNaam);
        console.log(product.naam)
        
        return false;
      } 
    }
      console.log("true")
      console.log(product.supermarkt.merkNaam);
      // return true;
    
    // Add more filters as needed
    // If the product passes all filters, include it in the result
    return true;
  });
}

  onFilter() {
    let filteredProducts: Product[] = this.filterProducts(this.resultaten, this.filters);
    console.log(filteredProducts);
    this.resultaten = filteredProducts;
  }

  getProductWhereNameLike(naam: string) {
    return this.http.post<Product[]>(this.database_url, naam).subscribe((data) => {
      this.resultaten = data;
      this.resultatenCopy = this.resultaten;
      this.showSpinner = false;
    })
  }

  sortPrijs() {
    this.resultaten.sort((a: Product, b: Product) => a.prijs - b.prijs);
    // products.sort((a: Product, b: Product) => a.price - b.price);
  }
}

interface Filters {
  merkNamen?: string[];
  // Add more filter properties as needed
}