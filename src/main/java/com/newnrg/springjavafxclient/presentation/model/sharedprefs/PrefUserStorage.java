package com.newnrg.springjavafxclient.presentation.model.sharedprefs;

import java.util.prefs.Preferences;

import com.newnrg.springjavafxclient.presentation.authorization.AuthorizationContract;
import com.newnrg.springjavafxclient.presentation.model.Role;
import com.newnrg.springjavafxclient.presentation.model.User;
import org.springframework.stereotype.Component;

@Component
public class PrefUserStorage implements AuthorizationContract.UserStorage {

    private final Preferences pref =  Preferences.userRoot().node(getClass().getName());
    private final String KEY_USER_NAME = "userName";
    private final String KEY_USER_ID = "userId";
    private final String KEY_USER_ROLE = "userRole";

    @Override
    public User getUser() {
        String userName = pref.get(KEY_USER_NAME, "null");
        String userId = pref.get(KEY_USER_ID, "null");
        String userRole = pref.get(KEY_USER_ROLE, "null");
        if (userName.equals("null") || userId.equals("null") || userRole.equals("null")) {
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
        pref.put(KEY_USER_ID, user.getUserId());
        pref.put(KEY_USER_ROLE, user.getUserRole().name());
        return true;
    }
}
