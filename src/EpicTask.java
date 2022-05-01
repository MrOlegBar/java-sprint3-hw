import java.util.ArrayList;
import java.util.Arrays;
/**
 * Класс для создания Epic задач
 */
public class EpicTask extends Task {
    ArrayList<SubTask> subTasks;
/**
 * Конструктор для создания Epic задач
 */
    public EpicTask(String nameEpicTask, String descriptionEpicTask, ArrayList<SubTask> subTasks) {
        super(nameEpicTask, descriptionEpicTask);
        this.subTasks = subTasks;
        this.status = Manager.getEpicTaskStatus(subTasks); // 4. Метод для управления статусом для эпик задач.
    }
/**
 * Конструктор для копирования Epic задач
 */
    public EpicTask(EpicTask epicTask) {
        this(epicTask.name, epicTask.description, epicTask.subTasks);
    }

    @Override
    public String toString() {
        return "ID задачи Epic=\"" + id + "\", Название Epic задачи=\"" + name + "\", Описание=\"" + description + "\""
                + ", " + Arrays.toString(subTasks.toArray()) + ", Статус=\"" + status + "\"";
    }
/**
 * Внутренний класс для создания SubTask подзадач Epic задач
 */
    static class SubTask extends Task {
        String nameEpicTask;
/**
 * Конструктор внутреннего класса для создания SubTask подзадач Epic задач
 */
        SubTask(String nameEpicTask, String nameSubTask, String descriptionSubTask, String statusSubTask) {
            super(nameSubTask, descriptionSubTask, statusSubTask);
            this.nameEpicTask = nameEpicTask;
        }
/**
 * Конструктор для копирования SubTask подзадач Epic задач
 */
        public SubTask(SubTask subtask) {
            this(subtask.nameEpicTask, subtask.name, subtask.description, subtask.status);
        }

        @Override
        public String toString() {
            return "ID подзадачи SubTask=\"" + id + "\", Название Epic задачи=\"" + nameEpicTask
                    + "\", Название подзадачи=\"" + name + "\", Описание=\"" + description + "\", Статус=\"" + status
                    + "\"";
        }
    }
}
