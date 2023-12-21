public class Rectangular extends Shape{
     double height,width;

    Rectangular(double height,double width){
        this.width=width;
        this.height=height;
    }
    public double calculateArea(){
        return height*width;
    }
    public double calculatePerimeter(){
        return 2*(height+width);
    }
}
