import java.util.ArrayList;
import java.util.Arrays;

public class EpicTask extends Task {
    ArrayList<SubTask> subTasks;

    public EpicTask(String nameEpicTask, String descriptionEpicTask, ArrayList<SubTask> subTasks) {
        super(nameEpicTask, descriptionEpicTask);
        this.subTasks = subTasks;
        this.status = Manager.getStatusEpicTask(subTasks);
    }

    public EpicTask(EpicTask epicTask) {
        this(epicTask.name, epicTask.description, epicTask.subTasks);
    }

    @Override
    public String toString() {
        return "ID Epic задачи=\"" + id + "\", Название Epic задачи=\"" + name + "\", Описание=\"" + description + "\""
                + ", " + Arrays.toString(subTasks.toArray()) + ", Статус=\"" + status + "\"";
    }

    static class SubTask extends Task {
        String nameEpicTask;

        SubTask(String nameEpicTask, String nameSubTask, String descriptionSubTask, String statusSubTask) {
            super(nameSubTask, descriptionSubTask, statusSubTask);
            this.nameEpicTask = nameEpicTask;
        }

        public SubTask(SubTask subtask) {
            this(subtask.nameEpicTask, subtask.name, subtask.description, subtask.status);
        }

        @Override
        public String toString() {
            return "ID подзадачи=\"" + id + "\", Название Epic задачи=\"" + nameEpicTask + "\", Название подзадачи=\""
                    + name + "\", Описание=\"" + description + "\", Статус=\"" + status + "\"";
        }
    }
}
