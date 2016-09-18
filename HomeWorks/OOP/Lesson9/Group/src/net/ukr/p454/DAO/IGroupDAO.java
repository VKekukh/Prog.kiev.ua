package net.ukr.p454.DAO;

import net.ukr.p454.Group;

/**
 * Created by user on 18.09.2016.
 */
public interface IGroupDAO {

    void saveGroup(Group group);

    Group loadGroup();
}
