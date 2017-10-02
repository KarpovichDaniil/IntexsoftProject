import {Component, Inject, OnInit} from "@angular/core";
import {IGoodsService} from "../service/igoods.service";
import {Goods} from "../model/goods";
import {ActivatedRoute, Router} from "@angular/router";

const SIZE_OF_A_PAGE = 3;

const PAGE_STEP = 1;

@Component({
    selector: 'goods',
    templateUrl: '../../assets/html/goods.component.html',
    styleUrls: ['../../assets/style/goods.component.css']
})
export class GoodsComponent implements OnInit {

    pageNumber: number;
    errorMessage: string;
    goods: Goods[];

    constructor(@Inject('goodsService') private goodsService: IGoodsService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit(): void {
        this.goodsService.findAll()
            .subscribe((goods: Goods[]) => {
                    this.goods = goods;
                },
                error => {
                    this.errorMessage = 'Sorry! No more goods available at the moment!';
                });
        this.pageNumber += PAGE_STEP;
    }

   /* findAll(): void {
        return new Promise((resolve, reject) => {
            this.http.get(/api/product)
                .subscribe(resp => resolve(resp.json())
                    , error => alert(error.message));
        });
        /*this.goodsService.findAll()
            .subscribe((goods: Goods[]) => this.goods = goods),
            (error => alert(error.message));
    }*/
}
