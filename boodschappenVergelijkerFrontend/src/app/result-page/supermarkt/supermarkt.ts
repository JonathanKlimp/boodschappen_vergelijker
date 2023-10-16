import { Product } from "../product/product";

export class Supermarkt {
    id!: number;
    naam!: string;
    url!: string;
    merkNaam!: string;
    logo!: string;
    producten!: Product[]
}
