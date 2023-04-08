import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs';
import { Employee } from '../Employee';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public username:string = ''
  public password:string = ''
  public user_id : string =''

  constructor(private http: HttpClient) { }

  authenticateinBackend(email: string, pass: string, uname:string) {
    let body = {
      email: email,
      password: pass,
    }
    
    // this.username = uname;
    // this.password = pass;

    let token = 'Basic '+ btoa(uname+":"+pass)

    let headers = new HttpHeaders({
      Authorization : token
    })

    return this.http.post(`http://localhost:8080/api/v1/loginBackend`, body, {headers}).pipe(
      (map(data => {
        sessionStorage.setItem('authenticatedUser', uname)
        sessionStorage.setItem('authenticatedToken',token)
        return data;
      }))
    )
    
  }


  registerBackend(emp: Employee) {
    return this.http.post(`http://localhost:8080/api/v1/addUser`, emp, { responseType: 'text' })
  }

 
  // createBasicAuthToken(uname:string, pass:string){
  //   let basicToken = 'Basic '+ btoa(uname+":"+pass)
  //   return basicToken;
  // }

  getBasicAuthToken(){
    let token = sessionStorage.getItem('authenticatedToken')
    return token; 
  }
  // setToken(username: string) {
  //   localStorage.setItem('authenticatedUser', username)
  // }

  getUsername() {
    let user = sessionStorage.getItem('authenticatedUser');
    if (user != null) return user;
    return '';
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser');
    if (user != null) return true;
    return false;
  }
  deleteToken() {
    sessionStorage.removeItem('authenticatedUser')
  }

  setUserRole(role: string) {
    sessionStorage.setItem('role', role)
  }
  getUserRole() {
    let role = sessionStorage.getItem('role')
    return role;
  }

  setUserId(id:any){
    this.user_id = id; 
  }
  getUserId(){
    return this.user_id;
  }
}
