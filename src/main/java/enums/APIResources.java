package enums;

public enum APIResources {
    POST_USER_REQUEST("/api/users"),
    GET_USER_REQUEST("/api/users");

    private String resource;

    APIResources(String resource){
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
