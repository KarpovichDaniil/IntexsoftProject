import {Component, Inject, OnInit} from '@angular/core';
import {IGoodsService} from "../service/igoods.service";
import {Goods} from "../model/goods";
import {IUsersService} from "../service/iuser.service";
import User from "../model/user";
import Category from "../model/category";
import {Router} from "@angular/router";

const INFO_MESSAGE: string = 'Admin_Info';

const ERROR_MESSAGE: string = 'Admin_Error';

@Component({
    selector: 'app-workspace',
    templateUrl: '../../assets/html/workspace.component.html',
    styleUrls: ['../../assets/style/workspace.component.css']
})
export class WorkspaceComponent {
    users: User[];
    goods: Goods[];
    singleGoods: Goods;
    categories: Category[];

    errorMessage: string;

    infoMessage: string;

    showInfo: boolean;

    submitted: boolean;

    methodNumber: number;

    constructor(@Inject('goodsService') private goodsService: IGoodsService, @Inject('userService') private userService: IUsersService,
                private router: Router) {
        this.submitted = false;
        this.showInfo = true;
        this.infoMessage = INFO_MESSAGE;
        this.users = [];
    }

    findAllGoods(): void {
        this.goodsService.getAll()
            .subscribe((goods: Goods[]) => this.goods = goods);
        (error => alert(error.message));
    }

    findAllUsers(): void {
        this.userService.getAll()
            .subscribe((users: User[]) => this.users = users),
            (error => alert(error.message));
    }

    saveGoods(): void {
        this.goodsService.save(this.singleGoods)
            .subscribe(result => {
                this.router.navigate(['/'])
            });
    }

    getEnabled(): void {
        this.methodNumber = 1;
        this.getAllEnabled(true);
    }

    getDisabled(): void {
        this.methodNumber = 2;
        this.getAllEnabled(false);
    }

    private getAllEnabled(enabled: boolean): void {
        this.submitted = false;
        this.userService.getAllEnabled(enabled)
            .subscribe((users: User[]) => {
                    this.users = users;
                    this.submitted = true;
                },
                error => {
                    this.errorMessage = ERROR_MESSAGE;
                    this.submitted = true;
                });
        this.showInfo = false;
    }
}
