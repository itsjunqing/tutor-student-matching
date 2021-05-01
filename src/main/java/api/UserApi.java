package api;

import stream.User;

import java.util.List;

public class UserApi extends BasicApi<User> implements ApiInterface<User> {

    private final String USER_ENDPOINT = "/user";
    private final String USER_PARAMETERS = "?fields=competencies" +
                                            "&fields=competencies.subject" +
                                            "&fields=qualifications" +
                                            "&fields=initiatedBids";
    private final String USER_VERIFY = "/login?jwt=false";

    @Override
    public List<User> getAll() {
        return getAllObjects(USER_ENDPOINT + USER_PARAMETERS, User[].class);
    }

    @Override
    public User get(String id) {
        return getObject(USER_ENDPOINT + "/" + id + USER_PARAMETERS, User.class);
    }

    @Override
    public User add(User object) {
        return postObject(USER_ENDPOINT, object, User.class);
    }

    @Override
    public boolean patch(String id, User object) {
        return patchObject(USER_ENDPOINT, object);
    }

    @Override
    public boolean remove(String id) {
        return deleteObject(USER_ENDPOINT + "/" + id);
    }

    public boolean verify(User user) {
        return postObject(USER_ENDPOINT + USER_VERIFY, user);
    }

    /*
    public List<User> getAllUsers() {
        String url = USER_ENDPOINT + "?fields=competencies&fields=competencies.subject&" +
                "fields=qualifications&fields=initiatedBids";
        return getAllObjects(url, User[].class);
    }

    public User getUser(String id) {
        String endpoint = USER_ENDPOINT + "/" + id +
                "?fields=competencies&fields=competencies.subject&" +
                "fields=qualifications&fields=initiatedBids";
        return getObject(endpoint, User.class);
    }

    public boolean addUser(User user) {
        return postObject(USER_ENDPOINT, user);
    }

    public boolean patchUser(User user) {
        return patchObject(USER_ENDPOINT, user);
    }

    public boolean removeUser(String id) {
        return deleteObject(USER_ENDPOINT + "/" + id);
    }

    public boolean verifyUser(User user) {
        return postObject(USER_ENDPOINT + USER_VERIFY, user);
    }
    */



}
