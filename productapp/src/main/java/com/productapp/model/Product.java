package com.productapp.model;
import lombok.Data;

@Data
public class Product {
private int pid;
private String pname;
private double pcost;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public double getPcost() {
	return pcost;
}
public void setPcost(double pcost) {
	this.pcost = pcost;
}
public Product orElseThrow(Object object) {
	// TODO Auto-generated method stub
	return null;
}


}
