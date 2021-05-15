package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserModel {

    public String username;
    public String password;
    public String name;
    public String adress;
    public String phone;
    public int permissions;

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public UserModel()
    {

    }
    public UserModel( String username, String password, String name, String adress, String phone, int permissions) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.permissions = permissions;
    }
}