package frontend;

public abstract class Scanner {

    protected Source source;
    private Token currentToken;


    public Scanner(Source source){
        this.source = source;
    }

    public Token currentToken(){
        return currentToken;
    }

    public Token nextToken(){
        currentToken = extractToken();
        return currentToken;
    }

    protected  abstract Token extractToken() throws  Exception;

    public char currentChar(){
        return source.currentChar();
    }

    public char nextChar(){
        return source.nextChar();
    }

}
