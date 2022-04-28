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

        manager.saveHashMapTask(taskFirst);
        manager.saveHashMapTask(taskSecond);
        manager.saveHashMapSubTask(subtaskFirstEpicFirst);
        manager.saveHashMapSubTask(subtaskSecondEpicFirst);
        manager.saveHashMapSubTask(subtaskFirstEpicSecond);

        ArrayList<EpicTask.SubTask> subTasksEpicTaskFirst = new ArrayList<>();
        ArrayList<EpicTask.SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskFirst.add(subtaskFirstEpicFirst);
        subTasksEpicTaskFirst.add(subtaskSecondEpicFirst);
        subTasksEpicTaskSecond.add(subtaskFirstEpicSecond);

        EpicTask epicTaskFirst = new EpicTask("Закончить учебу","Получить сертификат обучения"
                , subTasksEpicTaskFirst);
        EpicTask epicTaskSecond = new EpicTask("Сменить работу"
                ,"Начать работать Java разработчиком", subTasksEpicTaskSecond);

        manager.saveHashMapEpicTask(epicTaskFirst);
        manager.saveHashMapEpicTask(epicTaskSecond);

        /*System.out.println(taskFirst);
        System.out.println(taskSecond);
        System.out.println(subtaskFirstEpicFirst);
        System.out.println(subtaskSecondEpicFirst);
        System.out.println(subtaskFirstEpicSecond);
        System.out.println(epicTaskFirst);
        System.out.println(epicTaskSecond);*/

        System.out.println(Arrays.toString(manager.getArrayListAllTasks(manager.hashMapTask).toArray()));
    }
}
