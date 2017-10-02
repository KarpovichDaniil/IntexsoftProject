import {Component, OnInit, Inject} from "@angular/core";
import {Router} from "@angular/router";
import {IAuthenticationService} from "../service/iauthentication.service";
import {FormGroup, Validators, FormControl} from "@angular/forms";

/**
 * Login page controller
 */
@Component({
    selector: 'login-form',
    templateUrl: '../../assets/html/login-form.component.html',
    styleUrls: ['../../assets/style/login-form.component.css']
})
export class LoginFormComponent implements OnInit {
    username: string;
    password: string;
    loginFormControl: FormGroup;

    errorMessage: string;

    submitted: boolean = false;

    constructor(@Inject('authenticationService') private authenticationService: IAuthenticationService,
                private router: Router) {
    }

    ngOnInit(): void {
        this.authenticationService.logout();
        this.loginFormControl = new FormGroup({
            'validName': new FormControl(this.username, [Validators.required, Validators.minLength(3), Validators.maxLength(16)]),
            'validPassword': new FormControl(this.password, [Validators.required, Validators.minLength(3), Validators.maxLength(16)])
        });
    }

    login(): void {
        this.submitted = true;
        this.errorMessage = null;
        this.authenticationService.login(this.username, this.password)
            .subscribe(result => {
                    this.router.navigate(['/'])
                },
                error => {
                    this.submitted = false;
                    this.errorMessage = 'Incorrect username or password';
                });
    }
}
