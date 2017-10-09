import {Goods} from "../model/goods";
import {Component, OnInit, Inject} from "@angular/core";
import {IGoodsService} from "../service/igoods.service";
import {ActivatedRoute, Router, ParamMap} from "@angular/router";


@Component({
    selector: 'goods-detail',
    templateUrl: '../../assets/html/goods-detail.component.html',
    styleUrls: ['../../assets/style/goods-detail.component.css']
})
export class GoodsDetailComponent implements OnInit {

    singleGoods: Goods;

    constructor(@Inject('goodsService') private goodsService: IGoodsService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getOne();
    }

    getOne(): void {
        this.route.paramMap
            .switchMap((params: ParamMap) => this.goodsService.getOne(+params.get('id')))
            .subscribe((goods: Goods) => {
                    this.singleGoods = goods;
                }
            );
    }

    goBack(): void {
        this.router.navigateByUrl('/goods');
    }

    save(): void {
        this.goodsService.save(this.singleGoods)
            .subscribe(result => {
                this.router.navigate(['/'])
            });
    }
}