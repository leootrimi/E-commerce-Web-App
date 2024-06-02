package com.eCommerce.eCommerceApp.Service;

import com.eCommerce.eCommerceApp.Models.Role;
import com.eCommerce.eCommerceApp.Models.Users;
import com.eCommerce.eCommerceApp.Repository.UserRepository;
import com.eCommerce.eCommerceApp.Services.Service.UserService;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.UserServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.assertj.core.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImp userServiceImp;

    @Test
    public void saveUserTest() {
        Role userRole = Role.User;
        Users user = new Users("John", "Doe", "johndoe", "password123", "johndoe@example.com", "123-456-7890", "California", "90210", userRole);

        doAnswer((Answer<Void>) invocation -> {
            Users savedUser = invocation.getArgument(0);
            assertThat(savedUser).isNotNull();
            assertThat(savedUser.getUsername()).isEqualTo("johndoe");
            return null; // Void method, so return null
        }).when(userRepository).save(any(Users.class));

        userServiceImp.saveUser(user);
        verify(userRepository, times(1)).save(user);

        when(userRepository.findByUsername("johndoe")).thenReturn(user);

        Optional<Users> exists = userServiceImp.findByUsername("johndoe");
        Assertions.assertThat(exists).isPresent();
        Assertions.assertThat(exists.get().getUsername()).isEqualTo("johndoe");
    }

    @Test
    public void getAllTest() {
        // Prepare some mock data
        List<Users> userList = new ArrayList<>();
        userList.add(new Users("John", "Doe", "johndoe", "password123", "johndoe@example.com", "123-456-7890", "California", "90210", Role.User));
        userList.add(new Users("Jane", "Smith", "janesmith", "password456", "janesmith@example.com", "987-654-3210", "New York", "10001", Role.User));

        when(userRepository.findAll()).thenReturn(userList);

        List<Users> result = userServiceImp.getAll();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(userList.size());
    }

    @Test
    public void getUserById_ValidId_ReturnsUser() {
        int userId = 1; // Assuming user with ID 1 exists
        Users user = new Users(userId, "John", "Doe", "johndoe", "password123", "johndoe@example.com", "123-456-7890", "California", "90210", Role.User);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Users result = userServiceImp.getUserById(userId);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(user);
    }

    @Test
    public void getUserById_InvalidId_ReturnsNull() {
        int userId = 999;

        when(userRepository.findById(userId)).thenReturn(empty());
        Users result = userServiceImp.getUserById(userId);

        assertThat(result).isNull();
    }

    @Test
    public void findByUsername_ValidUsername_ReturnsUser() {
        String username = "johndoe"; // Assuming user with username "johndoe" exists
        Users user = new Users("John", "Doe", username, "password123", "johndoe@example.com", "123-456-7890", "California", "90210", Role.User);

        when(userRepository.findByUsername(username)).thenReturn(user);

        Optional<Users> result = userServiceImp.findByUsername(username);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(user);
    }

}
