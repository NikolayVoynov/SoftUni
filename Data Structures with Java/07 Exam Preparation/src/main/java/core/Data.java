package core;

import interfaces.Entity;
import interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data implements Repository {
    private List<Entity> dataList;

    public Data() {
        this.dataList = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.dataList.add(entity);
    }

    @Override
    public Entity getById(int id) {
        Entity result = null;

        for (Entity entity : dataList) {
            if (entity.getId() == id) {
                result = entity;
            }
        }

        return result;
    }

    @Override
    public List<Entity> getByParentId(int id) {
        return this.dataList
                .stream()
                .filter(entity -> entity.getParentId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return this.dataList;
    }

    @Override
    public Repository copy() {

        return (Repository) List.copyOf(this.dataList);
    }

    @Override
    public List<Entity> getAllByType(String type) {
        return null;
    }

    @Override
    public Entity peekMostRecent() {
        if (this.dataList.isEmpty()) {
            throw new IllegalStateException("Operation on empty Data");
        }

        Entity entityGreatestId = null;

        for (Entity entity : dataList) {
            int id = Integer.MIN_VALUE;
            if (entity.getId() > id) {
                entityGreatestId = entity;
            }
        }

        return entityGreatestId;
    }

    @Override
    public Entity pollMostRecent() {
        if (this.dataList.isEmpty()) {
            throw new IllegalStateException("Operation on empty Data");
        }

        Entity entityGreatestId = null;

        for (Entity entity : dataList) {
            int id = Integer.MIN_VALUE;
            if (entity.getId() > id) {
                entityGreatestId = entity;
            }
        }

        this.dataList.remove(entityGreatestId);
        return entityGreatestId;
    }

    @Override
    public int size() {
        return this.dataList.size();
    }
}
