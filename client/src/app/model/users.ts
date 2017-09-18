import Roles from './roles';

export default class Users {
  id: number;
  username: string;
  password: string;
  enabled: boolean;
  roles: Roles[];
}