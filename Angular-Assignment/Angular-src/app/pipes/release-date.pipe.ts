import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'releaseDate'
})
export class ReleaseDatePipe implements PipeTransform {
  transform(value: string): string {
    return new Date(value).toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric'
    });
  }
}