package service;


import model.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public void save(User user){
//        userRepository.save(user);
//    }

//    public void delete(UUID id){
//        userRepository.deleteById(id);
//    }
}
