package edu.iu.habahram.GumballMachine.model;

public class SoldOutState implements IState {
    private final IGumballMachine gumballMachine;

    public SoldOutState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        String message = "You can't insert a quarter, the machine is sold out";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult ejectQuarter() {
        String message = "Sorry, you can't eject a quarter, you haven't inserted one yet";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        String message = "Sorry, you turned the crank but there are no gumballs";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        String message = "Sorry, the machine is sold out";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }

    @Override
    public TransitionResult refill(int numGumballs) {
        gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        String message = "Refilling";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), numGumballs);
    }
}