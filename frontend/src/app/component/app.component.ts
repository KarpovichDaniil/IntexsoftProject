import {Component, Inject} from "@angular/core";
import {TranslateService} from "@ngx-translate/core";
import {IAuthenticationService} from "../service/iauthentication.service";
import {Router} from "@angular/router";
import {Categories} from "../model/categories"

@Component({
    selector: 'body',
    templateUrl: '../../assets/html/app.component.html',
    styleUrls: ['../../assets/style/app.component.css']
})
export class AppComponent {

    categories: Categories[];

    constructor(@Inject('authenticationService') private authenticationService: IAuthenticationService,
                private router: Router,
                private translate: TranslateService) {
        translate.setDefaultLang('en');
    }

    switchLanguage(language: string): void {
        this.translate.use(language);
    }

    haveAccess(): boolean {
        return !!localStorage.getItem('roles');
    }

    isLoggedIn(): boolean {
        return this.authenticationService.isLoggedIn();
    }

    logout(): void {
        this.authenticationService.logout();
    }
}
