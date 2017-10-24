import {Injectable} from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from "rxjs/Observable";
import {IAuthenticationService} from "../iauthentication.service";
import {User} from "../../model/user";

const AUTH_USER_PATH: string = 'api/auth';
const REGISTER_USER_PATH = 'api/register';

@Injectable()
export class AuthenticationService implements IAuthenticationService {

    constructor(private http: Http) {
    }

    login(username: string, password: string): Observable<boolean> {
        return this.http.post(AUTH_USER_PATH, JSON.stringify({username: username, password: password}),
            this.getPlainRequestOptions())
            .map((response: Response) => {
                let token: string = response.headers.get('Authorization').slice(7);
                let authorities: string[] = JSON.parse(response.text());
                let currentUser: string = username;

                console.log(authorities);
                console.log(currentUser);
                if (token) {
                    localStorage.setItem('token', JSON.stringify(token));
                    localStorage.setItem('authorities', response.text());
                    localStorage.setItem('currentUser', username);
                    return true;
                } else {
                    return false;
                }
            })
            .catch((error: any) => Observable.throw(error));
    }

    logout(): void {
        localStorage.removeItem('token');
        localStorage.removeItem('authorities');
        localStorage.removeItem('currentUser');
    }

    register(user: User): Observable<User> {
        return this.http.post(REGISTER_USER_PATH, JSON.stringify(user), this.getPlainRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    isLoggedIn(): boolean {
        return !!localStorage.getItem('token');
    }

    private getPlainRequestOptions(): RequestOptions {
        return new RequestOptions({
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            }
        );
    }
}