package frontend.pascal;

import frontend.EofToken;
import frontend.Parser;
import frontend.Scanner;
import frontend.Token;
import message.Message;
import message.MessageListener;
import message.MessageType;

import static message.MessageType.PARSER_SUMMARY;

public class PascalParserTD extends Parser {



    public PascalParserTD(Scanner scanner){
        super(scanner);
    }
    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();
        while (!((token = nextToken()) instanceof EofToken)) {}
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        sendMessage(new Message(PARSER_SUMMARY,
                new Number[] {token.getLineNumber(),
                        getErrorCount(),
                        elapsedTime}));
    }

    @Override
    public int getErrorCount() {
        return 0;
    }
}
