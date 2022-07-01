
package areaofshapes;

import static java.lang.Math.random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;




public class JavaFX extends Application {
    

    HasMethods obj = new HasMethods();
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        //For main animation
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500, Color.BLACK);
        primaryStage.setScene(scene);
        //
      
        
        primaryStage.setTitle("Shapes");
        GridPane grid = new GridPane();
        grid.setLayoutX(95);
        grid.setLayoutY(65);
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text a = new Text("Choose a shape: ");
        a.setId("choose-text");
        grid.add(a, 0, 0);
        grid.setColumnSpan(a, 4);
        
    //Circle button on the main scene    
        Label circle = new Label("circle");
        GridPane.setHalignment(circle, HPos.CENTER);
        Image imgCircle = new Image("shapes/circle-removebg-preview.png");
        ImageView imgV = new ImageView(imgCircle);
        imgV.setFitHeight(80);
        imgV.setPreserveRatio(true);
        Button button = new Button();
        button.setId("button");
        button.setGraphic(imgV);
        grid.add(button, 0, 2);
        grid.add(circle, 0, 3);
        GridPane circleGrid = new GridPane();                //circleGrid
        Group circleRoot = new Group();
        Scene sceneCircle = new Scene(circleRoot, 800, 500); //Circle's scene instantiation
        
        
        
//CIRCLE ANIMATION
        
        
    //for loop
    Group circles = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //CIRCLE
        Circle circleObj = new Circle(90, Color.web("white", 0.05));
        circleObj.setStrokeType(StrokeType.OUTSIDE);
        circleObj.setStroke(Color.web("white", 0.20));
        circleObj.setStrokeWidth(20);
        
        
        
       
                Rectangle colors = new Rectangle(sceneCircle.getWidth(), sceneCircle.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#ec1c24")),
                 }));
            colors.widthProperty().bind(sceneCircle.widthProperty());
            colors.heightProperty().bind(sceneCircle.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneCircle.getWidth(), sceneCircle.getHeight(),      
        Color.BLACK), circles), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(circleGrid);  
    circleRoot.getChildren().add(blendModeGroup);                                         
        
        circles.getChildren().add(circleObj);
        
    }
    
    //add effect 
    circles.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timeline = new Timeline();
    for (Node node : circles.getChildren()) {
    timeline.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, // set start position at 0
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), // set end position at 40s
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timeline.setAutoReverse(true);
    timeline.setCycleCount(Animation.INDEFINITE);
    
    
    
}
// play 40s of animation on repeat
    timeline.play();
       
//END OF CIRCLE ANIMATION    
        
        
       button.setOnAction(x -> primaryStage.setScene(sceneCircle));
        
        
     //Circle's scene
        circleGrid.setHgap(20);
        circleGrid.setVgap(10);
        circleGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iV = new ImageView(imgCircle);
        iV.setX(30); 
        iV.setY(60); 
        iV.setFitHeight(80);
        iV.setPreserveRatio(true);
        Group g = new Group(iV);
        
    Text circleInvalid = new Text("Enter a valid number*");
    circleInvalid.setVisible(false);
    circleInvalid.setId("circleInvalid");
    GridPane.setHalignment(circleInvalid, HPos.RIGHT);
    TextField circleField1 = new TextField();
    circleField1.setVisible(true); 
     
     
     //using these to fill up space in the grid ==> look for another solution
            Text circleInvalid3 = new Text("Enter a valid number*"); 
            circleInvalid3.setVisible(false); 
            circleInvalid3.setId("circleInvalid3");
            TextField circleField2 = new TextField();
            circleField2.setVisible(false);
            TextField circleField3 = new TextField(); 
            circleField3.setVisible(false);
            Text circleInvalid2 = new Text("Enter a valid number*");
            circleInvalid2.setVisible(false);
            circleInvalid2.setId("circleInvalid2");
            
        
        Text c = new Text("Circle: ");
        c.setId("circle-text");
        Label circleRadius = new Label("Enter radius: ");
       
    //setting column and row width
        ColumnConstraints circleColumn = new ColumnConstraints(200); 
        circleGrid.getColumnConstraints().addAll(circleColumn); 
        RowConstraints circleRow = new RowConstraints(); 
        circleRow.setPercentHeight(10); 
        circleGrid.getRowConstraints().addAll(circleRow); 
        
    //adding each Circle element to it's appropriate grid position 
        circleGrid.add(c, 0, 0);
        circleGrid.setColumnSpan(c, 2);
        circleGrid.add(g, 0, 1);
        circleGrid.setColumnSpan(g, 2);
        circleGrid.setRowSpan(g, 2);
        circleGrid.add(circleRadius, 2, 3);
        GridPane.setHalignment(circleRadius, HPos.RIGHT);
        circleGrid.setColumnSpan(circleRadius, 2);
        circleGrid.add(circleInvalid, 2, 4);
        circleGrid.setColumnSpan(circleInvalid, 2);
        circleGrid.add(circleField1, 4, 3);
        circleGrid.add(circleField2, 4, 5);
        circleGrid.add(circleField3, 4, 7);
        circleGrid.add(circleInvalid2, 2, 6);
        circleGrid.setColumnSpan(circleInvalid2, 2);
        circleGrid.add(circleInvalid3, 2, 8);
        circleGrid.setColumnSpan(circleInvalid3, 2);
        
        
    //adding the area label & textfield to the grid
        Label l1 = new Label("Area = ");
        GridPane.setHalignment(l1, HPos.RIGHT);
        TextField txtField1 = new TextField();
       
            circleGrid.add(l1, 3, 9);
            circleGrid.add(txtField1, 4, 9);
            circleGrid.setColumnSpan(txtField1, 2);
            GridPane.setHalignment(l1, HPos.RIGHT);
           
        
    //performs calculations with the input parameters + exception handling        
       Button cButton = new Button("Calculate");
       cButton.setId("cButton");
       circleGrid.add(cButton, 5, 3);
       cButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
           circleInvalid.setVisible(false);
        try {
            double radius = Double.parseDouble(circleField1.getText());
            double area = obj.circleArea(radius);
            txtField1.setText("" + area);
            
        } catch (NumberFormatException n) {
            circleInvalid.setVisible(true);
            //n.printStackTrace();
        }        
        
            }
        });
       
    //Removes text from the textfields   
       Button clearCircle = new Button("Clear");
       clearCircle.setId("clearCircle");
       circleGrid.add(clearCircle, 6, 3);
       clearCircle.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            txtField1.setText("");
            circleField1.setText("");
            circleInvalid.setVisible(false);
        }
        });
       
    //textfield keyboard controls
    circleField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField1.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField1.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField1.requestFocus();
            }
        });
    
    txtField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                circleField1.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                circleField1.requestFocus();
            }
        });
    
    
       
    //Returns to main menu   
        Button circleBack = new Button("Menu");
        circleBack.setId("circleBack");
        circleBack.setOnAction(x -> {   primaryStage.setScene(scene);
                                        txtField1.setText("");
                                        circleField1.setText("");
                                        circleInvalid.setVisible(false);
                               });
        circleGrid.add(circleBack, 0, 10);
            circleBack.setTranslateX(10);
            circleBack.setTranslateY(60);
        
        
       //
       //
       // 
        
        
        Label triangle = new Label("triangle");
        GridPane.setHalignment(triangle, HPos.CENTER);
        Image imgTriangle = new Image("shapes/triangle-removebg-preview.png");
        ImageView imgV2 = new ImageView(imgTriangle);
        imgV2.setFitHeight(80);
        imgV2.setPreserveRatio(true);
        Button button2 = new Button();
        button2.setId("button2");
        button2.setGraphic(imgV2);
        grid.add(button2, 2, 2);
        GridPane triangleGrid = new GridPane();   
        Group triangleRoot = new Group();//triangleGrid
        Scene sceneTriangle = new Scene(triangleRoot, 800, 500);        
        
        
        
        
//TRIANGLE ANIMATION 
        
    //for loop
    Group triangles = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //TRIANGLE
        Polygon triangleObj = new Polygon();
        triangleObj.getPoints().setAll(200d, 200d, 300d, 50d, 400d, 200d);
        triangleObj.setFill(Color.web("white", 0.05));
        triangleObj.setStrokeType(StrokeType.OUTSIDE);
        triangleObj.setStroke(Color.web("white", 0.20));
        triangleObj.setStrokeWidth(20);
        
        
        
       
                Rectangle colors = new Rectangle(sceneTriangle.getWidth(), sceneTriangle.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#fff238")),
                 }));
            colors.widthProperty().bind(sceneTriangle.widthProperty());
            colors.heightProperty().bind(sceneTriangle.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneTriangle.getWidth(), sceneTriangle.getHeight(),      
        Color.BLACK), triangles), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);   
    blendModeGroup.getChildren().add(triangleGrid);
    triangleRoot.getChildren().add(blendModeGroup);                                         
        
        triangles.getChildren().add(triangleObj);
        
    }
    
    //add effect 
    triangles.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineTriangle = new Timeline();
    for (Node node : triangles.getChildren()) {
    timelineTriangle.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineTriangle.setAutoReverse(true);
    timelineTriangle.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineTriangle.play();
   
//END OF TRIANGLE ANIMATION         
        
        
        button2.setOnAction(x -> primaryStage.setScene(sceneTriangle));
        grid.add(triangle, 2, 3);
        
        triangleGrid.setHgap(20);
        triangleGrid.setVgap(10);
        triangleGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVt = new ImageView(imgTriangle);
        iVt.setX(30); 
        iVt.setY(60); 
        iVt.setFitHeight(80);
        iVt.setPreserveRatio(true);
        Group gT = new Group(iVt);
        Text tr = new Text("Triangle: ");
        tr.setId("triangle-text");
        
        
    Text triangleInvalid = new Text("Enter a valid number*");
    triangleInvalid.setVisible(false);
    triangleInvalid.setId("triangleInvalid");
    GridPane.setHalignment(triangleInvalid, HPos.RIGHT);
    Text triangleInvalid2 = new Text("Enter a valid number*");
    triangleInvalid2.setVisible(false);
    triangleInvalid2.setId("triangleInvalid2");
    GridPane.setHalignment(triangleInvalid2, HPos.RIGHT);
    TextField triangleField1 = new TextField();
    triangleField1.setVisible(true); 
    TextField triangleField2 = new TextField();
    triangleField2.setVisible(true);
    Label triangleLength = new Label("Enter length: ");
    Label triangleHeight = new Label("Enter height: ");
     
     
     //using these to fill up space in the grid ==> look for another solution
            Text triangleInvalid3 = new Text("Enter a valid number*"); 
            triangleInvalid3.setVisible(false); 
            triangleInvalid3.setId("triangleInvalid3");
            TextField triangleField3 = new TextField(); 
            triangleField3.setVisible(false);
        
        
        ColumnConstraints triangleColumn = new ColumnConstraints(200); 
        triangleGrid.getColumnConstraints().addAll(triangleColumn); 
        RowConstraints triangleRow = new RowConstraints(); 
        triangleRow.setPercentHeight(10); 
        triangleGrid.getRowConstraints().addAll(triangleRow); 
        
        triangleGrid.add(tr, 0, 0);
        triangleGrid.setColumnSpan(tr, 2);
        triangleGrid.add(gT, 0, 1);
        triangleGrid.setColumnSpan(gT, 2);
        triangleGrid.setRowSpan(gT, 2);
        triangleGrid.add(triangleLength, 2, 3);
        GridPane.setHalignment(triangleLength, HPos.RIGHT);
        triangleGrid.setColumnSpan(triangleLength, 2);
        triangleGrid.add(triangleInvalid, 2, 4);
        triangleGrid.setColumnSpan(triangleInvalid, 2);
        triangleGrid.add(triangleField1, 4, 3);
        triangleGrid.add(triangleField2, 4, 5);
        triangleGrid.add(triangleField3, 4, 7);
        triangleGrid.add(triangleHeight, 2, 5);
        triangleGrid.setColumnSpan(triangleHeight, 2);
        GridPane.setHalignment(triangleHeight, HPos.RIGHT);
        triangleGrid.add(triangleInvalid2, 2, 6);
        triangleGrid.setColumnSpan(triangleInvalid2, 2);
        triangleGrid.add(triangleInvalid3, 2, 8);
        triangleGrid.setColumnSpan(triangleInvalid3, 2);
        
        
        Label l2 = new Label("Area = ");
        GridPane.setHalignment(l2, HPos.RIGHT);
        TextField txtField2 = new TextField();
       
            triangleGrid.add(l2, 3, 9);
            triangleGrid.add(txtField2, 4, 9);
            triangleGrid.setColumnSpan(txtField2, 2);
	
        
       Button tButton = new Button("Calculate");
       tButton.setId("tButton");
       triangleGrid.add(tButton, 5, 3);
       tButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                
        triangleInvalid.setVisible(false);
        triangleInvalid2.setVisible(false);
        try {
            double length = Double.parseDouble(triangleField1.getText());
            double height = Double.parseDouble(triangleField2.getText());
            double area = obj.triangleArea(length, height);
            txtField2.setText("" + area);
        } catch (NumberFormatException n) {
            triangleInvalid.setVisible(true);
            triangleInvalid2.setVisible(true);
        }     
        }
        });
       
       
       Button clearTriangle = new Button("Clear");
       clearTriangle.setId("clearTriangle");
       triangleGrid.add(clearTriangle, 6, 3);
       clearTriangle.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            txtField2.setText("");
            triangleField1.setText("");
            triangleField2.setText("");
            triangleInvalid.setVisible(false);
            triangleInvalid2.setVisible(false);
        }
        });
       
       
    //textfield keyboard controls
    triangleField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                triangleField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                triangleField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField2.requestFocus();
            }
        });
    
    triangleField2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                triangleField1.requestFocus();
            }
        });
    
    txtField2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                triangleField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                triangleField1.requestFocus();
            }
        });
    
    
    
    
       
        Button triangleBack = new Button("Menu");
        triangleBack.setId("triangleBack");
        triangleBack.setOnAction(x -> { primaryStage.setScene(scene);
                                        txtField2.setText("");
                                        triangleField1.setText("");
                                        triangleField2.setText("");
                                        triangleInvalid.setVisible(false);
                                        triangleInvalid2.setVisible(false);
                                 });
        triangleGrid.add(triangleBack, 0, 10);
            triangleBack.setTranslateX(10);
            triangleBack.setTranslateY(60);
       
       //
       //
       // 
        
        
        Label square = new Label("square");
        GridPane.setHalignment(square, HPos.CENTER);
        Image imgSquare = new Image("shapes/square-removebg-preview.png");
        ImageView imgV3 = new ImageView(imgSquare);
        imgV3.setFitHeight(80);
        imgV3.setPreserveRatio(true);
        Button button3 = new Button();
        button3.setId("button3");
        button3.setGraphic(imgV3);
        grid.add(button3, 4, 2);
        GridPane squareGrid = new GridPane();
        Group squareRoot = new Group();
        Scene sceneSquare = new Scene(squareRoot, 800, 500);            
        
        
//SQUARE ANIMATION
        
        
    //for loop
    Group squares = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //SQUARE   
        Rectangle squareObj = new Rectangle(5, 5, 160, 160);
        squareObj.setFill(Color.web("white", 0.05));
        squareObj.setStrokeType(StrokeType.OUTSIDE);
        squareObj.setStroke(Color.web("white", 0.20));
        squareObj.setStrokeWidth(20);
        
       
                Rectangle colors = new Rectangle(sceneSquare.getWidth(), sceneSquare.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#38a8f3")),
                 }));
            colors.widthProperty().bind(sceneSquare.widthProperty());
            colors.heightProperty().bind(sceneSquare.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneSquare.getWidth(), sceneSquare.getHeight(),      
        Color.BLACK), squares), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(squareGrid);  
    squareRoot.getChildren().add(blendModeGroup);                                         
        
        squares.getChildren().add(squareObj);
        
    }
    
    //add effect 
    squares.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineSquare = new Timeline();
    for (Node node : squares.getChildren()) {
    timelineSquare.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineSquare.setAutoReverse(true);
    timelineSquare.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineSquare.play();
       
    
//END OF SQUARE ANIMATION   
        
        
        
        button3.setOnAction(x -> primaryStage.setScene(sceneSquare));   
        grid.add(square, 4, 3);
        
        
        squareGrid.setHgap(20);
        squareGrid.setVgap(10);
        squareGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVs = new ImageView(imgSquare);
        iVs.setX(30); 
        iVs.setY(60); 
        iVs.setFitHeight(80);
        iVs.setPreserveRatio(true);
        Group gS = new Group(iVs);
        Text sq = new Text("Square: ");
        sq.setId("square-text");
        
        
        
     Text squareInvalid = new Text("Enter a valid number*");
     squareInvalid.setVisible(false);
     squareInvalid.setId("squareInvalid");
     GridPane.setHalignment(squareInvalid, HPos.RIGHT);
     
     
     //using these to fill up space in the grid ==> look for another solution
            Text squareInvalid2 = new Text("Enter a valid number*");
            squareInvalid2.setVisible(false);
            squareInvalid2.setId("squareInvalid2");
            Text squareInvalid3 = new Text("Enter a valid number*"); 
            squareInvalid3.setVisible(false); 
            squareInvalid3.setId("squareInvalid3");
            Label squareLength = new Label("Enter length: ");
            squareLength.setId("squareLength");
            TextField squareField1 = new TextField();
            TextField squareField2 = new TextField();
            squareField2.setVisible(false);
            TextField squareField3 = new TextField(); 
            squareField3.setVisible(false);
        
        
        ColumnConstraints squareColumn = new ColumnConstraints(200); 
        squareGrid.getColumnConstraints().addAll(squareColumn);
        RowConstraints squareRow = new RowConstraints(); 
        squareRow.setPercentHeight(10); 
        squareGrid.getRowConstraints().addAll(squareRow); 
        

        squareGrid.add(sq, 0, 0);
        squareGrid.setColumnSpan(sq, 2);
        squareGrid.add(gS, 0, 1);
        squareGrid.setColumnSpan(gS, 2);
        squareGrid.setRowSpan(gS, 2);
        squareGrid.add(squareLength, 2, 3);
        GridPane.setHalignment(squareLength, HPos.RIGHT);
        squareGrid.setColumnSpan(squareLength, 2);
        squareGrid.add(squareInvalid, 2, 4);
        squareGrid.setColumnSpan(squareInvalid, 2);
        squareGrid.add(squareField1, 4, 3);
        squareGrid.add(squareField2, 4, 5);
        squareGrid.add(squareField3, 4, 7);
        squareGrid.add(squareInvalid2, 2, 6);
        squareGrid.setColumnSpan(squareInvalid2, 2);
        squareGrid.add(squareInvalid3, 2, 8);
        squareGrid.setColumnSpan(squareInvalid3, 2);
        
        
        Label l3 = new Label("Area = ");
        GridPane.setHalignment(l3, HPos.RIGHT);
        TextField txtField3 = new TextField();
       
            squareGrid.add(l3, 3, 9);
            squareGrid.add(txtField3, 4, 9);
            squareGrid.setColumnSpan(txtField3, 2);
	
       
       Button sButton = new Button("Calculate");
       sButton.setId("sButton");
       squareGrid.add(sButton, 5, 3);
       sButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            squareInvalid.setVisible(false);  
        try {
            double length = Double.parseDouble(squareField1.getText());
            double area = obj.squareArea(length);
            txtField3.setText("" + area);
        } catch (NumberFormatException n) {
            squareInvalid.setVisible(true);
        }     
            }
        });
       
       
       Button clearSquare = new Button("Clear");
       clearSquare.setId("clearSquare");
       squareGrid.add(clearSquare, 6, 3);
       clearSquare.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            txtField3.setText("");
            squareField1.setText("");
            squareInvalid.setVisible(false);
        }
        });
       
       
    //textfield keyboard controls
    squareField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField3.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField3.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField3.requestFocus();
            }
        });
    
    
    txtField3.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                squareField1.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                squareField1.requestFocus();
            }
        });
    
    
       
        Button squareBack = new Button("Menu");
        squareBack.setId("squareBack");
        squareBack.setOnAction(x -> {   primaryStage.setScene(scene);
                                        txtField3.setText("");
                                        squareField1.setText("");
                                        squareInvalid.setVisible(false);
                                    });
        squareGrid.add(squareBack, 0, 10);
            squareBack.setTranslateX(10);
            squareBack.setTranslateY(60);
       
       //
       //
       // 
        
        
        Label rectangle = new Label("rectangle");
        GridPane.setHalignment(rectangle, HPos.CENTER);
        Image imgRectangle = new Image("shapes/rectangle-removebg-preview.png");
        ImageView imgV4 = new ImageView(imgRectangle);
        imgV4.setFitHeight(80);
        imgV4.setPreserveRatio(true);
        Button button4 = new Button();
        button4.setId("button4");
        button4.setGraphic(imgV4);
        grid.add(button4, 6, 2);
        GridPane rectangleGrid = new GridPane();
        Group rectangleRoot = new Group();
        Scene sceneRectangle = new Scene(rectangleRoot, 800, 500);
        
        
//SQUARE ANIMATION
        
        
    //for loop
    Group rectangles = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //RECTANGLE
        Rectangle rectangleObj = new Rectangle(5, 5, 180, 100);
        rectangleObj.setFill(Color.web("white", 0.05));
        rectangleObj.setStrokeType(StrokeType.OUTSIDE);
        rectangleObj.setStroke(Color.web("white", 0.20));
        rectangleObj.setStrokeWidth(20);
        
        
       
                Rectangle colors = new Rectangle(sceneRectangle.getWidth(), sceneRectangle.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#38d145")),
                 }));
            colors.widthProperty().bind(sceneRectangle.widthProperty());
            colors.heightProperty().bind(sceneRectangle.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneRectangle.getWidth(), sceneRectangle.getHeight(),      
        Color.BLACK), rectangles), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(rectangleGrid);  
    rectangleRoot.getChildren().add(blendModeGroup);                                         
        
        rectangles.getChildren().add(rectangleObj);
        
    }
    
    //add effect 
    rectangles.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineRectangle = new Timeline();
    for (Node node : rectangles.getChildren()) {
    timelineRectangle.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineRectangle.setAutoReverse(true);
    timelineRectangle.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineRectangle.play();
       
//END OF SQUARE ANIMATION   

        
        button4.setOnAction(x -> primaryStage.setScene(sceneRectangle));
        grid.add(rectangle, 6, 3);
        
        
        rectangleGrid.setHgap(20);
        rectangleGrid.setVgap(10);
        rectangleGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVr = new ImageView(imgRectangle);
        iVr.setX(30); 
        iVr.setY(60); 
        iVr.setFitHeight(80);
        iVr.setPreserveRatio(true);
        Group gR = new Group(iVr);
        Text re = new Text("Rectangle: ");
        re.setId("rectangle-text");
        
        
    Text rectangleInvalid = new Text("Enter a valid number*");
    rectangleInvalid.setVisible(false);
    rectangleInvalid.setId("rectangleInvalid");
    GridPane.setHalignment(rectangleInvalid, HPos.RIGHT);
    Text rectangleInvalid2 = new Text("Enter a valid number*");
    rectangleInvalid2.setVisible(false);
    
    TextField rectangleField1 = new TextField();
    Label rectangleLength = new Label("Enter length: ");
    Label rectangleHeight = new Label("Enter height: ");
    
    
    //using these to fill up space in the grid ==> look for another solution
            rectangleInvalid2.setId("rectangleInvalid2");
            Text rectangleInvalid3 = new Text("Enter a valid number*"); 
            rectangleInvalid3.setVisible(false); 
            rectangleInvalid3.setId("rectangleInvalid3");
            TextField rectangleField2 = new TextField();
            TextField rectangleField3 = new TextField(); 
            rectangleField3.setVisible(false);
        
            
        ColumnConstraints rectangleColumn = new ColumnConstraints(200); 
        rectangleGrid.getColumnConstraints().addAll(rectangleColumn);
        RowConstraints rectangleRow = new RowConstraints(); 
        rectangleRow.setPercentHeight(10); 
        rectangleGrid.getRowConstraints().addAll(rectangleRow); 
        
        rectangleGrid.add(re, 0, 0);
        rectangleGrid.setColumnSpan(re, 2);
        rectangleGrid.add(gR, 0, 1);
        rectangleGrid.setColumnSpan(gR, 2);
        rectangleGrid.setRowSpan(gR, 2);
        rectangleGrid.setColumnSpan(re, 2);
        rectangleGrid.add(rectangleLength, 2, 3);
        GridPane.setHalignment(rectangleLength, HPos.RIGHT);
        rectangleGrid.setColumnSpan(rectangleLength, 2);
        rectangleGrid.add(rectangleInvalid, 2, 4);
        rectangleGrid.setColumnSpan(rectangleInvalid, 2);
        rectangleGrid.add(rectangleField1, 4, 3);
        rectangleGrid.add(rectangleField2, 4, 5);
        rectangleGrid.add(rectangleField3, 4, 7);
        rectangleGrid.add(rectangleHeight, 2, 5);
        rectangleGrid.setColumnSpan(rectangleHeight, 2);
        GridPane.setHalignment(rectangleHeight, HPos.RIGHT);
        rectangleGrid.add(rectangleInvalid2, 2, 6);
        rectangleGrid.setColumnSpan(rectangleInvalid2, 2);
        rectangleGrid.add(rectangleInvalid3, 2, 8);
        rectangleGrid.setColumnSpan(rectangleInvalid3, 2);
        GridPane.setHalignment(rectangleInvalid3, HPos.RIGHT);
        rectangleGrid.setColumnSpan(rectangleInvalid2, 2);
        
       Label l4 = new Label("Area = ");
        GridPane.setHalignment(l4, HPos.RIGHT);
        TextField txtField4 = new TextField();
      
            rectangleGrid.add(l4, 3, 9);
            rectangleGrid.add(txtField4, 4, 9);
            rectangleGrid.setColumnSpan(txtField4, 2);
	
        
       Button rButton = new Button("Calculate");
       rButton.setId("rButton");
       rectangleGrid.add(rButton, 5, 3);
       rButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            rectangleInvalid.setVisible(false);  
            rectangleInvalid2.setVisible(false);
        try {
            double length = Double.parseDouble(rectangleField1.getText());
            double height = Double.parseDouble(rectangleField2.getText());
            double area = obj.rectangleArea(length, height);
            txtField4.setText("" + area);
        } catch (NumberFormatException n) {
            rectangleInvalid.setVisible(true);
            rectangleInvalid2.setVisible(true);
        }
        }
        });
       
       
       Button clearRectangle = new Button("Clear");
       clearRectangle.setId("clearRectangle");
       rectangleGrid.add(clearRectangle, 6, 3);
       clearRectangle.setOnAction(new EventHandler<ActionEvent>() {
       public void handle(ActionEvent e) {
            txtField4.setText("");
            rectangleField1.setText("");
            rectangleField2.setText("");
            rectangleInvalid.setVisible(false);
            rectangleInvalid2.setVisible(false);
        }
        });
       
    //textfield keyboard controls
    rectangleField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                rectangleField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                rectangleField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField4.requestFocus();
            }
        });
    
    rectangleField2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField4.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField4.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                rectangleField1.requestFocus();
            }
        });
    
    txtField4.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                rectangleField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                rectangleField1.requestFocus();
            }
        });
       
        
        Button rectangleBack = new Button("Menu");
        rectangleBack.setId("rectangleBack");
        rectangleBack.setOnAction(x -> {primaryStage.setScene(scene);
                                        txtField4.setText("");
                                        rectangleField1.setText("");
                                        rectangleField2.setText("");
                                        rectangleInvalid.setVisible(false);
                                        rectangleInvalid2.setVisible(false);
                                  });
        rectangleGrid.add(rectangleBack, 0, 10);
            rectangleBack.setTranslateX(10);
            rectangleBack.setTranslateY(60);
       
       
       //
       //
       // 
        
        
        Label rhombus = new Label("rhombus");
        GridPane.setHalignment(rhombus, HPos.CENTER);
        Image imgRhombus = new Image("shapes/rhombus-removebg-preview.png");
        ImageView imgV5 = new ImageView(imgRhombus);
        imgV5.setFitHeight(80);
        imgV5.setPreserveRatio(true);
        Button button5 = new Button();
        button5.setId("button5");
        button5.setGraphic(imgV5);
        grid.add(button5, 0, 5);
        GridPane rhombusGrid = new GridPane();
        Group rhombusRoot = new Group();
        Scene sceneRhombus = new Scene(rhombusRoot, 800, 500);
        
        
//RHOMBUS ANIMATION
        
    //for loop
    Group rhombuses = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //RHOMBUS  
        Rectangle rhombusObj = new Rectangle(5, 5, 140, 140);
        Rotate r = new Rotate();
        r.setAngle(45);  
        r.setPivotX(100);  
        r.setPivotY(300);  
        rhombusObj.getTransforms().add(r);  
        rhombusObj.setFill(Color.web("white", 0.05));
        rhombusObj.setStrokeType(StrokeType.OUTSIDE);
        rhombusObj.setStroke(Color.web("white", 0.20));
        rhombusObj.setStrokeWidth(20);
        
        
       
                Rectangle colors = new Rectangle(sceneRhombus.getWidth(), sceneRhombus.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#b83dba")),
                 }));
            colors.widthProperty().bind(sceneRhombus.widthProperty());
            colors.heightProperty().bind(sceneRhombus.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneRhombus.getWidth(), sceneRhombus.getHeight(),      
        Color.BLACK), rhombuses), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(rhombusGrid);  
    rhombusRoot.getChildren().add(blendModeGroup);                                         
        
        rhombuses.getChildren().add(rhombusObj);
        
    }
    
    //add effect 
    rhombuses.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineRhombus = new Timeline();
    for (Node node : rhombuses.getChildren()) {
    timelineRhombus.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineRhombus.setAutoReverse(true);
    timelineRhombus.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineRhombus.play();
       
//END OF RHOMBUS ANIMATION   
        
        
        button5.setOnAction(x -> primaryStage.setScene(sceneRhombus));
        grid.add(rhombus, 0, 6);
        
        
        rhombusGrid.setHgap(20);
        rhombusGrid.setVgap(10);
        rhombusGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVrh = new ImageView(imgRhombus);
        iVrh.setX(30); 
        iVrh.setY(60); 
        iVrh.setFitHeight(80);
        iVrh.setPreserveRatio(true);
        Group gRh = new Group(iVrh);
     
        
    Text rhombusInvalid = new Text("Enter a valid number*");
    rhombusInvalid.setVisible(false);
    rhombusInvalid.setId("rhombusInvalid");
    GridPane.setHalignment(rhombusInvalid, HPos.RIGHT);
    
    Text rh = new Text("Rhombus: ");
    rh.setId("rhombus-text");
    TextField rhombusField1 = new TextField();
    Label rhombusLength = new Label("Enter length: ");
     
     
     //using these to fill up space in the grid ==> look for another solution
            Text rhombusInvalid2 = new Text("Enter a valid number*");
            rhombusInvalid2.setVisible(false);
            rhombusInvalid2.setId("rhombusInvalid2");
            Text rhombusInvalid3 = new Text("Enter a valid number*"); 
            rhombusInvalid3.setVisible(false); 
            rhombusInvalid3.setId("rhombusInvalid3");
            TextField rhombusField2 = new TextField();
            rhombusField2.setVisible(false);
            TextField rhombusField3 = new TextField(); 
            rhombusField3.setVisible(false);
               
               
        ColumnConstraints rhombusColumn = new ColumnConstraints(200); 
        rhombusGrid.getColumnConstraints().addAll(rhombusColumn);
        RowConstraints rhombusRow = new RowConstraints(); 
        rhombusRow.setPercentHeight(10); 
        rhombusGrid.getRowConstraints().addAll(rhombusRow); 
        
        rhombusGrid.add(rh, 0, 0);
        rhombusGrid.setColumnSpan(rh, 2);
        rhombusGrid.add(gRh, 0, 1);
        rhombusGrid.setColumnSpan(gRh, 2);
        rhombusGrid.setRowSpan(gRh, 2);
        rhombusGrid.setColumnSpan(rh, 2);
        rhombusGrid.add(rhombusLength, 2, 3);
        rhombusGrid.setColumnSpan(rhombusLength, 2);
        GridPane.setHalignment(rhombusLength, HPos.RIGHT);
        rhombusGrid.add(rhombusInvalid, 2, 4);
        rhombusGrid.setColumnSpan(rhombusInvalid, 2);
        rhombusGrid.add(rhombusField1, 4, 3);
        rhombusGrid.add(rhombusField2, 4, 5);
        rhombusGrid.add(rhombusField3, 4, 7);
        rhombusGrid.add(rhombusInvalid2, 2, 6);
        rhombusGrid.setColumnSpan(rhombusInvalid2, 2);
        rhombusGrid.add(rhombusInvalid3, 2, 8);
        rhombusGrid.setColumnSpan(rhombusInvalid3, 2);
        
        
        Label l5 = new Label("Area = ");
        GridPane.setHalignment(l5, HPos.RIGHT);
        TextField txtField5 = new TextField();
       
            rhombusGrid.add(l5, 3, 9);
            rhombusGrid.add(txtField5, 4, 9);
            rhombusGrid.setColumnSpan(txtField5, 2);
	
        
       Button rhButton = new Button("Calculate");
       rhButton.setId("rhButton");
       rhombusGrid.add(rhButton, 5, 3);
       rhButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            rhombusInvalid.setVisible(false);
        try {
            double length = Double.parseDouble(rhombusField1.getText());
            double area = obj.rhombusArea(length);
            txtField5.setText("" + area);
        } catch (NumberFormatException n) {
            rhombusInvalid.setVisible(true);
        }
        }
        });
       
       
       Button clearRhombus = new Button("Clear");
       clearRhombus.setId("clearRhombus");
       rhombusGrid.add(clearRhombus, 6, 3);
       clearRhombus.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            txtField5.setText("");
            rhombusField1.setText("");
            rhombusInvalid.setVisible(false);
        }
        });
       
    //textfield keyboard controls
    rhombusField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField5.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField5.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField5.requestFocus();
            }
        });
    
    
    txtField5.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                rhombusField1.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                rhombusField1.requestFocus();
            }
        });
       
       
        Button rhombusBack = new Button("Menu");
        rhombusBack.setId("rhombusBack");
        rhombusBack.setOnAction(x -> {  primaryStage.setScene(scene);
                                        txtField5.setText("");
                                        rhombusField1.setText("");
                                        rhombusInvalid.setVisible(false);
                                });
        rhombusGrid.add(rhombusBack, 0, 10);
            rhombusBack.setTranslateX(10);
            rhombusBack.setTranslateY(60);
       
       //
       //
       // 
        
        
        Label deltoid = new Label("deltoid");
        GridPane.setHalignment(deltoid, HPos.CENTER);
        Image imgDeltoid = new Image("shapes/deltoid-removebg-preview.png");
        ImageView imgV6 = new ImageView(imgDeltoid);
        imgV6.setFitHeight(80);
        imgV6.setPreserveRatio(true);
        Button button6 = new Button();
        button6.setId("button6");
        button6.setGraphic(imgV6);
        grid.add(button6, 2, 5);
        GridPane deltoidGrid = new GridPane();
        Group deltoidRoot = new Group();
        Scene sceneDeltoid = new Scene(deltoidRoot, 800, 500);
        
//DELTOID ANIMATION
        
        
    //for loop
    Group deltoids = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //DELTOID  
        Polygon deltoidObj = new Polygon();
        deltoidObj.getPoints().setAll(46.5, 0.0, 135.0, 0.0, 168.00, 225.0, 0.0, 73.5); //62.0, 0.0, 180.0, 0.0, 224.00, 300.0, 0.0, 98.0
        Rotate r2 = new Rotate();
        r2.setAngle(27);  
        r2.setPivotX(100);  
        r2.setPivotY(300);  
        deltoidObj.getTransforms().add(r2);
        deltoidObj.setFill(Color.web("white", 0.05));
        deltoidObj.setStrokeType(StrokeType.OUTSIDE);
        deltoidObj.setStroke(Color.web("white", 0.20));
        deltoidObj.setStrokeWidth(20);
        
        
       
                Rectangle colors = new Rectangle(sceneDeltoid.getWidth(), sceneDeltoid.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#7b38b3")),
                 }));
            colors.widthProperty().bind(sceneDeltoid.widthProperty());
            colors.heightProperty().bind(sceneDeltoid.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneDeltoid.getWidth(), sceneDeltoid.getHeight(),      
        Color.BLACK), deltoids), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(deltoidGrid);  
    deltoidRoot.getChildren().add(blendModeGroup);                                         
        
        deltoids.getChildren().add(deltoidObj);
        
    }
    
    //add effect 
    deltoids.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineDeltoid = new Timeline();
    for (Node node : deltoids.getChildren()) {
    timelineDeltoid.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineDeltoid.setAutoReverse(true);
    timelineDeltoid.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineDeltoid.play();
       
//END OF DELTOID ANIMATION   
        
        button6.setOnAction(x -> primaryStage.setScene(sceneDeltoid));
        grid.add(deltoid, 2, 6);
        
        deltoidGrid.setHgap(20);
        deltoidGrid.setVgap(10);
        deltoidGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVd = new ImageView(imgDeltoid);
        iVd.setX(30); 
        iVd.setY(60); 
        iVd.setFitHeight(80);
        iVd.setPreserveRatio(true);
        Group gD = new Group(iVd);
        Text d = new Text("Deltoid: ");
        d.setId("deltoid-text");
        
        
    Text deltoidInvalid = new Text("Enter a valid number*");
    deltoidInvalid.setVisible(false);
    deltoidInvalid.setId("deltoidInvalid");
    GridPane.setHalignment(deltoidInvalid, HPos.RIGHT);
    Text deltoidInvalid2 = new Text("Enter a valid number*");
    deltoidInvalid2.setVisible(false); //SET TRUE IF EXCEPTION IS THROWN + ADD CSS
    deltoidInvalid2.setId("deltoidInvalid2");
    GridPane.setHalignment(deltoidInvalid2, HPos.RIGHT);
    
    TextField deltoidField1 = new TextField();
    Label deltoidLength = new Label("Enter length: ");
    TextField deltoidField2 = new TextField();
    Label deltoidHeight = new Label("Enter height: ");
     
    
     //using these to fill up space in the grid ==> look for another solution
            Text deltoidInvalid3 = new Text("Enter a valid number*"); 
            deltoidInvalid3.setVisible(false); 
            deltoidInvalid3.setId("deltoidInvalid3");
            TextField deltoidField3 = new TextField(); 
            deltoidField3.setVisible(false);
        
       
        ColumnConstraints deltoidColumn = new ColumnConstraints(200); 
        deltoidGrid.getColumnConstraints().addAll(deltoidColumn);
        RowConstraints deltoidRow = new RowConstraints(); 
        deltoidRow.setPercentHeight(10); 
        deltoidGrid.getRowConstraints().addAll(deltoidRow); 
        
        deltoidGrid.add(d, 0, 0);
        deltoidGrid.setColumnSpan(d, 2);
        deltoidGrid.add(gD, 0, 1);
        deltoidGrid.setColumnSpan(gD, 2);
        deltoidGrid.setRowSpan(gD, 2);
        deltoidGrid.add(deltoidLength, 2, 3);
        GridPane.setHalignment(deltoidLength, HPos.RIGHT);
        deltoidGrid.setColumnSpan(deltoidLength, 2);
        deltoidGrid.add(deltoidField1, 4, 3);
        deltoidGrid.add(deltoidField2, 4, 5);
        deltoidGrid.add(deltoidField3, 4, 7);
        deltoidGrid.add(deltoidHeight, 2, 5);
        deltoidGrid.setColumnSpan(deltoidHeight, 2);
        GridPane.setHalignment(deltoidHeight, HPos.RIGHT);
        deltoidGrid.add(deltoidInvalid, 2, 4);
        deltoidGrid.setColumnSpan(deltoidInvalid, 2);
        deltoidGrid.add(deltoidInvalid2, 2, 6);
        deltoidGrid.setColumnSpan(deltoidInvalid2, 2);
        deltoidGrid.add(deltoidInvalid3, 2, 8);
        deltoidGrid.setColumnSpan(deltoidInvalid3, 2);
        
        
        Label l6 = new Label("Area = ");
        GridPane.setHalignment(l6, HPos.RIGHT);
        TextField txtField6 = new TextField();
       
            deltoidGrid.add(l6, 3, 9);
            deltoidGrid.add(txtField6, 4, 9);
            deltoidGrid.setColumnSpan(txtField6, 2);
	
        
       Button dButton = new Button("Calculate");
       dButton.setId("dButton");
       deltoidGrid.add(dButton, 5, 3);
       dButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            deltoidInvalid.setVisible(false);
            deltoidInvalid2.setVisible(false);
        try {
            double length = Double.parseDouble(deltoidField1.getText());
            double height = Double.parseDouble(deltoidField2.getText());
            double area = obj.deltoidArea(length, height);
            txtField6.setText("" + area);
        } catch (NumberFormatException n) {
            deltoidInvalid.setVisible(true);
            deltoidInvalid2.setVisible(true);
        }     
        }
        });
       
       
       Button clearDeltoid = new Button("Clear");
       clearDeltoid.setId("clearDeltoid");
       deltoidGrid.add(clearDeltoid, 6, 3);
       clearDeltoid.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
           txtField6.setText("");
           deltoidField1.setText("");
           deltoidField2.setText("");
           deltoidInvalid.setVisible(false);
           deltoidInvalid2.setVisible(false);
        }
        });
       
    //textfield keyboard controls
    deltoidField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                deltoidField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                deltoidField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField6.requestFocus();
            }
        });
    
    deltoidField2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField6.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField6.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                deltoidField1.requestFocus();
            }
        });
    
    txtField6.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                deltoidField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                deltoidField1.requestFocus();
            }
        });
       
        
        Button deltoidBack = new Button("Menu");
        deltoidBack.setId("deltoidBack");
        deltoidBack.setOnAction(x -> {  primaryStage.setScene(scene);
                                        txtField6.setText("");
                                        deltoidField1.setText("");
                                        deltoidField2.setText("");
                                        deltoidInvalid.setVisible(false);
                                        deltoidInvalid2.setVisible(false);  
                                });
        deltoidGrid.add(deltoidBack, 0, 10);
            deltoidBack.setTranslateX(10);
            deltoidBack.setTranslateY(60);
       
       //
       //
       // 
        
        
        Label trapezoid = new Label("trapezoid");
        GridPane.setHalignment(trapezoid, HPos.CENTER);
        Image imgTrapezoid = new Image("shapes/trapezoid-removebg-preview.png");
        ImageView imgV7 = new ImageView(imgTrapezoid);
        imgV7.setFitHeight(80);
        imgV7.setPreserveRatio(true);
        Button button7 = new Button();
        button7.setId("button7");
        button7.setGraphic(imgV7);
        grid.add(button7, 4, 5);
        GridPane trapezoidGrid = new GridPane();  
        Group trapezoidRoot = new Group();//trapezoidGrid
        Scene sceneTrapezoid = new Scene(trapezoidRoot, 800, 500);          
         
        
//TRAPEZOID ANIMATION
        
    //for loop
    Group trapezoids = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //TRAPEZOID
        Polygon trapezoidObj = new Polygon();
        trapezoidObj.getPoints().addAll(60.0, 0.0, 180.0, 0.0, 240.00, 100.0, 0.0, 100.0);
        trapezoidObj.setFill(Color.web("white", 0.05));
        trapezoidObj.setStrokeType(StrokeType.OUTSIDE);
        trapezoidObj.setStroke(Color.web("white", 0.20));
        trapezoidObj.setStrokeWidth(20);
        
        
                Rectangle colors = new Rectangle(sceneTrapezoid.getWidth(), sceneTrapezoid.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#ff7f38")),
                 }));
            colors.widthProperty().bind(sceneTrapezoid.widthProperty());
            colors.heightProperty().bind(sceneTrapezoid.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneTrapezoid.getWidth(), sceneTrapezoid.getHeight(),      
        Color.BLACK), trapezoids), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(trapezoidGrid);  
    trapezoidRoot.getChildren().add(blendModeGroup);                                         
        
        trapezoids.getChildren().add(trapezoidObj);
        
    }
    
    //add effect 
    trapezoids.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineTrapezoid = new Timeline();
    for (Node node : trapezoids.getChildren()) {
    timelineTrapezoid.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineTrapezoid.setAutoReverse(true);
    timelineTrapezoid.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineTrapezoid.play();
       
//END OF TRAPEZOID ANIMATION    
    
        
        button7.setOnAction(x -> primaryStage.setScene(sceneTrapezoid));
        grid.add(trapezoid, 4, 6);
        
        
        trapezoidGrid.setHgap(20);
        trapezoidGrid.setVgap(10);
        trapezoidGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVtr = new ImageView(imgTrapezoid);
        iVtr.setX(30); 
        iVtr.setY(60); 
        iVtr.setFitHeight(80);
        iVtr.setPreserveRatio(true);
        Group gTr = new Group(iVtr);
        Text tz = new Text("Trapezoid: ");
        tz.setId("trapezoid-text");
      
        
        Text trapezoidInvalid = new Text("Enter a valid number*");
        trapezoidInvalid.setVisible(false);
        trapezoidInvalid.setId("trapezoidInvalid");
        Text trapezoidInvalid2 = new Text("Enter a valid number*");
        trapezoidInvalid2.setVisible(false);//SET TRUE IF EXCEPTION IS THROWN + ADD CSS
        trapezoidInvalid2.setId("trapezoidInvalid2");
        Text trapezoidInvalid3 = new Text("Enter a valid number*");
        trapezoidInvalid3.setVisible(false);
        trapezoidInvalid3.setId("trapezoidInvalid3");
        
        TextField trapezoidField1 = new TextField();
        Label trapezoidLength = new Label("Enter (longer) base length: ");
        TextField trapezoidField2 = new TextField();
        Label trapezoidLength2 = new Label("Enter (shorter) base length: ");
        TextField trapezoidField3 = new TextField();
        Label trapezoidHeight = new Label("Enter height: ");
        GridPane.setHalignment(trapezoidHeight, HPos.RIGHT);
        
       
        ColumnConstraints trapezoidColumn = new ColumnConstraints(159); 
        trapezoidGrid.getColumnConstraints().addAll(trapezoidColumn);
        RowConstraints trapezoidRow = new RowConstraints(); 
        trapezoidRow.setPercentHeight(10); 
        trapezoidGrid.getRowConstraints().addAll(trapezoidRow); 
       
       
       
        trapezoidGrid.add(tz, 0, 0);
        trapezoidGrid.setColumnSpan(tz, 2);
        trapezoidGrid.add(gTr, 0, 1);
        trapezoidGrid.setColumnSpan(gTr, 2);
        trapezoidGrid.setRowSpan(gTr, 2);
        trapezoidGrid.add(trapezoidLength, 2, 3);
        GridPane.setHalignment(trapezoidLength, HPos.RIGHT);
        trapezoidGrid.setColumnSpan(trapezoidLength, 2);
        trapezoidGrid.add(trapezoidLength2, 2, 5);
        trapezoidGrid.setColumnSpan(trapezoidLength2, 2);
        GridPane.setHalignment(trapezoidLength2, HPos.RIGHT);
        trapezoidGrid.add(trapezoidInvalid, 2, 4);
        trapezoidGrid.setColumnSpan(trapezoidInvalid, 2);
        GridPane.setHalignment(trapezoidInvalid, HPos.RIGHT);
        trapezoidGrid.add(trapezoidInvalid2, 2, 6);
        trapezoidGrid.setColumnSpan(trapezoidInvalid2, 2);
        GridPane.setHalignment(trapezoidInvalid2, HPos.RIGHT);
        trapezoidGrid.add(trapezoidInvalid3, 2, 8);
        trapezoidGrid.setColumnSpan(trapezoidInvalid3, 2);
        GridPane.setHalignment(trapezoidInvalid3, HPos.RIGHT);
        trapezoidGrid.add(trapezoidField1, 4, 3);
        trapezoidGrid.add(trapezoidField2, 4, 5);
        trapezoidGrid.add(trapezoidField3, 4, 7);
        trapezoidGrid.add(trapezoidHeight, 2, 7);
        trapezoidGrid.setColumnSpan(trapezoidHeight, 2);
        GridPane.setHalignment(trapezoidHeight, HPos.RIGHT);
       
        
       Label l7 = new Label("Area = ");
       GridPane.setHalignment(l7, HPos.RIGHT);
       TextField txtField7 = new TextField();        
        
            trapezoidGrid.add(l7, 3, 9);
            trapezoidGrid.add(txtField7, 4, 9);
            trapezoidGrid.setColumnSpan(txtField7, 2);
        
        
        
       Button tzButton = new Button("Calculate");
       tzButton.setId("tzButton");
       trapezoidGrid.add(tzButton, 5, 3);
       tzButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            trapezoidInvalid.setVisible(false);
            trapezoidInvalid2.setVisible(false);
            trapezoidInvalid3.setVisible(false);
        try {
            double longBase = Double.parseDouble(trapezoidField1.getText());
            double shortBase = Double.parseDouble(trapezoidField2.getText());
            double height = Double.parseDouble(trapezoidField3.getText());
            double area = obj.trapezoidArea(longBase, shortBase, height);
            txtField7.setText("" + area);
        } catch (NumberFormatException n) {
            trapezoidInvalid.setVisible(true);
            trapezoidInvalid2.setVisible(true);
            trapezoidInvalid3.setVisible(true);
        }  
        }
        });
       
       
       Button clearTrapezoid = new Button("Clear");
       clearTrapezoid.setId("clearTrapezoid");
       trapezoidGrid.add(clearTrapezoid, 6, 3);
       clearTrapezoid.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            txtField7.setText("");
            trapezoidField1.setText("");
            trapezoidField2.setText("");
            trapezoidField3.setText("");
            trapezoidInvalid.setVisible(false);
            trapezoidInvalid2.setVisible(false);
            trapezoidInvalid3.setVisible(false);
        }
        });
       
       //textfield keyboard controls
    trapezoidField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                trapezoidField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                trapezoidField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField7.requestFocus();
            }
        });
    
    trapezoidField2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                trapezoidField3.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                trapezoidField3.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                trapezoidField1.requestFocus();
            }
        });
    
    trapezoidField3.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField7.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField7.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                trapezoidField2.requestFocus();
            }
        });
    
    txtField7.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                trapezoidField3.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                trapezoidField1.requestFocus();
            }
        });
       
       
        
        Button trapezoidBack = new Button("Menu");
        trapezoidBack.setId("trapezoidBack");
        trapezoidBack.setOnAction(x -> {primaryStage.setScene(scene);
                                        txtField7.setText("");
                                        trapezoidField1.setText("");
                                        trapezoidField2.setText("");
                                        trapezoidField3.setText("");
                                        trapezoidInvalid.setVisible(false);
                                        trapezoidInvalid2.setVisible(false);
                                        trapezoidInvalid3.setVisible(false);   
                                  });
         trapezoidGrid.add(trapezoidBack, 0, 10);
            trapezoidBack.setTranslateX(10);
            trapezoidBack.setTranslateY(60);
       
       //
       //
       // 
        
       
        
        Label parallelogram = new Label("parallelogram");
        GridPane.setHalignment(parallelogram, HPos.CENTER);
        Image imgParallelogram = new Image("shapes/parallelogram-removebg-preview.png");
        ImageView imgV8 = new ImageView(imgParallelogram);
        imgV8.setFitHeight(80);
        imgV8.setPreserveRatio(true);
        Button button8 = new Button();
        button8.setId("button8");
        button8.setGraphic(imgV8);
        grid.add(button8, 6, 5);
        GridPane parallelogramGrid = new GridPane();
        Group parallelogramRoot = new Group();
        Scene sceneParallelogram = new Scene(parallelogramRoot, 800, 500);      
        
        
//PARALLELOGRAM ANIMATION
        
    //for loop
    Group parallelograms = new Group();
    for (int i = 0; i < 18; i++) {
        
        
        //PARALLELOGRAM 
        Polygon parallelogramObj = new Polygon();
        parallelogramObj.getPoints().addAll(80.0, 0.0, 260.0, 0.0, 180.00, 100.0, 0.0, 100.0);
        parallelogramObj.setFill(Color.web("white", 0.05));
        parallelogramObj.setStrokeType(StrokeType.OUTSIDE);
        parallelogramObj.setStroke(Color.web("white", 0.20));
        parallelogramObj.setStrokeWidth(20);
        
        
                Rectangle colors = new Rectangle(sceneParallelogram.getWidth(), sceneParallelogram.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#38a971")),
                 }));
            colors.widthProperty().bind(sceneParallelogram.widthProperty());
            colors.heightProperty().bind(sceneParallelogram.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(sceneParallelogram.getWidth(), sceneParallelogram.getHeight(),      
        Color.BLACK), parallelograms), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);
    blendModeGroup.getChildren().add(parallelogramGrid);  
    parallelogramRoot.getChildren().add(blendModeGroup);                                         
        
        parallelograms.getChildren().add(parallelogramObj);
        
    }
    
    //add effect 
    parallelograms.setEffect(new BoxBlur(10, 10, 3));
    
    

        Timeline timelineParallelogram = new Timeline();
    for (Node node : parallelograms.getChildren()) {
    timelineParallelogram.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO, 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 600)
        )
    );
   
    timelineParallelogram.setAutoReverse(true);
    timelineParallelogram.setCycleCount(Animation.INDEFINITE);
    
    
    
}

    timelineParallelogram.play();
       
//END OF PARALLELOGRAM ANIMATION


        button8.setOnAction(x -> primaryStage.setScene(sceneParallelogram));    
        grid.add(parallelogram, 6, 6);
        
        parallelogramGrid.setHgap(20);
        parallelogramGrid.setVgap(10);
        parallelogramGrid.setPadding(new Insets(25, 25, 25, 25));
        ImageView iVp = new ImageView(imgParallelogram);
        iVp.setX(30); 
        iVp.setY(60); 
        iVp.setFitHeight(80);
        iVp.setPreserveRatio(true);
        Group gP = new Group(iVp);
        Text p = new Text("Parallelogram: ");
        p.setId("parallelogram-text");
        
    Text parallelogramInvalid = new Text("Enter a valid number*");
    parallelogramInvalid.setVisible(false);
    parallelogramInvalid.setId("parallelogramInvalid");
    Text parallelogramInvalid2 = new Text("Enter a valid number*");
    parallelogramInvalid2.setVisible(false);
    parallelogramInvalid2.setId("parallelogramInvalid2");
    
    TextField parallelogramField1 = new TextField();
    Label parallelogramLength = new Label("Enter length: ");
    TextField parallelogramField2 = new TextField();
    Label parallelogramHeight = new Label("Enter height: ");
     
     //using these to fill up space in the grid ==> look for another solution
            Text parallelogramInvalid3 = new Text("Enter a valid number*"); 
            parallelogramInvalid3.setVisible(false); 
            parallelogramInvalid3.setId("parallelogramInvalid3");
            TextField parallelogramField3 = new TextField(); 
            parallelogramField3.setVisible(false);
     
            
        ColumnConstraints parallelogramColumn = new ColumnConstraints(190); 
        parallelogramGrid.getColumnConstraints().addAll(parallelogramColumn);
        RowConstraints parallelogramRow = new RowConstraints(); 
        parallelogramRow.setPercentHeight(10); 
        parallelogramGrid.getRowConstraints().addAll(parallelogramRow); 
        
        parallelogramGrid.add(p, 0, 0);
        parallelogramGrid.setColumnSpan(p, 2);
        parallelogramGrid.add(gP, 0, 1);
        parallelogramGrid.setColumnSpan(gP, 2);
        parallelogramGrid.setRowSpan(gP, 2);
        parallelogramGrid.add(parallelogramLength, 2, 3);
        GridPane.setHalignment(parallelogramLength, HPos.RIGHT);
        parallelogramGrid.setColumnSpan(parallelogramLength, 2);
        parallelogramGrid.add(parallelogramInvalid, 2, 4);
        parallelogramGrid.setColumnSpan(parallelogramInvalid, 2);
        GridPane.setHalignment(parallelogramInvalid, HPos.RIGHT);
        parallelogramGrid.add(parallelogramField1, 4, 3);
        parallelogramGrid.add(parallelogramField2, 4, 5);
        parallelogramGrid.add(parallelogramField3, 4, 7);
        parallelogramGrid.add(parallelogramHeight, 2, 5);
        parallelogramGrid.setColumnSpan(parallelogramHeight, 2);
        GridPane.setHalignment(parallelogramHeight, HPos.RIGHT);
        parallelogramGrid.add(parallelogramInvalid2, 2, 6);
        parallelogramGrid.setColumnSpan(parallelogramInvalid2, 2);
        GridPane.setHalignment(parallelogramInvalid2, HPos.RIGHT);
        parallelogramGrid.add(parallelogramInvalid3, 2, 8);
        parallelogramGrid.setColumnSpan(parallelogramInvalid3, 2);
        
        
       Label l8 = new Label("Area = ");
       GridPane.setHalignment(l8, HPos.RIGHT);
       TextField txtField8 = new TextField();
       
            parallelogramGrid.add(l8, 3, 9);
            parallelogramGrid.add(txtField8, 4, 9);
            parallelogramGrid.setColumnSpan(txtField8, 2);
	
        
        Button pButton = new Button("Calculate");
        pButton.setId("pButton");
        parallelogramGrid.add(pButton, 5, 3);
        pButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
            parallelogramInvalid.setVisible(false);
            parallelogramInvalid2.setVisible(false);
        try {
            double length = Double.parseDouble(parallelogramField1.getText());
            double height = Double.parseDouble(parallelogramField2.getText());
            double area = obj.parallelogramArea(length, height);
            txtField8.setText("" + area);
        } catch (NumberFormatException n) {
            parallelogramInvalid.setVisible(true);
            parallelogramInvalid2.setVisible(true);
        }   
        }
        });
        
        
       Button clearParallelogram = new Button("Clear");
       clearParallelogram.setId("clearParallelogram");
       parallelogramGrid.add(clearParallelogram, 6, 3);
       clearParallelogram.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            txtField8.setText("");
            parallelogramField1.setText("");
            parallelogramField2.setText("");
            parallelogramInvalid.setVisible(false);
            parallelogramInvalid2.setVisible(false);
        }
        });
       
    //textfield keyboard controls
    parallelogramField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.DOWN)){
                parallelogramField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.ENTER)){
                parallelogramField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                txtField8.requestFocus();
            }
        });
    
    parallelogramField2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txtField8.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                txtField8.requestFocus();
            }
            if(event.getCode().equals(KeyCode.UP)){
                parallelogramField1.requestFocus();
            }
        });
    
    txtField8.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.UP)){
                parallelogramField2.requestFocus();
            }
            if(event.getCode().equals(KeyCode.DOWN)){
                parallelogramField1.requestFocus();
            }
        });
       
       
        Button parallelogramBack = new Button("Menu");
        parallelogramBack.setId("parallelogramBack");
        parallelogramBack.setOnAction(x -> {primaryStage.setScene(scene);
                                            txtField8.setText("");
                                            parallelogramField1.setText("");
                                            parallelogramField2.setText("");
                                            parallelogramInvalid.setVisible(false);
                                            parallelogramInvalid2.setVisible(false);
                                      });
        parallelogramGrid.add(parallelogramBack, 0, 10);
            parallelogramBack.setTranslateX(10);
            parallelogramBack.setTranslateY(60);
       
       //
       //
       // 
        
       
    //Additional changes: - Next buttons: ">"
     Button circleNext = new Button(">");
     circleGrid.add(circleNext, 8, 10);
        circleNext.setTranslateX(-34);
        circleNext.setTranslateY(60);
     circleNext.setOnAction(x -> {  primaryStage.setScene(sceneTriangle);
                                    txtField1.setText("");
                                    circleField1.setText("");
                                    circleInvalid.setVisible(false);
     });
     circleNext.setId("circleNext");
     
     Button triangleNext = new Button(">");
     triangleGrid.add(triangleNext, 8, 10);
        triangleNext.setTranslateX(-34);
        triangleNext.setTranslateY(60);
     triangleNext.setOnAction(x -> {    primaryStage.setScene(sceneSquare);
                                        txtField2.setText("");
                                        triangleField1.setText("");
                                        triangleField2.setText("");
                                        triangleInvalid.setVisible(false);
                                        triangleInvalid2.setVisible(false);
     });
     triangleNext.setId("triangleNext");
     
     Button squareNext = new Button(">");
     squareGrid.add(squareNext, 8, 10);
        squareNext.setTranslateX(-34);
        squareNext.setTranslateY(60);
     squareNext.setOnAction(x -> {  primaryStage.setScene(sceneRectangle);
                                    txtField3.setText("");
                                    squareField1.setText("");
                                    squareInvalid.setVisible(false);
     });
     squareNext.setId("squareNext");
     
     Button rectangleNext = new Button(">");
     rectangleGrid.add(rectangleNext, 8, 10);
        rectangleNext.setTranslateX(-34);
        rectangleNext.setTranslateY(60);
     rectangleNext.setOnAction(x -> {   primaryStage.setScene(sceneRhombus);
                                        txtField4.setText("");
                                        rectangleField1.setText("");
                                        rectangleField2.setText("");
                                        rectangleInvalid.setVisible(false);
                                        rectangleInvalid2.setVisible(false);
     });
     
     rectangleNext.setId("rectangleNext");
     
     Button rhombusNext = new Button(">");
     rhombusGrid.add(rhombusNext, 8, 10);
        rhombusNext.setTranslateX(-34);
        rhombusNext.setTranslateY(60);
     rhombusNext.setOnAction(x -> { primaryStage.setScene(sceneDeltoid);
                                    txtField5.setText("");
                                    rhombusField1.setText("");
                                    rhombusInvalid.setVisible(false);
     });
     rhombusNext.setId("rhombusNext");
     
     Button deltoidNext = new Button(">");
     deltoidGrid.add(deltoidNext, 8, 10);
        deltoidNext.setTranslateX(-34);
        deltoidNext.setTranslateY(60);
     deltoidNext.setOnAction(x -> { primaryStage.setScene(sceneTrapezoid);
                                    txtField6.setText("");
                                    deltoidField1.setText("");
                                    deltoidField2.setText("");
                                    deltoidInvalid.setVisible(false);
                                    deltoidInvalid2.setVisible(false);
     });
     
     
     deltoidNext.setId("deltoidNext");
     
     Button trapezoidNext = new Button(">");
     trapezoidGrid.add(trapezoidNext, 8, 10);
        trapezoidNext.setTranslateX(-34);
        trapezoidNext.setTranslateY(60);
     trapezoidNext.setOnAction(x -> {   primaryStage.setScene(sceneParallelogram);
                                        txtField7.setText("");
                                        trapezoidField1.setText("");
                                        trapezoidField2.setText("");
                                        trapezoidField3.setText("");
                                        trapezoidInvalid.setVisible(false);
                                        trapezoidInvalid2.setVisible(false);
                                        trapezoidInvalid3.setVisible(false);   
    });
     trapezoidNext.setId("trapezoidNext");
     
     Button parallelogramNext = new Button(">");
     parallelogramGrid.add(parallelogramNext, 8, 10);
        parallelogramNext.setTranslateX(-34);
        parallelogramNext.setTranslateY(60);
     parallelogramNext.setOnAction(x -> {   primaryStage.setScene(sceneCircle);
                                            txtField8.setText("");
                                            parallelogramField1.setText("");
                                            parallelogramField2.setText("");
                                            parallelogramInvalid.setVisible(false);
                                            parallelogramInvalid2.setVisible(false);
     });
     parallelogramNext.setId("parallelogramNext");
     
     
                //
                //
     
     
     
     //Additional changes: - Back buttons: "<"
     Button circleBack2 = new Button("<");
     circleGrid.add(circleBack2, 7, 10);
        circleBack2.setTranslateX(-39);
        circleBack2.setTranslateY(60);
     circleBack2.setOnAction(x -> { primaryStage.setScene(sceneParallelogram);
                                    txtField1.setText("");
                                    circleField1.setText("");
                                    circleInvalid.setVisible(false);
     });
     circleBack2.setId("circleBack2");
     
     Button triangleBack2 = new Button("<");
     triangleGrid.add(triangleBack2, 7, 10);
        triangleBack2.setTranslateX(-39);
        triangleBack2.setTranslateY(60);
     triangleBack2.setOnAction(x -> {   primaryStage.setScene(sceneCircle);
                                        txtField2.setText("");
                                        triangleField1.setText("");
                                        triangleField2.setText("");
                                        triangleInvalid.setVisible(false);
                                        triangleInvalid2.setVisible(false);
     });
     triangleBack2.setId("triangleBack2");
     
     Button squareBack2 = new Button("<");
     squareGrid.add(squareBack2, 7, 10);
        squareBack2.setTranslateX(-39);
        squareBack2.setTranslateY(60);
     squareBack2.setOnAction(x -> { primaryStage.setScene(sceneTriangle);
                                    txtField3.setText("");
                                    squareField1.setText("");
                                    squareInvalid.setVisible(false);
     });
     squareBack2.setId("squareBack2");
     
     Button rectangleBack2 = new Button("<");
     rectangleGrid.add(rectangleBack2, 7, 10);
        rectangleBack2.setTranslateX(-39);
        rectangleBack2.setTranslateY(60);
     rectangleBack2.setOnAction(x -> {  primaryStage.setScene(sceneSquare);
                                        txtField4.setText("");
                                        rectangleField1.setText("");
                                        rectangleField2.setText("");
                                        rectangleInvalid.setVisible(false);
                                        rectangleInvalid2.setVisible(false);
     });
     rectangleBack2.setId("rectangleBack2");
     
     Button rhombusBack2 = new Button("<");
     rhombusGrid.add(rhombusBack2, 7, 10);
        rhombusBack2.setTranslateX(-39);
        rhombusBack2.setTranslateY(60);
     rhombusBack2.setOnAction(x -> {    primaryStage.setScene(sceneRectangle);
                                        txtField5.setText("");
                                        rhombusField1.setText("");
                                        rhombusInvalid.setVisible(false);
     });
     rhombusBack2.setId("rhombusBack2");
     
     Button deltoidBack2 = new Button("<");
     deltoidGrid.add(deltoidBack2, 7, 10);
        deltoidBack2.setTranslateX(-39);
        deltoidBack2.setTranslateY(60); 
     deltoidBack2.setOnAction(x -> {    primaryStage.setScene(sceneRhombus);
                                        txtField6.setText("");
                                        deltoidField1.setText("");
                                        deltoidField2.setText("");
                                        deltoidInvalid.setVisible(false);
                                        deltoidInvalid2.setVisible(false);
     });
     deltoidBack2.setId("deltoidBack2");
     
     Button trapezoidBack2 = new Button("<");
     trapezoidGrid.add(trapezoidBack2, 7, 10);
        trapezoidBack2.setTranslateX(-39);
        trapezoidBack2.setTranslateY(60);
     trapezoidBack2.setOnAction(x -> {  primaryStage.setScene(sceneDeltoid);
                                        txtField7.setText("");
                                        trapezoidField1.setText("");
                                        trapezoidField2.setText("");
                                        trapezoidField3.setText("");
                                        trapezoidInvalid.setVisible(false);
                                        trapezoidInvalid2.setVisible(false);
                                        trapezoidInvalid3.setVisible(false);   
     });
     trapezoidBack2.setId("trapezoidBack2");
     
     Button parallelogramBack2 = new Button("<");
     parallelogramGrid.add(parallelogramBack2, 7, 10);
        parallelogramBack2.setTranslateX(-39);
        parallelogramBack2.setTranslateY(60);
     parallelogramBack2.setOnAction(x -> {  primaryStage.setScene(sceneTrapezoid);
                                            txtField8.setText("");
                                            parallelogramField1.setText("");
                                            parallelogramField2.setText("");
                                            parallelogramInvalid.setVisible(false);
                                            parallelogramInvalid2.setVisible(false);
     });
     parallelogramBack2.setId("parallelogramBack2");
     
    
     
     
     
    
        /**                     
         * 
         * MAIN ANIMATION
         * 
         */
        
        
        {
        //for loop
        Group shapes = new Group();
    for (int i = 0; i < 3; i++) {
        
        
        //CIRCLE
        Circle circleObj = new Circle(90, Color.web("white", 0.05));
        circleObj.setStrokeType(StrokeType.OUTSIDE);
        circleObj.setStroke(Color.web("white", 0.32));
        circleObj.setStrokeWidth(14);
        
        //TRIANGLE
        Polygon triangleObj = new Polygon();
        triangleObj.getPoints().setAll(200d, 200d, 300d, 50d, 400d, 200d);
        triangleObj.setFill(Color.web("white", 0.05));
        triangleObj.setStrokeType(StrokeType.OUTSIDE);
        triangleObj.setStroke(Color.web("white", 0.32));
        triangleObj.setStrokeWidth(14);
        
        //SQUARE   
        Rectangle squareObj = new Rectangle(5, 5, 160, 160);
        squareObj.setFill(Color.web("white", 0.05));
        squareObj.setStrokeType(StrokeType.OUTSIDE);
        squareObj.setStroke(Color.web("white", 0.32));
        squareObj.setStrokeWidth(14);
        
        //RECTANGLE
        Rectangle rectangleObj = new Rectangle(5, 5, 180, 100);
        rectangleObj.setFill(Color.web("white", 0.05));
        rectangleObj.setStrokeType(StrokeType.OUTSIDE);
        rectangleObj.setStroke(Color.web("white", 0.32));
        rectangleObj.setStrokeWidth(14);
        
        //RHOMBUS  
        Rectangle rhombusObj = new Rectangle(5, 5, 140, 140);
        Rotate r = new Rotate();
        r.setAngle(45);  
        r.setPivotX(100);  
        r.setPivotY(300);  
        rhombusObj.getTransforms().add(r);  
        rhombusObj.setFill(Color.web("white", 0.05));
        rhombusObj.setStrokeType(StrokeType.OUTSIDE);
        rhombusObj.setStroke(Color.web("white", 0.32));
        rhombusObj.setStrokeWidth(14);
        
        //DELTOID  
        Polygon deltoidObj = new Polygon();
        deltoidObj.getPoints().setAll(46.5, 0.0, 135.0, 0.0, 168.00, 225.0, 0.0, 73.5); //62.0, 0.0, 180.0, 0.0, 224.00, 300.0, 0.0, 98.0
        Rotate r2 = new Rotate();
        r2.setAngle(27);  
        r2.setPivotX(100);  
        r2.setPivotY(300);  
        deltoidObj.getTransforms().add(r2);
        deltoidObj.setFill(Color.web("white", 0.05));
        deltoidObj.setStrokeType(StrokeType.OUTSIDE);
        deltoidObj.setStroke(Color.web("white", 0.32));
        deltoidObj.setStrokeWidth(14);
        
        //TRAPEZOID
        Polygon trapezoidObj = new Polygon();
        trapezoidObj.getPoints().addAll(60.0, 0.0, 180.0, 0.0, 240.00, 100.0, 0.0, 100.0);
        trapezoidObj.setFill(Color.web("white", 0.05));
        trapezoidObj.setStrokeType(StrokeType.OUTSIDE);
        trapezoidObj.setStroke(Color.web("white", 0.32));
        trapezoidObj.setStrokeWidth(14);
        
        //PARALLELOGRAM 
        Polygon parallelogramObj = new Polygon();
        parallelogramObj.getPoints().addAll(80.0, 0.0, 260.0, 0.0, 180.00, 100.0, 0.0, 100.0);
        parallelogramObj.setFill(Color.web("white", 0.05));
        parallelogramObj.setStrokeType(StrokeType.OUTSIDE);
        parallelogramObj.setStroke(Color.web("white", 0.32));
        parallelogramObj.setStrokeWidth(14);
        
        
        
                Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
                 Stop[]{
                 new Stop(0, Color.web("#f8bd55")),
                 new Stop(0.14, Color.web("#c0fe56")),
                 new Stop(0.28, Color.web("#5dfbc1")),
                 new Stop(0.43, Color.web("#64c2f8")),
                 new Stop(0.57, Color.web("#be4af7")),
                 new Stop(0.71, Color.web("#ed5fc2")),
                 new Stop(0.85, Color.web("#ef504c")),
                 new Stop(1, Color.web("#f2660f")),}));
            colors.widthProperty().bind(scene.widthProperty());
            colors.heightProperty().bind(scene.heightProperty());
            
        
        Group blendModeGroup =                                                      
        new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),      
        Color.BLACK), shapes), colors);                                            
    colors.setBlendMode(BlendMode.OVERLAY);     
    blendModeGroup.getChildren().add(grid);  
    root.getChildren().add(blendModeGroup);                                         
        
        shapes.getChildren().add(circleObj);
        shapes.getChildren().add(rectangleObj);
        shapes.getChildren().add(squareObj);
        shapes.getChildren().add(trapezoidObj);
        shapes.getChildren().add(triangleObj);
        shapes.getChildren().add(parallelogramObj);
        shapes.getChildren().add(rhombusObj);
        shapes.getChildren().add(deltoidObj);
    }
    
    //add effect 
    shapes.setEffect(new BoxBlur(10, 10, 3));
    
    
    
        Timeline timelineMain = new Timeline();
    for (Node node : shapes.getChildren()) {
    timelineMain.getKeyFrames().addAll(
        new KeyFrame(Duration.ZERO,
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 500)
        ),
        new KeyFrame(new Duration(40000), 
            new KeyValue(node.translateXProperty(), random() * 800),
            new KeyValue(node.translateYProperty(), random() * 500)
        )
    );
   
    timelineMain.setAutoReverse(true);
    timelineMain.setCycleCount(Animation.INDEFINITE);
    
   
}

    timelineMain.play();
        
}  
        
//END OF MAIN ANIMATION
    

    //specifying the css stylesheets used for the scenes
        
        scene.getStylesheets().add(JavaFX.class.getResource("/css/css.css").toExternalForm());
        
        sceneCircle.getStylesheets().add(JavaFX.class.getResource("/css/circle.css").toExternalForm());
        sceneTriangle.getStylesheets().add(JavaFX.class.getResource("/css/triangle.css").toExternalForm());
        sceneSquare.getStylesheets().add(JavaFX.class.getResource("/css/square.css").toExternalForm());
        sceneRectangle.getStylesheets().add(JavaFX.class.getResource("/css/rectangle.css").toExternalForm());
        sceneRhombus.getStylesheets().add(JavaFX.class.getResource("/css/rhombus.css").toExternalForm());
        sceneDeltoid.getStylesheets().add(JavaFX.class.getResource("/css/deltoid.css").toExternalForm());
        sceneTrapezoid.getStylesheets().add(JavaFX.class.getResource("/css/trapezoid.css").toExternalForm());
        sceneParallelogram.getStylesheets().add(JavaFX.class.getResource("/css/parallelogram.css").toExternalForm());
        
        
        
        
        
        
        System.gc();
        primaryStage.setScene(scene);
        primaryStage.show();
        
        grid.setGridLinesVisible(false);
        circleGrid.setGridLinesVisible(false);
        triangleGrid.setGridLinesVisible(false);
        squareGrid.setGridLinesVisible(false);
        rectangleGrid.setGridLinesVisible(false);
        rhombusGrid.setGridLinesVisible(false);
        deltoidGrid.setGridLinesVisible(false);
        trapezoidGrid.setGridLinesVisible(false);
        parallelogramGrid.setGridLinesVisible(false);
    }
    
}
