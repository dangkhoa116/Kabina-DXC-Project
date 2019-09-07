import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfiguration } from '../services/app-config.service';
import { RestService } from '../services/rest.service';
import { User } from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _appConfig: AppConfiguration,
    private _restService: RestService) { }

  public getUserList() : Observable<Object> {
    let url = this._appConfig.kabinaBaseURL + '/users';
    return this._restService.getByUrl(url);
  }
  public deleteUser(id:number) {
    let url = this._appConfig.kabinaBaseURL + '/users/del/' + id;
    return this._restService.getByUrl(url);
  }
  public addUser(user:User) {
    let url = this._appConfig.kabinaBaseURL + '/addUser';
    return this._restService.postByUrl(url,user);
  }
  public editUser(user:User) {
    let url = this._appConfig.kabinaBaseURL + '/update';
    return this._restService.patchByUrl(url,user);
  }
  
}
