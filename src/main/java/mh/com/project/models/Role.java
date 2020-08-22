package mh.com.project.models;

import com.google.common.collect.Sets;

import java.util.Set;

import static mh.com.project.models.Permission.*;

/**
 * Created by mh on 21/08/2020.
 */
public enum Role {
    ADMIN(Sets.newHashSet()),
    STUDENT(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
