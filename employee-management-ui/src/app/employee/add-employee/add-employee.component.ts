import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
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

  }

  onSubmit() {
    this.apiService.createEmployee(this.addForm.value)
      .subscribe( data => {
		alert('Employee added successfully.');
        this.router.navigate(['list-employee']);
      });
  }

}
