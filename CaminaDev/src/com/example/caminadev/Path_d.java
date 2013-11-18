package com.example.caminadev;

public class Path_d {
	private long id;
	private long path_h;
	
	private float directionX;
	private float directionY;
	private float directionZ;
	
	private float accelerationX;
	private float accelerationY;
	private float accelerationZ;
	
	private float gyroX;
	private float gyroY;
	private float gyroZ;
	public Path_d(){
	}
	
	public Path_d(long path_h, float directionX, float directionY, float directionZ, 
							   float accelerationX, float accelerationY, float accelerationZ,
							   float gyroX, float gyroY, float gyroZ){
		this.path_h=path_h;
		this.directionX=directionX;
		this.directionY=directionY;
		this.directionZ=directionZ;
		this.accelerationX=accelerationX;
		this.accelerationY=accelerationY;
		this.accelerationZ=accelerationZ;
		this.gyroX=gyroX;
		this.gyroY=gyroY;
		this.gyroZ=gyroZ;
	}
	
	public long getId(){
		return id;
	}

	public void setId(long id){
		this.id=id;
	}
	
	public long getPath_h(){
		return path_h;
	}
	
	public void setPath_h(long path_h){
		this.path_h=path_h;
	}
	
	public float getDirectionX(){
		return directionX;
	}
	
	public void setDirectionX(float directionX){
		this.directionX=directionX;
	}

	public float getDirectionY(){
		return directionY;
	}
	
	public void setDirectionY(float directionY){
		this.directionY=directionY;
	}
	
	public float getDirectionZ(){
		return directionZ;
	}
	
	public void setDirectionZ(float directionZ){
		this.directionZ=directionZ;
	}
	
	public float getAccelerationX(){
		return accelerationX;
	}
	
	public void setAccelerationX(float accelerationX){
		this.accelerationX=accelerationX;
	}
	
	public float getAccelerationY(){
		return accelerationY;
	}
	
	public void setAccelerationY(float accelerationY){
		this.accelerationY=accelerationY;
	}
	
	public float getAccelerationZ(){
		return accelerationZ;
	}
	
	public void setAccelerationZ(float accelerationZ){
		this.accelerationZ=accelerationZ;
	}
	
	public float getGyroX(){
		return gyroX;
	}
	
	public void setGyroX(float gyroX){
		this.gyroX=gyroX;
	}
	
	public float getGyroY(){
		return gyroY;
	}
	
	public void setGyroY(float gyroY){
		this.gyroY=gyroY;
	}
	
	public float getGyroZ(){
		return gyroZ;
	}
	
	public void setGyroZ(float gyroZ){
		this.gyroZ=gyroZ;
	}
}
