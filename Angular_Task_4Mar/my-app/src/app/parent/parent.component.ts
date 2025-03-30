import { Component } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css'],
})
export class ParentComponent {
  parentItems: string[] = ['Smart Phone', 'Laptop', 'Pendrive'];
  childItems: string[] = [];

  moveChild(item: string) {
    this.parentItems = this.parentItems.filter((i) => i !== item);
    this.childItems.push(item);
  }

  moveParent(item: string) {
    this.childItems = this.childItems.filter((i) => i !== item);
    this.parentItems.push(item);
  }
}
