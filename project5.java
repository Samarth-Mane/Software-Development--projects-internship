import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Task1 {
    int id;
    String title;
    String description;

    public Task1(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\nTitle: " + title + "\nDescription: " + description;
    }
}

public class project5 {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.txt";
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        loadTasksFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Task Manager (With File Storage) ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Exiting... Tasks saved.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Load tasks from file
    private static void loadTasksFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int maxId = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    tasks.add(new Task(id, title, description));
                    if (id > maxId) maxId = id;
                }
            }
            taskIdCounter = maxId + 1;
        } catch (FileNotFoundException e) {
            System.out.println("No previous task file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Save tasks to file
    private static void saveTasksToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                bw.write(task.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        tasks.add(new Task(taskIdCounter++, title, description));
        saveTasksToFile();
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- Task List ---");
            for (Task task : tasks) {
                System.out.println(task.toString());
                System.out.println("-------------------");
            }
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Task task : tasks) {
            if (task.id == id) {
                System.out.print("Enter new title: ");
                task.title = scanner.nextLine();
                System.out.print("Enter new description: ");
                task.description = scanner.nextLine();
                saveTasksToFile();
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == id) {
                tasks.remove(i);
                saveTasksToFile();
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }
}
