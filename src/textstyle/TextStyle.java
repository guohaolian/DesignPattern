package textstyle;

public class TextStyle {

    private String color;

    private String fontSize;

    public TextStyle(String color, String fontSize) {
        this.color = color;
        this.fontSize = fontSize;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getFontSize() {
        return fontSize;
    }
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }
}
