package AntiVirus;

public class VideoFile extends  AbstractFile{
    private String name;

    public VideoFile(String name){
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("对音频文件："+name+"进行杀毒");
    }
}
