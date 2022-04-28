import java.util.ArrayList;
import java.util.TreeMap;

public class Manager {

    static int id = 0;
    TreeMap<Integer, Task> treeMapTask = new TreeMap<>();
    TreeMap<Integer, EpicTask> treeMapEpicTask = new TreeMap<>();
    TreeMap<Integer, EpicTask.SubTask> treeMapSubTask = new TreeMap<>();

    void saveTreeMapTask(Task task) {
        treeMapTask.put(task.id, task);
    }
    void saveTreeMapEpicTask(EpicTask epicTask) {
        treeMapEpicTask.put(epicTask.id, epicTask);
    }
    void saveTreeMapSubTask(EpicTask.SubTask subTask) {
        treeMapSubTask.put(subTask.id, subTask);
    }

    ArrayList<Object> getArrayListAllTasks(TreeMap<Integer, ?> treeMap) {
        ArrayList<Object> arrayListAllTasks = new ArrayList<>();
            for (Integer key : treeMap.keySet()) {
                arrayListAllTasks.add(treeMap.get(key));
            }
        return arrayListAllTasks;
    }

    void removeAllTasks(TreeMap<Integer, ?> treeMap) {
        treeMap.clear();
    }

    Object getTaskToID(int id) {
        Object task = null;
        if (treeMapTask.get(id) != null) {
            task = treeMapTask.get(id);
        } else if (treeMapEpicTask.get(id) != null) {
            task = treeMapEpicTask.get(id);
        } else if (treeMapSubTask.get(id) != null) {
            task = treeMapSubTask.get(id);
        }
        return task;
    }

    Object createTask(Object task) {

        return task.clone();
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
