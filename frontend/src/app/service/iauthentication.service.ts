import {Users} from "../model/user";
import {Observable} from "rxjs";

export interface IAuthenticationService {

    login(username: string, password: string): Observable<boolean>;

    logout(): void;

    isLoggedIn(): boolean;

    register(user: Users): Observable<Users>;
}
