import {Component, Inject, OnInit} from '@angular/core';
import 'rxjs/add/operator/switchMap';

import User from "../model/user";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {IUsersService} from "../service/iuser.service";

@Component({
    selector: 'user-detail',
    templateUrl: '../../assets/html/user-detail.component.html',
    styleUrls: ['../../assets/style/user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

    user: User;

    constructor(@Inject("userService") private userService: IUsersService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit(): void {
        this.getOne();
    }

    getOne(): void {
        this.route.paramMap
            .switchMap((params: ParamMap) => this.userService.getOne(+params.get('id')))
            .subscribe((user: User) => this.user = user);
    }

    goBack(): void {
        this.router.navigateByUrl('dashboard');
    }

    save(): void {
        this.userService.save(this.user)
            .subscribe(result => {
                this.router.navigate(['/'])
            });
    }
}
