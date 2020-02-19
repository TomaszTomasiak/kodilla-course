package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUsersList = new ArrayList<>();

    public Forum() {
        theForumUsersList.add(new ForumUser(1001,"Lord_Wader", 'M', 2001, 01, 01,27 ));
        theForumUsersList.add(new ForumUser(1002,"Wonder_Woman", 'F', 1994, 01, 01,311 ));
        theForumUsersList.add(new ForumUser(1003,"Joker", 'M', 1988, 01, 01,202 ));
        theForumUsersList.add(new ForumUser(1004,"John Rambo", 'M', 1999, 01, 01,11 ));
        theForumUsersList.add(new ForumUser(1005,"Elizabeth III", 'F', 2002, 01, 01,87 ));
        theForumUsersList.add(new ForumUser(1006,"Mini Mouse", 'F', 1977, 01, 01,147 ));
        theForumUsersList.add(new ForumUser(1007,"James Bond", 'M', 1981, 01, 01,5 ));

    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theForumUsersList);
    }

}
