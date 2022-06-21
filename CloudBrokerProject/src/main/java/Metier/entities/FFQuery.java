package Metier.entities;

import java.io.Serializable;

import jade.core.AID;

public class FFQuery implements Serializable {
 private String FF;
 private AID aid;
public String getFF() {
	return FF;
}
public void setFF(String fF) {
	FF = fF;
}
public AID getAid() {
	return aid;
}
public void setAid(AID aid) {
	this.aid = aid;
}
 
}
