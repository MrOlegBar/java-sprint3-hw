public class Task {
    int id;
    String name;
    String description;
    String status;

    protected Task(String nameTask, String descriptionTask, String statusTask) {
        this.id = ++Manager.id;
        this.name = nameTask;
        this.description = descriptionTask;
        this.status = statusTask;
    }

    protected Task(String nameTask, String descriptionTask) {
        this.id = ++Manager.id;
        this.name = nameTask;
        this.description = descriptionTask;
    }

    @Override
    public String toString() {
        return "ID задачи=\"" + id + "\", Название=\"" + name + "\", Описание=\"" + description + "\", Статус=\""
                + status + "\"";
    }
}
