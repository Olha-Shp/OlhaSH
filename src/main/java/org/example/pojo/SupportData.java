package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SupportData {
    @JsonProperty
    private String url;
    @JsonProperty
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
