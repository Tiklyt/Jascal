package frontend;

public class Token {
    protected TokenType type;
    protected String text;
    protected Object value;
    protected Source source;

    public int getLineNumber() {
        return lineNum;
    }

    protected int lineNum;

    public int getPosition() {
        return position;
    }

    protected int position;

    public Token(Source source) throws Exception {
        this.source =source;
        this.lineNum = source.getLineNum();
        this.lineNum = source.getPosition();
        extract();
    }

    protected void extract() throws Exception {
        text = Character.toString(currentChar());
        value = null;
        nextChar();
    }

    protected char currentChar() throws Exception {
        return source.currentChar();
    }

    protected  char nextChar() throws Exception{
        return source.nextChar();
    }

    protected char peekChar() throws Exception{
        return source.peekChar();
    }
}
