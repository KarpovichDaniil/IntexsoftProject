import {Component, Inject, OnInit} from "@angular/core";
import {IGoodsService} from "../service/igoods.service";
import {Goods} from "../model/goods";

@Component({
    selector: 'goods',
    templateUrl: '../../assets/html/goods.component.html',
    styleUrls: ['../../assets/style/goods.component.css']
})
export class GoodsComponent implements OnInit {

    errorMessage: string;
    goods: Goods[];
    imagePath: string = './assets/image/';
    imageFormat: string = '.jpeg';

    constructor(@Inject('goodsService') private goodsService: IGoodsService) {
    }

    ngOnInit(): void {
       this.findAll();
    }

    findAll() {
        this.goodsService.getAll()
            .subscribe((goods: Goods[]) => {
                    this.goods = goods;
                },
                error => {
                    this.errorMessage = 'Sorry! No more goods available at the moment!';
                });
    }

    getByCategory(id: number): void {
        this.goodsService.findByCategory(id)
            .subscribe((goods: Goods[]) => {
                    this.goods = goods;
                },
                error => {
                    this.errorMessage = 'Error with category change!';
                });
    }
}
