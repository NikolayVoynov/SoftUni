package core;

import models.Task;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManagerImpl implements TaskManager {
    private Map<String, Task> tasksById;
    private Map<String, Task> executedTasks;
    private Queue<Task> executionQueue;

    public TaskManagerImpl() {
        this.tasksById = new LinkedHashMap<>();
        this.executedTasks = new HashMap<>();
        this.executionQueue = new ArrayDeque<>();
    }

    @Override
    public void addTask(Task task) {
        this.tasksById.put(task.getId(), task);
        this.executionQueue.offer(task);
    }

    @Override
    public boolean contains(Task task) {
        return this.tasksById.containsKey(task.getId());
    }

    @Override
    public int size() {
        return this.executionQueue.size();
    }

    @Override
    public Task getTask(String taskId) {
        if (!this.tasksById.containsKey(taskId)) {
            throw new IllegalArgumentException();
        }

        return this.tasksById.get(taskId);
    }

    @Override
    public void deleteTask(String taskId) {
        if (!this.tasksById.containsKey(taskId)) {
            throw new IllegalArgumentException();
        }

        Task removeTask = this.tasksById.remove(taskId);
        this.executionQueue.remove(removeTask);
        this.executedTasks.remove(removeTask.getId());
    }

    @Override
    public Task executeTask() {
        if (this.executionQueue.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Task executedTask = this.executionQueue.poll();
        this.executedTasks.put(executedTask.getId(), executedTask);

        return executedTask;
    }

    @Override
    public void rescheduleTask(String taskId) {
        if (!this.executedTasks.containsKey(taskId)) {
            throw new IllegalArgumentException();
        }

        Task taskAddToQueue = this.executedTasks.remove(taskId);
        this.executionQueue.offer(taskAddToQueue);
    }

    @Override
    public Iterable<Task> getDomainTasks(String domain) {
        List<Task> collectionUnexecutedTasksWithGivenDomain = this.executionQueue
                .stream()
                .filter(task -> task.getDomain().equals(domain))
                .collect(Collectors.toList());

        if (collectionUnexecutedTasksWithGivenDomain.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collectionUnexecutedTasksWithGivenDomain;
    }

    @Override
    public Iterable<Task> getTasksInEETRange(int lowerBound, int upperBound) {
        return this.executionQueue
                .stream()
                .filter(task -> task.getEstimatedExecutionTime() >= lowerBound && task.getEstimatedExecutionTime() <= upperBound)
                .collect(Collectors.toList());

    }

    @Override
    public Iterable<Task> getAllTasksOrderedByEETThenByName() {
        return this.tasksById
                .values()
                .stream()
                .sorted((t1,t2) -> {
                    if (t1.getEstimatedExecutionTime() != t2.getEstimatedExecutionTime()) {
                        return Integer.compare(t2.getEstimatedExecutionTime(), t1.getEstimatedExecutionTime());
                    }

                    return Integer.compare(t1.getName().length(),t2.getName().length());
                })
                .collect(Collectors.toList());
    }
}
