package data;

import pojo.PostUsers;

public class TestDataBuilder {
    public PostUsers getPostUserData(){
        PostUsers postUser = new PostUsers();
        postUser.setName("morpheus");
        postUser.setJob("leader");
        return postUser;
    }
}
