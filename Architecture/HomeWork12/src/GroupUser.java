import java.util.List;

public class GroupUser {
    private List<User> userList;

    public GroupUser(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User findList(String name) {
        for (User user: userList) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public  void addUser(User user) {
        userList.add(user);
    }
}
