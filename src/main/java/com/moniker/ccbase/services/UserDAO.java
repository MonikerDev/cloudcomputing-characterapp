package com.moniker.ccbase.services;

import com.moniker.ccbase.models.UserModel;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserDAO implements UserRepository{

    static final String DB_URL = "jdbc:mysql://localhost/cloudcomputing";
    static final String USER = "admin";
    static final String PASS = "yummy";


    @Override
    public <S extends UserModel> S save(S entity) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            String query = "INSERT INTO users {username, password} VALUES {?, ?}";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,entity.getUsername());
            stmt.setString(2, entity.getPassword());
            stmt.execute();
            }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entity;
    }


    @Override
    public Optional<UserModel> findById(Long aLong) {

        UserModel user = new UserModel();

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            String query = "SELECT * FROM users WHERE id == ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, aLong);
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                user = new UserModel(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Optional.of(user);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public <S extends UserModel> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public ArrayList<UserModel> findAll() {

        ArrayList<UserModel> users = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            String query = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                UserModel user = new UserModel(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );

                System.out.println(user.getUsername());

                users.add(user);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<UserModel> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserModel entity) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            String query = "DELETE FROM USERS WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, entity.getId());
            stmt.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserModel> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserModel> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UserModel> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<UserModel> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserModel getOne(Long aLong) {
        return null;
    }

    @Override
    public UserModel getById(Long aLong) {
        return null;
    }

    @Override
    public UserModel getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends UserModel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserModel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserModel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserModel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserModel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserModel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UserModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<UserModel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return null;
    }
}
