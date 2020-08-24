import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {PostingService} from "../../services/posting.service";

@Component({
  selector: 'app-posting-form',
  templateUrl: './posting-form.component.html',
  styleUrls: ['./posting-form.component.css']
})
export class PostingFormComponent implements OnInit {
  postingForm = this.formBuilder.group(
    {
      title: [''],
      text: [''],
      url: [''],
    });

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private postingService: PostingService
              ) { }

  ngOnInit(): void {
  }

  submitPost() {
    let postData = {...this.postingForm.value};
    this.postingService.savePost(postData)
      .subscribe( () => {
        this.router.navigate(['posting-list']);},
        // error => handleValidationErrors(error, this.postingForm),
      )
  }
}
