import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";

@Injectable()
export class GoodsCreationSectionGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let authorities: string[] = JSON.parse(localStorage.getItem('authorities'));
        for (let authority of authorities) {
            switch (authority) {
                case 'ROLE_USER':
                    return true;
                case 'ROLE_MODERATOR':
                    return true;
                case 'ROLE_ADMIN':
                    return true;
            }
        }
        return false;
    }
}