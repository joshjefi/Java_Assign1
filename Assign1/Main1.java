import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. View Statistics");
            System.out.println("6. Sort Tasks by Completion");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskList.addTask(description);
                }
                case 2 -> {
                    System.out.print("Enter task index to remove: ");
                    int index = scanner.nextInt();
                    taskList.removeTask(index);
                }
                case 3 -> {
                    System.out.print("Enter task index to mark as completed: ");
                    int index = scanner.nextInt();
                    taskList.markTaskAsCompleted(index);
                }
                case 4 -> taskList.viewTasks();
                case 5 -> taskList.viewStatistics();
                case 6 -> {
                    taskList.sortTasks();
                    System.out.println("Tasks sorted by completion status.");
                }
                case 7 -> {
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
