package textstyle;

import java.util.ArrayList;

public class BaseDocFactory {
    private ArrayList doc=new ArrayList();
    private  int count=0;
    public BaseDocFactory(){
        BaseDoc doc1=new TextDoc();
        doc1.setContent("Java");
        doc.add(doc1);

    }
    public BaseDoc getDoc(){
        count++;
        return (BaseDoc)doc.get(0);
    }
    public int getDocCount(){
        return doc.size();
    }
    public int getCount(){
        return count;
    }
}
