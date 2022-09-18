package tira.regextonfa;

public class Transition {
    public Node x;
    public Node y;
    public char value;

    public Transition(Node x, char value) {
        this.x = x;
        this.value = value;
    }
    
    public Transition(Node x, char value, Node y) {
        this.x = x;
        this.value = value;
        this.y = y;        
    }

    public Node getX() {
        return x;
    }

    public void setX(Node x) {
        this.x = x;
    }

    public Node getY() {
        return y;
    }

    public void setY(Node y) {
        this.y = y;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "char " +this.value+ " from " +this.x+ " to " +this.y;
    }
}
