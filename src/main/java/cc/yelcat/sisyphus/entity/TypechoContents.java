package cc.yelcat.sisyphus.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypechoContents implements Serializable {
    private Integer cid;

    private String title;

    private String slug;

    private Integer created;

    private Integer modified;

    private String text;

    private Integer order;

    private Integer authorid;

    private String template;

    private String type;

    private String status;

    private String password;

    private Integer commentsnum;

    private String allowcomment;

    private String allowping;

    private String allowfeed;

    private Integer parent;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text.replace("../ibm_articles_img/", "https://www.yelcat.cc/ibm_articles_img/");
    }
}