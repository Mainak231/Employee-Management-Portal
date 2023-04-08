import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../Employee';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = ''
  pass: string = ''
  username: string = ''
  errorMessage = 'Invalid username / password';
  invalidLogin = false;

  emp: Employee = new Employee();

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }


  handleLoginBackend() {
    //   this.authService.authenticateinBackend(this.email, this.pass, this.username).subscribe((res:any) => {
    //     console.log(res);
    //     if(res.message === "User Authenticated"){
    //       this.router.navigate(['home']);
    //       this.invalidLogin = false;
    //       this.authService.setToken(res.username)
    //       this.authService.setUserRole(res.role)

    //   }
    //     else if(res.message === "User not Authenticated"){
    //       this.invalidLogin = true;
    //     }
    //   },error => { this.invalidLogin = true; this.errorMessage = 'Error : No such user present' })
    // }

    this.authService.authenticateinBackend(this.email, this.pass, this.username).subscribe((res: any) => {
      console.log(res)
      if (res.message === "User Authenticated") {
        if (this.username === res.username) {
          this.router.navigate(['home']);
          this.invalidLogin = false;
          this.authService.setUserRole(res.role)
          this.authService.setUserId(res.id)
        }
        else{
           this.invalidLogin = true
           this.errorMessage = 'Error :Incorrect username' 
        }
      }
      else if (res.message === "User not Authenticated") {
        this.invalidLogin = true;
      }
    }, error => { this.invalidLogin = true; this.errorMessage = 'Error : No such user present' })
  }

}
