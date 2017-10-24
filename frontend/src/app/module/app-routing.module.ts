import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UserDetailComponent} from "../component/user-detail.component";
import {LoginFormComponent} from "../component/login-form.component";
import {GoodsComponent} from "../component/goods.component";
import {SignupFormComponent} from "../component/signup-form.component";
import {PageNotFoundComponent} from "../component/page-not-found.component";
import {GoodsDetailComponent} from "../component/goods-detail.component";
import {AdminComponent} from "../component/admin.component";
import {GoodsCreationComponent} from "../component/goods-creation.component";
import {AdminSectionGuard} from "../guard/admin-section.guard";
import {GoodsCreationSectionGuard} from "../guard/goods-creation-section-guard";

const routes: Routes = [
    {
        path: '',
        redirectTo: 'goods',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginFormComponent
    },
    {
        path: 'goods',
        component: GoodsComponent
    },
    {
        path: 'signup',
        component: SignupFormComponent
    },
    {
        path: 'admin',
        component: AdminComponent,
        canActivate: [AdminSectionGuard]
    },
    {
        path: 'create',
        component: GoodsCreationComponent,
        canActivate: [GoodsCreationSectionGuard]
    },
    {
        path: 'user/:id',
        component: UserDetailComponent
    },
    {
        path: 'goods/:id',
        component: GoodsDetailComponent
    },
    {
        path: '**',
        component: PageNotFoundComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
