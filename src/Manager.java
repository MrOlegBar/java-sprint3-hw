import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    static int id = 0;
    HashMap<Integer, Task> hashMapTask = new HashMap<>();
    HashMap<Integer, EpicTask> hashMapEpicTask = new HashMap<>();
    HashMap<Integer, EpicTask.SubTask> hashMapSubTask = new HashMap<>();

    void saveHashMapTask(Task task) {
        hashMapTask.put(task.id, task);
    }

    void saveHashMapEpicTask(EpicTask epicTask) {
        hashMapEpicTask.put(epicTask.id, epicTask);
    }

    void saveHashMapSubTask(EpicTask.SubTask subTask) {
        hashMapSubTask.put(subTask.id, subTask);
    }

    ArrayList<Object> getArrayListAllTasks(HashMap<Integer, ?> hashMap) {
        ArrayList<Object> arrayListAllTasks = new ArrayList<>();
            for (Integer key : hashMap.keySet()) {
                arrayListAllTasks.add(hashMap.get(key));
            }
        return arrayListAllTasks;
    }

    static String getStatusEpicTask(ArrayList<EpicTask.SubTask> subTasks) {
        int countNew = 0;
        int countDone = 0;
        String statusEpicTask;

        for (EpicTask.SubTask subTask : subTasks) {

            if (subTask.status.equalsIgnoreCase("NEW")) {
                countNew++;
            }
            if (!subTask.status.equalsIgnoreCase("DONE")) {
                countDone++;
            }
        }

        if ((subTasks.isEmpty()) || (countNew == subTasks.size())) {
            statusEpicTask = "NEW";
        } else if (countDone == subTasks.size()) {
            statusEpicTask = "DONE";
        } else {
            statusEpicTask = "IN_PROGRESS";
        }
        return statusEpicTask;
    }
}
