package taskmanager.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskmanager.entity.User;
import taskmanager.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }

    public boolean loginUser(String email, String password, HttpSession sess) {

        User user = userRepository.findByEmail(email);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            sess.setAttribute("user", user);
            return true;
        } else {
            sess.setAttribute("user", null);
            return false;
        }
    }

//    public boolean isLoggedIn(HttpSession sess) {
//        return (sess.getAttribute("user") != null);
//    }
}
