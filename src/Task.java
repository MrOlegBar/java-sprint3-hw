public class Task {
/**
 * Класс для создания Task задач
 */
    int id;
    String name;
    String description;
    String status;
/**
 * Конструктор для создания Task задач
 */
    public Task(String nameTask, String descriptionTask, String statusTask) {
        this.id = ++Manager.Id;
        this.name = nameTask;
        this.description = descriptionTask;
        this.status = statusTask;
    }
/**
 * Конструктор для создания задач наследников Epic задач и SubTask подзадач
 */
    public Task(String nameTask, String descriptionTask) {
        this.id = ++Manager.Id;
        this.name = nameTask;
        this.description = descriptionTask;
    }
/**
 * Конструктор для копирования Task задач
 */
    public Task(Task task) {
        this(task.name, task.description, task.status);
    }

    @Override
    public String toString() {
        return "ID задачи Task=\"" + id + "\", Название задачи=\"" + name + "\", Описание=\"" + description
                + "\", Статус=\"" + status + "\"";
    }
}
