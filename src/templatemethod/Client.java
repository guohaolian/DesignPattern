package templatemethod;
//模板方法模式-客户端
public class Client
{
	public static void main(String a[])
	{
		BankTemplateMethod bank;
		bank=(BankTemplateMethod)XMLUtil.getBean();
		bank.process();
		System.out.println("---------------------------------------");
	}
}
