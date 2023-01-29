package grandduke.task;

import grandduke.command.Io;

public class Task {
    private String taskDesc;
    private boolean isDone = false;

    /**
     * Constructor for a new Task object. Stores a description and status of the
     * task. The task is set to unmarked at initialization
     * 
     * @param taskDesc
     *            the description of the new task created
     */
    public Task(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    /**
     * Getter for task description
     * 
     * @return the description of the task
     */
    public String getTaskDesc() {
        return taskDesc;
    }

    /**
     * Returns a string representing the task status
     * 
     * @return the string representing the task status
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    /**
     * Returns the task description and status in a format that would be used during
     * task listing
     * 
     * @return the string of status and description in task listing format
     */
    public String getTaskPrint() {
        return getStatusIcon() + " " + getTaskDesc();
    }

    /**
     * Set the task status as done
     */
    public void markDone(boolean isDone) {
        this.isDone = isDone;
        Io.printLine();
        if (this.isDone) {
            Io.printOutput("Alright!, I helped you mark this task as done:");
        } else {
            Io.printOutput("OK, I helped you mark this task as not done yet:");
        }
        Io.printOutput("  " + getTaskPrint());
        Io.printLine();
    }
}