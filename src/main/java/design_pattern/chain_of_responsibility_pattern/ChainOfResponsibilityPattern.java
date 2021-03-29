package design_pattern.chain_of_responsibility_pattern;

import lombok.Getter;
import lombok.Setter;

public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        Leader teamManager = new TeamManager();
        Leader departmentManager = new DepartmentManager();
        Leader technicalDirector = new TechnicalDirector();
        teamManager.setNext(departmentManager);
        departmentManager.setNext(technicalDirector);

        teamManager.handleRequest(8);

    }

    public static abstract class Leader {
        @Getter
        @Setter
        private Leader next;

        private String name;

        public Leader(String name) {
            this.name = name;
        }


        protected void leaveSuccessfully(int leaveDays) {
            System.out.println(this.name + " approve your " + leaveDays + " days leave.");
        }

        protected void leaveFailed() {
            System.out.println("There are too many days of leave, no one approved the leave slip!");
        }

        public abstract void handleRequest(int leaveDays);
    }

    public static class TeamManager extends Leader {

        public TeamManager() {
            super("TeamManager");
        }

        @Override
        public void handleRequest(int leaveDays) {
            if (leaveDays <= 7) {
                this.leaveSuccessfully(leaveDays);
            } else {
                if (getNext() != null) {
                    getNext().handleRequest(leaveDays);
                } else {
                    this.leaveFailed();
                }
            }
        }
    }

    public static class DepartmentManager extends Leader {

        public DepartmentManager() {
            super("DepartmentManager");
        }

        @Override
        public void handleRequest(int leaveDays) {
            if (leaveDays <= 10) {
                this.leaveSuccessfully(leaveDays);
            } else {
                if (getNext() != null) {
                    getNext().handleRequest(leaveDays);
                } else {
                    this.leaveFailed();
                }
            }
        }
    }

    public static class TechnicalDirector extends Leader {
        public TechnicalDirector() {
            super("TechnicalDirector");
        }

        @Override
        public void handleRequest(int leaveDays) {
            if (leaveDays <= 15) {
                this.leaveSuccessfully(leaveDays);
            } else {
                if (getNext() != null) {
                    getNext().handleRequest(leaveDays);
                } else {
                    this.leaveFailed();
                }
            }
        }
    }

    public static class CTO extends Leader {
        public CTO() {
            super("CTO");
        }

        @Override
        public void handleRequest(int leaveDays) {
            if (leaveDays <= 20) {
                this.leaveSuccessfully(leaveDays);
            } else {
                if (getNext() != null) {
                    getNext().handleRequest(leaveDays);
                } else {
                    this.leaveFailed();
                }
            }
        }
    }

}
