public class TasksApp {
    public static void main(String[] args) {

        System.out.println("=== Basic Production Plan (Numbers only) ===");
        ProductionPlan numericPlan = new ProductionPlan(6);
        numericPlan.addDependency(0, 2);
        numericPlan.addDependency(1, 3);
        numericPlan.addDependency(2, 4);
        numericPlan.addDependency(3, 4);
        numericPlan.addDependency(4, 5);
        numericPlan.printProductionStages();

        System.out.println("\n=== Production Plan By Task Names ===");
        ProductionPlanByName namePlan = new ProductionPlanByName(6);
        namePlan.addTask("Receive Components");
        namePlan.addTask("Initial Quality Check");
        namePlan.addTask("Assemble Circuits");
        namePlan.addTask("Electronic Testing");
        namePlan.addTask("Final Quality Inspection");
        namePlan.addTask("Packaging");

        namePlan.addDependency("Receive Components", "Assemble Circuits");
        namePlan.addDependency("Initial Quality Check", "Electronic Testing");
        namePlan.addDependency("Assemble Circuits", "Final Quality Inspection");
        namePlan.addDependency("Electronic Testing", "Final Quality Inspection");
        namePlan.addDependency("Final Quality Inspection", "Packaging");
        namePlan.printProductionStages();

        System.out.println("\n=== Timed Production Plan ===");
        double[] taskTimes = {2.0, 4.5, 1.0, 3.0, 2.5, 1.5}; // Same order as numeric example
        TimedProductionPlan timedPlan = new TimedProductionPlan(6, taskTimes);
        timedPlan.addDependency(0, 2);
        timedPlan.addDependency(1, 3);
        timedPlan.addDependency(2, 4);
        timedPlan.addDependency(3, 4);
        timedPlan.addDependency(4, 5);
        timedPlan.printProductionStages();

    }
}
