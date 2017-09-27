import {Component, Inject, OnInit} from '@angular/core';
import {Users} from "../model/user";
import {IUsersService} from "../service/iuser.service";

const NUMBER_OF_USERS: number = 4;


@Component({
    selector: 'users-dashboard',
    templateUrl: '../../assets/html/dashboard.component.html',
    styleUrls: ['../../assets/style/dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    users: Users[];

    constructor(@Inject('userService') private userService: IUsersService) {
    }

    ngOnInit(): void {
        this.refresh();
    }

    refresh() {
        this.userService.findAll()
            .subscribe((users: Users[]) => this.users = users.slice(0, NUMBER_OF_USERS)),
            error => alert(error.message);
    }
}
