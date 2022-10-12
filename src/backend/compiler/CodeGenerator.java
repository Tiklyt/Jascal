package backend.compiler;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageType;

public class CodeGenerator extends MessageHandler {

    public void process(ICode iCode, SymTab symTab)throws Exception{
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int instructionCount = 0;

        sendMessage(new Message(MessageType.COMPILER_SUMMARY,new Number[]{instructionCount,elapsedTime}));
    }
}
