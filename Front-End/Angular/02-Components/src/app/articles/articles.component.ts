import { Component, OnInit } from '@angular/core';
import { ArticleData } from '../data/data';
import { Article } from '../article.model';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})

export class ArticlesComponent implements OnInit {
  articles: Article[];

  constructor() {
    this.articles = [];
   }

  ngOnInit() {
    this.articles = new ArticleData().getData();
  }

}
