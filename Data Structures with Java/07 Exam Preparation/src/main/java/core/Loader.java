package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Loader implements Buffer {
    private LinkedList<Entity> listEntities;
//    private List<Entity> listEntities;

    public Loader() {
        this.listEntities = new LinkedList<>();
//        this.listEntities = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.listEntities.add(entity);
    }

    @Override
    public Entity extract(int id) {
        if (this.listEntities.isEmpty()) {
            return null;
        }

        Entity removedEntity = null;

        for (Entity entity : listEntities) {
            if (entity.getId() == id) {
                removedEntity = entity;
                this.listEntities.remove(entity);
                break;
            }
        }

        if (removedEntity == null) {
            return null;
        }

        return removedEntity;
    }

    @Override
    public Entity find(Entity entity) {
        if (this.listEntities.isEmpty()) {
            return null;
        }

        Entity foundEntity = null;

        for (Entity listEntity : listEntities) {
            if (listEntity == entity) {
                foundEntity = listEntity;
                break;
            }
        }

        if (foundEntity == null) {
            return null;
        }

        return foundEntity;
    }

    @Override
    public boolean contains(Entity entity) {
        return this.find(entity) != null;
    }

    @Override
    public int entitiesCount() {
        return this.listEntities.size();
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        Entity lookingFor = this.find(oldEntity);

        if (lookingFor == null) {
            throw new IllegalStateException("Entity not found");
        }

        // Дали е на същия индекс?

        this.listEntities.remove(lookingFor);
        this.listEntities.add(newEntity);
    }

    @Override
    public void swap(Entity first, Entity second) {
        Entity findFirst = this.find(first);
        Entity findSecond = this.find(second);

        if (findFirst == null || findSecond == null) {
            throw new IllegalStateException("Entities not found");
        }

        Entity temp = findFirst;
        findFirst = findSecond;
        findSecond = temp;
    }

    @Override
    public void clear() {
        this.listEntities.clear();
    }

    @Override
    public Entity[] toArray() {
        return listEntities.toArray(new Entity[0]);
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return this.listEntities
                .stream()
                .filter(e -> e.getStatus().ordinal() >= lowerBound.ordinal() && e.getStatus().ordinal() <= upperBound.ordinal())
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return this.listEntities;
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        this.listEntities
                .forEach(e -> {
                    if (e.getStatus().equals(oldStatus)) {
                        e.setStatus(newStatus);
                    }
                });
    }

    @Override
    public void removeSold() {
        this.listEntities
                .forEach(e -> {
                    if (e.getStatus().equals(BaseEntity.Status.SOLD)) {
                        listEntities.remove(e);
                    }
                });
    }

    @Override
    public Iterator<Entity> iterator() {
        return new Iterator<Entity>() {
            private int i = 0;
            private LinkedList<Entity> list = listEntities;
//            private List<Entity> list = listEntities;

            @Override
            public boolean hasNext() {
                return i < list.size();
            }

            @Override
            public Entity next() {
                Entity currentEntity = list.get(i);
                i++;
                return currentEntity;
            }
        };
    }
}
