// ============================================================================
// Strategy Design Pattern Example
// ============================================================================
//
// Problem:
// Different robots have different behaviors.
// Some robots can walk, some cannot.
// Some robots can fly, some cannot.
// Some robots can talk, some cannot.
//
// Instead of writing multiple if-else statements inside the Robot class,
// we separate each behavior into its own strategy class.
//
// This follows the Strategy Design Pattern.
//
// ============================================================================



// ============================================================================
// WALK STRATEGY
// ============================================================================

// Strategy Interface
// Every walking behavior must implement this interface.
interface WalkableRobot {

    // Method that defines walking behavior.
    void walk();
}



// Concrete Strategy
// Robot walks normally.
class NormalWalk implements WalkableRobot {

    @Override
    public void walk() {
        System.out.println("Walking normally...");
    }
}



// Concrete Strategy
// Robot cannot walk.
class NoWalk implements WalkableRobot {

    @Override
    public void walk() {
        System.out.println("Cannot walk.");
    }
}




// ============================================================================
// TALK STRATEGY
// ============================================================================

// Strategy Interface
// Every talking behavior implements this interface.
interface TalkableRobot {

    // Method that defines talking behavior.
    void talk();
}



// Concrete Strategy
// Robot can talk normally.
class NormalTalk implements TalkableRobot {

    @Override
    public void talk() {
        System.out.println("Talking normally...");
    }
}



// Concrete Strategy
// Robot cannot talk.
class NoTalk implements TalkableRobot {

    @Override
    public void talk() {
        System.out.println("Cannot talk.");
    }
}




// ============================================================================
// FLY STRATEGY
// ============================================================================

// Strategy Interface
// Every flying behavior implements this interface.
interface FlyableRobot {

    // Method that defines flying behavior.
    void fly();
}



// Concrete Strategy
// Robot can fly.
class NormalFly implements FlyableRobot {

    @Override
    public void fly() {
        System.out.println("Flying normally...");
    }
}



// Concrete Strategy
// Robot cannot fly.
class NoFly implements FlyableRobot {

    @Override
    public void fly() {
        System.out.println("Cannot fly.");
    }
}




// ============================================================================
// CONTEXT CLASS
// ============================================================================

// Robot is the Context class.
//
// It does NOT implement walking, talking, or flying itself.
//
// Instead, it stores references to different strategy objects
// and delegates the work to them.
abstract class Robot {

    // Reference to walking strategy
    protected WalkableRobot walkBehavior;

    // Reference to talking strategy
    protected TalkableRobot talkBehavior;

    // Reference to flying strategy
    protected FlyableRobot flyBehavior;


    // Constructor injects all strategies.
    public Robot(WalkableRobot walkBehavior,
                 TalkableRobot talkBehavior,
                 FlyableRobot flyBehavior) {

        this.walkBehavior = walkBehavior;
        this.talkBehavior = talkBehavior;
        this.flyBehavior = flyBehavior;
    }


    // Delegate walking to selected strategy.
    public void walk() {
        walkBehavior.walk();
    }


    // Delegate talking to selected strategy.
    public void talk() {
        talkBehavior.talk();
    }


    // Delegate flying to selected strategy.
    public void fly() {
        flyBehavior.fly();
    }


    // Each robot has its own projection.
    public abstract void projection();
}




// ============================================================================
// CONCRETE ROBOT : Companion Robot
// ============================================================================

// Companion robot uses whatever strategies are provided.
class CompanionRobot extends Robot {

    public CompanionRobot(WalkableRobot walkBehavior,
                          TalkableRobot talkBehavior,
                          FlyableRobot flyBehavior) {

        super(walkBehavior, talkBehavior, flyBehavior);
    }

    @Override
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}




// ============================================================================
// CONCRETE ROBOT : Worker Robot
// ============================================================================

// Worker robot also uses strategies passed from outside.
class WorkerRobot extends Robot {

    public WorkerRobot(WalkableRobot walkBehavior,
                       TalkableRobot talkBehavior,
                       FlyableRobot flyBehavior) {

        super(walkBehavior, talkBehavior, flyBehavior);
    }

    @Override
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}




// ============================================================================
// CLIENT
// ============================================================================

// Client chooses which strategies each robot should use.
//
// This is where the Strategy Pattern becomes powerful.
// The Robot class never changes.
// Only the selected strategies change.
public class StrategyDesignPattern {

    public static void main(String[] args) {

        // ==========================================================
        // Companion Robot
        //
        // Walk  -> NormalWalk
        // Talk  -> NormalTalk
        // Fly   -> NoFly
        // ==========================================================

        Robot robot1 = new CompanionRobot(
                new NormalWalk(),
                new NormalTalk(),
                new NoFly());

        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();


        System.out.println("-------------------------");


        // ==========================================================
        // Worker Robot
        //
        // Walk -> NoWalk
        // Talk -> NoTalk
        // Fly  -> NormalFly
        // ==========================================================

        Robot robot2 = new WorkerRobot(
                new NoWalk(),
                new NoTalk(),
                new NormalFly());

        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}