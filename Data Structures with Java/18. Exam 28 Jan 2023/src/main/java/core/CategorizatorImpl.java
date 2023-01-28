package core;

import models.Category;

import java.util.*;

public class CategorizatorImpl implements Categorizator {
    private Map<String, Category> categoryById;
    private Map<Category, List<Category>> parentChildrenMap;

    public CategorizatorImpl() {
        this.categoryById = new HashMap<>();
        this.parentChildrenMap = new HashMap<>();
    }

    @Override
    public void addCategory(Category category) {
        if (this.categoryById.containsKey(category.getId())) {
            throw new IllegalArgumentException();
        }
        this.categoryById.put(category.getId(), category);
    }

    @Override
    public void assignParent(String childCategoryId, String parentCategoryId) {
        if (!this.categoryById.containsKey(childCategoryId) || !this.categoryById.containsKey(parentCategoryId)) {
            throw new IllegalArgumentException();
        }

        Category parent = this.categoryById.get(parentCategoryId);
        Category child = this.categoryById.get(childCategoryId);

        if (!this.parentChildrenMap.containsKey(parent)) {
            this.parentChildrenMap.put(parent, new ArrayList<>());
        }

        if (this.parentChildrenMap.get(parent).contains(child)) {
            throw new IllegalArgumentException();
        }

        this.parentChildrenMap.get(parent).add(child);
    }

    @Override
    public void removeCategory(String categoryId) {
        if (!this.categoryById.containsKey(categoryId)) {
            throw new IllegalArgumentException();
        }

        Category removeCategory = this.categoryById.remove(categoryId);
        this.parentChildrenMap.remove(removeCategory);
    }

    @Override
    public boolean contains(Category category) {
        return this.categoryById.containsKey(category.getId());
    }

    @Override
    public int size() {
        return this.categoryById.size();
    }

    @Override
    public Iterable<Category> getChildren(String categoryId) {
        if (!this.categoryById.containsKey(categoryId)) {
            throw new IllegalArgumentException();
        }

        Category category = this.categoryById.get(categoryId);

        List<Category> result = new ArrayList<>();
        List<Category> categories = this.parentChildrenMap.get(category);

        for (Category cat : categories) {
            List<Category> children = this.parentChildrenMap.get(cat);
            while (!children.isEmpty()) {
                for (Category child : children) {
                    result.add(child);
                    children = this.parentChildrenMap.get(child);
                }
            }
        }

//        for (Category cat : categories) {
//            result.add(cat);
//            if (this.parentChildrenMap.containsKey(cat)) {
//                result.addAll(this.parentChildrenMap.get(cat));
//            }
//        }

        return result;
    }

    @Override
    public Iterable<Category> getHierarchy(String categoryId) {
        if (!this.categoryById.containsKey(categoryId)) {
            throw new IllegalArgumentException();
        }
        List<Category> result = new ArrayList<>();

        return result;
    }

    @Override
    public Iterable<Category> getTop3CategoriesOrderedByDepthOfChildrenThenByName() {
        List<Category> result = new ArrayList<>();

        return result;
    }
}
