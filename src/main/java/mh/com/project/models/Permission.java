package mh.com.project.models;

/**
 * Created by mh on 21/08/2020.
 */
public enum Permission {
    STUDENT_READ("student:write"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("student:write"),
    COURSE_WRITE("student:write");

    private final String permission;


    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
