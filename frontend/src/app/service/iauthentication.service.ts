import User from "../model/user";
import {Observable} from "rxjs";

export interface IAuthenticationService {

    login(username: string, password: string): Observable<boolean>;

    logout(): void;

    register(user: User): Observable<User>;

    isLoggedIn(): boolean;
}
