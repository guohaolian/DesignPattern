package textstyle;
//ÏíÔªÄ£Ê½
public class Client {
    public static void main(String[] args) {
        BaseDoc doc1,doc2,doc3;
        BaseDocFactory df=new BaseDocFactory();
        doc1=df.getDoc();
        doc1.display(new TextStyle("red","16px"));
        doc2=df.getDoc();
        doc2.display(new TextStyle("blue","13px"));
        doc3=df.getDoc();
        doc3.display(new TextStyle("green","18px"));
        System.out.println("Total documents created: "+df.getCount());
        System.out.println("Total documents available: "+df.getDocCount());
    }
}
