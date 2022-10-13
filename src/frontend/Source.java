package frontend;

import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

import java.io.BufferedReader;
import java.io.IOException;

import static message.MessageType.SOURCE_LINE;

public class Source implements MessageProducer {

    public static final char EOL = '\n';
    public static final char EOF = (char) 0;

    private BufferedReader reader;
    private String line;

    private MessageHandler messageHandler;
    public int getLineNum() {
        return lineNum;
    }

    private int lineNum;

    public int getPosition() {
        return currentPos;
    }

    private int currentPos;


    public Source(BufferedReader reader) throws IOException {
        messageHandler = new MessageHandler();
        this.lineNum = 0;
        this.currentPos = -2;
        this.reader = reader;
    }

    public char currentChar() throws Exception
    {
        if(currentPos == -2){
            readLine();
            return nextChar();
        }else if(line == null){
            return EOF;
        }else if((currentPos == -1) || (currentPos == line.length())){
            return EOL;
        }else if(currentPos > line.length()){
            readLine();
            return nextChar();
        }else{
            return line.charAt(currentPos);
        }
    }

    public char nextChar() throws Exception {
        ++currentPos;
        return currentChar();
    }

    public char peekChar() throws Exception {
        currentChar();
        if(line == null){
            return EOF;
        }
        int nextPos = currentPos + 1;
        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    public void close() throws IOException {
        if(reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    private void readLine()
            throws IOException
    {
        line = reader.readLine(); // null when at the end of the source
        currentPos = 0;
        if (line != null) {
            ++lineNum;
        }
        if (line != null) {
            sendMessage(new Message(SOURCE_LINE,
                    new Object[] {lineNum, line}));
        }
    }

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
