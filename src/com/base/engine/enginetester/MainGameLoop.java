package com.base.engine.enginetester;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import com.base.engine.renderengine.DisplayManager;
import com.base.engine.renderengine.Loader;
import com.base.engine.renderengine.RawModel;
import com.base.engine.renderengine.Renderer;

public class MainGameLoop {
    
    public static void main(String[] args) {
        
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        //OpenGL expects vertices to be defined counter clockwise by default
        float[] vertices = {
            -0.5f, 0.5f, 0f,
            -0.5f, -0.5f, 0f,
            0.5f, -0.5f, 0f,
            0.5f, -0.5f, 0f,
            0.5f, 0.5f, 0f,
            -0.5f, 0.5f, 0f
          };

        RawModel model = loader.loadToVAO(vertices);

        while (!Display.isCloseRequested()) {
            renderer.prepare();
            renderer.render(model);
            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();

    }
    
}
