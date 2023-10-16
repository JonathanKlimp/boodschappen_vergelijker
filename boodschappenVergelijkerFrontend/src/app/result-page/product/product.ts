import { Supermarkt } from "../supermarkt/supermarkt"

export class Product {
    id!: number
    naam!: string
    url!: string
    prijs!: number
    inhoud!: string
    imageUrl!: string
    supermarkt!: Supermarkt
}
