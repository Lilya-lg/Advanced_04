package advanced02;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Pudge implements Externalizable {
	private String name;
	private int strikePower;
	private int hp;
	private int intelligence;
	private int strength;
	private int agility;
	//private int totalIntel;
	//private int totalAgility;
	//private int totalStrength;

	public Pudge() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public Pudge(String name, int agility) {
		super();
		this.name = name;
		this.agility = agility;
	}

	@Override
	public String toString() {
		return "Pudge [name=" + name + ", agility=" + agility + "]";
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		 name = (String)in.readObject();
	     agility = in.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name);
        out.writeInt(agility);
	}	
	
}
