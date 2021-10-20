import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


/**
 * Name: Bhaswati Das Gupta
 * Date: 3/17/2021
 * Period: 3
 * Time: 1.5 hours
 * Reflection: This lab was similar to what we used to do in the beginning of the year. However, it was a bit more complicated in terms of
 * the syntax. I struggled with the parameters required to include an arc for the stem of the cherry. I searched up the API but the values 
 * were still a bit difficult to understand. The arc is still not how I would like it to be, but it works for the image. Overall, this lab 
 * helped me understand the different parts to JavaFX. 
 *
 */
public class P3_DasGupta_Bhaswati_JavaFX_HW1 extends Application {
	// measurements
	private final double ICECREAM_RADIUS = 100; // changing this scales everything
	
	private final double ICECREAM_OFF_Y = 2 * ICECREAM_RADIUS;
	
	private final double CHERRY_RADIUS = ICECREAM_RADIUS / 5;
	private final double CHERRY_OFF_Y = ICECREAM_OFF_Y + (ICECREAM_OFF_Y / 2);
	
	private final double CONE_OFF_Y = 3.5 * ICECREAM_RADIUS;
	
	private final double CHERRYSTEM_RADIUS_X = ICECREAM_RADIUS / 10;
	private final double CHERRYSTEM_RADIUS_Y = ICECREAM_RADIUS / 10;
	
	// colors
	private final Color ICECREAM_COLOR = Color.PINK;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ice Cream");
		stage.setResizable(false);
		stage.sizeToScene();
		
		Group root = new Group();
		Scene scene = new Scene(root, 1500, 1500);
		stage.setScene(scene);
		
		
		Circle iceCream= new Circle(ICECREAM_RADIUS);
		iceCream.setCenterX(scene.getWidth() / 2 );
		iceCream.setCenterY((scene.getHeight() / 2) - ICECREAM_OFF_Y);
		iceCream.setFill(ICECREAM_COLOR);
		iceCream.setStroke(Color.RED);
		root.getChildren().add(iceCream);
		
		Circle cherry = new Circle(CHERRY_RADIUS);
		cherry.setCenterX(scene.getWidth() / 2);
		cherry.setCenterY(scene.getHeight() / 2 - CHERRY_OFF_Y);
		cherry.setFill(Color.RED);
		cherry.setStroke(Color.RED);
		root.getChildren().add(cherry);
		
		Polygon cone = new Polygon(iceCream.getCenterX() - ICECREAM_RADIUS, iceCream.getCenterY() + ICECREAM_RADIUS/6,
									iceCream.getCenterX(), iceCream.getCenterY() + CONE_OFF_Y,
									iceCream.getCenterX() + ICECREAM_RADIUS, iceCream.getCenterY() + ICECREAM_RADIUS/6);
		cone.setFill(Color.NAVAJOWHITE);
		cone.setStroke(Color.PERU);
		root.getChildren().add(cone);
		
		Arc cherryStem = new Arc(scene.getWidth() / 2,(scene.getHeight() / 2) - (1.06 * CHERRY_OFF_Y), CHERRYSTEM_RADIUS_X, CHERRYSTEM_RADIUS_Y, 5, 100);
		cherryStem.setFill(null);
		cherryStem.setStroke(Color.RED);
		cherryStem.setStrokeWidth(5);
		root.getChildren().add(cherryStem);
		

		
		stage.show();
	}

}

