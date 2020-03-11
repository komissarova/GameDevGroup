package ru.fireburn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.fireburn.FireBurnGame;
import ru.fireburn.settings.*;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = Settings.screenWight;
		config.height = Settings.screenHeight;
		config.fullscreen = Settings.screenFullscreen;
		config.resizable = Settings.screenResizable;

		new LwjglApplication(new FireBurnGame(), config);
	}
}
