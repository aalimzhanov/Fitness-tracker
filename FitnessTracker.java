import java.util.ArrayList;
import java.util.Scanner;

class Exercise {
    private String name, muscleGroup;
    public Exercise(String name, String muscleGroup){
        this.name = name;
        this.muscleGroup = muscleGroup;
    }
    public String getName(){
        return name;
    }
    public String getMuscleGroup(){
        return muscleGroup;
    }
    public void changeName(String newName){
        name = newName;
    }
    public void changeMuscleGroup(String newMuscleGroup){
        muscleGroup = newMuscleGroup;
    }
}

class FitnessTracker {
    private ArrayList<Exercise> exercises;
        
    public FitnessTracker(){
        exercises = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueChoosing = true;
        int choice; 
        while(continueChoosing){
            System.out.println("1. Add a new exercise");
            System.out.println("2. Modify existing exercise");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.print("What is the name of the exercise you want to add?");
                    String name = scanner.nextLine();
                    System.out.println("What muscle group is this exercise for?");
                    String muscleGroup = scanner.nextLine();
                    addExercise(new Exercise(name, muscleGroup));
                    break;
                case 2: 
                    System.out.println("What is the name of the exercise you would like to modify?");
                    String oldName = scanner.nextLine();
                    System.out.println("Enter the new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new muscle group: ");
                    String newMuscleGroup = scanner.nextLine();
                    changeExercise(oldName, newName, newMuscleGroup);
                    break;
                case 3:
                    continueChoosing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        }
        scanner.close();

    }
    private void addExercise(Exercise exercise){
        exercises.add(exercise);
    }
    private Exercise getExercise(String name){
        for(Exercise exercise : exercises){
            if(exercise.getName().equals(name)) return exercise;
        }
        return null;
    }
    private boolean changeExercise(String oldName, String newName, String newMuscleGroup){
        if (getExercise(oldName) == null){
            addExercise(new Exercise(newName, newMuscleGroup));
            return false;
        }
        getExercise(oldName).changeName(newName);
        getExercise(oldName).changeMuscleGroup(newMuscleGroup);
        return true;
    }



    public static void main(String[] args){
        new FitnessTracker();
    }
}