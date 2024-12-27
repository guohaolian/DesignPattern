package textstyle;

public class TextDoc implements BaseDoc {
    private String content;

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void display(TextStyle ts) {
        System.out.println("�������ݣ�" + getContent() + "����ɫ��" + ts.getColor() + "�����ִ�С��" + ts.getFontSize());
    }
}
