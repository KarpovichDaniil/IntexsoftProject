import {Users} from "../model/user";
import {Observable} from "rxjs";


export interface IUsersService {

    findAll(): Observable<Users[]>;

    getOne(id: number): Observable<Users>;

    save(user: Users): Observable<Users>;
}