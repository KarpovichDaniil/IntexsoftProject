import {Component, Inject, OnInit} from "@angular/core";
import {IGoodsService} from "../service/igoods.service";
import {Goods} from "../model/goods";

const SIZE_OF_A_PAGE = 5;

const PAGE_STEP = 1;

@Component({
    selector: 'goods',
    templateUrl: '../../assets/html/goods.component.html',
    styleUrls: ['../../assets/style/news.component.css']
})
export class GoodsComponent implements OnInit {

    private pageNumber: number;
    private errorMessage: string;
    private title: Goods[];

    constructor(@Inject('goodsService') private goodsService: IGoodsService) {
        this.pageNumber = 0;
    }

    ngOnInit(): void {
        this.goodsService.findSubset(this.pageNumber.toString(), SIZE_OF_A_PAGE.toString())
            .subscribe((goods: Goods[]) => {
                    this.title = goods;
                },
                error => {
                    this.errorMessage = 'Sorry! No more goods available at the moment!';
                });
        this.pageNumber += PAGE_STEP;
    }

    loadMoreGoods(): void {
        this.goodsService.findSubset(this.pageNumber.toString(), SIZE_OF_A_PAGE.toString())
            .subscribe((goods: Goods[]) => {
                    goods.forEach(oneGoods =>
                        this.title.push(oneGoods)
                    )
                },
                error => {
                    this.errorMessage = 'Sorry! No more goods available at the moment!';
                });
        this.pageNumber += PAGE_STEP;
    }
}
