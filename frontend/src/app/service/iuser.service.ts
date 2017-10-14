import {User} from "../model/user";
import {Observable} from "rxjs";


export interface IUsersService {

    findAll(): Observable<User[]>;

    getOne(id: number): Observable<User>;

    save(user: User): Observable<User>;

    saveByAdmin(user: User): Observable<User>;

    obtainUser(user: User): Observable<User>;

    findAllEnabled(enabled: boolean): Observable<User[]>;

    deleteUser(id: number): Observable<boolean>;
}