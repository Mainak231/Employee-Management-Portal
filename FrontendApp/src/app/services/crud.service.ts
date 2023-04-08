import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  constructor(private http : HttpClient) { }

  getRoles(){
    return this.http.get(`http://localhost:8080/api/v1/getAllRoles`)
  }
  updateDetails(id:number){
    //return this.http.post();
  }

  deleteDetails(id:number){
    return this.http.delete(`http://localhost:8080/api/v1/deleteUser/${id}`)
  }
}
