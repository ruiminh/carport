package web.commands;

import business.services.SVG;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowSVGCommand extends CommandUnprotectedPage {

    public ShowSVGCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int a = 780; // todo: receive parameter of carport length.
        int b = 600;   // todo: receive parameter of carport width.
        int textA=780;  // receive parameter of carport length
        int textB=600;  // receive parameter of carport width.
        Double carportLength = Double.valueOf(a);
        Double carportWidth = Double.valueOf(b);
        boolean withShed = true;//todo: receive parameterf
        int s1 =180;
        int s2=200;
        Double shedLength =Double.valueOf(s1);
        Double shedWidth = Double.valueOf(s2);


        String viewBox ="0 0 "+(a+75)+" "+(b+90);
        String viewBoxInner="0 0 "+a+" "+b;

        SVG svg = new SVG(0,0,viewBox,100,100);
        svg.addArrowMarkers();
        svg.addArrowLine(50,10,50,b+10);
        svg.addArrowLine(75,b+35,a+75,b+35);
        svg.addText(30,b/2,-90,b);
        svg.addText(75+a/2,b+65,0,a);

        SVG svgInner = new SVG(75,10,viewBoxInner,91,91);

        svgInner.addRect(0.0,0.0,carportWidth,carportLength);
        svgInner.addRect(0.0,0.0,carportWidth,4.5);
        svgInner.addRect(carportLength-4.5,0.0,carportWidth,4.5);
        svgInner.addRect(4.5,30.0,4.5,carportLength-(4.5*2));
        svgInner.addRect(4.5,b-30.0-4.5,4.5,carportLength-(4.5*2));
        svgInner.addDashLine(50,30,a-180,b-30);
        svgInner.addDashLine(50,b-30,a-180,30);
        svgInner.addRect(100.0,27.4,9.7,9.7);
        svgInner.addRect((carportLength-120)/2+100,27.4,9.7,9.7);
        svgInner.addRect((carportLength-20),27.4,9.7,9.7);
        svgInner.addRect(100.0,carportWidth-34.5-2.7,9.7,9.7);
        svgInner.addRect((carportLength-120)/2+100,carportWidth-34.5-2.7,9.7,9.7);
        svgInner.addRect((carportLength-20),carportWidth-34.5-2.7,9.7,9.7);
        double l=4.5;
        while(l<carportLength){
            l+=50.5;
            svgInner.addRect(l,0.0,carportWidth,4.5);
        }
        if(withShed){
            svgInner.addRect(carportLength-20-shedLength,27.4,shedWidth,shedLength+9.7);
            svgInner.addRect(carportLength-10.3-shedLength,37.1,shedWidth-19.4,shedLength-9.7);
            svgInner.addRect(carportLength-20.0-shedLength,27.4,9.7,9.7);
            svgInner.addRect(carportLength-20.0-shedLength,27.4+shedWidth-9.7,9.7,9.7);
            svgInner.addRect(carportLength-20,27.4+shedWidth-9.7,9.7,9.7);
            svgInner.addRect(carportLength-20.0-shedLength,27.4+shedWidth/2,9.7,9.7);
            svgInner.addRect(carportLength-20.0,27.4+shedWidth/2,9.7,9.7);
        }

        svg.addSVG(svgInner);
        svg.addArrowMarkers();
        svg.addArrowLine(50,10,50,b+10);
        svg.addArrowLine(75,b+35,a+75,b+35);
        svg.addText(30,b/2,-90,textB);
        svg.addText(75+a/2,b+65,0,textA);

        request.setAttribute("svgdrawing",svg.toString());
        return pageToShow;
    }

}
