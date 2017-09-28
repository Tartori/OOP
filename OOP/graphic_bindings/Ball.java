package graphic_bindings;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

class Ball extends Circle {
   private double dragBaseX;
   private double dragBaseY;

   public Ball(double centerX, double centerY, double radius) {
       super(centerX, centerY, radius);

       setOnMousePressed(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               dragBaseX = event.getSceneX() - getCenterX();
               dragBaseY = event.getSceneY() - getCenterY();
           }
       });

       setOnMouseDragged(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               setCenterX(event.getSceneX() - dragBaseX);
               setCenterY(event.getSceneY() - dragBaseY);
           }
       });
   }
}



