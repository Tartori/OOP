package graphic_bindings;

import javafx.scene.shape.Line;

class Connection extends Line {
	   public Connection(Ball startBall, Ball endBall) {
	       startXProperty().bind(startBall.centerXProperty());
	       startYProperty().bind(startBall.centerYProperty());        
	       endXProperty().bind(endBall.centerXProperty());
	       endYProperty().bind(endBall.centerYProperty());        
	   }
	}