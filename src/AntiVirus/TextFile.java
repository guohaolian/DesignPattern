package AntiVirus;

public class TextFile extends  AbstractFile{
    private String name;

    public TextFile(String name) {

        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("���ı��ļ�:"+name+"����ɱ��");
    }
}
