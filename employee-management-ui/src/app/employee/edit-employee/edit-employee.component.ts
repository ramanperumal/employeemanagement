import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {Employee} from "../../model/employee.model";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  employee: Employee;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  ngOnInit() {
    let employeeId = window.localStorage.getItem("editEmployeeId");
    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      gender: ['', Validators.required],
      email: ['', Validators.required],
      contact: ['', Validators.maxLength(10)],
      address : this.formBuilder.group({
			street: ['', Validators.required],
			city: ['', Validators.required],
	        state: ['', Validators.required],
	        zip: ['', Validators.maxLength(4)]
	  })
    });
    this.apiService.getEmployeeById(+employeeId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.apiService.updateEmployee(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
            alert('Employee updated successfully.');
            this.router.navigate(['list-employee']);
        },
        error => {
          alert(error);
        });
  }

}
