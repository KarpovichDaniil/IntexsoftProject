import {BrowserModule} from "@angular/platform-browser";
import {
    MdToolbarModule,
    MdTabsModule,
    MdButtonModule,
    MdMenuModule,
    MdIconModule,
    MdCardModule,
    MdInputModule,
    MdProgressSpinnerModule,
    MdExpansionModule,
    MdDatepickerModule,
    MdNativeDateModule,
    MdGridListModule,
    MdSelectModule,
    MdTableModule,
    MdRadioModule,
    MdSlideToggleModule,
    MdCheckboxModule,
    MdSidenavModule
} from "@angular/material";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {AppComponent} from "../component/app.component";
import {UserDetailComponent} from "../component/user-detail.component";
import {UsersService} from "../service/implementation/user.service";
import {AppRoutingModule} from "./app-routing.module";
import {LoginFormComponent} from "../component/login-form.component";
import {GoodsComponent} from "../component/goods.component";
import {AuthenticationService} from "../service/implementation/authentication.service";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {SignupFormComponent} from '../component/signup-form.component';
import {PageNotFoundComponent} from '../component/page-not-found.component';
import {GoodsService} from "../service/implementation/goods.service";
import {GoodsDetailComponent} from "../component/goods-detail.component";
import {AdminComponent} from "../component/admin.component";
import {GoodsCreationComponent} from "../component/goods-creation.component";
import {AdminSectionGuard} from "../guard/admin-section.guard";
import {GoodsCreationSectionGuard} from "../guard/goods-creation-section-guard";

const URL_I18N_FILES = 'assets/i18n/';
const FILE_FORMAT = '.json';

export function HttpLoaderFactory(http: HttpClient): TranslateLoader {
    return new TranslateHttpLoader(http, URL_I18N_FILES, FILE_FORMAT);
}


@NgModule({
    declarations: [
        AppComponent,
        UserDetailComponent,
        LoginFormComponent,
        GoodsComponent,
        GoodsDetailComponent,
        SignupFormComponent,
        PageNotFoundComponent,
        GoodsCreationComponent,
        AdminComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        MdToolbarModule,
        MdTabsModule,
        MdButtonModule,
        MdMenuModule,
        MdIconModule,
        MdCardModule,
        MdInputModule,
        MdProgressSpinnerModule,
        MdExpansionModule,
        MdDatepickerModule,
        MdNativeDateModule,
        MdGridListModule,
        MdSelectModule,
        MdTableModule,
        MdRadioModule,
        MdSlideToggleModule,
        MdCheckboxModule,
        MdSidenavModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        HttpModule,
        HttpClientModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [HttpClient]
            }
        })
    ],
    providers: [
        {provide: 'userService', useClass: UsersService},
        {provide: 'authenticationService', useClass: AuthenticationService},
        {provide: 'goodsService', useClass: GoodsService},
        AdminSectionGuard,
        GoodsCreationSectionGuard
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
