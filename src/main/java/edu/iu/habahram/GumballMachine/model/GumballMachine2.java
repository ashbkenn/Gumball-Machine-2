package edu.iu.habahram.GumballMachine.model;

public class GumballMachine2 implements IGumballMachine {
    private String id;
    private IState soldOutState;
    private IState noQuarterState;
    private IState hasQuarterState;
    private IState soldState;
    private IState state;
    private int count = 0;

    public GumballMachine2(String id, String stateName, int count) {
        this.id = id;
        this.count = count;

        // Initialize all states
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        // Set initial state based on provided stateName
        changeTheStateTo(GumballMachineState.valueOf(stateName));
    }

    @Override
    public TransitionResult insertQuarter() {
        return state.insertQuarter();
    }

    @Override
    public TransitionResult ejectQuarter() {
        return state.ejectQuarter();
    }

    @Override
    public TransitionResult turnCrank() {
        state.turnCrank();
        return state.dispense();
    }

    @Override
    public void releaseBall() {
        if (count > 0) {
            System.out.println("A gumball comes rolling out the slot...");
            count--;
        }
    }

    @Override
    public void changeTheStateTo(GumballMachineState name) {
        switch (name) {
            case NO_QUARTER:
                state = noQuarterState;
                break;
            case HAS_QUARTER:
                state = hasQuarterState;
                break;
            case OUT_OF_GUMBALLS:
                state = soldOutState;
                break;
            case GUMBALL_SOLD:
                state = soldState;
                break;
        }
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public String getTheStateName() {
        return state.getTheName();
    }
}