package prototype.shallow;
//原型模式-浅克隆
public class Client
{
	public static void main(String a[])
	{
		Email email,copyEmail;
		
		email=new Email();
		
		copyEmail=(Email)email.clone();
		
		System.out.println("email==copyEmail?");
		System.out.println(email==copyEmail);
		
		System.out.println("email.getAttachment==copyEmail.getAttachment?"); 
		System.out.println(email.getAttachment()==copyEmail.getAttachment());			
	}
}