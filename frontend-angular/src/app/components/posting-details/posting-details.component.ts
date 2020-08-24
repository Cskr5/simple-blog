import {Component, OnInit} from '@angular/core';
import {PostListDataModel} from "../../models/postListDataModel";
import {ActivatedRoute, Router} from "@angular/router";
import {PostingService} from "../../services/posting.service";
import {PostDetailsDataModel} from "../../models/postDetailsDataModel";
import {FormBuilder} from "@angular/forms";
import {handleValidationErrors} from "../../services/errorMessage";

@Component({
  selector: 'app-posting-details',
  templateUrl: './posting-details.component.html',
  styleUrls: ['./posting-details.component.css']
})
export class PostingDetailsComponent implements OnInit {

  post: PostDetailsDataModel;
  commentForm = this.formBuilder.group(
    {
      author: [''],
      text: ['']
    });

  ngOnInit(): void {
  }

  constructor(private formBuilder: FormBuilder, private postingService: PostingService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe(
      paramMap => {
        const idParam = paramMap.get("id");
        if (isNaN(+idParam) || +idParam < 0) {
          router.navigate(['posting-list'])
        } else {
          this.postingService.getPostById(+idParam)
            .subscribe((details) => {this.post = details; console.log(this.post)}
            )
        }
      });
  }

  submitComment(id: number) {
    let commentData = {...this.commentForm.value};
    this.postingService.saveComment(commentData, id)
      .subscribe(() => this.postingService.getPostById(id).subscribe(
        (p) => this.post = p,
        error => handleValidationErrors(error, this.commentForm),
        )
      )
  }

}
