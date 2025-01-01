package adapter;

public class DogAdapter extends Dog implements Robot {
//	private Bird bird;
//	public DogAdapter(){
//		bird = new Bird();
//	}
	public void cry()
	{
		System.out.print("机器人模仿：");
//		bird.tweedle();
		super.wang();
	}
	
	public void move()
	{
		System.out.print("机器人模仿：");
		super.run();
	}
}