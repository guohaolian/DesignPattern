package flyweight.nonextrinsic;

public class Hub implements NetworkDevice
{
	private String type;
	
	public Hub(String type)
	{
		this.type=type;
	}
	

	
	public void use()
	{
		System.out.println("Linked by Hub, type is " + this.type);
	}	
}