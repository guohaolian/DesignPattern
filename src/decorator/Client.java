package decorator;
//в╟йндёй╫
public class Client
{
	public static void main(String args[])
	{
		Transform camaro;
		camaro=new Car();
		camaro.move();
		System.out.println("-----------------------------");
		
		Airplane bumblebee=new Airplane(camaro);
		bumblebee.move();
		bumblebee.fly();
		System.out.println("-----------------------------");

		Robot robot=new Robot(camaro);
		robot.move();
		robot.say();
	}
}