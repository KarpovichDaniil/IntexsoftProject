import {Observable} from "rxjs";
import {Goods} from "../model/goods";

export interface IGoodsService {

    findAll(): Observable<Goods[]>;

    getOne(id: number): Observable<Goods>;

    save(goods: Goods): Observable<Goods>;

    //findSubset(page: string, size: string): Observable<Goods[]>;
   // findSub(): Observable<Goods[]>;
}