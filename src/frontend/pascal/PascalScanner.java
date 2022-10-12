package frontend.pascal;

import frontend.EofToken;
import frontend.Scanner;
import frontend.Source;
import frontend.Token;

import static frontend.Source.EOF;

public class PascalScanner extends Scanner {


    public PascalScanner(Source source) {
        super(source);
    }

    @Override
    protected Token extractToken() throws Exception {
        Token token;
        char currentChar = currentChar();
        if(currentChar == EOF){
            token = new EofToken(source);
        }else{
            token = new Token(source);
        }
        return token;
    }
}
