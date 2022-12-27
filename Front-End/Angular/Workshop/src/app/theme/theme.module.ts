import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThemeListComponent } from './theme-list/theme-list.component';
import { ThemeRoutingModule } from './theme-routing.module';
import { SharedModule } from '../shared/shared.module';
import { NewThemeComponent } from './new-theme/new-theme.component';
import { ThemeDetailComponent } from './theme-detail/theme-detail.component';
import { MainComponent } from './main/main.component';
import { RecentPostsComponent } from './recent-posts/recent-posts.component';
import { FormsModule } from '@angular/forms';
import { LoaderComponent } from "../shared/loader/loader.component";



@NgModule({
    declarations: [
        ThemeListComponent,
        NewThemeComponent,
        ThemeDetailComponent,
        MainComponent,
        RecentPostsComponent
    ],
    exports: [
        ThemeListComponent
    ],
    imports: [
        CommonModule,
        SharedModule,
        FormsModule,
        ThemeRoutingModule
    ]
})
export class ThemeModule { }
