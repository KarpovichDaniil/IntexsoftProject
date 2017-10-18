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
        this.goodsService.getAll()
            .subscribe((goods: Goods[]) => {
                    this.goods = goods;
                },
                error => {
                    this.errorMessage = 'Sorry! No more goods available at the moment!';
                });
        /*this.getAll();*/
    }

    /*   getAll(): void {
          this.goodsService.getAllGoods()
              .then((goods: Goods[]) => this.goods = goods);
      }
  */
    /*this.goodsService.findAll()
        .subscribe((goods: Goods[]) => {
                this.goods = goods;
            },
            error => {
                this.errorMessage = 'Sorry! No more goods available at the moment!';
            });
    this.pageNumber += PAGE_STEP;*/


    /*findAll(): {
    return new Promise((resolve, reject) => {
        this.http.get(api/goods)
            .subscribe(resp => resolve(resp.json())
                , error => alert(error.message));
    });}

    /*this.goodsService.findAll()
        .subscribe((goods: Goods[]) => this.goods = goods),
        (error => alert(error.message));
}*/
}
