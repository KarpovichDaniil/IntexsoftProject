import {Component, Inject, OnInit} from '@angular/core';

import {Users} from "../model/user";
import {Router} from "@angular/router";
import {IUsersService} from "../service/iuser.service";

/**
 * Controller which using provided services displays college users
 */
@Component({
    selector: 'users-root',
    templateUrl: '../../assets/html/user.component.html',
    styleUrls: ['../../assets/style/user.component.css']
})
export class UserComponent implements OnInit {

    selectedUser: Users;
    users: Users[]=[];


    constructor(@Inject('userService') private userService: IUsersService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.findAll();
    }

    findAll(): void {
        this.userService.findAll()
            .subscribe((users: Users[]) => this.users = users),
            (error => alert(error.message));
    }

    onSelect(user: Users): void {
        this.selectedUser = user;
    }

    showDetails(): void {
        this.router.navigate(['/user', this.selectedUser.id])
            .catch((e: Error) => alert(e.message));
    }
}
