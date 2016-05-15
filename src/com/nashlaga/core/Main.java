package com.nashlaga.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*; // Gives OpenGL access.
import static org.lwjgl.system.MemoryUtil.*; // Gives us NULL

import java.nio.ByteBuffer;
import org.lwjgl.glfw.GLFWVidMode;

public class Main implements Runnable{
	
	private Thread thread;
	public boolean running = true;
	
	public Long window;
	
	public static void main(String[] args) {
		// Main method - starts here.
		Main game = new Main();
		game.start();
	}
	
	public void start(){
		running = true;
		thread = new Thread(this, "LéMemeStation");
		thread.start();
	}
	
	public void init(){
		if(!glfwInit()){
			System.err.println("GLFW init failure!");
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		window = glfwCreateWindow(800, 600, "Lé Memé Stácion", NULL, NULL);
		
		if(window == NULL){
			System.err.println("Failed to create window!");
		}
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, 100, 100);
		
		glfwMakeContextCurrent(window);
		
		glfwShowWindow(window);
	}
	
	public void update(){
		glfwPollEvents();
	}
	
	public void render(){
		glfwSwapBuffers(window);
	}
	
	@Override
	public void run(){
		init();
		while(running){
			update();
			render();
			
			if(glfwWindowShouldClose(window)){
				running = false;
			}
		}
	}

}
