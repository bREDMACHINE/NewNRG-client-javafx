package com.newnrg.springjavafxclient.data.storage.sharedprefs;

import java.util.prefs.Preferences;
import com.newnrg.springjavafxclient.data.storage.UserStorage;
import com.newnrg.springjavafxclient.data.storage.models.Role;
import com.newnrg.springjavafxclient.data.storage.models.User;
import org.springframework.stereotype.Component;

@Component
public class PrefUserStorage implements UserStorage {

    private final Preferences pref =  Preferences.userRoot().node(getClass().getName());
    private final String KEY_USER_NAME = "userName";
    private final String KEY_USER_ID = "userId";
    private final String KEY_USER_ROLE = "userRole";

    @Override
    public User getUser() {
        String userName = pref.get(KEY_USER_NAME, "null");
        long userId = pref.getLong(KEY_USER_ID, -1L);
        String userRole = pref.get(KEY_USER_ROLE, "null");
        if (userName.equals("null") || userId == -1 || userRole.equals("null")) {
            return null;
        }
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userRole(Role.valueOf(userRole))
                .build();
    }

    @Override
    public Boolean saveUser(User user) {
        pref.put(KEY_USER_NAME, user.getUserName());
        pref.putLong(KEY_USER_ID, user.getUserId());
        pref.put(KEY_USER_ROLE, user.getUserRole().name());
        return true;
    }
}
