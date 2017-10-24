import {Component, OnInit, Inject} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {Goods} from "../model/goods";
import {NativeDateAdapter, DateAdapter} from "@angular/material";
import Category from "../model/category";
import City from "../model/city";
import {IGoodsService} from "../service/igoods.service";
import {Router} from "@angular/router";
import {User} from "../model/user";

@Component({
    selector: 'app-article-creation',
    templateUrl: '../../assets/html/goods-creation.component.html',
    styleUrls: ['../../assets/style/goods-creation.component.css']
})
export class GoodsCreationComponent implements OnInit {

    oneGoods: Goods;
    goodsFormControl: FormGroup;

    errorMessage: string;

    submitted: boolean = false;

    categories = [
        'Cars',
        'Real estate',
        'Clothes',
        'Tech'
    ];

    cities = [
        'Grodno',
        'Minsk',
        'Homel',
        'Brest',
        'Mogilev',
        'Vitebsk'
    ];

    cutString:string;

    choosingCategory: string;
    choosingCity: string;
    constructor(@Inject('goodsService') private goodsService: IGoodsService,
                private router: Router,
                dateAdapter: DateAdapter<NativeDateAdapter>) {
        dateAdapter.setLocale('en-GB');
    }

    ngOnInit() {
        console.log(localStorage.getItem('currentUser'));
        this.cutString=localStorage.getItem('currentUser').toString();
        console.log(this.cutString);
        this.oneGoods = new Goods();
        this.goodsFormControl = new FormGroup({
            'validTitle': new FormControl(this.oneGoods.title, [Validators.required, Validators.minLength(5), Validators.maxLength(150)]),
            'validDescription': new FormControl(this.oneGoods.description, [Validators.required, Validators.minLength(50), Validators.maxLength(5000)]),
            'validPrice': new FormControl(this.oneGoods.price, [Validators.required, Validators.minLength(5), Validators.maxLength(100)]),
            'validPhone': new FormControl(this.oneGoods.phone, [Validators.required, Validators.minLength(5), Validators.maxLength(20)]),
        });
    }

    //TODO:fix this shit
    private createCategoryType(): Category {
        let categoryType: Category;
        if (this.choosingCategory='Cars') {
            categoryType = new Category(1, 'Cars')
        }
        if (this.choosingCategory='Real estate') {
            categoryType = new Category(2, 'Real estate')
        }
        if (this.choosingCategory='Clothes') {
            categoryType = new Category(3, 'Clothes')
        }
        if (this.choosingCategory='Tech') {
            categoryType = new Category(4, 'Tech')
        }
        return categoryType;
    }

    private createCityType(): City {
        let cityType: City;
        if (this.choosingCity='Grodno') {
            cityType = new City(1, 'Grodno')
        }
        if (this.choosingCity='Minsk') {
            cityType = new City(2, 'Minsk')
        }
        if (this.choosingCity='Homel') {
            cityType = new City(3, 'Homel')
        }
        if (this.choosingCity='Brest') {
            cityType = new City(4, 'Brest')
        }
        if (this.choosingCity='Brest') {
            cityType = new City(5, 'Mogilev')
        }
        if (this.choosingCity='Brest') {
            cityType = new City(6, 'Vitebsk')
        }
        return cityType;
    }

    uploadGoods(): void {
        this.oneGoods.user=new User(localStorage.getItem('currentUser').toString());
        this.oneGoods.city = this.createCityType();
        this.oneGoods.category = this.createCategoryType();
        this.save();
    }

    save(): void {
        this.submitted = true;
        this.errorMessage = null;
        let oneGoods: Goods = this.oneGoods;
        this.oneGoods.created_date = new Date();
        this.goodsService.save(oneGoods)
            .subscribe(result => {
                    this.router.navigate(['/'])
                },
                error => {
                    this.submitted = false;
                    this.errorMessage = "Failer";
                });
    }
}
