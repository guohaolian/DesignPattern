package observer;

public class Cat extends MySubject
{
	public void cry()
	{
		System.out.println("è�У�");
		System.out.println("----------------------------");		
		
		for(Object obs:observers)
		{
			((MyObserver)obs).response();
		}
		
	}	   	
}