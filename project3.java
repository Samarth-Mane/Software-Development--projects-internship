import java.util.ArrayList;
import java.util.Scanner;

class Task {
    int id;
    String title;
    String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ",\nTitle: " + title + ",\nDescription: " + description;
    }
}

public class project3 {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        tasks.add(new Task(taskIdCounter++, title, description)); // if we enter at the last it will update the task id will be incremented
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) { // if no task is present then it will print the following
            System.out.println("No tasks available.");
        } else { // if the task is present then it wiil print the task, title, description about the task.
            System.out.println("\n--- Task List ---");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Task task : tasks) {
            if (task.id == id) { // if the task id enterd and the task id is same then it will print the following.
                System.out.print("Enter new title: ");
                task.title = scanner.nextLine();
                System.out.print("Enter new description: ");
                task.description = scanner.nextLine();
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found!"); // if no task id is found then it will print the following.
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == id) {
                tasks.remove(i); // remove will be removing the id and its related title and the description.
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }
}
