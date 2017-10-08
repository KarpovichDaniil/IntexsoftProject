import {Component, Inject, OnInit} from '@angular/core';
import {IGoodsService} from "../service/igoods.service";
import {Goods} from "../model/goods";
import {IUsersService} from "../service/iuser.service";
import {Users} from "../model/user";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
    selector: 'app-workspace',
    templateUrl: '../../assets/html/workspace.component.html',
    styleUrls: ['../../assets/style/workspace.component.css']
})
export class WorkspaceComponent {
    users: Users[]=[];
    goods: Goods[]=[];
    singleGoods: Goods;
    selectedCategory: string;
    categories = [
        {value: 'car', viewValue: 'Cars'},
        {value: 'real-estate', viewValue: 'Real estate'},
        {value: 'clothes', viewValue: 'Clothes'},
        {value: 'tech', viewValue: 'Tech'},
    ];

    constructor(@Inject('goodsService') private goodsService: IGoodsService, @Inject('userService') private userService: IUsersService,
                private route: ActivatedRoute,
                private router: Router) {

    }
    findAllGoods(): void {
        this.goodsService.getAllGoods()
            .then((goods: Goods[]) => this.goods = goods);
    }
    findAllUsers(): void {
        this.userService.findAll()
            .subscribe((users: Users[]) => this.users = users),
            (error => alert(error.message));
    }
    saveGoods(): void {
        this.goodsService.save(this.singleGoods)
            .subscribe(result => {
                this.router.navigate(['/'])
            });
    }
}
