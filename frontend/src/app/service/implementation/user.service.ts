import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import User from "../../model/user";
import {IUsersService} from "../iuser.service";
import {Observable} from "rxjs";
import "rxjs/add/operator/toPromise";

const ALL_USERS_PATH = 'api/users/all';
const USER_PATH = 'api/user/';
const USER_PATH_FOR_ADMIN = 'api/user/admin';
const CURRENT_USER_PATH = 'api/user/current';

/**
 * Service which provides method to perform basic CRUD operations
 */
@Injectable()
export class UsersService implements IUsersService {

    constructor(private http: Http) {
    }

    private getAuthRequestOptions(): RequestOptions {
        return new RequestOptions({
                headers: new Headers({
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem('token'))
                })
            }
        );
    }

    getAll(): Observable<User[]> {
        return this.http.get(ALL_USERS_PATH, this.getAuthRequestOptions())
            .map((response: Response) => {
               return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    getOne(id: number): Observable<User> {
        const url = `${USER_PATH}/${id}`;
        return this.http.get(url, this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    save(user: User): Observable<User> {
        return this.http.post(USER_PATH, JSON.stringify(user), this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    saveByAdmin(user: User): Observable<User> {
        return this.http.post(USER_PATH_FOR_ADMIN, JSON.stringify(user), this.getAuthRequestOptions())
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    obtainUser(user: User): Observable<User> {
        return this.http.post(CURRENT_USER_PATH, JSON.stringify(user), this.getAuthRequestOptions())
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    getAllEnabled(enabled: boolean): Observable<User[]> {
        return this.http.get(ALL_USERS_PATH + '/' + enabled, this.getAuthRequestOptions())
            .map((response: Response) => {
                return response.json().content;
            })
            .catch((error: any) => Observable.throw(error));
    }

    deleteUser(id: number): Observable<boolean> {
        let url = `${USER_PATH}${id}`;
        return this.http.get(url, this.getAuthRequestOptions())
            .map((response: Response) => {
                return true;
            })
            .catch((error: any) => Observable.throw(error));
    }
}
