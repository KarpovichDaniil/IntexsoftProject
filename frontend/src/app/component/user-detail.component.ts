import {Component, Inject, OnInit} from '@angular/core';
import 'rxjs/add/operator/switchMap';
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {User} from "../model/user";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {IUsersService} from "../service/iuser.service";
import Role from "../model/role";

const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
    selector: 'user-detail',
    templateUrl: '../../assets/html/user-detail.component.html',
    styleUrls: ['../../assets/style/user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

    currentUser: User;
    userDetailFormControl: FormGroup;

    errorMessage: string;

    submitted: boolean = false;

    roles = {
        isAdmin: false,
        isModerator: false,
        isUser: false
    };

    constructor(@Inject("userService") private userService: IUsersService,
                private route: ActivatedRoute,
                private router: Router) {
    }

    ngOnInit(): void {
        this.currentUser = new User();
        this.getOne();
        this.userDetailFormControl = new FormGroup({
            'validName': new FormControl(this.currentUser.username, [Validators.required, Validators.minLength(5), Validators.maxLength(16)]),
            'validPassword': new FormControl(this.currentUser.password, [Validators.required, Validators.minLength(5), Validators.maxLength(16)]),
            'validEmail': new FormControl(this.currentUser.email, [Validators.pattern(EMAIL_REGEX)]),
            'validEnabled': new FormControl(this.currentUser.enabled, [Validators.required]),
            'validAuthority': new FormControl(this.currentUser.roles, [Validators.required])
        });
    }

    getOne(): void {
        this.route.paramMap
            .switchMap((params: ParamMap) => this.userService.getOne(+params.get('id')))
            .subscribe((user: User) => {
                this.currentUser = user;
                this.syncRolesArray();
            });
    }

    deleteUser(): void {
        this.route.paramMap
            .switchMap((params: ParamMap) => this.userService.deleteUser(+params.get('id')))
            .subscribe((result: boolean) => {
                    this.goBack();
                },
                error => {
                    this.errorMessage = "Error! User has not been deleted!";
                });
    }

    goBack(): void {
        this.router.navigateByUrl('/admin');
    }

    saveUser(): void {
        this.currentUser.roles = this.createRolesArray();
        this.userService.saveByAdmin(this.currentUser)
            .subscribe(result => {
                this.goBack();
            });
    }

    syncRolesArray(): void {
        for (let role of this.currentUser.roles) {
            if (role.role === 'ROLE_ADMIN') {
                this.roles.isAdmin = true;
            }
            if (role.role === 'ROLE_MODERATOR') {
                this.roles.isModerator = true;
            }
            if (role.role === 'ROLE_USER') {
                this.roles.isUser = true;
            }
        }
    }

    createRolesArray(): Role[] {
        let rolesArray: Role[] = [];
        if (this.roles.isAdmin) {
            rolesArray.push(new Role(1, 'ROLE_ADMIN'))
        }
        if (this.roles.isModerator) {
            rolesArray.push(new Role(2, 'ROLE_MODERATOR'))
        }
        if (this.roles.isUser) {
            rolesArray.push(new Role(3, 'ROLE_USER'))
        }
        return rolesArray;
    }

    save(): void {
        this.submitted = true;
        this.errorMessage = null;
        let user: User = this.currentUser;
        this.userService.save(this.currentUser)
            .subscribe(result => {
                    this.router.navigate(['/'])
                },
                error => {
                    this.submitted = false;
                    this.errorMessage = 'Failed';
                });
        this.submitted = false;
    }
}
