package com.adapter.sharewe.chat;

import com.google.gson.Gson;

public class ChattingVO {
 
    private String message;
    private String type;
    private String to;
     
    // ����ڰ� ���� �޼��� ������ ��� ��Ȱ�� �Ѵ�.
    public static ChattingVO convertMessage( String source ) {
        ChattingVO message = new ChattingVO();
        Gson gson = new Gson();
        // ����ڰ� ���� json Ÿ���� ������ �ڹ� ��ü�� �־��ش�.
        message = gson.fromJson(source, ChattingVO.class);
         
        return message;
    }
     
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
}