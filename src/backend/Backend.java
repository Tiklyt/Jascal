package backend;

import intermediate.ICode;
import intermediate.SymTab;
import message.MessageHandler;
import message.MessageProducer;

public abstract class Backend implements MessageProducer {

    protected static MessageHandler messageHandler;

    static{
        messageHandler = new MessageHandler();
    }

    protected SymTab symTab;
    protected ICode iCode;


    public abstract void process(ICode iCode,SymTab symTab)throws Exception;

}
