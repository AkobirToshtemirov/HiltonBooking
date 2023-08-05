package com.epam.hiltonbooking.dao.impl;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.dao.Table;
import com.epam.hiltonbooking.dao.api.AbstractDao;
import com.epam.hiltonbooking.dao.api.RoomDao;
import com.epam.hiltonbooking.dao.mapper.MapperFactory;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public class RoomDaoImpl extends AbstractDao<Room> implements RoomDao {
    private static final String GET_ALL_ROOMS_QUERY =
            "SELECT * FROM " + Table.ROOMS.getTableName();
    private static final String FIND_ROOM_BY_ID_QUERY =
            "SELECT * FROM " + Table.ROOMS.getTableName() + " WHERE room_id = ?";
    private static final String SAVE_ROOM_QUERY =
            "INSERT INTO " + Table.ROOMS.getTableName() + "(room_number, room_class, beds_amount, room_cost) VALUES (?, ?, ?, ?)";
    private static final String GET_SUITABLE_ROOMS =
            "SELECT * FROM " + Table.ROOMS.getTableName() + " WHERE beds_amount = ? AND room_class = ? AND is_active = true";
    private static final String DELETE_ROOM_QUERY =
            "DELETE FROM " + Table.ROOMS.getTableName() + " WHERE room_id = ?";
    private static final String FIND_BY_ROOM_NUMBER_QUERY =
            "SELECT * FROM " + Table.ROOMS.getTableName() + " WHERE room_number = ?";

    private static final String SET_ROOM_INACTIVE_QUERY =
            "UPDATE " + Table.ROOMS.getTableName() + " SET is_active = false WHERE room_id = ?";


    public RoomDaoImpl() {
        super(MapperFactory.getInstance().getRoomMapper(), Table.ROOMS.getTableName());
    }


    @Override
    public List<Room> findAll() throws DaoException {
        return executeQuery(GET_ALL_ROOMS_QUERY);
    }

    @Override
    public Optional<Room> findById(Integer id) throws DaoException {
        return executeQueryForSingleResult(FIND_ROOM_BY_ID_QUERY, id);
    }

    @Override
    public Integer save(Room room) throws DaoException {
        return executeInsertQuery(SAVE_ROOM_QUERY, room.getRoomNumber(), room.getRoomClass(),
                room.getBedsAmount(), room.getRoomCost());
    }

    @Override
    public List<Room> getSuitableRooms(int bedsAmount, String roomClass) throws DaoException {
        return executeQuery(GET_SUITABLE_ROOMS, bedsAmount, roomClass);
    }

    @Override
    public Optional<Room> findByRoomNumber(int roomNumber) throws DaoException {
        return executeQueryForSingleResult(FIND_BY_ROOM_NUMBER_QUERY, roomNumber);
    }

    @Override
    public void setRoomInActive(Room room) throws DaoException {
        executeUpdateQuery(SET_ROOM_INACTIVE_QUERY, room.getId());
    }

    @Override
    public void deleteById(int id) throws DaoException {
        executeUpdateQuery(DELETE_ROOM_QUERY, id);
    }

}