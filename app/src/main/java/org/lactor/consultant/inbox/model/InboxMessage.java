package org.lactor.consultant.inbox.model;

/**
 * @Author Matthew Page
 * @Date 11/18/17
 */

public class InboxMessage {
    private String senderName;
    private String receiverName;
    private long messageSendTimestamp;
    private String message;

    public InboxMessage(String senderName, String receiverName, long messageSendTimestamp, String message) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.messageSendTimestamp = messageSendTimestamp;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public long getMessageSendTimestamp() {
        return messageSendTimestamp;
    }

    public void setMessageSendTimestamp(long messageSendTimestamp) {
        this.messageSendTimestamp = messageSendTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
