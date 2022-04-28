import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Task taskFirst = new Task("Поесть","Принять пищу", "NEW");
        Task taskSecond = new Task("Поспать","Хорошенько выспаться", "DONE");
        EpicTask.SubTask subtaskFirstEpicFirst = new EpicTask.SubTask("Закончить учебу","Сдать все спринты"
                , "Вовремя выполнить ТЗ", "NEW");
        EpicTask.SubTask subtaskSecondEpicFirst = new EpicTask.SubTask("Закончить учебу","Сдать дипломный проект"
                , "Сделать дипломный проект", "DONE");
        EpicTask.SubTask subtaskFirstEpicSecond = new EpicTask.SubTask("Сменить работу","Сдать все спринты"
                ,"Вовремя выполнить ТЗ", "NEW");

        manager.saveTreeMapTask(taskFirst);
        manager.saveTreeMapTask(taskSecond);
        manager.saveTreeMapSubTask(subtaskFirstEpicFirst);
        manager.saveTreeMapSubTask(subtaskSecondEpicFirst);
        manager.saveTreeMapSubTask(subtaskFirstEpicSecond);

        ArrayList<EpicTask.SubTask> subTasksEpicTaskFirst = new ArrayList<>();
        ArrayList<EpicTask.SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskFirst.add(subtaskFirstEpicFirst);
        subTasksEpicTaskFirst.add(subtaskSecondEpicFirst);
        subTasksEpicTaskSecond.add(subtaskFirstEpicSecond);

        EpicTask epicTaskFirst = new EpicTask("Закончить учебу","Получить сертификат обучения"
                , subTasksEpicTaskFirst);
        EpicTask epicTaskSecond = new EpicTask("Сменить работу"
                ,"Начать работать Java разработчиком", subTasksEpicTaskSecond);

        manager.saveTreeMapEpicTask(epicTaskFirst);
        manager.saveTreeMapEpicTask(epicTaskSecond);

        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.treeMapTask).toArray()));
        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.treeMapEpicTask).toArray()));
        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.treeMapSubTask).toArray()));

        Task task = manager.createTask(Task);
    }
}
