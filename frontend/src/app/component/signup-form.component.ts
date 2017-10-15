import {Component, OnInit, Inject} from "@angular/core";
import {Router} from "@angular/router";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {User} from "../model/user";
import {IAuthenticationService} from "../service/iauthentication.service";

/**
 * @type {RegExp} - регулярное выражение, используется для проверки правильности ввода email адресса
 */
const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
    selector: 'signup-component',
    templateUrl: '../../assets/html/signup-form.component.html',
    styleUrls: ['../../assets/style/signup-form.component.css']
})
export class SignupFormComponent implements OnInit {

    newUser: User;
    signupFormControl: FormGroup;

    errorMessage: string;

    submitted: boolean = false;

    constructor(@Inject('authenticationService') private authenticationService: IAuthenticationService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.newUser = new User();
        this.signupFormControl = new FormGroup({
            'validName': new FormControl(this.newUser.username, [Validators.required, Validators.minLength(4), Validators.maxLength(16)]),
            'validPassword': new FormControl(this.newUser.password, [Validators.required, Validators.minLength(4), Validators.maxLength(16)]),
            'validEmail': new FormControl(this.newUser.email, [Validators.required, Validators.pattern(EMAIL_REGEX)]),
        });
    }

    register(): void {
        this.submitted = true;
        this.errorMessage = null;

        let user: User = this.newUser;
        this.newUser.enabled = false;
        this.authenticationService.register(user)
            .subscribe(result => {
                    this.router.navigate(['/'])
                },
                error => {
                    this.submitted = false;
                    this.errorMessage = 'Failed';
                });
    }
}
