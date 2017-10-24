import {Observable} from "rxjs";
import {Goods} from "../model/goods";

export interface IGoodsService {

    getAll(): Observable<Goods[]>;

    getOne(id: number): Observable<Goods>;

    save(goods: Goods): Observable<Goods>;

    findByCategory(id: number): Observable<Goods[]>;
}