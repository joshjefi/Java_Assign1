import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void viewTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    public void viewStatistics() {
        int completedTasks = (int) tasks.stream().filter(Task::isCompleted).count();
        System.out.println("Total tasks: " + tasks.size());
        System.out.println("Completed tasks: " + completedTasks);
        System.out.println("Completion percentage: " + (completedTasks * 100.0 / tasks.size()) + "%");
    }

    public void sortTasks() {
        tasks.sort((a, b) -> Boolean.compare(a.isCompleted(), b.isCompleted()));
    }
}

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return description + (isCompleted ? " [Completed]" : "");
    }
}
