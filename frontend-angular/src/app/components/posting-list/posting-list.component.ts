import { Component, OnInit } from '@angular/core';
import {PostingService} from "../../services/posting.service";
import {PostListDataModel} from "../../models/postListDataModel";
import {Router} from "@angular/router";

@Component({
  selector: 'app-posting-list',
  templateUrl: './posting-list.component.html',
  styleUrls: ['./posting-list.component.css']
})
export class PostingListComponent implements OnInit {
  posts: PostListDataModel[];

  constructor(private postingService: PostingService, private router:Router) { }

  ngOnInit(): void {
    this.displayPosts();
  }

  displayPosts(){
    this.postingService.getAllPosts()
      .subscribe( (posts:PostListDataModel[]) => this.posts = posts,
        error => {}
    )
  }

  goToDetails(id: number) {
    this.router.navigate(['/post', id]);
  }
}
