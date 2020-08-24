import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PostFormDataModel} from "../models/postFormDataModel";
import {PostListDataModel} from "../models/postListDataModel";

const BASE_URL = 'http://localhost:8080/api/posts';

@Injectable({
  providedIn: 'root'
})
export class PostingService {

  constructor(private http: HttpClient) { }

  savePost(dataModel: PostFormDataModel): Observable<any> {
    return this.http.post(BASE_URL,dataModel);
  }

  getAllPosts(): Observable<PostListDataModel[]>{
    return this.http.get<PostListDataModel[]>(BASE_URL);
  }
}