package backend.compiler;

import backend.Backend;
import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageType;

public class Executor extends Backend {

    public void process(ICode iCode, SymTab symTab){
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int executionCount = 0;
        int runtimeErrors = 0;

        sendMessage(new Message(MessageType.INTERPRETER_SUMMARY,new Number[]{executionCount,runtimeErrors,elapsedTime}));


    }

    @Override
    public void addMessageListener(MessageListener listener) {

    }

    @Override
    public void removeMessageListener(MessageListener listener) {

    }

    @Override
    public void sendMessage(Message message) {

    }
}
