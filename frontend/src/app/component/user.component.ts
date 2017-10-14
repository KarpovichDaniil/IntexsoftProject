import {Component, Inject, OnInit} from '@angular/core';

import {User} from "../model/user";
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

    selectedUser: User;
    users: User[]=[];


    constructor(@Inject('userService') private userService: IUsersService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.findAll();
    }

    findAll(): void {
        this.userService.findAll()
            .subscribe((users: User[]) => this.users = users),
            (error => alert(error.message));
    }

    onSelect(user: User): void {
        this.selectedUser = user;
    }

    showDetails(): void {
        this.router.navigate(['/user', this.selectedUser.id])
            .catch((e: Error) => alert(e.message));
    }
}
