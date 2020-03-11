package ru.fireburn;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import ru.fireburn.screens.GameScreen;
import ru.fireburn.screens.MainMenuScreen;
import ru.fireburn.settings.*;

public class FireBurnGame extends Game {

	public enum AllScreens {
		MENU, GAME
	}

	private Settings settings;
	private SpriteBatch batch;
	private Viewport viewport;

	private MainMenuScreen mainMenuScreen;
	private GameScreen gameScreen;

	@Override
	public void create() {
		batch = new SpriteBatch();
		mainMenuScreen = new MainMenuScreen(this, batch);
		gameScreen = new GameScreen(this, batch);
		viewport = new FitViewport(Settings.screenWight, Settings.screenHeight);
		switchScreen(AllScreens.MENU);
	}

	@Override
	public void render() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		getScreen().render(deltaTime);
	}

	public void switchScreen(AllScreens screen) {
		Screen currentScreen = getScreen();
		if (currentScreen != null) {
			currentScreen.dispose();
		}

		switch (screen) {
			case MENU:
				setScreen(mainMenuScreen);
				break;
			case GAME:
				setScreen(gameScreen);
				break;
		}
	}

	public Viewport getViewport() {
		return viewport;
	}

	@Override
	public void dispose() {
		batch.dispose();
		getScreen().dispose();
	}
}
