package com.ui.pojo;

public class Environment
{
   private String url;
   private int MAX_ATTEMPTS;

   public String getUrl() {
       return url;
   }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }

    public void setMAX_ATTEMPTS(int MAX_Attempts) {
        this.MAX_ATTEMPTS = MAX_Attempts;
    }
}
