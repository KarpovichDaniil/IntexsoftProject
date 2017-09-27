import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-workspace',
    templateUrl: '../../assets/html/workspace.component.html',
    styleUrls: ['../../assets/style/workspace.component.css']
})
export class WorkspaceComponent {

    private step: number;

    private selectedCategory: string;
    private categories = [
        {value: 'car', viewValue: 'Cars'},
        {value: 'real-estate', viewValue: 'Real estate'},
        {value: 'clothes', viewValue: 'Clothes'},
        {value: 'tech', viewValue: 'Tech'},
    ];

    constructor() {
        this.step = 0;
    }
}
