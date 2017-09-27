import {Users} from "../model/user";
import {Observable} from "rxjs";

/**
 * Interface specifies basic authentication methods
 */
export interface IAuthenticationService {

    login(username: string, password: string): Observable<boolean>;

    logout(): void;

    isLoggedIn(): boolean;

    register(user: Users): Observable<Users>;
}
