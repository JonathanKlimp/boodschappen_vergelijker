import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/app/landing/search/search.service';
import { ProductService } from './product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


  constructor(private searchService: SearchService, private productService: ProductService) {
    console.log('aangemaakt')
  }

  ngOnInit() {
    console.log('begin subscribe')
    this.searchService.getZoekterm().subscribe(zoekterm => {
      console.log('Gevonden' + zoekterm)
      this.productService.getProductWhereNameLike(zoekterm)
    })
  }


}
