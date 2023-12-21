import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ShapeGui extends JFrame implements ActionListener {
    JLabel heightLabel;
    JLabel widthLabel;
    JLabel radiusLabel;
    JTextField heightField;
    JTextField widthField;
    JTextField radiusField;

    JButton btnAddSquare;
    JButton btnAddRectangualar;
    JButton btnAddCircle;

    JButton btnAscending;
    JButton btnDescending;

    JTextArea result;



    ShapeGui(){
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        addComponent();
        setVisible(true);

    }
    public void addComponent(){
        heightLabel=new JLabel("Hiegh;t");
        widthLabel=new JLabel("Width");
        radiusLabel=new JLabel("Radius");
        heightField= new JTextField();
        widthField= new JTextField();
        radiusField= new JTextField();

        heightLabel.setBounds(20,20,100,50);
        heightField.setBounds(120,20,60,50);
        widthLabel.setBounds(220,20,100,50);
        widthField.setBounds(320,20,60,50);
        radiusLabel.setBounds(420,20,1000,50);
        radiusField.setBounds(520,20,60,50);

        //button
        btnAddSquare=new JButton("add Square");
        btnAddRectangualar=new JButton("add Rectangular");
        btnAddCircle=new JButton("add Circle");


        btnAddSquare.setBounds(30,100,140,50);
        btnAddRectangualar.setBounds(230,100,140,50);
        btnAddCircle.setBounds(430,100,140,50);


        //new Button
        btnAscending=new JButton("Sort Ascending");
        btnDescending=new JButton("Sort Descending");


        btnAscending.setBounds(50,200,200,50);
        btnDescending.setBounds(350,200,200,50);

        //Add text area
        result=new JTextArea();
        result.setBounds(30,300,530,250);

        add(heightField);
        add(heightLabel);
        add(widthField);
        add(widthLabel);
        add(radiusField);
        add(radiusLabel);
        add(btnAddCircle);
        add(btnAddSquare);
        add(btnAddRectangualar);
        add(btnAscending);
        add(btnDescending);
        add(result);


        btnAddSquare.addActionListener(this);
        btnAddRectangualar.addActionListener(this);
        btnAddCircle.addActionListener(this);
        btnAscending.addActionListener(this);
        btnDescending.addActionListener(this);


    }
    ArrayList<Shape> shapes= new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {

//        Double width= Double.parseDouble(widthField.getText());
//        Double radius= Double.parseDouble(radiusField.getText());
        if(e.getSource()==btnAddSquare){
             double height= Double.parseDouble(heightField.getText());
            //use validation later for square method [like only h will be apply]

            shapes.add(new Square(height));



//            System.out.println(height+", "+width+", "+radius+", ");
        }
        if(e.getSource()==btnAddCircle){
            double radius= Double.parseDouble(radiusField.getText());
            shapes.add(new Circle(radius));

        }
        if(e.getSource()==btnAddRectangualar){
            double height= Double.parseDouble(heightField.getText());
            double width= Double.parseDouble(widthField.getText());
            shapes.add(new Rectangular(height,width));

        }
        String resArea="";
        String resPerimeter="";
        String obName="";
        if(e.getSource()==btnAscending){
            Shape.state=1;
            Collections.sort(shapes);

            resArea=String.valueOf(shapes.get(0).calculateArea());
            resPerimeter=String.valueOf(shapes.get(0).calculatePerimeter());
            if(shapes.get(0) instanceof Square){
                obName="Square";
            }else if(shapes.get(0) instanceof Rectangular){
                obName="Rectangular";
            }else{
                obName="Circle";
            }
                result.setText("The object name is "+ obName+ "\nThe Area "+resArea+"\nThe Perimeter "+resPerimeter);

        }
        if(e.getSource()==btnDescending){
            Shape.state=2;
            Collections.sort(shapes);
            resArea=String.valueOf(shapes.get(0).calculateArea());
            resPerimeter=String.valueOf(shapes.get(0).calculatePerimeter());
            if(shapes.get(0) instanceof Square){
                obName="Square";
            }else if(shapes.get(0) instanceof Rectangular){
                obName="Rectangular";
            }else{
                obName="Circle";
            }
            result.setText("The object name is "+ obName+ "\nThe Area "+resArea+"\nThe Perimeter "+resPerimeter);
        }

    }
}
