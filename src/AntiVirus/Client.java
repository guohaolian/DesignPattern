package AntiVirus;
//���ģʽ
public class Client {
    public static void main(String args[]) {
        //��Գ��󹹼����
        AbstractFile file1,file2,file3,file4,file5;
        Folder folder1,folder2,folder3,folder4;

        folder1 = new Folder("���Ե�����");
        folder2 = new Folder("ͼ���ļ�");
        folder3 = new Folder("�ı��ļ�");
        folder4 = new Folder("��Ƶ�ļ�");

        file1 = new ImageFile("1.jpg");
        file2 = new ImageFile("2.gif");
        file3 = new TextFile("������¼.txt");
        file4 = new TextFile("yy.doc");
        file5 = new VideoFile("�ഺ����2.rmvb");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        //�ӡ����Ե����ϡ��ڵ㿪ʼ����ɱ������
        folder1.killVirus();
    }
}
