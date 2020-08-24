import {CommentDataModel} from "./commentDataModel";

export interface PostDetailsDataModel {
  id?: number;
  url: string;
  title: string;
  text: string;
  createdAt?: Date;
  comments?: CommentDataModel[];
}
