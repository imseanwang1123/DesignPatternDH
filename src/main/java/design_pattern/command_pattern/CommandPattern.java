package design_pattern.command_pattern;

import lombok.AllArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CommandPattern {


    public static class Employee {
        public void action(String action) {
            System.out.println(action);
        }

    }

    @AllArgsConstructor
    public static abstract class Command {
        protected Employee employee;

        public abstract void execute();

    }

    public static class MeetingCommand extends Command {
        public MeetingCommand(Employee employee) {
            super(employee);
        }

        @Override
        public void execute() {
            employee.action("Employee do MeetingCommand");
        }
    }

    public static class PrepareSlideCommand extends Command {
        public PrepareSlideCommand(Employee employee) {
            super(employee);
        }

        @Override
        public void execute() {
            employee.action("Employee do PrepareSlideCommand");
        }
    }


    public static class Secretary {
        private List<Command> commands = new ArrayList<>();


        public void add(Command command) {
            this.commands.add(command);
        }

        public void executeCommands() {
            System.out.println("Secretary call Receiver");
            for (Command command : commands) {
                command.execute();
            }
        }
    }

}
