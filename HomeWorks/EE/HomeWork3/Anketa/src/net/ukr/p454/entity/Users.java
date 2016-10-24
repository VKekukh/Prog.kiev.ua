package net.ukr.p454.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkekukh on 24.10.2016.
 */
@XmlRootElement
public class Users {

    private List<User> list = new ArrayList<>();

    public Users() {
    }

    public Users(List<User> list) {

        this.list = list;
    }
    @XmlElement
    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
