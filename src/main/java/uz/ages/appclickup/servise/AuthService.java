package uz.ages.appclickup.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ages.appclickup.entity.User;
import uz.ages.appclickup.entity.enums.SystemRoleName;
import uz.ages.appclickup.payload.ApiResponse;
import uz.ages.appclickup.payload.RegisterDto;
import uz.ages.appclickup.repository.UserRepository;

import java.util.Random;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail()))
            return new ApiResponse("Bunday user mavjud.", false);
        User user = new User(
                registerDto.getFullName(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                SystemRoleName.SYSTEM_USER
        );
        int code = new Random().nextInt(999999);
        user.setEmailcode(String.valueOf(code).substring(0, 4));
        userRepository.save(user);

        sendEmail(user.getEmail(), user.getEmailcode());
        return new ApiResponse("User saved.", true);
    }

    public Boolean sendEmail(String sendEmail, String emailCode) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("test@Formgmail.com");
            message.setTo(sendEmail);
            message.setSubject("Accauntni Tasdiqlsh");
            message.setText(emailCode);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
