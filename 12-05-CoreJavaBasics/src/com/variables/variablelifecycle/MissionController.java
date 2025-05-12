package com.variables.variablelifecycle;

public class MissionController {
    public static void main(String[] args) {

//loading Config class
        String config = Config.getCurrentThread();
        System.out.println("-------------------------------------");

        for (int i = 1; i <= 5; i++) {
            int stepId = i;
            String status = "PENDING";


            //nested instance block-> it will initialize the variable before constructor
            {

                int shadowStepId = stepId + 100;
                String shadowStatus = "RUNNING";
                System.out.println("Inside instance Nested Block: " + "\n shadowStepId:" + shadowStepId + "\n shadowStatus:" + shadowStatus);

            }
            Step step = new Step(stepId, status, System.currentTimeMillis(), Config.DEFAULT_TIMEOUT);
            System.out.println(step);

        }

        System.out.println("Total Steps created:" + Step.totalStepsCreated);
    }
}
