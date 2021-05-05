package lib.game;

public class Rectangle {
    public int centerX;
    public int centerY;
    public int width;
    public int height;
    public int top;
    public int bottom;
    public int left;
    public int right;
    public Rectangle(int centerX, int centerY, int width, int height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.top = centerY - height / 2;
        this.bottom = centerY + height / 2;
        this.left = centerX - width / 2;
        this.right = centerX + width / 2;
    }
    public boolean collision(Rectangle other) {
        boolean v = other.left < left + width && left < other.left + other.width;
        boolean h = other.top < top + height && top < other.top + other.height;
        return v && h;
    }
}
