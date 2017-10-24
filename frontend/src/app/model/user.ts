import Role from './role';

export class User {
  id: number;
  username: string;
  password: string;
  email: string;
  enabled: boolean;
  roles: Role[];
    constructor(username?: string, password?: string) {
        this.username = username;
        this.password = password;
    }
}