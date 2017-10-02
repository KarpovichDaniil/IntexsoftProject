import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response, URLSearchParams} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Observable} from "rxjs";
import {IGoodsService} from "../igoods.service";
import {Goods} from "../../model/goods";

const ALL_GOODS_PATH = 'api/goods';
const ONE_GOODS_PATH = 'api/goods';

@Injectable()
export class GoodsService implements IGoodsService {

    constructor(private http: Http) {
    }

    findAll(): Observable<Goods[]> {
        return this.http.get(ALL_GOODS_PATH, this.getPlainRequestOptions())
            .map((response: Response) => {
                response.json()
            })
            .catch((error: any) => Observable.throw(error));
    }

    getOne(id: number): Observable<Goods> {
        const url = `${ONE_GOODS_PATH}/${id}`;
        return this.http.get(url, this.getPlainRequestOptions())
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    save(goods: Goods): Observable<Goods> {
        return this.http.post(ONE_GOODS_PATH, JSON.stringify(goods), this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    private getUrlSearchParams(page: string, size: string): URLSearchParams {
        let params = new URLSearchParams();
        params.set('page', page);
        params.set('size', size);
        return params;
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

    private getPlainRequestOptions(): RequestOptions {
        return new RequestOptions({
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            }
        );
    }
}