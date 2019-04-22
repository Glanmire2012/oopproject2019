package panes;

import javafx.geometry.Side;
import javafx.scene.control.TabPane;

public class MyTabPane extends TabPane{
	public MyTabPane(){

		this.setSide(Side.TOP);
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	}
}
