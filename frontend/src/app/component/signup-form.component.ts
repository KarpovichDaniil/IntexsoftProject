import {Component, OnInit, Inject} from "@angular/core";
import {Router} from "@angular/router";
import {IUsersService} from "../service/iuser.service";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {Users} from "../model/user";
import {IAuthenticationService} from "../service/iauthentication.service";

/**
 * @type {RegExp} - is used to validate provided email address
 */
const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

/**
 * Controller for sign-up form. Determines whether or not a Guest provides enough information for
 * http request
 */
@Component({
    selector: 'signup-component',
    templateUrl: '../../assets/html/signup-form.component.html',
    styleUrls: ['../../assets/style/signup-form.component.css']
})
export class SignupFormComponent implements OnInit {

    newUser: Users;
    signupFormControl: FormGroup;

    errorMessage: string;

    submitted: boolean = false;

    constructor(@Inject('authenticationService') private authenticationService: IAuthenticationService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.newUser = new Users();
        this.signupFormControl = new FormGroup({
            'validName': new FormControl(this.newUser.username, [Validators.required, Validators.minLength(3), Validators.maxLength(16)]),
            'validPassword': new FormControl(this.newUser.password, [Validators.required, Validators.minLength(3), Validators.maxLength(16)]),
            'validEmail': new FormControl(this.newUser.email, [Validators.pattern(EMAIL_REGEX)])
        });
    }

    register(): void {
        this.submitted = true;
        this.errorMessage = null;

        let user: Users = this.newUser;
        this.authenticationService.register(user)
            .subscribe(result => {
                    this.router.navigate(['/'])
                },
                error => {
                    this.submitted = false;
                    this.errorMessage = 'Registration failed. Try another username';
                });
    }
}
