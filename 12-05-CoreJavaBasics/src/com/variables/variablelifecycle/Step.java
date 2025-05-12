package com.variables.variablelifecycle;

public class Step {
    private int stepId;
    private String status;
    private long startTime;
    private int timeout;
    static int totalStepsCreated;

    public Step(int stepId, String status, long startTime, int timeout) {
        this.stepId = stepId;
        this.status = status;
        this.startTime = startTime;
        this.timeout = timeout;
        totalStepsCreated++;
    }

    {
        stepId = 1;
    }


    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", timeout=" + timeout +
                '}';
    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Stats updated successfully!");
    }


    public void notInitializingLocalVariable() {
        int localVariable;//local variable

        //Java will not allow to use an uninitialized local variable it will give error or RuntimeTime Exception if we try to read.
        try {
            // System.out.println("Local Variable Value:" + localVariable);// Error! Cannot read uninitialized variable

        } catch (Exception e) {
            System.out.println("Error: Variable must be initialized before reading: " + e);
        }
    }


}
