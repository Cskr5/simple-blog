import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PostFormDataModel} from "../models/postFormDataModel";
import {PostListDataModel} from "../models/postListDataModel";
import {PostDetailsDataModel} from "../models/postDetailsDataModel";
import {CommentDataModel} from "../models/commentDataModel";

const BASE_URL = 'http://localhost:8080/api/posts';

@Injectable({
  providedIn: 'root'
})
export class PostingService {

  constructor(private http: HttpClient) {
  }

  savePost(dataModel: PostFormDataModel): Observable<any> {
    return this.http.post(BASE_URL, dataModel);
  }

  getAllPosts(): Observable<PostListDataModel[]> {
    return this.http.get<PostListDataModel[]>(BASE_URL);
  }

  getPostById(id: number): Observable<PostDetailsDataModel> {
    return this.http.get<PostDetailsDataModel>(BASE_URL + '/' + id);
  }

  saveComment(comment:CommentDataModel, postId: number) {
    return this.http.post(BASE_URL + '/comment/' + postId,comment)
  }
}
