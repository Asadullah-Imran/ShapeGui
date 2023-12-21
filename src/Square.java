public class Square extends Shape {
    double height;

    Square(double height){

        this.height=height;
    }
    public double calculateArea(){
        return height*height;
    }
    public double calculatePerimeter(){
        return 4*(height);
    }
}
