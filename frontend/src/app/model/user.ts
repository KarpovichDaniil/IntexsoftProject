import Roles from './role';

export class Users {
  id: number;
  username: string;
  password: string;
  email: string;
  enabled: boolean;
  roles: Roles[];
    constructor(username?: string, password?: string) {
        this.username = username;
        this.password = password;
    }
}