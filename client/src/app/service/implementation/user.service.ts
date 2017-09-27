import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Users} from "../../model/user";
import {IUsersService} from "../iuser.service";
import {Observable} from "rxjs";

const ALL_USERS_PATH = 'api/users';
const USER_PATH = 'api/user';

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

    findAll(): Observable<Users[]> {
        return this.http.get(ALL_USERS_PATH, this.getAuthRequestOptions())
            .map((response: Response) => {
            response.json()
            })
            .catch((error: any) => Observable.throw(error));
    }

    getOne(id: number): Observable<Users> {
        const url = `${USER_PATH}/${id}`;
        return this.http.get(url, this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    save(user: Users): Observable<Users> {
        return this.http.post(USER_PATH, JSON.stringify(user), this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }
}
