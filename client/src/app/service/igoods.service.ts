import {Users} from "../model/user";
import {Observable} from "rxjs";
import {Goods} from "../model/goods";

/**
 * Interface specifies some of the CRUD operations which can be proceed upon {@see News} instances
 */
export interface IGoodsService {

    findAll(): Observable<Goods[]>;

    getOne(id: number): Observable<Goods>;

    save(goods: Goods): Observable<Goods>;

    findSubset(page: string, size: string): Observable<Goods[]>;
}