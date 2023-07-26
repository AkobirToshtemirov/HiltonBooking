package com.epam.hiltonbooking.service.impl;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.dao.api.DaoFactory;
import com.epam.hiltonbooking.dao.api.RoomDao;
import com.epam.hiltonbooking.exceptions.DaoException;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.RoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class RoomServiceImpl implements RoomService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean addNewRoom(int roomNumber, String roomClass, int bedsAmount, double roomCost) throws ServiceException {
        if (roomNumber < 1 || roomClass == null || bedsAmount < 1 || roomCost < 1) {
            return false;
        }

        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
            Room room = buildRoom(roomNumber, roomClass, bedsAmount, roomCost);
            roomDao.save(room);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add room!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Room> getAllRooms() throws ServiceException {
        List<Room> rooms;
        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
            rooms = roomDao.findAll();
        } catch (DaoException e) {
            logger.error("Unable to get all rooms!");
            throw new ServiceException(e.getMessage(), e);
        }
        return rooms;
    }

    @Override
    public Optional<Room> getRoomById(Integer id) throws ServiceException {
        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
            return roomDao.findById(id);
        } catch (DaoException e) {
            logger.error("Unable to get room by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void setRoomActiveById(Integer id, boolean isActive) throws ServiceException {
        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
            Room room = roomDao.findById(id)
                    .orElseThrow(() -> new ServiceException("Room is not found by id! ID = " + id));
            room.setActive(isActive);
            roomDao.save(room);
        } catch (DaoException e) {
            logger.error("Unable to set room is active or not!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Room> getSuitableRooms(int bedsAmount, String roomClass) throws ServiceException {
        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();

            return roomDao.getSuitableRooms(bedsAmount, roomClass);
        } catch (DaoException e) {
            logger.error("Unable to set room is active or not!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(Integer id) throws ServiceException {
        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
            roomDao.deleteById(id);
        } catch (DaoException e) {
            logger.error("Unable to delete room!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean isRoomAdded(int roomNumber) throws ServiceException {
        try {
            RoomDao roomDao = DaoFactory.getInstance().getRoomDao();
            return roomDao.findByRoomNumber(roomNumber).isPresent();
        } catch (DaoException e) {
            logger.error("Unable to check if room is added!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Room buildRoom(Integer roomNumber, String roomClass, int bedsAmount, double roomCost) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setRoomClass(roomClass);
        room.setBedsAmount(bedsAmount);
        room.setRoomCost(roomCost);
        return room;
    }
}
