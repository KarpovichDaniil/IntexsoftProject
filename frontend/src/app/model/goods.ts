import City from './city';
import {User} from './user';
import Category from './category';

export class Goods {
  id: number;
  title: string;
  description: string;
  city: City;
  author: User;
  phone:string;
  price: number;
  //created_date: Date = new Date();
  category: Category;
}