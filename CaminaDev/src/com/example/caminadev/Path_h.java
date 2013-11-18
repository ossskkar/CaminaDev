package com.example.caminadev;

public class Path_h{
	private long id;
	private String subject;
	private String device;
	private String description;
	private String date;
	private String fileName;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setSubject(String subject){
		this.subject=subject;
	}
	
	public String getDevice(){
		return device;
	}
	
	public void setDevice(String device){
		this.device=device;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date=date;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public void setFileName(String fileName){
		this.fileName=fileName;
	}
	
	@Override
	public String toString(){
		return fileName;
	}
}
