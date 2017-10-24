import {Component, Inject} from '@angular/core';
import {IUsersService} from "../service/iuser.service";
import {User} from "../model/user";

const INFO_MESSAGE: string = 'Admin_Info';
const ERROR_MESSAGE: string = 'Admin_Error';

@Component({
    selector: 'app-admin',
    templateUrl: '../../assets/html/admin.component.html',
    styleUrls: ['../../assets/style/admin.component.css']
})
export class AdminComponent {

    errorMessage: string;

    infoMessage: string;

    showInfo: boolean;

    submitted: boolean;

    currentUserNumber: number;

    users: User[];

    constructor(@Inject('userService') private userService: IUsersService) {
        this.currentUserNumber = 1;
        this.submitted = false;
        this.showInfo = true;
        this.infoMessage = INFO_MESSAGE;
        this.users = [];
    }

    getAllUsers(): void {
        this.submitted = false;
        this.userService.findAll()
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

    getAllEnabled(enabled: boolean): void {
        this.submitted = false;
        this.userService.findAllEnabled(enabled)
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