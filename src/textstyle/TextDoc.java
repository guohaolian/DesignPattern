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
        System.out.println("文字内容：" + getContent() + "，颜色：" + ts.getColor() + "，文字大小：" + ts.getFontSize());
    }
}
