import Cities from './cities';
import Users from './users';
import Categories from './categories';

export default class Goods {
  id: number;
  title: string;
  description: string;
  city: Cities;
  user: Users;
  price: number;
  created_date: Date = new Date();
  category: Categories;
}