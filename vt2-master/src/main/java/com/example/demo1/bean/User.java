package com.example.demo1.bean;

import com.example.demo1.exception.DAOException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class representing a user entity.
 */
public class User {

    /** The unique identifier for the user. */
    private int id;

    /** The user's login. */
    private String Login;

    /** The user's password salt. */
    private final static String salt = "";

    /** The user's hashed password. */
    private String Password;

    /** The role of the user. */
    private String role = "user";

    /** The email of the user. */
    private String email;


    /**
     * Gets the user's login.
     * @return the user's login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * Sets the user's login.
     * @param login the user's login to set
     */
    public void setLogin(String login) {
        Login = login;
    }

    /**
     * Gets the user's password.
     * @return the user's password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets the user's password.
     * @param password the user's password to set
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * Gets the user's email.
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     * @param email the user's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the role of the user.
     * @return the role of the user
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * @param role the role of the user to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the unique identifier for the user.
     * @return the unique identifier for the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the user.
     * @param id the unique identifier for the user to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
