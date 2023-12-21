public abstract class Shape implements Comparable<Shape>{
    static int state=0;
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public int compareTo(Shape s){
       if(state==1){
           if(calculateArea()!=s.calculateArea()){
               return Double.compare(calculateArea(),s.calculateArea());
           }else{
               return Double.compare(calculatePerimeter(),s.calculatePerimeter());
           }
       } else if (state==2) {
           if(calculateArea()!=s.calculateArea()){
               return Double.compare(s.calculateArea(),calculateArea());
           }else{
               return Double.compare(s.calculatePerimeter(),calculatePerimeter());
           }
       }
       return 0;
    }
}
