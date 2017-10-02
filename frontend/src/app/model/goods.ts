import Cities from './cities';
import {Users} from './user';
import Categories from './categories';

export class Goods {
  id: number;
  title: string;
  description: string;
  city: Cities;
  author: Users;
  phone:string;
  price: number;
  //created_date: Date = new Date();
  category: Categories;
}