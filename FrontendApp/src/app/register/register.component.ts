import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Employee } from '../Employee';
import { AuthService } from '../services/auth.service';
import { CrudService } from '../services/crud.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  showMessage = "";
  addedToDB = false;

  cPassword:string='';

  emp:Employee = new Employee();

  roles:any[] = []

  constructor(private authService : AuthService,private crudService : CrudService) { }

  ngOnInit(): void {
    this.crudService.getRoles().subscribe(
      (res : any) => {
        this.roles = res;
      }
    );
    
  }

  handleRegister(){
    if(this.validateForm()){
      if(this.emp.password === this.cPassword){
        this.authService.registerBackend(this.emp)
          .subscribe((res) => {
            console.log(res)
            if(res == "succesful" ){
              this.addedToDB = true;
              this.showMessage = "Succesful : User added to the database"
              // this.checkAdmin = true;
            }
            else if(res == "faliure"){
              this.addedToDB = true;
              this.showMessage = "Error : User already exists!"
            }
      })
      }
      else{
        alert("Error: Password Mismatch");
      }
    }
    else{
      alert("Error: Fill in to continue");
    }
  }

  validateForm(){
    if(this.emp.firstName != '' && this.emp.lastName!='' && this.emp.password!='' 
      && this.emp.email!='' && this.emp.designation!='' && this.emp.address!='' 
      && this.emp.salary.toString()!='')
      return true;
    
    return false;
  }

  handleReset(){
    this.emp.firstName = '' 
    this.emp.lastName ='' 
    this.emp.password='' 
    this.emp.email='' 
    this.emp.designation=''
    this.emp.address='' 
    this.emp.salary=0
    this.emp.role='';
    this.cPassword=''
  }
}
