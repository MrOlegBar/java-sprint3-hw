import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Task taskFirst = new Task("Поесть","Принять пищу", "NEW");
        Task taskSecond = new Task("Поспать","Хорошенько выспаться", "DONE");
        EpicTask.SubTask subtaskFirstEpicTaskFirst = new EpicTask.SubTask("Закончить учебу","Сдать все спринты"
                , "Вовремя выполнить ТЗ", "NEW");
        EpicTask.SubTask subtaskSecondEpicTaskFirst = new EpicTask.SubTask("Закончить учебу","Сдать дипломный проект"
                , "Сделать дипломный проект", "DONE");
        EpicTask.SubTask subtaskFirstEpicTaskSecond = new EpicTask.SubTask("Сменить работу","Закончить курс по Java"
                ,"Научиться программировать на языке Java", "NEW");

        manager.saveTreeMapTask(taskFirst);
        manager.saveTreeMapTask(taskSecond);
        manager.saveTreeMapSubTask(subtaskFirstEpicTaskFirst);
        manager.saveTreeMapSubTask(subtaskSecondEpicTaskFirst);
        manager.saveTreeMapSubTask(subtaskFirstEpicTaskSecond);

        ArrayList<EpicTask.SubTask> subTasksEpicTaskFirst = new ArrayList<>();
        ArrayList<EpicTask.SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskFirst.add(subtaskFirstEpicTaskFirst);
        subTasksEpicTaskFirst.add(subtaskSecondEpicTaskFirst);
        subTasksEpicTaskSecond.add(subtaskFirstEpicTaskSecond);

        EpicTask epicTaskFirst = new EpicTask("Закончить учебу","Получить сертификат обучения"
                , subTasksEpicTaskFirst);
        EpicTask epicTaskSecond = new EpicTask("Сменить работу"
                ,"Начать работать Java разработчиком", subTasksEpicTaskSecond);

        manager.saveTreeMapEpicTask(epicTaskFirst);
        manager.saveTreeMapEpicTask(epicTaskSecond);

        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.treeMapTask).toArray()));
        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.treeMapSubTask).toArray()));
        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.treeMapEpicTask).toArray()));

        System.out.println(manager.getArrayListAllSubTask(epicTaskFirst));
        System.out.println(manager.getArrayListAllSubTask(epicTaskSecond));
    }
}
