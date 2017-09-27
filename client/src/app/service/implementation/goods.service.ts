import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response, URLSearchParams} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Observable} from "rxjs";
import {IGoodsService} from "../igoods.service";
import {Goods} from "../../model/goods";

const ALL_NEWS_PATH = 'api/all/goods';
const NEWS_PATH = 'api/goods';

@Injectable()
export class GoodsService implements IGoodsService {

    constructor(private http: Http) {
    }

    findAll(): Observable<Goods[]> {
        return this.http.get(ALL_NEWS_PATH, this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json()
            })
            .catch((error: any) => Observable.throw(error));
    }

    getOne(id: number): Observable<Goods> {
        const url = `${NEWS_PATH}/${id}`;
        return this.http.get(url, this.getPlainRequestOptions())
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    save(news: Goods): Observable<Goods> {
        return this.http.post(NEWS_PATH, JSON.stringify(news), this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }


    findSubset(page: string, size: string): Observable<Goods[]> {
        return this.http.get(ALL_NEWS_PATH, this.getRequestOptionsWithPage(page, size))
            .map((response: Response) => {
                return response.json().content;
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

    private getRequestOptionsWithPage(page: string, size: string): RequestOptions {
        return new RequestOptions({
                headers: new Headers({
                    'Content-Type': 'application/json'
                }),
                params: this.getUrlSearchParams(page, size)
            }
        );
    }
}