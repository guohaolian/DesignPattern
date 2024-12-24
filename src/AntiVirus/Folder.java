package AntiVirus;

import java.util.ArrayList;

public class Folder extends AbstractFile{
    private ArrayList<AbstractFile> fileList=new ArrayList<AbstractFile>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }
    public void add(AbstractFile file) {
        fileList.add(file);
    }
    @Override
    public void killVirus() {
        System.out.println("���ļ��У� "+name+" ����ɱ��");
        for(Object obj : fileList) {
            ((AbstractFile)obj).killVirus();
        }

    }
}
