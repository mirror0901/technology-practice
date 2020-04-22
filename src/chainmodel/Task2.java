package chainmodel;

/**
 * @author: mirror
 * @date: 2020/4/22 16:07
 * @description:
 */
public class Task2 implements Task {

    private Task task;

    public Task2() {
    }

    public Task2(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("task2 is run");
        if (task != null) {
            task.run();
        }
    }
}
