package adapter;
//ÊÊÅäÆ÷Ä£Ê½
public class Client
{
	public static void main(String args[])
	{
		Robot robot=(Robot)XMLUtil.getBean();
		robot.cry();
		robot.move();
	}
}