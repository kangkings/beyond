import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class UserEntity {
    private String userName;
    private List<UserEntity> friendList;

    public UserEntity() {
    }

    public UserEntity(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserEntity> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<UserEntity> friendList) {
        this.friendList = friendList;
    }
}
