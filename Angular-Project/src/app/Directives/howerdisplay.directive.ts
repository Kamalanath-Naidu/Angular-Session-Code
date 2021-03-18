import { Directive, ElementRef, HostBinding, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHowerdisplay]'
})
export class HowerdisplayDirective {

  constructor(private ele :ElementRef, private renderer:Renderer2) { }

  @HostBinding('style.background') background:string;
  @HostBinding('style.opacity') opacity:string;

  @HostListener("mouseenter") mouseover(data: Event){
    //this.background="cyan";
    this.opacity="0.4";
  } 

  @HostListener("mouseleave") mouseleave(data: Event){
    this.background="transparent";
    this.opacity="1";
  } 
  ngOnInit(){
    this.background="transparent";
  }

}
