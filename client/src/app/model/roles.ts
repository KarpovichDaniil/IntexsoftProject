import Users from './users';

export default class Roles {
  id: number;
  name: string;
  description: string;
  users: Users[];
}