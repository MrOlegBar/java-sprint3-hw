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

    ArrayList<Object> getArrayListAllTasks(TreeMap<Integer, ? extends Task> treeMap) {
        ArrayList<Object> arrayListAllTasks = new ArrayList<>();
            for (Integer key : treeMap.keySet()) {
                arrayListAllTasks.add(treeMap.get(key));
            }
        return arrayListAllTasks;
    }

    void removeAllTasks(TreeMap<Integer, ?> treeMap) {
        treeMap.clear();
    }

    Object getTaskToId(int id) {
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

    public Object createTask(Object task) {
        switch (task.getClass().toString()) {
            case "class Task": {
                return new Task((Task) task);
            }
            case "class EpicTask$SubTask": {
                return new EpicTask.SubTask((EpicTask.SubTask) task);
            }
            case "class EpicTask": {
                return new EpicTask((EpicTask) task);
            }
            default:
                return null;
        }
    }

    void updateTask(int id, Object task) {
        switch (task.getClass().toString()) {
            case "class Task": {
                treeMapTask.put(id, (Task) task);
                break;
            }
            case "class EpicTask$SubTask": {
                treeMapEpicTask.put(id, (EpicTask) task);
                break;
            }
            case "class EpicTask": {
                treeMapSubTask.put(id, (EpicTask.SubTask) task);
                break;
            }
        }
    }

    void removeTaskToId(int id) {
        for (Integer task : treeMapTask.keySet()) {
            if (id == task) {
                treeMapTask.remove(id);
                break;
            }
        }
        for (Integer epicTask : treeMapEpicTask.keySet()) {
            if (id == epicTask) {
                treeMapEpicTask.remove(id);
                break;
            }
        }
        for (Integer subTask : treeMapSubTask.keySet()) {
            if (id == subTask) {
                treeMapSubTask.remove(id);
                break;
            }
        }
    }

    public ArrayList<EpicTask.SubTask> getArrayListAllSubTask(EpicTask epicTask) {
        return epicTask.subTasks;
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
