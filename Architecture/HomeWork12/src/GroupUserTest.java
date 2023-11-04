import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GroupUserTest {

    @org.junit.jupiter.api.Test
    void getUserList() {
        User user1 = new User("Анастасия");
        User user2 = new User("Алексей");
        User user3 = new User("Владимир");
        User user4 = new User("Марина");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        GroupUser groupUser = new GroupUser(userList);
        assertEquals(userList, groupUser.getUserList());
    }

    @org.junit.jupiter.api.Test
    void findList() {
        User user1 = new User("Анастасия");
        User user2 = new User("Алексей");
        User user3 = new User("Владимир");
        User user4 = new User("Марина");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        GroupUser groupUser = new GroupUser(userList);
        assertNull(groupUser.findList("Кирилл"));
        assertEquals(user4, groupUser.findList("Марина"));
    }

    @org.junit.jupiter.api.Test
    void addUser() {
        User user1 = new User("Анастасия");
        User user2 = new User("Алексей");
        User user3 = new User("Владимир");
        User user4 = new User("Марина");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        GroupUser groupUser = new GroupUser(userList);
        groupUser.addUser(user3);
        groupUser.addUser(user4);

        List<User> userListTest = new ArrayList<>();
        userListTest.add(user1);
        userListTest.add(user2);
        userListTest.add(user3);
        userListTest.add(user4);

        assertEquals(userListTest, groupUser.getUserList());
    }
}