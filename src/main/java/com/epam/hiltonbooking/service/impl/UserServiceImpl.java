package com.epam.hiltonbooking.service.impl;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.api.DaoFactory;
import com.epam.hiltonbooking.dao.api.UserDao;
import com.epam.hiltonbooking.exceptions.DaoException;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean registerUser(String firstName, String lastName, String email, String username, String password) throws ServiceException {
        if (firstName == null || lastName == null || email == null || username == null || password == null) {
            return false;
        }

        // Validation code here:

        // if (!(isEmailValid(email) && isUserInformationValid(name, surname, patronymic, phoneString))) {
        //      return false;
        //  }

        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            if (userDao.findUserByEmail(email).isPresent()) {
                return false;
            }
            User user = buildUser(firstName, lastName, email, username, password);
            userDao.save(user);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to register user!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> loginUser(String username, String password) throws ServiceException {
        if (username == null || password == null) {
            return Optional.empty();
        }

        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.findByUsernameAndPassword(username, password);
        } catch (DaoException e) {
            logger.error("Unable to login user!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteUserById(Integer id) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            userDao.deleteById(id);
        } catch (DaoException e) {
            logger.error("Unable to delete user!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> users;
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            users = userDao.findAll();
        } catch (DaoException e) {
            logger.error("Unable to get all users!");
            throw new ServiceException(e.getMessage(), e);
        }
        return users;
    }

    private User buildUser(String firstName, String lastName, String email, String username, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    @Override
    public boolean isEmailInUse(String email) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.findUserByEmail(email).isPresent();
        } catch (DaoException e) {
            logger.error("Unable to check if email is in use!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean isUsernameInUse(String username) throws ServiceException {
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            return userDao.findUserByUsername(username).isPresent();
        } catch (DaoException e) {
            logger.error("Unable to check if username is in use!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateUser(User updatedUser) throws ServiceException {
        if (updatedUser == null || updatedUser.getFirstName() == null || updatedUser.getLastName() == null ||
                updatedUser.getEmail() == null || updatedUser.getUsername() == null || updatedUser.getPassword() == null) {
            return false;
        }
        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();

            Optional<User> existingUserWithEmail = userDao.findUserByEmail(updatedUser.getEmail());
            if (existingUserWithEmail.isPresent() && !Objects.equals(existingUserWithEmail.get().getId(), updatedUser.getId())) {
                return false;
            }

            Optional<User> existingUserWithUsername = userDao.findUserByUsername(updatedUser.getUsername());
            if (existingUserWithUsername.isPresent() && !Objects.equals(existingUserWithUsername.get().getId(), updatedUser.getId())) {
                return false;
            }

            userDao.updateUserInformation(updatedUser);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to update user!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean validateUser(String username, String password) throws ServiceException {
        if (username == null || password == null) {
            return false;
        }

        try {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            if (userDao.findByUsernameAndPassword(username, password).isPresent()) {
                return true;
            }
        } catch (DaoException e) {
            logger.error("Unable to validate user!");
            throw new ServiceException(e.getMessage(), e);
        }

        return false;
    }
}
