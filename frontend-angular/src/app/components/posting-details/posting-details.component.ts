import { Component, OnInit } from '@angular/core';
import {PostListDataModel} from "../../models/postListDataModel";
import {ActivatedRoute, Router} from "@angular/router";
import {PostingService} from "../../services/posting.service";
import {PostDetailsDataModel} from "../../models/postDetailsDataModel";

@Component({
  selector: 'app-posting-details',
  templateUrl: './posting-details.component.html',
  styleUrls: ['./posting-details.component.css']
})
export class PostingDetailsComponent implements OnInit {

  post: PostDetailsDataModel;

  constructor(private postingService: PostingService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe(
      paramMap => {
        const idParam = paramMap.get("id");
        if (isNaN(+idParam) || +idParam < 0) {
          router.navigate(['posting-list'])
        } else {
          this.postingService.getPostById(+idParam).
          subscribe( (details) => this.post = details
          )
        }
      });
  }

  ngOnInit(): void {
  }

}
