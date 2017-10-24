import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";

@Injectable()
export class AdminSectionGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let authorities: string[] = JSON.parse(localStorage.getItem('authorities'));
        for (let authority of authorities) {
            switch (authority) {
                case 'ROLE_ADMIN' :
                    return true;
            }
        }
        return false;
    }
}