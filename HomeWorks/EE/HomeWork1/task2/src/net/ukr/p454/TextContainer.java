package net.ukr.p454;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vkekukh on 15.10.2016.
 */
public class TextContainer {

    @SaveTo (path = "text.txt")
    private String text;

    @SaveTo (path = "text2.txt")
    private String text2;


    public TextContainer(String text, String text2) {
        this.text = text;
        this.text2 = text2;
    }

    public TextContainer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "text='" + text + '\'' +
                ", text2='" + text2 + '\'' +
                '}';
    }

    @Saver
    public void save(String path, String txt){
        try(PrintWriter writer = new PrintWriter(path)){
            writer.write(txt);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
